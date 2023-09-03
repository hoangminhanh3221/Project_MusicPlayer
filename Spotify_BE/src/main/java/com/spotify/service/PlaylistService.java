package com.spotify.service;

import com.spotify.entity.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {
    List<Playlist> getAllPlaylist();

    Optional<Playlist> getPlaylistById(Integer playlistId);

    Playlist createPlaylist(Playlist playlist);

    Playlist updatePlaylist(Playlist playlist);

    void deletePlaylist(Integer playlistId);
}
