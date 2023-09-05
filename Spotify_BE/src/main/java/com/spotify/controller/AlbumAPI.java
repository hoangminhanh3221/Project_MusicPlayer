package com.spotify.controller;

import com.spotify.dto.AlbumDTO;
import com.spotify.entity.Album;
import com.spotify.service.AlbumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/album")
public class AlbumAPI {

    private final AlbumService albumService;
    private final MessageSource messageSource;

    @Autowired
    public AlbumAPI(AlbumService albumService, MessageSource messageSource) {
        this.albumService = albumService;
        this.messageSource = messageSource;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Album>> getAllAlbum() {
        return ResponseEntity.ok(albumService.getAllAlbum());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createAlbum(@RequestBody @Valid AlbumDTO albumDTO) {
        if (albumDTO != null) {
            albumService.createOrUpdate(albumDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateAlbum(@RequestBody @Valid AlbumDTO albumDTO) {
        Optional<Album> currentAlbum = albumService.getAlbumById(albumDTO.getAlbumId());
        if (currentAlbum.isPresent()) {
            albumService.createOrUpdate(albumDTO);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound.album", null,
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAlbum(@PathVariable("id") Integer id) {
        Optional<Album> currentAlbum = albumService.getAlbumById(id);
        if (currentAlbum.isPresent()) {
            albumService.deleteAlbum(id);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound.album", null,
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

}
