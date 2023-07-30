package com.willofd.dunit.services.impl;


import com.willofd.dunit.dao.SimpleUserDAO;
import com.willofd.dunit.entities.SimpleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * @author Ivan Partola
 */

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SimpleUserDAO simpleUserDAO;

    @Autowired
    public UserDetailsServiceImpl(SimpleUserDAO simpleUserDAO) {
        this.simpleUserDAO = simpleUserDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SimpleUser simpleUser = simpleUserDAO.getSimpleUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        HashSet<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(simpleUser.getRole()));
        return new User(simpleUser.getEmail(), simpleUser.getPassword(), roles);
    }
}

