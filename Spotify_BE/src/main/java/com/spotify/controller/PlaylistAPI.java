package com.spotify.controller;

import com.spotify.dto.PlaylistDTO;
import com.spotify.entity.Playlist;
import com.spotify.service.PlaylistService;
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
@RequestMapping("/api/playlist")
@RequiredArgsConstructor
public class PlaylistAPI {

    private final PlaylistService playlistService;
    private final MessageSource messageSource;

    @GetMapping("/getAll")
    public ResponseEntity<List<Playlist>> getAllPlaylist() {
        return ResponseEntity.ok(playlistService.getAllPlaylist());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createPlaylist(@RequestBody @Valid PlaylistDTO playlistDTO) {
        if (playlistDTO != null) {
            playlistService.createOrUpdate(playlistDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updatePlaylist(@RequestBody @Valid PlaylistDTO playlistDTO) {
        Optional<Playlist> currentPlaylist = playlistService.getPlaylistById(playlistDTO.getPlaylistId());
        if (currentPlaylist.isPresent()) {
            playlistService.createOrUpdate(playlistDTO);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Playlist"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePlaylist(@PathVariable("id") Integer id) {
        Optional<Playlist> currentPlaylist = playlistService.getPlaylistById(id);
        if (currentPlaylist.isPresent()) {
            playlistService.deletePlaylist(id);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Playlist"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

}
