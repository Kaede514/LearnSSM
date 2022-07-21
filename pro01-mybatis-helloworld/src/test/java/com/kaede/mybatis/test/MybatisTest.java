package com.kaede.mybatis.test;

import com.kaede.mybatis.mapper.UserMapper;
import com.kaede.mybatis.pojo.User;
import com.kaede.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author kaede
 * @create 2022-07-19 17:18
 */

public class MybatisTest {
    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlsessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // //获取sql的会话对象SqlSession，是MyBatis提供的操控数据库的对象，不会自动提交事务，需手动提交事务
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取sql的会话对象SqlSession，是MyBatis提供的操控数据库的对象，自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取UserMapper的代理实现类对象
        //自动创建UserMapper接口的实现类，并且找到相对应的sql语句在重写的方法中执行
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper中的方法，实现添加用户信息的功能
        int result = mapper.insertUser();
        //提供sql语句以及唯一标识找到sql并执行，唯一标识是namespace.sqlId
        // int result = sqlSession.insert("com.kaede.mybatis.mapper.UserMapper.insertUser");
        System.out.println("result = " + result);
        //手动提交事务
        // sqlSession.commit();
        //关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }
    
    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getAllUser();
        users.forEach(x -> System.out.println(x));
    }
}

