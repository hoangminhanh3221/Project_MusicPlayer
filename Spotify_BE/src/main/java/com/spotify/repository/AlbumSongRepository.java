package com.spotify.repository;

import com.spotify.entity.AlbumSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumSongRepository extends JpaRepository<AlbumSong, Integer> {
}
