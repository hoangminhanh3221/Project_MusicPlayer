package com.spotify.service;

import com.spotify.dto.ArtistDTO;
import com.spotify.entity.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> getAllArtist();

    Optional<Artist> getArtistById(Integer artistId);

    Artist createOrUpdate(ArtistDTO artistDTO);

    void deleteArtist(Integer artistId);
}
