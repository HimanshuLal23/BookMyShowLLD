package Model;

import java.util.*;

public class Show {
    private UUID id;
    private UUID movieId;
    private Time time;
    private Map<Seat,Boolean> seats;

    public Show(UUID movieId, Time time) {
        this.id = UUID.randomUUID();
        this.movieId = movieId;
        this.time = time;
        this.seats = new HashMap<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getMovieId() {
        return movieId;
    }

    public void setMovieId(UUID movieId) {
        this.movieId = movieId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Map<Seat, Boolean> getSeats() {
        return seats;
    }

    public void setNewSeats(int noOfSeats,SeatType seatType,int price) {
        for(int i=0;i<noOfSeats;i++) {
            Seat seat = new Seat(seatType,true,price);
            seats.put(seat,true);
        }
    }
    public void bookSeat(Seat seat) {
        seat.setAvailable(false);
    }
    public void freeSeat(Seat seat) {
        seat.setAvailable(true);
    }
    public void updateSeats(Map<Seat, Boolean> seats) {
        this.seats = seats;
    }
}
