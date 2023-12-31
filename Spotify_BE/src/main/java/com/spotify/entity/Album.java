package com.spotify.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ReleaseDate", nullable = false)
    private LocalDateTime releaseDate;

    @Column(name = "Genre", length = 50, nullable = false)
    private String genre;

    @Column(name = "AlbumImage", length = 50, nullable = false)
    private String albumImage;

    @Column(name = "IsDeleted", nullable = false)
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "ArtistId", referencedColumnName = "ArtistId", nullable = false)
    private Artist artist;

    @JsonIgnore
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<AlbumSong> albumSongs;

}
