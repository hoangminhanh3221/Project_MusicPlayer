package com.spotify.repository;

import com.spotify.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    Optional<Playlist> findByPlaylistName(String playlistName);
}
