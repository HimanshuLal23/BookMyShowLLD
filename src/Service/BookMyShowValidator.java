package Service;

import Dao.ShowDao;
import Model.Seat;
import Model.SeatType;
import Model.Show;
import javafx.util.Pair;

import java.util.*;

public class BookMyShowValidator {
    private ShowDao showDao;
    public BookMyShowValidator() {
        showDao = ShowDao.getInstance();
    }
    public boolean validateSeats(List<UUID> listOfSeatIds, UUID showId) {
        Optional<Show> show = showDao.getShowList().stream().filter(show1 -> show1.getId().equals(showId)).findAny();
        Map<Seat,Boolean> map = show.get().getSeats();
        List<Seat> seatList = new ArrayList<>();
        for(var seatId:listOfSeatIds) {
            for(var m:map.entrySet()) {
                if(m.getKey().getId().equals(seatId)) {
                    seatList.add(m.getKey());
                }
            }
        }
        for(var seat:seatList) {
            if(!seat.getAvailable()) {
                return false;
            }
        }
        for (var seat:seatList) {
            seat.setAvailable(false);
        }
        return true;
    }
}
