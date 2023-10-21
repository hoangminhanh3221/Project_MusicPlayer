package com.spotify.security.service;

import com.spotify.dto.AccountDTO;
import com.spotify.dto.AuthorityDTO;
import com.spotify.entity.Account;
import com.spotify.entity.Authority;
import com.spotify.entity.Role;
import com.spotify.security.dto.LoginRequest;
import com.spotify.security.dto.LoginResponse;
import com.spotify.security.dto.RegisterRequest;
import com.spotify.security.jwt.JwtUtil;
import com.spotify.service.AccountService;
import com.spotify.service.AuthorityService;
import com.spotify.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AccountService accountService;
    private final RoleService roleService;
    private final AuthorityService authorityService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public LoginResponse register(RegisterRequest request) {
        AccountDTO accountDTO = new AccountDTO();
        BeanUtils.copyProperties(request, accountDTO);
        accountDTO.setPassword(passwordEncoder.encode(request.getPassword()));
        accountService.createOrUpdate(accountDTO);

        Role role = roleService.getRoleById("R01").orElse(null);

        Authority authority = new Authority();

        authority.setAccount(accountService.findByUsername(accountDTO.getUsername()).get());
        authority.setRole(role);

        AuthorityDTO authorityDTO = new AuthorityDTO();
        BeanUtils.copyProperties(authority,authorityDTO);
        authorityService.createOrUpdate(authorityDTO);
        String jwtToken = jwtUtil.generateToken(accountDTO.getUsername());
        return new LoginResponse(jwtToken);
    }

    public LoginResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        Account account = accountService.findByUsername(request.getUsername()).orElseThrow();
        String jwtToken = jwtUtil.generateToken(account.getUsername());
        return new LoginResponse(jwtToken);
    }

}
