package com.kaede.spring.dao.impl;

import com.kaede.spring.dao.UserDAO;

/**
 * @author kaede
 * @create 2022-07-24 8:50
 */

public class UserDAOImpl implements UserDAO {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
