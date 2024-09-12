package com.ritanath.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ritanath.library.model.AppUser;


@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {
}
