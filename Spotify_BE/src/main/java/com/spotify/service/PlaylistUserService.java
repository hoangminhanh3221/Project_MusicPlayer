package com.spotify.service;

import com.spotify.entity.PlaylistUser;

import java.util.List;
import java.util.Optional;

public interface PlaylistUserService {
    List<PlaylistUser> getAllPlaylistUser();

    Optional<PlaylistUser> getPlaylistUserById(Integer playlistUserId);

    PlaylistUser createPlaylistUser(PlaylistUser playlistUser);

    PlaylistUser updatePlaylistUser(PlaylistUser playlistUser);

    void deletePlaylistUser(Integer playlistUserId);
}
