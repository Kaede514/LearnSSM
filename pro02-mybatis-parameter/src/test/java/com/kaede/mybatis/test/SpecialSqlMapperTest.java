package com.kaede.mybatis.test;

import com.kaede.mybatis.mapper.SpecialSqlMapper;
import com.kaede.mybatis.pojo.User;
import com.kaede.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * @author kaede
 * @create 2022-07-20 17:35
 */

public class SpecialSqlMapperTest {
    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> users = mapper.getUserByLike("a");
        System.out.println(users);
    }

    public void testJDBC() {
        try {
            Class.forName("");
            Connection connection = DriverManager.getConnection("", "", "");
            /*String sql = "select * from t_user where username like '%?%'";
            PreparedStatement ps = connection.prepareStatement(sql);
            //ps.setString(1, "a");*/
            String sql = "insert into t_user values()";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            generatedKeys.next();
            int id = generatedKeys.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteMoreUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        mapper.deleteMoreUser("3,4");
    }

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> users = mapper.getUserList("t_user");
        users.forEach(x -> System.out.println(x));
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        User user = new User(null, "xiaoming", "123456", 23, "男", "xiaoming@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
