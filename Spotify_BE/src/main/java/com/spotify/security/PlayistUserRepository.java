package com.spotify.security;

import com.spotify.entity.PlaylistUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayistUserRepository extends JpaRepository<PlaylistUser, Integer> {
}
