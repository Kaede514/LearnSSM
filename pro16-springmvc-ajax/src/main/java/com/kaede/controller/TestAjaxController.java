package com.kaede.controller;

import com.kaede.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author kaede
 * @create 2022-07-29 11:24
 *
 * 1、@RequestBody：将请求体中的内容和控制器方法的形参进行绑定
 * 2、使用@RequestBody注解将json格式的请求参数转换为java对象
 *      1）导入jackson的依赖
 *      2）在SpringMVC的配置文件中设置开启MVC的注解驱动
 *      3）在处理请求的控制器方法的形参位置，直接设置json格式的请求参数
 *        要转换的java类型的形参，使用@RequestBody注解标识即可
 * 3、@ResponseBody：将所标识的控制器方法的返回值作为响应报文的响应体响应到浏览器
 * 4、使用@ResponseBody注解响应浏览器json格式的数据
 *      1）导入jackson的依赖
 *      2）在SpringMVC的配置文件中设置开启MVC的注解驱动
 *      3）将需要转换为json字符串的java对象直接作为控制器方法的返回值，使用
 *        @ResponseBody注解标识控制器方法，就可以将java对象直接转换为json字符串并响应到浏览器
 *
 * 常用的java对象转换为json的结果：
 * 实体类 --> json对象
 * Map集合 --> json对象
 * List集合 --> json数组
 *
 * @RestController注解是springMVC提供的一个复合注解，标识在控制器的类上，就相当于为类添加了
 * @Controller注解，并且为其中的每个方法添加了@ResponseBody注解
 */

@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("id = " + id);
        System.out.println("requestBody = " + requestBody);
        response.getWriter().write("hello, axios");
    }

    //@RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello, RequestBody");
    }

    @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody Map<String,Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello, RequestBody");
    }

    @RequestMapping("/test/responseBody")
    @ResponseBody
    public String testResponseBody() {
        return "success";
    }

    /*@RequestMapping("/test/responseBody/json")
    @ResponseBody
    public User testResponseBodyJson() {
        User user = new User(1001, "admin", "123456", 20, "男");
        return user;
    }*/

    @RequestMapping("/test/responseBody/json")
    @ResponseBody
    public List<Object> testResponseBodyJson() {
        User user1 = new User(1001, "admin", "123456", 20, "男");
        User user2 = new User(1001, "admin", "123456", 20, "男");
        User user3 = new User(1001, "admin", "123456", 20, "男");
        List<Object> list = Arrays.asList(user1, user2, user3);
        return list;
    }

}
