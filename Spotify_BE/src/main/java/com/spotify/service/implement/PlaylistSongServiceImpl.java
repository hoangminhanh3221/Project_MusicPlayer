package com.spotify.service.implement;

import com.spotify.dto.PlaylistSongDTO;
import com.spotify.entity.PlaylistSong;
import com.spotify.repository.PlaylistSongRepository;
import com.spotify.service.PlaylistSongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistSongServiceImpl implements PlaylistSongService {

    private final PlaylistSongRepository playlistSongRepository;

    @Autowired
    public PlaylistSongServiceImpl(PlaylistSongRepository playlistSongRepository) {
        this.playlistSongRepository = playlistSongRepository;
    }

    @Override
    public List<PlaylistSong> getAllPlaylistSong() {
        return playlistSongRepository.findAll();
    }

    @Override
    public Optional<PlaylistSong> getPlaylistSongById(Integer playlistSongId) {
        return playlistSongRepository.findById(playlistSongId);
    }

    @Override
    public PlaylistSong createOrUpdate(PlaylistSongDTO playlistSongDTO) {
        PlaylistSong playlistSong = new PlaylistSong();
        BeanUtils.copyProperties(playlistSongDTO, playlistSong);
        return playlistSongRepository.save(playlistSong);
    }
    @Override
    public void deletePlaylistSong(Integer playlistSongId) {
        playlistSongRepository.deleteById(playlistSongId);
    }
}
