package com.smartosc.ecommerce.clothes.service;

import com.smartosc.ecommerce.clothes.model.User;
import com.smartosc.ecommerce.clothes.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User users = userRepository.findUserByUsername(username);

        if(null == users) {
            throw new UsernameNotFoundException("Username not found");
        }

        return users;
    }
}
