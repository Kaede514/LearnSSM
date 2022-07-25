package com.kaede.spring.test;

import com.kaede.spring.pojo.Clazz;
import com.kaede.spring.pojo.Person;
import com.kaede.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kaede
 * @create 2022-07-23 10:35
 */

public class IOCByXMLTest {

    /**
     * 获取bean的三种方式：
     * 1、根据bean的id获取
     * 2、根据bean的类型获取（以后常用的方式，因为同一个bean不需要
     *      在配置文件中配置多次，现在是做测试）
     * 注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
     *      若没有任何一个类型匹配的bean，此时抛出NoSuchBeanDefinitionException
     *      若有多个类型匹配的bean，此时抛出NoUniqueBeanDifinitionException
     * 3、根据bean的id和类型获取
     *
     * 根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：『对象 instanceof
     * 指定的类型』的返回结果，只要返回的是true就可以认定为和类型匹配，能够获取到
     * 即通过bean的类型，或者bean所继承的类的类型、bean所实现的接口的类型都可以获取bean对象
     */

    @Test
    public void testIOC() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中的bean对象
        //Student studentOne = (Student) ioc.getBean("studentOne");
        //System.out.println(studentOne);
        //Student student = ioc.getBean(Student.class);
        //System.out.println(student);
        //Student studentOne = ioc.getBean("studentOne", Student.class);
        //System.out.println(studentOne);
        Person person = ioc.getBean(Person.class);
        System.out.println(person);
    }

    @Test
    public void testDI() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中的bean对象
        //Student studentTwo = ioc.getBean("studentTwo", Student.class);
        //System.out.println(studentTwo);

        //Student studentThree = ioc.getBean("studentThree", Student.class);
        //System.out.println(studentThree);

        //Student studentFour = ioc.getBean("studentFour", Student.class);
        //System.out.println(studentFour);

        //Student studentFive = ioc.getBean("studentFive", Student.class);
        //System.out.println(studentFive);

        //Clazz clazzTwo = ioc.getBean("clazzTwo", Clazz.class);
        //System.out.println(clazzTwo);

        //Student studentFive = ioc.getBean("studentFive", Student.class);
        //System.out.println(studentFive);

        Student studentSix = ioc.getBean("studentSix", Student.class);
        System.out.println(studentSix);
    }
}
