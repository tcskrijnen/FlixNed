package com.flixned.contentservice.services;

import com.flixned.contentservice.common.models.Playlist;
import com.flixned.contentservice.repositories.PlaylistRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
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

    public Playlist getPlaylist(int userId){
        return playlistRepository.findPlaylistByUserId(userId);
    }
}
