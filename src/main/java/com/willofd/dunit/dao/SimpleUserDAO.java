package com.willofd.dunit.dao;

import com.willofd.dunit.entities.SimpleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Ivan Partola
 */

@Component
public interface SimpleUserDAO extends JpaRepository<SimpleUser, Long> {
    Optional<SimpleUser> getSimpleUserByEmail(String email);
    Optional<SimpleUser> getSimpleUserById(Long id);
    Optional<SimpleUser> getSimpleUserByUsername(String username);
}
