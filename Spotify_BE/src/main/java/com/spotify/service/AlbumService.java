package com.spotify.service;

import com.spotify.entity.Album;
import com.spotify.entity.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> getAllAlbum();

    Optional<Album> getAlbumById(Integer albumId);

    Album createAlbum(Album album);

    Album updateAlbum(Album album);

    void deleteAlbum(Integer albumId);
}
