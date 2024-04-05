package Model;

import java.util.List;
import java.util.UUID;

public class Ticket {
    private UUID id;
    private UUID bookingId;
    private double price;

    public Ticket(UUID bookingId,double price) {
        this.id = UUID.randomUUID();
        this.bookingId = bookingId;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public UUID getBookingId() {
        return bookingId;
    }
}
