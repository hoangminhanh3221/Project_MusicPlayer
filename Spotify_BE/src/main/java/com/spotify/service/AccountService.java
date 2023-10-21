package com.spotify.service;

import com.spotify.dto.AccountDTO;
import com.spotify.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAllAccount();
    Optional<Account> getAccountById(Integer accountId);
    Account createOrUpdate(AccountDTO accountDTO);
    void deleteAccount(Integer accountId);
    Optional<Account> findByUsername(String username);
}
