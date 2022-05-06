package com.example.test_spring_boot.Configuration.Security;

import com.example.test_spring_boot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceCustom implements org.springframework.security.core.userdetails.UserDetailsService{
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetailCustom(userRepository.getByUsername(username));
    }
}
