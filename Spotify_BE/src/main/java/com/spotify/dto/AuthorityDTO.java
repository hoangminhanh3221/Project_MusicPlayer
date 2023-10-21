package com.spotify.dto;

import com.spotify.entity.Account;
import com.spotify.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityDTO {
    private Integer authorityId;

    private Account account;

    private Role role;
}
