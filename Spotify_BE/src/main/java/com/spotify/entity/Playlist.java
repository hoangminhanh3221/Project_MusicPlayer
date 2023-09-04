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
@Table(name = "playlist")
public class Playlist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlaylistId")
    private Integer playlistId;

    @Column(name = "PlaylistName", length = 50, nullable = false)
    private String playlistName;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "PlaylistImage", length = 50, nullable = false)
    private String playlistImage;

    @Column(name = "IsPublic", nullable = false)
    private Boolean isPublic;

    @JsonIgnore
    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private List<PlaylistUser> playlistUsers;

    @JsonIgnore
    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private List<PlaylistSong> playlistSongs;

}
