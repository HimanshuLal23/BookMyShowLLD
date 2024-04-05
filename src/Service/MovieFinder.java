package Service;

import Dao.MovieDao;
import Dao.CinermaInACityDao;
import Model.Cinema;
import Model.Movie;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import Exception.*;
import Model.Show;

public class MovieFinder {
    private MovieDao movieDao;
    private List<Movie> movieList;
    private CinermaInACityDao cinemaInACityDao;

    public MovieFinder() {
        movieDao = MovieDao.getInstance();
        movieList = new ArrayList<>();
        cinemaInACityDao = CinermaInACityDao.getInstance();
    }

    public List<Movie> getMovieByName(String movieName) {
        for(var movie:movieDao.getMovieList()) {
            if(movie.getName().equals(movieName)) {
                movieList.add(movie);
            }
        }
        return movieList;
    }

    public List<Movie> getMovieByGenre(String genreName) {
        for(var movie:movieDao.getMovieList()) {
            for(var genre:movie.getGenre()) {
                if (genre.equals(genreName)) {
                    movieList.add(movie);
                }
            }
        }
        return movieList;
    }

    public List<Movie> getMovieByLanguage(String languageName) {
        for(var movie:movieDao.getMovieList()) {
            for(var genre:movie.getLanguage()) {
                if (genre.equals(languageName)) {
                    movieList.add(movie);
                }
            }
        }
        return movieList;
    }

    public List<Movie> getMovieByReleaseDate(LocalDate localDate) {
        for(var movie:movieDao.getMovieList()) {
            if(movie.getReleaseDate().equals(localDate)) {
                movieList.add(movie);
            }
        }
        return movieList;
    }

    public List<Show> getShowsOfAMovieByCity(String city,String movieName) {
        List<Cinema> cinemas = cinemaInACityDao.getMovieList(city);
        if(cinemas.size() == 0) {
            throw new BMSException("No cinemas is present in this city", BMSExceptionEnum.NoCinemasInACityException);
        }
        List<Show> shows = new ArrayList<>();
        Optional<Movie> movie = MovieDao.getInstance().getMovieList().stream().filter(movie1 -> movie1.getName().equals(movieName)).findAny();
        for(var cinema:cinemas) {
            for(var show:cinema.getShows()) {
                if(show.getMovieId().equals(movie.get().getId()))
                    shows.add(show);
            }
        }
        return shows;
    }
}
