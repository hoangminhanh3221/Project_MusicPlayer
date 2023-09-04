package com.spotify.dto;

import com.spotify.entity.Song;
import com.spotify.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDTO {
    private Integer favoriteId;

    private LocalDateTime datetimeFavorite;

    private Integer userId;

    private Integer songId;
}
