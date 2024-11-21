package com.ritanath.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ritanath.library.model.AppUser;
import java.util.List;



@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {
  AppUser findByEmail(String email);
}
