package com.kaede.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author kaede
 * @create 2022-07-27 14:06
 *
 * ThymeleafView（用的多）：
 * 当控制器方法中所设置的视图名称没有任何前缀时，此时的视图名称会被SpringMVC配置文件中所配置
 * 的视图解析器解析，视图名称拼接视图前缀和视图后缀所得到的最终路径，会通过转发的方式实现跳 转
 *
 * SpringMVC中默认的转发视图是InternalResourceView：
 * 当控制器方法中所设置的视图名称以"forward:"为前缀时，创建InternalResourceView视图，此时的视
 * 图名称不会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀"forward:"去掉，找到去掉
 * "forward"前缀的剩余部分的Controller控制器方法，通过转发的方式实现跳转，最终解析成ThymeleafView
 * 例如"forward:/test/model"
 * 不可以用forward:+html直接跳转到其他页面
 *
 * SpringMVC中默认的重定向视图是RedirectView（用的多）：
 * 当控制器方法中所设置的视图名称以"redirect:"为前缀时，创建RedirectView视图，此时的视图名称不
 * 会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀"redirect:"去掉，找到去掉"forward"
 * 前缀的剩余部分的Controller控制器方法，通过重定向的方式实现跳转，最终解析成ThymeleafView
 * 例如"redirect:/test/model"
 * 在重定向实现页面跳转的时候，会自动为当前设置的绝对路径前设置一个上下文路径，以/开头的路径为
 * 绝对路径，由浏览器解析解析为localhost:8080，无应用程序上下文路径，故在SpringMVC中创建重定向
 * 视图不需要手动加上应用程序上下文路径
 */

@Controller
public class TestViewController {

    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView(Model model) {
        return "success";
    }

    @RequestMapping("/test/view/forward")
    public String testInternalResourceView() {
        return "forward:/test/model";
    }

    @RequestMapping("/test/view/redirect")
    public String testRedirectView() {
        return "redirect:/test/model";
    }

}
