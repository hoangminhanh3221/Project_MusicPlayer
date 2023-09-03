package com.spotify.repository;

import com.spotify.entity.PlaylistUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistUserRepository extends JpaRepository<PlaylistUser, Integer> {
}
