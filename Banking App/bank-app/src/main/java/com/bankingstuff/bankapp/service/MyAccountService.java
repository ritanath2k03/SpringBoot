package com.bankingstuff.bankapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bankingstuff.bankapp.model.Account;

@Service
public interface MyAccountService {
    Account createAccount(Account account);

    Account getAccount(Long id);

    void deleteAccount(Long id);

    Account deposite(Long id, Double amount);

    List<Account> getAll();
}
