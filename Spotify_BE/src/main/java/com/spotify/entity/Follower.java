package com.spotify.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "follower")
public class Follower implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FollowerId")
    private Integer followerId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DatetimeFollow", nullable = false)
    private LocalDateTime datetimeFollow;

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ArtistId", referencedColumnName = "ArtistId", nullable = false)
    private Artist artist;
}
