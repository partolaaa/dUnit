package com.willofd.dunit.services.impl;

import com.willofd.dunit.services.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Ivan Partola
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String redirectIfLogged(String loggedPage, String notLoggedPage) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")
                ? loggedPage : notLoggedPage;
    }
}
