package com.spotify.security.service;

import com.spotify.entity.Account;
import com.spotify.entity.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetail implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> roles;

    public UserDetail(Account account, List<Authority> lists) {
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.roles = extractRoles(account, lists);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    private List<GrantedAuthority> extractRoles(Account account, List<Authority> lists) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (account != null && account.getAuthorities() != null) {
            for (Authority authority : lists) {
                if (authority != null && authority.getRole() != null) {
                    authorities.add(new SimpleGrantedAuthority(authority.getRole().getRoleName()));
                }
            }
        }
        return authorities;
    }
}
