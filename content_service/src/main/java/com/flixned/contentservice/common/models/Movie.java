package com.flixned.contentservice.common.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String movieId;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = true)
    private Long duration;

    @ElementCollection
    private List<String> cast = new ArrayList<String>();

    @Column(nullable = false, unique = true)
    private int year;

    public Movie(String movieId, String title, Long duration, List<String> cast, int year) {
        this.movieId = movieId;
        this.title = title;
        this.duration = duration;
        this.cast = cast;
        this.year = year;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
