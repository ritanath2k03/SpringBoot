package com.ritanath.library.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ritanath.library.model.AppUser;

import java.util.Collection;
@Service
public class UserDetailsImpl implements UserDetails {

    @Autowired
    private final AppUser user;

    public UserDetailsImpl(AppUser user) {
        this.user = user;
    }

  

    @Override
    public String getPassword() {
        return user.getPhone();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    
        return null;
    }
}
