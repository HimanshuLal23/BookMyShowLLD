package Dao;

import Model.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingDao {
    private static List<Booking> bookingList;
    private BookingDao() {
        bookingList = new ArrayList<>();
    }

    private static class Holder{
        private static BookingDao INSTANCE = new BookingDao();
    }

    public static BookingDao getInstance() {
        return Holder.INSTANCE;
    }

    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }

    public List<Booking> getBookingList() {
        return this.bookingList;
    }
}
