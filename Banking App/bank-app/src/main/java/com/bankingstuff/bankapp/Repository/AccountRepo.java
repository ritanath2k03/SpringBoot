package com.bankingstuff.bankapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankingstuff.bankapp.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long>{

    
}

