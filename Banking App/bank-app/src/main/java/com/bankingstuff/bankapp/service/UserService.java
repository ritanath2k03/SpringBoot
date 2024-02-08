package com.bankingstuff.bankapp.service;

import org.springframework.stereotype.Service;

import com.bankingstuff.bankapp.model.UserDetails;

@Service
public interface UserService {

    UserDetails editUser(UserDetails userDetails, Long id);

}
