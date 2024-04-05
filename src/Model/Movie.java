package Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class Movie {
    private UUID id;
    private String name;
    private List<String> genre;
    private List<String> language;
    private LocalDate releaseDate;
    private LocalTime movieLength;

    public Movie(String name, List<String> genre, List<String> language, LocalDate releaseDate, LocalTime movieLength) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.genre = genre;
        this.language = language;
        this.releaseDate = releaseDate;
        this.movieLength = movieLength;
    }

    public LocalTime getMovieLength() {
        return movieLength;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getGenre() {
        return genre;
    }

    public List<String> getLanguage() {
        return language;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}
