package Dao;

import Model.Movie;
import Model.Show;

import java.util.ArrayList;
import java.util.List;

public class ShowDao {
    private List<Show> showList;
    private ShowDao() {
        showList = new ArrayList<>();
    }

    private static class Holder{
        private static ShowDao INSTANCE = new ShowDao();
    }

    public static ShowDao getInstance() {
        return Holder.INSTANCE;
    }

    public void addShow(Show show) {
        this.showList.add(show);
    }

    public List<Show> getShowList() {
        return showList;
    }
}
