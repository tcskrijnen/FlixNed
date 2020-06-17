package com.flixned.contentservice.common.dto;

import com.flixned.contentservice.common.models.Movie;
import com.flixned.contentservice.common.models.Serie;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlaylistDTO {

    private List<Serie> series = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();

    public PlaylistDTO(List<Serie> series, List<Movie> movies) {
        this.series = series;
        this.movies = movies;
    }

    public List<Serie> getSerieList() {
        return series;
    }

    public List<Movie> getMovieList() {
        return movies;
    }
}
