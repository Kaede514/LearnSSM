package com.kaede.spring.test;

import com.kaede.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kaede
 * @create 2022-07-23 17:28
 */

public class LifeCycleTest {

    /**
     * 1、实例化
     * 2、依赖注入
     * 3、后置处理器的postProcessBeforeInitialization步骤
     * 4、初始化，需要通过bean的init-method属性指定初始化的方法
     * 5、后置处理器的postProcessAfterInitialization步骤
     * 6、IOC容器关闭时销毁，需要通过bean的destory-method属性指定销毁的方法
     *
     * bean的后置处理器会在生命周期的初始化前后添加额外的操作，需要实现BeanPostProcessor接口
     * bean后置处理器不是单独针对某一个bean生效，而是针对IOC容器中所有bean都会执行
     *
     * 注意：当bean的作用域为单例时，生命周期的实例化、依赖注入和初始化会在获取IOC容器时执行
     * 当bean的作用域为多例时，生命周期的实例化、依赖注入和初始化会在获取bean时执行
     */

    @Test
    public void testLifeCycle() {
        //ConfigurableApplicationContext是ApplicationContext的子接口，其中扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        System.out.println("生命周期：4、通过IOC容器获取bean并使用");
        ioc.close();
    }
}
