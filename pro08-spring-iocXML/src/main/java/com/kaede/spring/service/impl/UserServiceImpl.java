package com.kaede.spring.service.impl;

import com.kaede.spring.dao.UserDAO;
import com.kaede.spring.service.UserService;

/**
 * @author kaede
 * @create 2022-07-24 8:49
 */

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void saveUser() {
        userDAO.saveUser();
    }
}
