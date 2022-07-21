package com.kaede.mybatis.mapper;

import com.kaede.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author kaede
 * @create 2022-07-20 15:48
 */

public interface SelectMapper {
    /**
     * 若sql语句查询结果为多条时，一定不能以实体类类型作为方法的返回值
     * 否则会抛出异常TooManyResultsException
     * 若sql语句查询的结果为一条时，此时可以使用实体类类型或集合类型作为方法的返回值
     */

    //根据Id查询用户信息
    User getUserById(@Param("id") Integer id);

    //查询所有用户信息
    List<User> getAllUser();

    //查询用户的总数量
    Integer getCount();

    //根据id查询用户信息为map集合
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    //查询所有用户信息为map集合
    /**
     * 若查询的数据有多条时，并且要将每条数据转换为Map集合（本方法中可以直接用User代替）
     * 很多时候查询的结果没法转换为实体类，这时就需要用Map
     * 此时有两种解决方案：
     * 1、将mapper接口方法的返回值设置为泛型是Map的list集合（推荐这一种）
     * 结果：[{password=123456, gender=男, id=1, age=23, email=12345@qq.com, username=admin},
     *       {password=123456, gender=女, id=2, age=20, email=123@qq.com, username=root}]
     * 2、可以将每条数据转化的Map结合放在一个大的Map中，但必须要通过@MapKey注解
     * 将查询的某个字段的值作为大的Map的键
     * @MapKey("id")
     * Map<String, Object> getAllUserToMap();
     * 结果：{1={password=123456, gender=男, id=1, age=23, email=12345@qq.com, username=admin},
     *       2={password=123456, gender=女, id=2, age=20, email=123@qq.com, username=root}}
     */
    List<Map<String, Object>> getAllUserToMap();
    //@MapKey("id")
    //Map<String, Object> getAllUserToMap();
}
