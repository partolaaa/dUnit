package com.willofd.dunit.services;

import com.willofd.dunit.entities.SimpleUser;

import java.util.Optional;


/**
 * @author Ivan Partola
 */

public interface SimpleUserService {
    void save(SimpleUser simpleUser);
    Optional<SimpleUser> findUserByUserId(Long userId);
    Optional<SimpleUser> findUserByEmail(String email);
    Optional<SimpleUser> findUserByUsername(String username);
    Optional<SimpleUser> getCurrentUserFromSession();
}

