package com.spotify.service;

import com.spotify.dto.PlaylistUserDTO;
import com.spotify.entity.PlaylistUser;

import java.util.List;
import java.util.Optional;

public interface PlaylistUserService {
    List<PlaylistUser> getAllPlaylistUser();
    Optional<PlaylistUser> getPlaylistUserById(Integer playlistUserId);
    PlaylistUser createOrUpdate(PlaylistUserDTO playlistUserDTO);
    void deletePlaylistUser(Integer playlistUserId);
}
