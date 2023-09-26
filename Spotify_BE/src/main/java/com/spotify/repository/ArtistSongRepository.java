package com.spotify.repository;

import com.spotify.entity.ArtistSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistSongRepository extends JpaRepository<ArtistSong, Integer> {
}
