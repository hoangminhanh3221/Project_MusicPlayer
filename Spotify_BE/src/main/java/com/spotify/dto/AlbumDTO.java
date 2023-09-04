package com.spotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {
    private Integer albumId;

    private String albumName;

    private String albumTitle;

    private LocalDate releaseDate;

    private String genre;

    private String albumImage;

    private Boolean isDeleted;

    private Integer artistId;
}
