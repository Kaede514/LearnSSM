package com.kaede.spring.service;

/**
 * @author kaede
 * @create 2022-07-25 17:46
 */

public interface CheckOutService {
    //结账
    void checkOut(Integer userId, Integer[] bookIds);
}
