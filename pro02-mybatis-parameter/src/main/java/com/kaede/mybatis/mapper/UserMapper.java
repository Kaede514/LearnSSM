package com.kaede.mybatis.mapper;

import com.kaede.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author kaede
 * @create 2022-07-20 12:41
 */

public interface UserMapper {
    //根据用户名查询用户信息
    User getUserByUsername(String username);

    //验证登录
    User checkLogin(String username, String password);

    //以map集合作为参数验证登录
    User checkLoginByMap(Map<String,Object> map);

    //添加用户信息
    void insertUser(User user);

    //验证登录（使用@Param注解）
    //@Param只为value属性赋值的话value可以省略不写，@Param("username")
    //MyBatis会把注解里的value属性值作为键，以参数作为值
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
