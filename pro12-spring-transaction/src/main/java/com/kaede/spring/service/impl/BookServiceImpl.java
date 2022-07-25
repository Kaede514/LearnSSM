package com.kaede.spring.service.impl;

import com.kaede.spring.service.BookService;
import com.kaede.spring.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 @author kaede
 @create 2022-07-25 15:59
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    //@Transactional(
    //        //readOnly = true
    //        //timeout = 3
    //        //noRollbackFor = ArithmeticException.class
    //        //noRollbackForClassName = "java.lang.ArithmeticException"
    //        //isolation = Isolation.DEFAULT
    //        //不使用结账的事务，使用自己的事务
    //        propagation = Propagation.REQUIRES_NEW
    //)
    public void buyBook(Integer userId, Integer bookId) {
        //try {
        //    TimeUnit.SECONDS.sleep(5);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //查询图书的价格
        Integer price = bookDAO.getPriceByBookId(bookId);
        //更新图书的库存
        bookDAO.updateStock(bookId);
        //更新用户的余额
        bookDAO.updateBalance(userId, price);
        //System.out.println(1 / 0);
    }

}
