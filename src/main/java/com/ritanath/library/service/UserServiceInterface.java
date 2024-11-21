package com.ritanath.library.service;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ritanath.library.model.AppUser;

public interface UserServiceInterface extends UserDetailsService{

    AppUser add(AppUser user);

    AppUser findById(Long id);

    List<AppUser> findAll();

    void deleteById(Long id);

    AppUser updateById(Long id, AppUser updatedUser);
}
