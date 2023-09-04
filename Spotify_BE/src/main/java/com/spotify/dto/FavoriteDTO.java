package com.spotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDTO {
    private Integer favoriteId;

    private Integer userId;

    private Integer songId;
}
