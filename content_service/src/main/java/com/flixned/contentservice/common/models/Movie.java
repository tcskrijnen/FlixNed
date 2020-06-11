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

    @Column()
    private String description;

    @Column()
    private Long duration;

    @ElementCollection
    private List<String> cast = new ArrayList<String>();

    @Column(nullable = false, unique = true)
    private int year;

    @Column()
    private String imageUrl;

    public Movie(String movieId, String title, String description, Long duration, List<String> cast, int year, String imageUrl) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.cast = cast;
        this.year = year;
        this.imageUrl = imageUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
