package com.spotify.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "album")
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AlbumId")
    private Integer albumId;

    @Column(name = "AlbumName", length = 50, nullable = false)
    private String albumName;

    @Column(name = "AlbumTitle", nullable = false)
    private String albumTitle;

    @Temporal(TemporalType.DATE)
    @Column(name = "ReleaseDate", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "Genre", length = 50, nullable = false)
    private String genre;

    @Column(name = "AlbumImage", length = 50, nullable = false)
    private String albumImage;

    @Column(name = "IsDeleted", nullable = false)
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "ArtistId", referencedColumnName = "ArtistId", nullable = false)
    private Artist artist;

}
