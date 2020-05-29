package com.flixned.contentservice.services;

import com.flixned.contentservice.common.models.Movie;
import com.flixned.contentservice.controllers.ContentController;
import com.flixned.contentservice.repositories.MovieRepository;
import com.flixned.contentservice.repositories.SerieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final SerieRepository serieRepository;

    public MovieService(MovieRepository movieRepository, SerieRepository serieRepository) {
        this.movieRepository = movieRepository;
        this.serieRepository = serieRepository;
    }


    public Iterable<Movie> allMovies() {
        return movieRepository.findAll();
    }
}
