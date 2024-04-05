package Dao;

import Model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDao {
    private static List<Movie> movieList;
    private MovieDao() {
        movieList = new ArrayList<>();
    }

    private static class Holder{
        private static MovieDao INSTANCE = new MovieDao();
    }

    public static MovieDao getInstance() {
        return Holder.INSTANCE;
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

}
