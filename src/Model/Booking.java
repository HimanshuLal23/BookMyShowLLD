package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Booking {
    private List<Seat> seatList;
    private UUID id;
    private UUID movieId;
    private UUID showId;
    private double price;
    private BookingStatus bookingStatus;
    public Booking(UUID movieId,UUID showId,double price,List<Seat> seatList) {
        this.id = UUID.randomUUID();
        this.seatList = seatList;
        this.movieId = movieId;
        this.showId = showId;
        this.price = price;
        this.bookingStatus = BookingStatus.Booked;
    }
    public void addSeat(Seat seat) {
        this.seatList.add(seat);
    }
    public void removeSeat(Seat seat) {
        this.seatList.remove(seat);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public UUID getId() {
        return id;
    }

    public UUID getMovieId() {
        return movieId;
    }

    public UUID getShowId() {
        return showId;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void cancelBooking() {
        this.bookingStatus = BookingStatus.Cancel;
    }
}
