package com.spotify.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistDTO {
    private Integer playlistId;

    @NotEmpty(message = "{notempty.playlist.playlistName}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "{pattern.playlist.playlistName}")
    private String playlistName;

    private String description;

    @NotEmpty(message = "{notempty.playlist.playlistImage}")
    private String playlistImage;

    @NotNull(message = "{notnull.playlist.isPublic}")
    private Boolean isPublic;
}
