package com.spotify.service;

import com.spotify.entity.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> getAllSong();

    Optional<Song> getSongById(Integer songId);

    Song createSong(Song song);

    Song updateSong(Song song);

    void deleteSong(Integer songId);
}
