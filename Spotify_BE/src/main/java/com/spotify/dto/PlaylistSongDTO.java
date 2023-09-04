package com.spotify.dto;

import com.spotify.entity.Playlist;
import com.spotify.entity.Song;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistSongDTO {
    private Integer playlistSongId;

    private LocalDateTime createDate;

    private Integer playlistId;

    private Integer songId;
}
