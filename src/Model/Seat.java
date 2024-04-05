package Model;

import java.util.UUID;

public class Seat {
    private SeatType seatType;
    private Boolean available;
    private int price;
    private UUID id;

    public Seat(SeatType seatType, Boolean available, int price) {
        this.id = UUID.randomUUID();
        this.seatType = seatType;
        this.available = available;
        this.price = price;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public int getPrice() {
        return price;
    }

    public UUID getId() {
        return id;
    }
}
