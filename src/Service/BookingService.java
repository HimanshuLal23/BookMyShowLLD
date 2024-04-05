package Service;

import Dao.BookingDao;
import Dao.ShowDao;
import Factory.BookingFactory;
import Model.*;

import java.util.*;

import javafx.util.Pair;

import Exception.*;

import static Exception.BMSExceptionEnum.*;

public class BookingService implements ICancelService{
    private BookingDao bookingDao;
    private double totalPrice;
    private PaymentService paymentService;
    private BookMyShowValidator bookMyShowValidator;
    public BookingService() {
        bookingDao = BookingDao.getInstance();
        paymentService = new PaymentService();
        bookMyShowValidator = new BookMyShowValidator();
    }

    public Booking createBooking(Show show, int noOfSeats, SeatType seatType, UUID movieId) throws BMSException{
        if(noOfSeats>=10) {
            throw new BMSException("You can't book more than 10 seats at a time",SeatLimitExceededException);
        }
        List<Seat> seatList = getSeatsOfTheShow(show,noOfSeats,seatType);
        totalPrice = calculatePrice(seatList);
        Booking booking = BookingFactory.getBookingObject(movieId,show.getId(),totalPrice,seatList);
        return booking;
    }
    private List<Seat> getSeatsOfTheShow(Show show,int noOfSeats, SeatType seatType) throws BMSException{
        int countSeats = 0;
        List<Seat> seats = new ArrayList<>();
        Map<Seat,Boolean> seatMap = show.getSeats();
        for(var seat:seatMap.entrySet()) {
            if(!seat.getValue()) {
                countSeats++;
            }
        }
        if(countSeats>noOfSeats) {
            throw new BMSException("Not enough seats available",BMSExceptionEnum.SeatLimitExceededException);
        }
        for(var seat:seatMap.entrySet()) {
            if(seat.getValue()) {
                seat.setValue(false);
                seats.add(seat.getKey());
            }
        }
        show.updateSeats(seatMap);
        return seats;
    }
    @Override
    public double cancel(UUID bookingId) throws BMSException{
        Optional<Booking> booking = bookingDao.getBookingList().stream().filter(booking1 -> booking1.getId().equals(bookingId)).findAny();
        if(booking.get() != null) {
            if(booking.get().getBookingStatus().equals(BookingStatus.Cancel)) {
                throw new BMSException("This booking id is already canceled",SeatCancelationException);
            }
            booking.get().cancelBooking();
            updateSeat(booking.get().getSeatList());
            return paymentService.cancel(bookingId);
        }
        throw new BMSException("No booking found with this bookingId",BookingNotFoundException);
    }
    private void updateSeat(List<Seat> seats) {
        for(var seat:seats) {
            seat.setAvailable(false);
        }
    }
    private double calculatePrice(List<Seat> seats) {
       return seats.stream().mapToDouble(seat -> seat.getPrice()).sum();
    }
}
