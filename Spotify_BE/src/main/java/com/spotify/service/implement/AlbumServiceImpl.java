package com.spotify.service.implement;

import com.spotify.dto.AlbumDTO;
import com.spotify.entity.Album;
import com.spotify.repository.AlbumRepository;
import com.spotify.service.AlbumService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final MessageSource messageSource;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository, MessageSource messageSource) {
        this.albumRepository = albumRepository;
        this.messageSource = messageSource;
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
    public Album createOrUpdate(AlbumDTO albumDTO) {
        checkDuplicateAlbum(albumDTO);
        Album album = new Album();
        BeanUtils.copyProperties(albumDTO, album);
        return albumRepository.save(album);
    }

    @Override
    public void deleteAlbum(Integer albumId) {
        albumRepository.deleteById(albumId);
    }

    private void checkDuplicateAlbum(AlbumDTO albumDTO){
        /*Kiểm tra duplicate nếu thỏa 2 điều kiện sau
        * 1. Bị trùng đữ liệu với database
        * 2. mã của dữ liệu check phải khác với mã tìm đc trong database*/
        if(albumDTO.getAlbumName() != null){
            Optional<Album> album = albumRepository.findByAlbumName(albumDTO.getAlbumName());
            if(album.isPresent() && !Objects.equals(album.get().getAlbumId(), albumDTO.getAlbumId())){
                String errorMessage = messageSource.getMessage("duplicate", new Object[]{"Tên Album"},
                        LocaleContextHolder.getLocale());
                throw new RuntimeException(errorMessage);
            }
        }
    }
}
