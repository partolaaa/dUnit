package com.willofd.dunit.services;

/**
 * @author Ivan Partola
 */
public interface AuthService {
    String redirectIfLogged(String loggedPage, String notLoggedPage);
}
