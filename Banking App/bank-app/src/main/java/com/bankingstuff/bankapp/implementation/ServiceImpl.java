package com.bankingstuff.bankapp.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingstuff.bankapp.Repository.AccountRepo;
import com.bankingstuff.bankapp.model.Account;
import com.bankingstuff.bankapp.service.MyAccountService;

@Service
public class ServiceImpl implements MyAccountService{

    @Autowired
    AccountRepo repo;
    @SuppressWarnings("null")
    @Override
    public Account createAccount( Account account) {        
        return repo.save(account);
    }
    @SuppressWarnings("null")
    @Override
    public Account getAccount(Long id) {
        // TODO Auto-generated method stub
        return repo.findById(id).orElse(null);
    }
    @SuppressWarnings("null")
    @Override
    public void deleteAccount(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }
    
}
