package com.spotify.service.implement;

import com.spotify.dto.ArtistDTO;
import com.spotify.entity.Artist;
import com.spotify.repository.ArtistRepository;
import com.spotify.service.ArtistService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> getAllArtist() {
        return artistRepository.findAll();
    }

    @Override
    public Optional<Artist> getArtistById(Integer artistId) {
        return artistRepository.findById(artistId);
    }

    @Override
    public Artist createOrUpdate(ArtistDTO artistDTO) {
        Artist artist = new Artist();
        BeanUtils.copyProperties(artistDTO, artist);
        return artistRepository.save(artist);
    }

    @Override
    public void deleteArtist(Integer artistId) {
        artistRepository.deleteById(artistId);
    }
}
