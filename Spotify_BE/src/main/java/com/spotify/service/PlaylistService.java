package com.spotify.service;

import com.spotify.dto.PlaylistDTO;
import com.spotify.entity.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {
    List<Playlist> getAllPlaylist();

    Optional<Playlist> getPlaylistById(Integer playlistId);

    Playlist createOrUpdate(PlaylistDTO playlistDTO);

    void deletePlaylist(Integer playlistId);
}
