package com.bankingstuff.bankapp.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingstuff.bankapp.Repository.UserDetailsRepo;
import com.bankingstuff.bankapp.model.UserDetails;
import com.bankingstuff.bankapp.service.UserService;

@Service
public class UserserviceImpl implements UserService {

    @Autowired
    UserDetailsRepo repo;

    @Override
    public UserDetails editUser(UserDetails userDetails, Long id) {
        // TODO Auto-generated method stub
        userDetails.setUserInfoId(id);
        return repo.save(userDetails);
    }

}
