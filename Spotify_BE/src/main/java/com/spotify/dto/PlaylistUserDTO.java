package com.spotify.dto;

import com.spotify.entity.Playlist;
import com.spotify.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistUserDTO {
    private Integer playlistUserId;

    private LocalDateTime createDate;

    private Integer playlistId;

    private Integer userId;
}
