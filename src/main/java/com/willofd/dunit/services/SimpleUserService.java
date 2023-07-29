package com.willofd.dunit.services;

import com.willofd.dunit.entity.SimpleUser;

import java.util.Optional;


/**
 * @author Ivan Partola
 */

public interface SimpleUserService {
    void save(SimpleUser simpleUser);
    Optional<SimpleUser> findUserByUserId(Long userId);
    Optional<SimpleUser> findUserByEmail(String email);
}

