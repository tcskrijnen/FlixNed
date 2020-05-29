package com.flixned.contentservice.controllers;

import com.flixned.contentservice.common.models.Movie;
import com.flixned.contentservice.common.models.Serie;
import com.flixned.contentservice.services.MovieService;
import com.flixned.contentservice.services.SerieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentController {

    private final MovieService movieService;
    private final SerieService serieService;

    public ContentController(MovieService movieService, SerieService serieService) {
        this.movieService = movieService;
        this.serieService = serieService;
    }

    @RequestMapping(value = RestURIConstant.allMovies, method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Movie> allMovies() {
        return movieService.allMovies();
    }

    @RequestMapping(value = RestURIConstant.allSeries, method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Serie> allSeries() {
        return serieService.allSeries();
    }
}
