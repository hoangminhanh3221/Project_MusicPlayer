package com.spotify.controller;

import com.spotify.dto.PlaylistUserDTO;
import com.spotify.entity.PlaylistUser;
import com.spotify.service.PlaylistUserService;
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
@RequestMapping("/api/playlistUser")
@RequiredArgsConstructor
public class PlaylistUserController {

    private final PlaylistUserService playlistUserService;
    private final MessageSource messageSource;

    @GetMapping("/getAll")
    public ResponseEntity<List<PlaylistUser>> getAllPlaylistUser() {
        return ResponseEntity.ok(playlistUserService.getAllPlaylistUser());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createPlaylistUser(@RequestBody @Valid PlaylistUserDTO playlistUserDTO) {
        if (playlistUserDTO != null) {
            playlistUserService.createOrUpdate(playlistUserDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updatePlaylistUser(@RequestBody @Valid PlaylistUserDTO playlistUserDTO) {
        Optional<PlaylistUser> currentPlaylistUser = playlistUserService.getPlaylistUserById(playlistUserDTO.getPlaylistUserId());
        if (currentPlaylistUser.isPresent()) {
            playlistUserService.createOrUpdate(playlistUserDTO);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"PlaylistUser"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePlaylistUser(@PathVariable("id") Integer id) {
        Optional<PlaylistUser> currentPlaylistUser = playlistUserService.getPlaylistUserById(id);
        if (currentPlaylistUser.isPresent()) {
            playlistUserService.deletePlaylistUser(id);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"PlaylistUser"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

}
