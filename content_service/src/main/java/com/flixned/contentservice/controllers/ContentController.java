package com.flixned.contentservice.controllers;

import com.flixned.contentservice.common.models.Movie;
import com.flixned.contentservice.common.models.Playlist;
import com.flixned.contentservice.common.models.Serie;
import com.flixned.contentservice.services.MovieService;
import com.flixned.contentservice.services.PlaylistService;
import com.flixned.contentservice.services.SerieService;
import com.google.gson.Gson;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContentController {

    private final MovieService movieService;
    private final SerieService serieService;
    private final PlaylistService playlistService;

    public ContentController(MovieService movieService, SerieService serieService, PlaylistService playlistService) {
        this.movieService = movieService;
        this.serieService = serieService;
        this.playlistService = playlistService;
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

    @RequestMapping(value = RestURIConstant.addMovieToPlaylist,  method = RequestMethod.POST)
    public @ResponseBody
    String addMovieToPlaylist(Integer userId, String movieId) {
        playlistService.addMovieToPlaylist(userId, movieId);
        return "saved";
    }

    @RequestMapping(value = RestURIConstant.addSerieToPlaylist,  method = RequestMethod.POST)
    public @ResponseBody
    String addSerieToPlaylist(Integer userId, String serieId) {
        playlistService.addSerieToPlaylist(userId, serieId);
        return "saved";
    }

    @RequestMapping(value = RestURIConstant.getPlaylist, method = RequestMethod.GET)
    public @ResponseBody
    Playlist getPlaylist(@RequestParam("userId") int userId) {

        return playlistService.getPlaylist(userId);
    }

    @RequestMapping(value = RestURIConstant.getMovie, method = RequestMethod.GET)
    public @ResponseBody
    Movie getMovie(@RequestParam("movieId") String movieId) {
        return movieService.getMovieById(movieId);
    }

    @RequestMapping(value = RestURIConstant.getSerie, method = RequestMethod.GET)
    public @ResponseBody
    Serie getSerie(@RequestParam("serieId") String serieId) {
        return serieService.getSerieById(serieId);
    }
}
