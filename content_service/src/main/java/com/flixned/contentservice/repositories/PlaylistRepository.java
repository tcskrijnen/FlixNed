package com.flixned.contentservice.repositories;

import com.flixned.contentservice.common.models.Playlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {

    Playlist findPlaylistByUserId(int userId);
}
