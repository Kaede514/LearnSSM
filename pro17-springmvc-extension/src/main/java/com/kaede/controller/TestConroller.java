package com.kaede.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kaede
 * @create 2022-07-30 9:38
 */

@Controller
public class TestConroller {

    @RequestMapping("/test/hello")
    public String testHello() {
        System.out.println(1/0);
        return "success";
    }

}
