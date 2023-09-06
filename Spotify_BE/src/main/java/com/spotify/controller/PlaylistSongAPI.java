package com.spotify.controller;

import com.spotify.dto.PlaylistSongDTO;
import com.spotify.entity.PlaylistSong;
import com.spotify.service.PlaylistSongService;
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
@RequestMapping("/api/playlistSong")
public class PlaylistSongAPI {

    private final PlaylistSongService playlistSongService;
    private final MessageSource messageSource;

    @Autowired
    public PlaylistSongAPI(PlaylistSongService playlistSongService, MessageSource messageSource) {
        this.playlistSongService = playlistSongService;
        this.messageSource = messageSource;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PlaylistSong>> getAllPlaylistSong() {
        return ResponseEntity.ok(playlistSongService.getAllPlaylistSong());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createPlaylistSong(@RequestBody @Valid PlaylistSongDTO playlistSongDTO) {
        if (playlistSongDTO != null) {
            playlistSongService.createOrUpdate(playlistSongDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updatePlaylistSong(@RequestBody @Valid PlaylistSongDTO playlistSongDTO) {
        Optional<PlaylistSong> currentPlaylistSong = playlistSongService.getPlaylistSongById(playlistSongDTO.getPlaylistSongId());
        if (currentPlaylistSong.isPresent()) {
            playlistSongService.createOrUpdate(playlistSongDTO);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"PlaylistSong"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePlaylistSong(@PathVariable("id") Integer id) {
        Optional<PlaylistSong> currentPlaylistSong = playlistSongService.getPlaylistSongById(id);
        if (currentPlaylistSong.isPresent()) {
            playlistSongService.deletePlaylistSong(id);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"PlaylistSong"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

}
