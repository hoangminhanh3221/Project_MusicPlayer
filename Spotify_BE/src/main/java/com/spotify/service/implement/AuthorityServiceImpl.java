package com.spotify.service.implement;

import com.spotify.entity.Authority;
import com.spotify.repository.AuthorityRepository;
import com.spotify.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public List<Authority> getAllAuthority() {
        return authorityRepository.findAll();
    }

    @Override
    public Optional<Authority> getAuthorityById(Integer authorityId) {
        return authorityRepository.findById(authorityId);
    }

    @Override
    public Authority createAuthority(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public Authority updateAuthority(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public void deleteAuthority(Integer authorityId) {
        authorityRepository.deleteById(authorityId);
    }
}
