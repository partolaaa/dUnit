package com.willofd.dunit.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Ivan Partola
 */
@Component
public class AuthenticationCreator {

    public Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getName(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
