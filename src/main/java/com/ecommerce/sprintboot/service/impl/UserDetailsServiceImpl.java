package com.ecommerce.sprintboot.service.impl;

import com.ecommerce.sprintboot.entity.User;
import com.ecommerce.sprintboot.entity.UserDetailsImpl;
import com.ecommerce.sprintboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> oUser = userRepository.findByEmail( username );
        oUser.orElseThrow( ()-> new UsernameNotFoundException("username not found"));

        return oUser
                .map(UserDetailsImpl::new).get();
    }
}
