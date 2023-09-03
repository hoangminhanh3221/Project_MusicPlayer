package com.spotify.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "favorite")
public class Favorite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FavoriteId")
    private Integer favoriteId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DatetimeFavorite", nullable = false)
    private LocalDateTime datetimeFavorite;

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "SongId", referencedColumnName = "SongId", nullable = false)
    private Song song;
}
