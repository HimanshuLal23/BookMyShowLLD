package Factory;

import Model.Booking;
import Model.Seat;

import java.util.List;
import java.util.UUID;

public class BookingFactory {
    private BookingFactory() {

    }
    public static Booking getBookingObject(UUID movieId, UUID showId,double price, List<Seat> seatList) {
        return new Booking(movieId, showId, price, seatList);
    }
}
