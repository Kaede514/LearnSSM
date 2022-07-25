package com.kaede.spring.dao.impl;

import com.kaede.spring.dao.UserDAO;
import org.springframework.stereotype.Repository;

/**
 * @author kaede
 * @create 2022-07-24 10:10
 */

@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
