package com.kaede.mybatis.test;

import com.kaede.mybatis.mapper.UserMapper;
import com.kaede.mybatis.pojo.User;
import com.kaede.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kaede
 * @create 2022-07-20 13:27
 * MyBatis获取参数值的两种方式：${}和#{}
 * ${}的本质就是字符串拼接，#{}的本质就是占位符赋值
 * 1、若mapper接口方法的参数为单个的字面量类型
 * 此时可以通过${}和#{}以任意内容获取参数值，一定要注意${}的单引号问题
 * 2、若mapper接口方法的参数为多个的字面量类型
 * 此时MyBatis会将参数放在map集合中，以两种方式存储数据
 * 1）以arg0,arg1...为键，以参数为值
 * 2）以param1,param2...为键，以参数为值
 * 因为，只需要通过#{}和${}访问map集合的键，就可以获取相对应的值
 * 3、若mapper接口方法的参数为一个map集合类型的参数
 * 只需要通过#{}和${}访问map集合的键，就可以获取相对应的值
 * 4、若mapper接口方法的参数为实体类类型的参数
 * 属性和成员变量没有关系，只跟get、set方法有关系，把get、set方法的get、set去掉，剩余部分的首字母变为小写的结果是属性名
 * 只需要通过#{}和${}访问实体类中的属性名，就可以获取相对应的属性值
 * 5、可以在mapper接口方法的参数上设置@Param注解
 * 此时MyBatis会将这些参数放在map中，然后以两种方式进行存储
 * 1）@Param注解的value属性值为键，以参数为值
 * 2）以param1,param2...为键，以参数为值
 *
 * 建议实战中分两种情况即可：
 * 1、实体类类型的参数，通过属性名获取属性名
 * 2、其他的所有情况，如单个的参数、多个的参数，都加上@Param注解，通过value属性值获取参数值
 */

public class ParameterTest {
    @Test
    public void testGetUserByUsername() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("admin", "123456");
        System.out.println(user);
    }

    @Test
    public void tesCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "root", "123456", 20, "女", "123@qq.com");
        mapper.insertUser(user);
    }

    @Test
    public void testCheckLoginByParam() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("admin", "123456");
        System.out.println(user);
    }
}
