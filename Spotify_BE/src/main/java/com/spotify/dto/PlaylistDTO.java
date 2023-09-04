package com.spotify.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistDTO {
    private Integer playlistId;

    private String playlistName;

    private String description;

    private String playlistImage;

    private Boolean isPublic;
}
