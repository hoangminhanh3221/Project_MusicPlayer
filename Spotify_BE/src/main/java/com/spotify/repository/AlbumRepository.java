package com.spotify.repository;

import com.spotify.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    Optional<Album> findByAlbumName(String albumName);
}
