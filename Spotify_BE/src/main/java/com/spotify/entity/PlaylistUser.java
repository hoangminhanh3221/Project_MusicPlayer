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
@Table(name = "playlist_user")
public class PlaylistUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlaylistUserId")
    private Integer playlistUserId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreateDate", nullable = false)
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "PlaylistId", referencedColumnName = "PlaylistId", nullable = false)
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    private User user;
}
