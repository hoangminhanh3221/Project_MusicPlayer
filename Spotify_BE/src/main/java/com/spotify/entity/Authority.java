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
@Table(name = "authority")
public class Authority implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuthorityId")
    private Integer authorityId;

    @ManyToOne
    @JoinColumn(name = "AccountId", referencedColumnName = "AccountId", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "RoleId", referencedColumnName = "RoleId", nullable = false)
    private Role role;
}
