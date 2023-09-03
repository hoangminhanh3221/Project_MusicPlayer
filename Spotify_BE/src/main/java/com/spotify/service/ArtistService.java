package com.spotify.service;

import com.spotify.entity.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> getAllArtist();

    Optional<Artist> getArtistById(Integer artistId);

    Artist createArtist(Artist artist);

    Artist updateArtist(Artist artist);

    void deleteArtist(Integer artistId);
}
