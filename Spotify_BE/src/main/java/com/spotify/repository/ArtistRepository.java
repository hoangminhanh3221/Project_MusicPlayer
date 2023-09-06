package com.spotify.repository;

import com.spotify.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    Optional<Artist> findByArtistName(String artistName);
}
