package Dao;

import Model.Cinema;
import Model.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinermaInACityDao {
    private static Map<String,List<Cinema>> cinemaInACity;
    private CinermaInACityDao() {
        cinemaInACity = new HashMap<>();
    }

    private static class Holder{
        private static CinermaInACityDao INSTANCE = new CinermaInACityDao();
    }

    public static CinermaInACityDao getInstance() {
        return Holder.INSTANCE;
    }

    public void addMovie(String city, List<Cinema> cinemas) {
        List<Cinema> cinemaList;
        if(!cinemaInACity.containsKey(city)) {
            cinemaList = new ArrayList<>();
        }else {
            cinemaList = cinemaInACity.get(city);
        }
        cinemaList.addAll(cinemas);
        cinemaInACity.put(city,cinemaList);
    }

    public void addCinema(String city, Cinema cinema) {
        List<Cinema> cinemas;
        if(!cinemaInACity.containsKey(city)) {
            cinemas = new ArrayList<>();
        }else {
            cinemas = cinemaInACity.get(city);
        }
        cinemas.add(cinema);
        cinemaInACity.put(city,cinemas);
    }

    public List<Cinema> getMovieList(String city) {
        return cinemaInACity.get(city);
    }
}
