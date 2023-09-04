package com.spotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDTO {
    private Integer artistId;

    private String artistName;

    private String genre;

    private Long monthlyListener;

    private Long follower;

    private Boolean gender;

    private String artistImage;

    private Boolean isDeleted;
}
