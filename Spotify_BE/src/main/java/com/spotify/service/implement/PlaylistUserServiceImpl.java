package com.spotify.service.implement;

import com.spotify.dto.PlaylistUserDTO;
import com.spotify.entity.PlaylistUser;
import com.spotify.repository.PlaylistUserRepository;
import com.spotify.service.PlaylistUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaylistUserServiceImpl implements PlaylistUserService {

    private final PlaylistUserRepository playlistUserRepository;

    @Override
    public List<PlaylistUser> getAllPlaylistUser() {
        return playlistUserRepository.findAll();
    }

    @Override
    public Optional<PlaylistUser> getPlaylistUserById(Integer playlistUserId) {
        return playlistUserRepository.findById(playlistUserId);
    }

    @Override
    public PlaylistUser createOrUpdate(PlaylistUserDTO playlistUserDTO) {
        PlaylistUser playlistUser = new PlaylistUser();
        BeanUtils.copyProperties(playlistUserDTO, playlistUser);
        return playlistUserRepository.save(playlistUser);
    }

    @Override
    public void deletePlaylistUser(Integer playlistUserId) {
        playlistUserRepository.deleteById(playlistUserId);
    }
}
