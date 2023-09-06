package com.spotify.service.implement;

import com.spotify.dto.PlaylistDTO;
import com.spotify.entity.Playlist;
import com.spotify.repository.PlaylistRepository;
import com.spotify.service.PlaylistService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final MessageSource messageSource;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository, MessageSource messageSource) {
        this.playlistRepository = playlistRepository;
        this.messageSource = messageSource;
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
    public Playlist createOrUpdate(PlaylistDTO playlistDTO) {
        checkDuplicatePlaylist(playlistDTO);
        Playlist playlist = new Playlist();
        BeanUtils.copyProperties(playlistDTO, playlist);
        return playlistRepository.save(playlist);
    }

    @Override
    public void deletePlaylist(Integer playlistId) {
        playlistRepository.deleteById(playlistId);
    }

    private void checkDuplicatePlaylist(PlaylistDTO playlistDTO){
        /*Kiểm tra duplicate nếu thỏa 2 điều kiện sau
         * 1. Bị trùng đữ liệu với database
         * 2. mã của dữ liệu check phải khác với mã tìm đc trong database
         * */
        if(playlistDTO.getPlaylistName() != null){
            Optional<Playlist> playlist = playlistRepository.findByPlaylistName(playlistDTO.getPlaylistName());
            if(playlist.isPresent() && !Objects.equals(playlist.get().getPlaylistId(), playlistDTO.getPlaylistId())){
                String errorMessage = messageSource.getMessage("duplicate", new Object[]{"Tên Playlist"},
                        LocaleContextHolder.getLocale());
                throw new RuntimeException(errorMessage);
            }
        }
    }
}
