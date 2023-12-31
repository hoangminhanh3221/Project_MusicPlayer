package com.spotify.service.implement;

import com.spotify.dto.FavoriteDTO;
import com.spotify.entity.Favorite;
import com.spotify.repository.FavoriteRepository;
import com.spotify.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Override
    public List<Favorite> getAllFavorite() {
        return favoriteRepository.findAll();
    }

    @Override
    public Optional<Favorite> getFavoriteById(Integer favoriteId) {
        return favoriteRepository.findById(favoriteId);
    }

    @Override
    public Favorite createOrUpdate(FavoriteDTO favoriteDTO) {
        Favorite favorite = new Favorite();
        BeanUtils.copyProperties(favoriteDTO, favorite);
        return favoriteRepository.save(favorite);
    }

    @Override
    public void deleteFavorite(Integer favoriteId) {
        favoriteRepository.deleteById(favoriteId);
    }
}
