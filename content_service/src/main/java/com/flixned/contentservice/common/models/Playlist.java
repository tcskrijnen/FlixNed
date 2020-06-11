package com.flixned.contentservice.common.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private int userId;

    @ElementCollection
    private Set<String> movieList;

    @ElementCollection
    private Set<String> serieList;

    public Playlist(int userId, Set<String> movieList, Set<String> serieList) {
        this.userId = userId;
        this.movieList = movieList;
        this.serieList = serieList;
    }

    public Playlist() {
    }


    public void addMovieIdToList(String movieId) {
        this.movieList.add(movieId);
    }

    public void addSerieIdToList(String serieId) {
        this.serieList.add(serieId);
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Set<String> getMovieList() {
        return movieList;
    }

    public void setMovieList(Set<String> movieList) {
        this.movieList = movieList;
    }

    public Set<String> getSerieList() {
        return serieList;
    }

    public void setSerieList(Set<String> serieList) {
        this.serieList = serieList;
    }
}
