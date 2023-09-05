package com.spotify.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {

    private Integer albumId;

    @NotEmpty(message = "{notempty.album.albumName}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "{pattern.album.albumName}")
    private String albumName;

    @NotEmpty(message = "{notempty.album.albumName}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "{pattern.album.albumTitle}")
    private String albumTitle;

    @Future(message = "{future.album.releaseDate}")
    @NotEmpty(message = "{notempty.album.releaseDate}")
    private LocalDateTime releaseDate;

    @NotEmpty(message = "{notempty.genre}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "{pattern.genre}")
    private String genre;

    @NotEmpty(message = "{notempty.album.albumImage}")
    private String albumImage;

    private Boolean isDeleted;

    private Integer artistId;
}
