package com.spotify.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Integer userId;

    @Column(name = "UserName", length = 50, nullable = false)
    private String userName;

    @Column(name = "Gender", nullable = false)
    private Boolean gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "DOB", nullable = false)
    private LocalDate dob;

    @Column(name = "Country", length = 50, nullable = false)
    private String country;

    @Column(name = "UserImage", length = 50, nullable = false)
    private String userImage;

    @OneToOne
    @JoinColumn(name = "AccountId", referencedColumnName = "AccountId", unique = true)
    private Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PlaylistUser> playlistUsers;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<History> histories;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Favorite> favorites;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Follower> followers;

}
