package com.kaede.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kaede
 * @create 2022-07-26 14:10
 *
 * 1、@RequestMapping注解标识的位置
 * @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求请求路径的具体信息
 * 类上若有则拼接方法上的，若没有则不拼接
 *
 * 2、@RequestMapping注解value属性
 * 作用：通过请求的请求路径来匹配请求
 * value属性是数组类型，即当前浏览器所发送请求的请求路径匹配value中的任何一个值
 * 则当前会被注解所标识的方法处理
 *
 * 3、@RequsetMapping注解的method属性
 * 作用：通过请求的请求方式匹配请求
 * method属性是RequestMethod类型的数组，即当前浏览器所发送请求的请求方式匹配method中的任何一种请求方式
 * 则当前会被注解所标识的方法处理
 * 若浏览器所发送的请求的请求路径和@RequestMapping注解value属性匹配，但与请求方式不匹配，此时
 * 页面报405 - Request method 'xxx' not supported
 *
 * 在@RequestMapping的基础上结合请求方式的一些派生注解：
 * @GetMapping，@PostMapping，@DeleteMapping，@PutMapping
 *
 * 4、@RequestMapping注解的params属性
 * 作用：通过当前请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须满足params属性的所有设置
 * params可以使用四种表达式：
 * "param"：表示当前所匹配请求的请求参数中必须携带param参数
 * "!param"：表示当前所匹配请求的请求参数中一定不能携带param参数
 * "param=value"：表示当前所匹配请求的请求参数中必须携带param参数，且值必须为value
 * "param!=value"：表示当前所匹配请求的请求参数中可以不携带param参数，若携带则值一定不能是value
 * 若浏览器所发送的请求的请求路径和@RequestMapping注解value属性匹配，但与请求参数不匹配，此时
 * 页面报400 - Parameter conditions "username" not met for actual request parameters:
 *
 * 5、@RequestMapping注解的headers属性
 * 作用：通过当前请求的请求头信息匹配请求，即浏览器发送的请求的请求头信息必须满足headers属性的所有设置
 * 请求头和响应头的键不区分大小写
 * 若浏览器所发送的请求的请求路径和@RequestMapping注解value属性匹配，但与请求头不匹配，此时
 * 页面报404
 *
 * 6、SpringMVC支持ant风格的路径
 * 在@RequestMapping注解的value属性值中设置一些特殊字符
 * ？：表示任意的单个字符
 * *：表示任意的0个或多个字符
 * **：表示任意层数的任意目录
 * 注意：在使用**时，**只能单独写在//中，前后不能有其他字符
 *
 * 7、@RequestMapping注解使用路径中的占位符
 * 传统：/deleteUser?id=1
 * rest：/user/delete/1
 * 需要在@RequestMapping注解的value属性值所设置的路径中，使用{xxx}的方式表示路径中的数据，
 * 在通过@PathVariable注解，将占位符所表示的值和控制器方法的形参进行绑定
 */

@Controller
@RequestMapping("/test")
public class TestRequestMappingController {

    //此时控制器方法所匹配的请求的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello", "/abc"},
            method = {RequestMethod.POST, RequestMethod.GET},
            //params = {"username", "!password", "age=20", "gender!=女"}
            headers = {"referer"}
    )
    public String hello() {
        return "success";
    }

    @RequestMapping("/a?a/test/ant")
    public String testAnt() {
        return "success";
    }

    @RequestMapping("/test/rest/{admin}/{id}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("admin") String username) {
        System.out.println("id = " + id);
        System.out.println("username = " + username);
        return "success";
    }

}
