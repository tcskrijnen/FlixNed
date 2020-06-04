package com.flixned.contentservice.services;

import com.flixned.contentservice.common.dto.MovieDTO;
import com.flixned.contentservice.common.models.Movie;
import com.flixned.contentservice.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
