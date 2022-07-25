package com.kaede.spring.controller;

import com.kaede.spring.service.BookService;
import com.kaede.spring.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author kaede
 * @create 2022-07-25 15:59
 */

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CheckOutService checkOutService;

    public void buyBook(Integer userId, Integer bookId) {
        bookService.buyBook(userId, bookId);
    }

    public void checkOut(Integer userId, Integer[] bookIds) {
        checkOutService.checkOut(userId, bookIds);
    }

}
