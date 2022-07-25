package com.kaede.spring.service.impl;

import com.kaede.spring.service.BookService;
import com.kaede.spring.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kaede
 * @create 2022-07-25 17:46
 */

@Service
public class CheckOutServiceImpl implements CheckOutService {

    @Autowired
    private BookService bookService;

    @Override
    //@Transactional
    public void checkOut(Integer userId, Integer[] bookIds) {
        for (Integer bookId : bookIds) {
            bookService.buyBook(userId, bookId);
        }
    }

}
