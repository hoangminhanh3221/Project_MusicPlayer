package com.spotify.service;

import com.spotify.entity.Authority;

import java.util.List;
import java.util.Optional;

public interface AuthorityService {
    List<Authority> getAllAuthority();

    Optional<Authority> getAuthorityById(Integer authorityId);

    Authority createAuthority(Authority authority);

    Authority updateAuthority(Authority authority);

    void deleteAuthority(Integer authorityId);
}
