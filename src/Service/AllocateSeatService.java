package Service;

import Dao.ShowDao;
import Model.SeatType;
import Model.Show;

import java.util.Optional;
import java.util.UUID;

public class AllocateSeatService {
    private UUID showId;
    private ShowDao showDao;
    public AllocateSeatService(UUID showId) {
        this.showId = showId;
        this.showDao = ShowDao.getInstance();
    }

    public void allocateSeat(int noOfSeats, int price, SeatType seatType) {
        Optional<Show> show = showDao.getShowList().stream().filter(show1 -> show1.getId().equals(showId)).findAny();
        show.get().setNewSeats(noOfSeats,seatType,price);
    }
}
