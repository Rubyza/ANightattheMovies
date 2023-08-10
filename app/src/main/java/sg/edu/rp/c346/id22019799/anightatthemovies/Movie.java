package sg.edu.rp.c346.id22019799.anightatthemovies;

import java.io.Serializable;

public class Movie implements Serializable{
    private int id;
    private String title;
    private String genre;
    private int year;
    private String rating;

    public Movie(int id,String title, String genre, int year, String rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }
}
