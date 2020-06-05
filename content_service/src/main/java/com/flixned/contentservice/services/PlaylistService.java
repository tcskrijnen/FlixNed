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

        System.out.println(userId);
        Playlist playlist = playlistRepository.findPlaylistByUserId(userId);

        playlist.addMovieIdToList(movieId);

        playlistRepository.save(playlist);
    }
}
