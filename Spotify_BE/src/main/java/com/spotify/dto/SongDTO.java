package com.spotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {

    private Integer songId;

    private String songName;

    private Integer durationSeconds;

    private String path;

    private Boolean isDeleted;

    private Integer albumId;

    private Integer artistId;
}
