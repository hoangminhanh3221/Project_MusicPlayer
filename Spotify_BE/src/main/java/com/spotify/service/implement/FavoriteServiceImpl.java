package com.spotify.service.implement;

import com.spotify.entity.Favorite;
import com.spotify.repository.FavoriteRepository;
import com.spotify.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    @Override
    public List<Favorite> getAllFavorite() {
        return favoriteRepository.findAll();
    }

    @Override
    public Optional<Favorite> getFavoriteById(Integer favoriteId) {
        return favoriteRepository.findById(favoriteId);
    }

    @Override
    public Favorite createFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    @Override
    public Favorite updateFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    @Override
    public void deleteFavorite(Integer favoriteId) {
        favoriteRepository.deleteById(favoriteId);
    }
}
