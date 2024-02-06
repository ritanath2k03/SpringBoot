package com.bankingstuff.bankapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingstuff.bankapp.model.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails,Long>{
    
}
