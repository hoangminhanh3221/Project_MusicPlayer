package com.spotify.service.implement;

import com.spotify.entity.Playlist;
import com.spotify.repository.PlaylistRepository;
import com.spotify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<Playlist> getAllPlaylist() {
        return playlistRepository.findAll();
    }

    @Override
    public Optional<Playlist> getPlaylistById(Integer playlistId) {
        return playlistRepository.findById(playlistId);
    }

    @Override
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist updatePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public void deletePlaylist(Integer playlistId) {
        playlistRepository.deleteById(playlistId);
    }
}
