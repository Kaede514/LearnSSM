package com.kaede.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author kaede
 * @create 2022-07-27 12:52
 *
 * 向域对象共享数据
 * 1、通过servletAPI获取
 * 只需在控制器方法的形参位置设置HttpServletRequest类型的形参，就可以在
 * 控制器方法中使用Request对象共享数据
 *
 * 2、通过ModelAndView向请求域共享数据
 * 使用ModelAndView时，可以使用其Model功能向请求域共享数据，使用View功能设置
 * 逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值
 *
 * 3、通过Model向请求域共享数据
 *
 * 4、通过ModelMap向请求域共享数据
 *
 * 5、通过map向请求域共享数据
 *
 * 6、Model、ModelMap和Map的关系
 * 其实在底层中，这些类型的形参最终都是通过BindingAwareModelMap进行创建的
 * public class BindingAwareModelMap extends ExtendedModelMap {}
 * public class ExtendedModelMap extends ModelMap implements Model {}
 * public class ModelMap extends LinkedHashMap<String, Object> {}
 */

@Controller
public class TestScopeController {

    @RequestMapping("/test/ServletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("testScope", "hello,servletAPI");
        return "success";
    }


    @RequestMapping("/test/mav")
    public ModelAndView testMAV() {
        /**
         * ModelAndView包含Model和View的功能
         * Model：向请求域中共享数据
         * View：设置逻辑视图实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //往请求域中共享数据
        mav.addObject("testRequestScope", "hello, ModelAndView");
        //设置逻辑视图
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model) {
        //org.springframework.validation.support.BindingAwareModelMap
        System.out.println(model.getClass().getName());
        model.addAttribute("testRequestScope", "hello, Model");
        return "success";
    }
    
    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap) {
        //org.springframework.validation.support.BindingAwareModelMap
        System.out.println(modelMap.getClass().getName());
        modelMap.addAttribute("testRequestScope", "hello, ModelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map) {
        //org.springframework.validation.support.BindingAwareModelMap
        System.out.println(map.getClass().getName());
        map.put("testRequestScope", "hello, map");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello, session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession httpSession) {
        ServletContext application = httpSession.getServletContext();
        application.setAttribute("testApplicationScope", "hello, application");
        return "success";
    }

}
