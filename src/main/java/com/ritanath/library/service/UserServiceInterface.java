package com.ritanath.library.service;


import java.util.List;

import com.ritanath.library.model.AppUser;

public interface UserServiceInterface {

    AppUser add(AppUser user);

    AppUser findById(Long id);

    List<AppUser> findAll();

    void deleteById(Long id);

    AppUser updateById(Long id, AppUser updatedUser);
}
