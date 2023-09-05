package com.spotify.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {

    private Integer songId;

    @NotEmpty(message = "{notempty.song.songName}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "{pattern.song.songName}")
    private String songName;

    private Integer durationSeconds;

    private String path;

    @NotEmpty(message = "{notempty.song.songImage}")
    private String songImage;

    private Boolean isDeleted;

    private Integer albumId;

    private Integer artistId;
}
