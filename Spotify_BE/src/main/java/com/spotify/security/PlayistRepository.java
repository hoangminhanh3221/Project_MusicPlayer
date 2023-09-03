package com.spotify.security;

import com.spotify.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayistRepository extends JpaRepository<Playlist, Integer> {
}
