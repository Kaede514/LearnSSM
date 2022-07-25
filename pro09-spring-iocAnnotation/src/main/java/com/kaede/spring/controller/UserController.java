package com.kaede.spring.controller;

import com.kaede.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author kaede
 * @create 2022-07-24 10:09
 */

@Controller("controller")
public class UserController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    //@Autowired
    //public void setUserService(UserService userService) {
    //    this.userService = userService;
    //}

    //@Autowired
    //public UserController(UserService userService) {
    //    this.userService = userService;
    //}

    public void saveUser() {
        userService.saveUser();
    }
}
