package com.kaede.mybatis.mapper;

import com.kaede.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kaede
 * @create 2022-07-20 17:29
 *
 * 模糊查询可以用#{}和${}，推荐#{}
 * 如 select * from t_user where username like '%'#{like}'%'
 * 批量删除和动态设置表名这种参数不能含''的只能用#{}
 * 如 delete from t_user where id in(${ids})
 *    select * from ${tableName}
 */

public interface SpecialSqlMapper {
    //根据用户名进行模糊查询用户信息
    List<User> getUserByLike(@Param("like") String like);

    //批量删除
    void deleteMoreUser(@Param("ids") String ids);

    //动态设置表名查询当前用户信息
    List<User> getUserList(@Param("tableName") String tableName);

    //添加用户信息并获取自增的主键
    void insertUser(User user);
}
