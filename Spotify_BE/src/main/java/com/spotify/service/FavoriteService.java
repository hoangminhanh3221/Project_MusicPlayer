package com.spotify.service;

import com.spotify.dto.FavoriteDTO;
import com.spotify.entity.Favorite;

import java.util.List;
import java.util.Optional;

public interface FavoriteService {
    List<Favorite> getAllFavorite();
    Optional<Favorite> getFavoriteById(Integer favoriteId);
    Favorite createOrUpdate(FavoriteDTO favoriteDTO);
    void deleteFavorite(Integer favoriteId);
}
