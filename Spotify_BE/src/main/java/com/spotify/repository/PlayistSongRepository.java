package com.spotify.repository;

import com.spotify.entity.PlaylistSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayistSongRepository extends JpaRepository<PlaylistSong, Integer> {
}
