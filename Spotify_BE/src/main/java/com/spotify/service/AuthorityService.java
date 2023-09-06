package com.spotify.service;

import com.spotify.dto.AuthorityDTO;
import com.spotify.entity.Authority;

import java.util.List;
import java.util.Optional;

public interface AuthorityService {
    List<Authority> getAllAuthority();
    Optional<Authority> getAuthorityById(Integer authorityId);
    Authority createOrUpdate(AuthorityDTO authorityDTO);
    void deleteAuthority(Integer authorityId);
}
