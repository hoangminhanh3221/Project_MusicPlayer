package com.spotify.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotify.entity.Authority;
import com.spotify.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private String accountId;

    private String email;

    private String password;

    private Integer userId;
}
