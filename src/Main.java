import Dao.MovieDao;
import Dao.CinermaInACityDao;
import Dao.ShowDao;
import Model.*;
import Service.AllocateSeatService;
import Service.BookingService;
import Service.MovieFinder;
import Service.PaymentService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

import Exception.BMSException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            //======= Movie Setup ======
            MovieDao movieDao = MovieDao.getInstance();
            Movie lagaan = new Movie("Lagaan", List.of("Inspiration", "Comedy"), List.of("Hindi", "English", "Telugu"), LocalDate.of(2002, Month.APRIL, 21), LocalTime.of(2, 30));
            Movie kantara = new Movie("Kantara", List.of("Inspiration", "Spiritual"), List.of("Hindi", "English", "Kannada"), LocalDate.of(2021, Month.AUGUST, 12), LocalTime.of(2, 00));
            movieDao.addMovie(lagaan);
            movieDao.addMovie(kantara);

            //======= Movie in a city Setup ======
            CinermaInACityDao cinermaInACityDao = CinermaInACityDao.getInstance();

            Cinema inoxCinema = new Cinema("Inox", "Delhi");

            cinermaInACityDao.addMovie("Delhi", List.of(inoxCinema));

            Show lagaanShow = new Show(lagaan.getId(), new Time(LocalTime.of(2, 00), LocalTime.of(4, 45)));
            inoxCinema.addShow(lagaanShow);

            ShowDao showDao = ShowDao.getInstance();
            showDao.addShow(lagaanShow);

            AllocateSeatService allocateSeatService = new AllocateSeatService(lagaanShow.getId());
            allocateSeatService.allocateSeat(5, 250, SeatType.Deluxe);
            allocateSeatService.allocateSeat(10, 200, SeatType.Premium);

            MovieFinder movieFinder = new MovieFinder();

            List<Show> showList = movieFinder.getShowsOfAMovieByCity("Delhi", "Lagaan");

            BookingService bookingService = new BookingService();

            Show show = showList.get(0);

            Booking booking = bookingService.createBooking(show, 3, SeatType.Deluxe, lagaan.getId());
            PaymentService paymentService = new PaymentService();
            Ticket ticket = paymentService.makePayment(booking.getPrice(), 5, booking.getId(), PaymentType.UPI);
            System.out.println(ticket.getBookingId()+" "+booking.getId());

            Booking anotherBooking = bookingService.createBooking(show,10,SeatType.Deluxe,lagaan.getId());
            Ticket ticket2 = paymentService.makePayment(anotherBooking.getPrice(), 5, anotherBooking.getId(), PaymentType.Cash);
            System.out.println(ticket2.getBookingId()+" "+anotherBooking.getId());
        } catch (BMSException e) {
            System.out.println(e.getMessage());
        }
    }
}