package com.spotify.service.implement;

import com.spotify.dto.AuthorityDTO;
import com.spotify.entity.Authority;
import com.spotify.repository.AuthorityRepository;
import com.spotify.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Override
    public List<Authority> getAllAuthority() {
        return authorityRepository.findAll();
    }

    @Override
    public Optional<Authority> getAuthorityById(Integer authorityId) {
        return authorityRepository.findById(authorityId);
    }

    @Override
    public Authority createOrUpdate(AuthorityDTO authorityDTO) {
        Authority authority = new Authority();
        BeanUtils.copyProperties(authorityDTO, authority);
        return authorityRepository.save(authority);
    }

    @Override
    public void deleteAuthority(Integer authorityId) {
        authorityRepository.deleteById(authorityId);
    }

    @Override
    public List<Authority> findByAccountId(Integer accountId) {
        return authorityRepository.findAuthoritiesByAccount_AccountId(accountId);
    }
}
