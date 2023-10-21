package com.spotify.controller;

import com.spotify.dto.AccountDTO;
import com.spotify.entity.Account;
import com.spotify.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final MessageSource messageSource;

    @GetMapping("/getAll")
    public ResponseEntity<List<Account>> getAllAccount() {
        return ResponseEntity.ok(accountService.getAllAccount());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createAccount(@RequestBody @Valid AccountDTO accountDTO) {
        if (accountDTO != null) {
            accountService.createOrUpdate(accountDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateAccount(@RequestBody @Valid AccountDTO accountDTO) {
        Optional<Account> currentAccount = accountService.getAccountById(accountDTO.getAccountId());
        if (currentAccount.isPresent()) {
            accountService.createOrUpdate(accountDTO);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Account"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") Integer id) {
        Optional<Account> currentAccount = accountService.getAccountById(id);
        if (currentAccount.isPresent()) {
            accountService.deleteAccount(id);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Account"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

}
