package com.spotify.service.implement;

import com.spotify.entity.Song;
import com.spotify.repository.SongRepository;
import com.spotify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository albumRepository;

    @Autowired
    public SongServiceImpl(SongRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> getAllSong() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Song> getSongById(Integer albumId) {
        return albumRepository.findById(albumId);
    }

    @Override
    public Song createSong(Song album) {
        return albumRepository.save(album);
    }

    @Override
    public Song updateSong(Song album) {
        return albumRepository.save(album);
    }

    @Override
    public void deleteSong(Integer albumId) {
        albumRepository.deleteById(albumId);
    }
}
