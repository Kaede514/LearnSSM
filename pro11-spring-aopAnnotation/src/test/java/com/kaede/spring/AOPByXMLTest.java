package com.kaede.spring;

import com.kaede.spring.aop.xml.Caculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kaede
 * @create 2022-07-25 10:51
 */

public class AOPByXMLTest {
    @Test
    public void testAOPByXML() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        Caculator caculator = ioc.getBean(Caculator.class);
        caculator.div(4, 2);

    }
}
