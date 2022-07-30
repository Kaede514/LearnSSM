package com.kaede.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kaede
 * @create 2022-07-26 14:10
 */

@Controller
public class ProtalController {

    /*@RequestMapping("/")
    public String protal() {
        return "index";
    }*/

    @RequestMapping("/hello")
    public String hello() {
        return "success";
    }

}
