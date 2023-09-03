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
@Table(name = "history")
public class History implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HistoryId")
    private Integer historyId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DatetimeListened", nullable = false)
    private LocalDateTime datetimeListened;

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "SongId", referencedColumnName = "SongId", nullable = false)
    private Song song;
}
