package com.spotify.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "album_song")
public class AlbumSong implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AlbumSongId")
    private Integer albumSongId;

    @ManyToOne
    @JoinColumn(name = "AlbumId", referencedColumnName = "AlbumId", nullable = false)
    private Album album;

    @ManyToOne
    @JoinColumn(name = "SongId", referencedColumnName = "SongId", nullable = false)
    private Song song;
}
