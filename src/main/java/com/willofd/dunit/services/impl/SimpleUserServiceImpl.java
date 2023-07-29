package com.willofd.dunit.services.impl;


import com.willofd.dunit.dao.SimpleUserDAO;
import com.willofd.dunit.entity.SimpleUser;
import com.willofd.dunit.services.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Ivan Partola
 */

@Service
public class SimpleUserServiceImpl implements SimpleUserService {
    private final SimpleUserDAO simpleUserDAO;

    @Autowired
    public SimpleUserServiceImpl(SimpleUserDAO simpleUserDAO) {
        this.simpleUserDAO = simpleUserDAO;
    }

    @Override
    public void save(SimpleUser simpleUser) {
        simpleUserDAO.save(simpleUser);
    }

    @Override
    public Optional<SimpleUser> findUserByUserId(Long id) {
        return simpleUserDAO.getSimpleUserById(id);
    }

    @Override
    public Optional<SimpleUser> findUserByEmail(String email) {
        return simpleUserDAO.getSimpleUserByEmail(email);
    }
}
