package com.kaede.spring.test;

import com.kaede.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author kaede
 * @create 2022-07-25 16:17
 *
 * 声明式事务的配置步骤：
 * 1、在Spring的配置文件中事务管理器
 * 2、开启事务的注解驱动
 * 在需要被事务管理里的方法或类上添加@Transactional注解，该方法或类就可以被事务管理
 * @Transaction注解标识的位置：
 * 1、标识在方法上
 * 2、标识在类上，若标识在类上，则类中所有的方法都会被事务管理
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TxByXMLTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook() {
        bookController.buyBook(1, 1);
        //bookController.checkOut(1, new Integer[]{1, 2});
    }

}
