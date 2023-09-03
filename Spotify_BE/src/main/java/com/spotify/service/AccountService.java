package com.spotify.service;

import com.spotify.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAllAccount();

    Optional<Account> getAccountById(String accountId);

    Account createAccount(Account account);

    Account updateAccount(Account account);

    void deleteAccount(String accountId);
}
