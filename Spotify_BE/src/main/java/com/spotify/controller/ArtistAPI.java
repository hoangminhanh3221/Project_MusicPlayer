package com.spotify.controller;

import com.spotify.dto.ArtistDTO;
import com.spotify.entity.Artist;
import com.spotify.service.ArtistService;
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
@RequestMapping("/api/artist")
@RequiredArgsConstructor
public class ArtistAPI {

    private final ArtistService artistService;
    private final MessageSource messageSource;

    @GetMapping("/getAll")
    public ResponseEntity<List<Artist>> getAllArtist() {
        return ResponseEntity.ok(artistService.getAllArtist());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createArtist(@RequestBody @Valid ArtistDTO artistDTO) {
        if (artistDTO != null) {
            artistService.createOrUpdate(artistDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateArtist(@RequestBody @Valid ArtistDTO artistDTO) {
        Optional<Artist> currentArtist = artistService.getArtistById(artistDTO.getArtistId());
        if (currentArtist.isPresent()) {
            artistService.createOrUpdate(artistDTO);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Artist"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteArtist(@PathVariable("id") Integer id) {
        Optional<Artist> currentArtist = artistService.getArtistById(id);
        if (currentArtist.isPresent()) {
            artistService.deleteArtist(id);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Artist"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

}
