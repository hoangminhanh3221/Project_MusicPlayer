package com.spotify.controller;

import com.spotify.dto.SongDTO;
import com.spotify.entity.Song;
import com.spotify.service.SongService;
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
@RequestMapping("/api/song")
public class SongAPI {

    private final SongService songService;
    private final MessageSource messageSource;

    @Autowired
    public SongAPI(SongService songService, MessageSource messageSource) {
        this.songService = songService;
        this.messageSource = messageSource;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Song>> getAllSong() {
        return ResponseEntity.ok(songService.getAllSong());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createSong(@RequestBody @Valid SongDTO songDTO) {
        if (songDTO != null) {
            songService.createOrUpdate(songDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateSong(@RequestBody @Valid SongDTO songDTO) {
        Optional<Song> currentSong = songService.getSongById(songDTO.getSongId());
        if (currentSong.isPresent()) {
            songService.createOrUpdate(songDTO);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Song"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteSong(@PathVariable("id") Integer id) {
        Optional<Song> currentSong = songService.getSongById(id);
        if (currentSong.isPresent()) {
            songService.deleteSong(id);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Song"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

}
