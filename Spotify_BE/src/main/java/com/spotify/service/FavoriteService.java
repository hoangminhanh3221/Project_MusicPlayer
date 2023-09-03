package com.spotify.service;

import com.spotify.entity.Favorite;

import java.util.List;
import java.util.Optional;

public interface FavoriteService {
    List<Favorite> getAllFavorite();

    Optional<Favorite> getFavoriteById(Integer favoriteId);

    Favorite createFavorite(Favorite favorite);

    Favorite updateFavorite(Favorite favorite);

    void deleteFavorite(Integer favoriteId);
}
