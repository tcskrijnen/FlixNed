package com.flixned.contentservice.services;

import com.flixned.contentservice.common.models.Movie;
import com.flixned.contentservice.producers.MessageProducer;
import com.flixned.contentservice.repositories.MovieRepository;
import com.flixned.contentservice.utils.RandomString;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MessageProducer messageProducer;

    public MovieService(MovieRepository movieRepository, MessageProducer messageProducer) {
        this.movieRepository = movieRepository;
        this.messageProducer = messageProducer;
    }

    public Iterable<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(String movieId){
        return movieRepository.getMovieByMovieId(movieId);
    }

    public String newMovie(String movie){
        RandomString rdmStr = new RandomString();
        Gson gson = new Gson();

        Movie movieObject = gson.fromJson(movie, Movie.class);
        movieObject.setMovieId(rdmStr.getAlphaNumericString(8));

        Movie newMovie = movieRepository.save(movieObject);

        if(newMovie != null){
            messageProducer.sendNewMovie(newMovie.getMovieId());
            return "saved";
        }else {
            return "User not saved";
        }
    }
}
