package com.kaede.mybatis.mapper;

import com.kaede.mybatis.pojo.User;

import java.util.List;

/**
 * @author kaede
 * @create 2022-07-19 16:55
 */

public interface UserMapper {
    //添加用户信息
    int insertUser();

    //修改用户信息
    void updateUser();

    //删除用户信息
    void deleteUser();

    //根据id查询用户信息
    User getUserById();

    //查询所有的用户信息
    List<User> getAllUser();
}
