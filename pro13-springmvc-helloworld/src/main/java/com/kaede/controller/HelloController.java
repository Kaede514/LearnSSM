package com.kaede.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kaede
 * @create 2022-07-26 11:09
 *
 * 浏览器发送请求，若请求地址符合前端控制器的url-pattern，该请求就会被前端控制器
 * DispatcherServlet处理。前端控制器会读取SpringMVC的核心配置文件，通过扫描组件找到控制器，
 * 将请求地址和控制器中@RequestMapping注解的value属性值进行匹配，若匹配成功，该注解所标识的
 * 控制器方法就是处理请求的方法。处理请求的方法需要返回一个字符串类型的视图名称，该视图名称会
 * 被视图解析器解析，加上前缀和后缀组成视图的路径，通过Thymeleaf对视图进行渲染，最终转发到视
 * 图所对应页面
 *
 * 用服务器内部转发而非客户端重定向是因为：
 * 1、WEB-INF下的页面无法通过重定向访问
 *      WEB-INF是Java的WEB应用的安全目录。所谓安全就是客户端无法访问，只有服务端可以访问的目录。
 * 2、Thymeleaf是服务器中使用的视图渲染技术，故页面必须在服务器中进行渲染
 *
 * java和resources下的内容被达成war包时最终都会放在target中项目中的WEB-INF下的classes下
 * 若有资源未打包的话，可用maven重新打包（package，会自动清理编译重新打包）
 */

@Controller
public class HelloController {

    //当前在xml配置了除.jsp外的所有请求都由DispacherServlet处理
    //DispacherServlet再从Controller中寻找可以匹配的方法，如果
    //找到了匹配的方法就可以执行然后渲染视图，找不到就报404

    @RequestMapping("/")
    //在服务器中/为绝对路径标识，被服务器解析为localhost:8080 + 应用程序上下文路径
    //即/被解析为localhost:8080/pro13/
    //若请求路径和@RequestMapping属性值value相同，则请求由该方法处理
    public String protal() {
        //将逻辑视图返回
        //然后逻辑视图被组合为物理视图/WEB-INF/templates/index.html
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "success";
    }

}
