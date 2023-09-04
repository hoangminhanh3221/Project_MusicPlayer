package com.spotify.dto;

import com.spotify.entity.Artist;
import com.spotify.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowerDTO {
    private Integer followerId;

    private LocalDateTime datetimeFollow;

    private Integer userId;

    private Integer artistId;
}
