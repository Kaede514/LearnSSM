package com.kaede.spring.dao;

/**
 * @author kaede
 * @create 2022-07-25 16:00
 */
public interface BookDAO {
    //根据图书id查询图书的价格
    Integer getPriceByBookId(Integer bookId);

    //更新图书的库存
    void updateStock(Integer bookId);

    //更新用户的余额
    void updateBalance(Integer userId, Integer price);
}
