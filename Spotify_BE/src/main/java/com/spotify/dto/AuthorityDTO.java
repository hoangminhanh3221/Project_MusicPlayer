package com.spotify.dto;

import com.spotify.entity.Account;
import com.spotify.entity.Role;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityDTO {
    private Integer authorityId;

    private String accountId;

    private String roleId;
}
