package com.spotify.service.implement;

import com.spotify.dto.AccountDTO;
import com.spotify.entity.Account;
import com.spotify.repository.AccountRepository;
import com.spotify.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final MessageSource messageSource;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, MessageSource messageSource) {
        this.accountRepository = accountRepository;
        this.messageSource = messageSource;
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccountById(String accountId) {
        return accountRepository.findById(accountId);
    }

    @Override
    public Account createOrUpdate(AccountDTO accountDTO) {
        checkDuplicateAccount(accountDTO);
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO, account);
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String accountId) {
        accountRepository.deleteById(accountId);
    }

    private void checkDuplicateAccount(AccountDTO accountDTO){
        /*Kiểm tra duplicate nếu thỏa điều kiện sau
         * 1. Bị trùng đữ liệu với database*/
        if(accountDTO.getAccountId() != null){
            Optional<Account> account = accountRepository.findById(accountDTO.getAccountId());
            if(account.isPresent()){
                String errorMessage = messageSource.getMessage("duplicate", new Object[]{"Tên tài khoản"},
                        LocaleContextHolder.getLocale());
                throw new RuntimeException(errorMessage);
            }
        }
    }
}
