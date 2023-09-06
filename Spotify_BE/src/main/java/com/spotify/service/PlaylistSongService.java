package com.spotify.service;

import com.spotify.dto.PlaylistSongDTO;
import com.spotify.entity.PlaylistSong;

import java.util.List;
import java.util.Optional;

public interface PlaylistSongService {
    List<PlaylistSong> getAllPlaylistSong();
    Optional<PlaylistSong> getPlaylistSongById(Integer playlistSongId);
    PlaylistSong createOrUpdate(PlaylistSongDTO playlistSongDTO);
    void deletePlaylistSong(Integer playlistSongId);
}
