package com.kaede.spring.service.impl;

import com.kaede.spring.dao.UserDAO;
import com.kaede.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kaede
 * @create 2022-07-24 10:09
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void saveUser() {
        userDAO.saveUser();
    }
}
