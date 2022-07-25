package com.kaede.spring.test;

import com.kaede.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kaede
 * @create 2022-07-24 8:25
 *
 * FactoryBean是一个接口，需要创建一个类实现该接口，其中有三个方法
 * getObject()：提供一个对象交给IOC容器管理
 * getObjectType()：设置所提供对象的类型
 * isSingleton()：所提供的对象是否单例
 * 当把Factory的实现类配置为bean时，会将当前类中getObject()方法所返回的对象交给IOC容器管理
 */

public class FactoryBeanTest {
    @Test
    public void testFactoryBean() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
    }
}
