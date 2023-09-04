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
public class HistoryDTO {
    private Integer historyId;

    private LocalDateTime datetimeListened;

    private Integer userId;

    private Integer songId;
}
