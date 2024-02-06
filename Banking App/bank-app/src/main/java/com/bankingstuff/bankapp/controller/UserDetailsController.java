package com.bankingstuff.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bankingstuff.bankapp.Repository.UserDetailsRepo;

@RestController
public class UserDetailsController {
    @Autowired
    UserDetailsRepo repo;

}
