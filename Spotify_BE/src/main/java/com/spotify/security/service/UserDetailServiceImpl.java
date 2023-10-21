package com.spotify.security.service;

import com.spotify.entity.Account;
import com.spotify.entity.Authority;
import com.spotify.service.AccountService;
import com.spotify.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final AccountService accountService;
    private final AuthorityService authorityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountService.findByUsername(username);
//        if(account.isEmpty()){
//            throw new UsernameNotFoundException("User not found", null);
//        }
//        return new User(account.get().getUsername(),account.get().getPassword(),new ArrayList<>());
        if (account.isPresent()) {
            List<Authority> lists = authorityService.findByAccountId(account.get().getAccountId());
            for(Authority authority : lists){
                System.out.println(authority.getRole().getRoleName());
            }
            return new UserDetail(account.get(), lists);
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
