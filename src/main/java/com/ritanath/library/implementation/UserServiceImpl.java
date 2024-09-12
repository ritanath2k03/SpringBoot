package com.ritanath.library.implementation;

import com.ritanath.library.config.CachingConfig;
import com.ritanath.library.model.AppUser;
import com.ritanath.library.repo.UserRepo;
import com.ritanath.library.service.UserServiceInterface;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserServiceInterface {


    private final UserRepo appUserRepo;

    @Override
    public AppUser add(AppUser appUser) {
        return appUserRepo.save(appUser);
    }

    @Override
    @Cacheable(cacheNames = CachingConfig.PATRONS_CACHE_NAME, key = "#id")
    public AppUser findById(Long id) {
        return appUserRepo.findById(id)
                .orElseThrow();
    }

    @Override
    @Cacheable(cacheNames = CachingConfig.PATRONS_CACHE_NAME, key = "#root.methodName")
    public List<AppUser> findAll() {
        return appUserRepo.findAll();
    }

    @Override
    @CacheEvict(cacheNames = CachingConfig.PATRONS_CACHE_NAME, key = "#id")
    public void deleteById(Long id) {
        AppUser appUser = appUserRepo.findById(id)
                        .orElseThrow();
        appUserRepo.deleteById(appUser.getId());
    }

    @Override
    @CachePut(cacheNames = CachingConfig.PATRONS_CACHE_NAME, key = "#id")
    public AppUser updateById(Long id, AppUser updatedPatron) {
        AppUser appUser = appUserRepo.findById(id)
                .orElseThrow();

        appUser.setName(updatedPatron.getName());
        appUser.setEmail(updatedPatron.getEmail());
        appUser.setPhone(updatedPatron.getPhone());
        appUser.setAddress(updatedPatron.getAddress());
        appUser = appUserRepo.save(appUser);

        return appUser;
    }
}
