package com.spotify.service;

import com.spotify.dto.SongDTO;
import com.spotify.entity.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> getAllSong();

    Optional<Song> getSongById(Integer songId);

    Song createOrUpdate(SongDTO songDTO);

    void deleteSong(Integer songId);
}
