package com.kaede.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kaede
 * @create 2022-07-30 9:45
 *
 * 拦截器的三个方法：
 * 1、preHandle()：在控制器方法执行之前执行，其返回值表示对控制器方法的拦截（flase）或放行（true）
 * 2、postHandle()：在控制器方法执行之后执行
 * 3、afterCompletion()：在控制器方法执行之后，且渲染视图完毕之后执行
 *
 * 多个拦截器的执行顺序和在SpringMVC配置文件中配置的顺序有关
 * preHandle()按照配置的顺序执行，而postHandle()和afterCompletion()会按照配置的反序执行
 *
 * 若拦截器中某个拦截器的preHandler()返回了false
 * 该拦截器的preHandler()和它之前的拦截器的preHandler()都会执行   i < xx.size() ; i++
 * 所有的拦截器的postHanlder()都不执行
 * 拦截器的preHandler()返回false之前的拦截器的afterCompletion()会执行   i > xx.size() ; i--
 */

@Component
public class FirstInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor --> preHandler");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor --> postHandler");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor --> afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
