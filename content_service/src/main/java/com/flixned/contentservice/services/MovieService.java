package com.flixned.contentservice.services;

import com.flixned.contentservice.common.models.Movie;
import com.flixned.contentservice.repositories.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public Iterable<Movie> allMovies() {
        return movieRepository.findAll();
    }
}
