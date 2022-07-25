package com.kaede.spring.controller;

import com.kaede.spring.service.UserService;

/**
 * @author kaede
 * @create 2022-07-24 8:47
 */

public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //保存用户信息
    public void saveUser() {
        userService.saveUser();
    }
}
