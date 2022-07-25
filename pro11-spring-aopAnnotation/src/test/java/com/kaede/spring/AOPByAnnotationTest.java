package com.kaede.spring;

import com.kaede.spring.aop.annotation.Caculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kaede
 * @create 2022-07-24 17:57
 */

public class AOPByAnnotationTest {

    @Test
    public void testAOPByAnnotation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        //报错
        //Caculator caculator = ioc.getBean(CaculatorImpl.class);
        //用所继承的接口或者所实现的父类获取代理对象
        Caculator caculator = ioc.getBean(Caculator.class);
        caculator.div(4, 2);
    }

}
