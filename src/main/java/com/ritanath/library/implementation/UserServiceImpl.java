package com.ritanath.library.implementation;

import com.ritanath.library.config.CachingConfig;
import com.ritanath.library.model.AppUser;
import com.ritanath.library.repo.UserRepo;
import com.ritanath.library.service.UserServiceInterface;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserServiceInterface {

    
    private final UserRepo appUserRepo;
    
    private final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Override
    public AppUser add(AppUser appUser) {
        appUser.setPhone(passwordEncoder.encode(appUser.getPhone()));
        return appUserRepo.save(appUser);
    }

    @Override
    @Cacheable(cacheNames = CachingConfig.StudentS_CACHE_NAME, key = "#id")
    public AppUser findById(Long id) {
        return appUserRepo.findById(id)
                .orElseThrow();
    }

    @Override
    @Cacheable(cacheNames = CachingConfig.StudentS_CACHE_NAME, key = "#root.methodName")
    public List<AppUser> findAll() {
        return appUserRepo.findAll();
    }

    @Override
    @CacheEvict(cacheNames = CachingConfig.StudentS_CACHE_NAME, key = "#id")
    public void deleteById(Long id) {
        AppUser appUser = appUserRepo.findById(id)
                        .orElseThrow();
        appUserRepo.deleteById(appUser.getId());
    }

    @Override
    @CachePut(cacheNames = CachingConfig.StudentS_CACHE_NAME, key = "#id")
    public AppUser updateById(Long id, AppUser updatedStudent) {
        AppUser appUser = appUserRepo.findById(id)
                .orElseThrow();

        appUser.setName(updatedStudent.getName());
        appUser.setEmail(updatedStudent.getEmail());
        appUser.setPhone(updatedStudent.getPhone());
        appUser.setAddress(updatedStudent.getAddress());
        appUser = appUserRepo.save(appUser);

        return appUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = appUserRepo.findByEmail(username);
        System.out.println("My username  is : "+ username+" and value is : "+user);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new UserDetailsImpl(user);
        
    }
}
