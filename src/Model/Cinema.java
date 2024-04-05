package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cinema {
    private List<Show> shows;
    private UUID id;
    private String name;
    private String city;

    public Cinema(String name, String city) {
        this.id = UUID.randomUUID();
        this.shows = new ArrayList<>();
        this.name = name;
        this.city = city;
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShows() {
        return shows;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
