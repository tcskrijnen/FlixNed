package com.flixned.contentservice.controllers;

import com.flixned.contentservice.common.models.Movie;
import com.flixned.contentservice.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentController {

    private final MovieService movieService;

    public ContentController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = RestURIConstant.allMovies, method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Movie> allmovies() {
        return movieService.allmovies();
    }
}
