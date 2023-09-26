package com.spotify.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "song")
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SongId")
    private Integer songId;

    @Column(name = "SongName", length = 50, nullable = false)
    private String songName;

    @Column(name = "DurationSeconds", nullable = false)
    private Integer durationSeconds;

    @Column(name = "Path", length = 50, nullable = false)
    private String path;

    @Column(name = "SongImage", length = 50, nullable = false)
    private String songImage;

    @Column(name = "IsDeleted", nullable = false)
    private Boolean isDeleted;

    @JsonIgnore
    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL)
    private List<AlbumSong> albumSongs;

    @JsonIgnore
    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL)
    private List<ArtistSong> artistSongs;

    @JsonIgnore
    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL)
    private List<PlaylistSong> playlistSongs;

    @JsonIgnore
    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL)
    private List<History> histories;

    @JsonIgnore
    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL)
    private List<Favorite> favorites;
}
