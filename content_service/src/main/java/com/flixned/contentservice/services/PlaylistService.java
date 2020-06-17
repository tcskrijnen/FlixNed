package com.flixned.contentservice.services;

import com.flixned.contentservice.common.dto.PlaylistDTO;
import com.flixned.contentservice.common.models.Movie;
import com.flixned.contentservice.common.models.Playlist;
import com.flixned.contentservice.common.models.Serie;
import com.flixned.contentservice.repositories.MovieRepository;
import com.flixned.contentservice.repositories.PlaylistRepository;
import com.flixned.contentservice.repositories.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PlaylistService {

    private final SerieRepository serieRepository;
    private final MovieRepository movieRepository;
    private final PlaylistRepository playlistRepository;

    public PlaylistService(SerieRepository serieRepository, MovieRepository movieRepository, PlaylistRepository playlistRepository) {
        this.serieRepository = serieRepository;
        this.movieRepository = movieRepository;
        this.playlistRepository = playlistRepository;
    }

    public void addMovieToPlaylist(int userId, String movieId) {
        Playlist playlist = playlistRepository.findPlaylistByUserId(userId);

        playlist.addMovieIdToList(movieId);

        playlistRepository.save(playlist);
    }

    public void addSerieToPlaylist(int userId, String serieId) {
        Playlist playlist = playlistRepository.findPlaylistByUserId(userId);

        playlist.addSerieIdToList(serieId);

        playlistRepository.save(playlist);
    }

    public PlaylistDTO getPlaylist(int userId){
        Playlist playlist = playlistRepository.findPlaylistByUserId(userId);

        List<Serie> series = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();

        if(playlist != null){
            for (String serieId: playlist.getSerieList()) {
                Serie serie = serieRepository.getSerieBySerieId(serieId);
                series.add(serie);
            }

            for (String movieId: playlist.getMovieList()) {
                Movie movie = movieRepository.getMovieByMovieId(movieId);
                movies.add(movie);
            }
            return new PlaylistDTO(series, movies);
        }

        return null;

    }

    public void createPlaylist(int userId){
        Set<String> movieSet = new HashSet();;
        Set<String> serieSet = new HashSet();;

        Playlist playlist = new Playlist(userId, movieSet, serieSet);

        playlistRepository.save(playlist);
    }

    public void deletePlaylist(int userId){
        playlistRepository.delete(playlistRepository.findPlaylistByUserId(userId));
    }
}
