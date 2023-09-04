package com.spotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistUserDTO {
    private Integer playlistUserId;

    private Integer playlistId;

    private Integer userId;
}
