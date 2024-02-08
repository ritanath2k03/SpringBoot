package com.bankingstuff.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingstuff.bankapp.model.UserDetails;
import com.bankingstuff.bankapp.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/bank")
public class UserDetailsController {
    @Autowired
    UserService service;

    @PutMapping("/edit/{id}")
    public UserDetails changeUser(@PathVariable Long id, @RequestBody UserDetails userDetails) {
        return service.editUser(userDetails, id);
    }

}
