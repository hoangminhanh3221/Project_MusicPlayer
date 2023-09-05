package com.spotify.service;

import com.spotify.dto.AlbumDTO;
import com.spotify.entity.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> getAllAlbum();

    Optional<Album> getAlbumById(Integer albumId);

    Album createOrUpdate(AlbumDTO albumDTO);

    void deleteAlbum(Integer albumId);
}
