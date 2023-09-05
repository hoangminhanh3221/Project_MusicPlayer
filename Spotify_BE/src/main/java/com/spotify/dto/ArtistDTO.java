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
public class ArtistDTO {
    private Integer artistId;

    @NotEmpty(message = "{notempty.artist.artistName}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "{pattern.artist.artistName}")
    private String artistName;

    @NotEmpty(message = "{notempty.genre}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "{pattern.genre}")
    private String genre;

    private Long monthlyListener;

    private Long follower;

    @NotNull(message = "{notnull.gender}")
    private Boolean gender;

    @NotEmpty(message = "{notempty.artist.artistImage}")
    private String artistImage;

    private Boolean isDeleted;
}
