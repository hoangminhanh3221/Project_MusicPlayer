package com.spotify.repository;

import com.spotify.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    List<Authority> findAuthoritiesByAccount_AccountId(Integer accountId);
}
