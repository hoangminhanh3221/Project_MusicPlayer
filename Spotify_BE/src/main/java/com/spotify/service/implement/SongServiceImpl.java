package com.spotify.service.implement;

import com.spotify.dto.SongDTO;
import com.spotify.entity.Song;
import com.spotify.repository.SongRepository;
import com.spotify.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    @Override
    public List<Song> getAllSong() {
        return songRepository.findAll();
    }

    @Override
    public Optional<Song> getSongById(Integer albumId) {
        return songRepository.findById(albumId);
    }

    @Override
    public Song createOrUpdate(SongDTO songDTO) {
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        return songRepository.save(song);
    }
    
    @Override
    public void deleteSong(Integer albumId) {
        songRepository.deleteById(albumId);
    }
}
