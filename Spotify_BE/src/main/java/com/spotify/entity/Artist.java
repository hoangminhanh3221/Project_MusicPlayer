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
@Table(name = "artist")
public class Artist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArtistId")
    private Integer artistId;

    @Column(name = "ArtistName", length = 50, nullable = false)
    private String artistName;

    @Column(name = "Genre", length = 50, nullable = false)
    private String genre;

    @Column(name = "MonthlyListener", nullable = false)
    private Long monthlyListener;

    @Column(name = "Follower", nullable = false)
    private Long follower;

    @Column(name = "Gender", nullable = false)
    private Boolean gender;

    @Column(name = "ArtistImage", length = 50, nullable = false)
    private String artistImage;

    @Column(name = "IsDeleted", nullable = false)
    private Boolean isDeleted;

    @JsonIgnore
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Album> albums;

    @JsonIgnore
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<ArtistSong> artistSongs;

    @JsonIgnore
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Follower> followers;

}
