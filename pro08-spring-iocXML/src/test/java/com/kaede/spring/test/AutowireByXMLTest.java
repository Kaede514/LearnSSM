package com.kaede.spring.test;

import com.kaede.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kaede
 * @create 2022-07-24 9:07
 */

public class AutowireByXMLTest {

    /**
     * 自动装配：
     * 根据指定的策略在IOC容器中匹配某个bean，自动为bean中的类类型的属性或接口类型的属性赋值
     * 可以通过bean标签中的autowire属性设置自动装配的策略
     * 自动装配的策略：
     * default、no：表示不装配，即bean中的属性不会自动匹配某个bean为属性赋值，此时属性使用默认值
     * byType：根据要赋值的属性的类型，在IOC中匹配某个bean为属性赋值（接口类型可以匹配实现类，父类可以匹配子类）（用得较多）
     * 注意：若通过类型在IOC容器中没有找到任何一个类型匹配的bean，此时不装配，属性使用默认值null
     *      若通过类型找到了多个类型匹配的bean，此时会抛出NoUniqueBeanDefinitionException异常
     * 总结：当使用byType自动装配时，IOC容器中有且只有一个类型匹配的bean能够为属性赋值
     * byName：将要赋值的属性的属性名，作为bean的id在IOC容器中匹配某个bean，为属性赋值
     * 总结：当类型匹配的bean有多个时此时可以使用byName实现自动装配
     */

    @Test
    public void testAutowire() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
