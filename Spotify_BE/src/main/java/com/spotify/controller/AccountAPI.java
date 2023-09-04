package com.spotify.controller;

import com.spotify.entity.Account;
import com.spotify.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/account")
public class AccountAPI {

    private final AccountService accountService;

    @Autowired
    public AccountAPI(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Account>> getAllAccount() {
        return ResponseEntity.ok(accountService.getAllAccount());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createAccount(@RequestBody Account account){
        if(account != null){
            accountService.createAccount(account);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping ("/update")
    public ResponseEntity<HttpStatus> updateAccount(
            @RequestBody Account account
    ){
        Optional<Account> currentAccount = accountService.getAccountById(account.getAccountId());
        if(currentAccount.isPresent()){
            accountService.updateAccount(account);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(
            @PathVariable("id") String id
    ){
        Optional<Account> currentAccount = accountService.getAccountById(id);
        if(currentAccount.isPresent()){
            accountService.deleteAccount(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
