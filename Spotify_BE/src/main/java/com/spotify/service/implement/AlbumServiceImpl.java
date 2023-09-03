package com.spotify.service.implement;

import com.spotify.entity.Album;
import com.spotify.repository.AlbumRepository;
import com.spotify.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> getAllAlbum() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> getAlbumById(Integer albumId) {
        return albumRepository.findById(albumId);
    }

    @Override
    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Album updateAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void deleteAlbum(Integer albumId) {
        albumRepository.deleteById(albumId);
    }
}
