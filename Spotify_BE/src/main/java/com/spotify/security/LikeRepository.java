package com.spotify.security;

import com.spotify.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Favorite, Integer> {
}
