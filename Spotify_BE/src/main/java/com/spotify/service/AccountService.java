package com.spotify.service;

import com.spotify.dto.AccountDTO;
import com.spotify.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAllAccount();

    Optional<Account> getAccountById(String accountId);

    Account createOrUpdate(AccountDTO accountDTO);

    void deleteAccount(String accountId);
}
