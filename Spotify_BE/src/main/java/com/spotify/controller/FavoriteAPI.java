package com.spotify.controller;

import com.spotify.dto.FavoriteDTO;
import com.spotify.entity.Favorite;
import com.spotify.service.FavoriteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/favorite")
@RequiredArgsConstructor
public class FavoriteAPI {

    private final FavoriteService favoriteService;
    private final MessageSource messageSource;

    @GetMapping("/getAll")
    public ResponseEntity<List<Favorite>> getAllFavorite() {
        return ResponseEntity.ok(favoriteService.getAllFavorite());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createFavorite(@RequestBody @Valid FavoriteDTO favoriteDTO) {
        if (favoriteDTO != null) {
            favoriteService.createOrUpdate(favoriteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateFavorite(@RequestBody @Valid FavoriteDTO favoriteDTO) {
        Optional<Favorite> currentFavorite = favoriteService.getFavoriteById(favoriteDTO.getFavoriteId());
        if (currentFavorite.isPresent()) {
            favoriteService.createOrUpdate(favoriteDTO);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Favorite"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFavorite(@PathVariable("id") Integer id) {
        Optional<Favorite> currentFavorite = favoriteService.getFavoriteById(id);
        if (currentFavorite.isPresent()) {
            favoriteService.deleteFavorite(id);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Favorite"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

}
