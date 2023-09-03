package com.spotify.service;

import com.spotify.entity.PlaylistSong;

import java.util.List;
import java.util.Optional;

public interface PlaylistSongService {
    List<PlaylistSong> getAllPlaylistSong();

    Optional<PlaylistSong> getPlaylistSongById(Integer playlistSongId);

    PlaylistSong createPlaylistSong(PlaylistSong playlistSong);

    PlaylistSong updatePlaylistSong(PlaylistSong playlistSong);

    void deletePlaylistSong(Integer playlistSongId);
}
