package com.kaede.spring.test;

import com.kaede.spring.controller.UserController;
import com.kaede.spring.dao.UserDAO;
import com.kaede.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kaede
 * @create 2022-07-24 10:12
 */

public class IOCByAnnotationTest {

    /**
     * @Component：将类标识为普通组件
     * @Controller：将类标识为控制层组件
     * @Service：将类标识为业务层组件
     * @Repository：将类标识为持久层组件
     *
     * 通过注解加扫描所配置的bean的id，默认值为类名首字母小写的结果，如UserController -> userController
     * 可以通过标识组件的注解的value属性值设置bean的自定义的id
     *
     * @Autowired：实现自动装配功能的注解
     * 1、@Autowired注解能够标识的位置：
     *      标识在成员变量上，此时不需要设置成员变量的set方法
     *      标识在set方法上
     *      为当前成员变量赋值的有参构造上
     * 2、@Autowired注解的原理：
     *      默认通过byType的方式在IOC容器中通过类型匹配某个bean为属性赋值
     *      若有多个类型匹配的bean，此时会自动转换为byName的方式实现自动装配的效果，
     *      即将要赋值的属性的属性名的驼峰作为bean的id匹配某个bean为属性赋值
     *      若byType和byName的方式都无法实现自动装配，即IOC容器中有个类型匹配的bean，
     *      且这些bean的id和要赋值的属性的属性名的驼峰都不一致，此时抛出NoUniqueBeanDefinationException
     *      此时可以在要赋值的属性上添加一个注解@Qualifier，通过该注解的value属性值，
     *      指定某个bean的id，将这个bean为属性赋值
     *
     * 注意：若IOC容器中没有任何一个类型匹配的bean，此时抛出NoSuchBeanDefinationException
     *      在@Autowire注解中有个属性required，默认值为true，要求必须完成自动装配，若将required
     *      设置为flase，此时能装配就装配，无法装配就使用属性的默认值
     */

    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
        //System.out.println(userController);
        //UserService userService = ioc.getBean(UserService.class);
        //System.out.println(userService);
        //UserDAO userDAO = ioc.getBean(UserDAO.class);
        //System.out.println(userDAO);
        userController.saveUser();
    }
}
