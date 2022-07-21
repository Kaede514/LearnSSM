package com.kaede.mybatis.test;

import com.kaede.mybatis.mapper.SelectMapper;
import com.kaede.mybatis.pojo.User;
import com.kaede.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author kaede
 * @create 2022-07-20 15:55
 */

public class SelectMapperTest {
    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.getAllUser();
        users.forEach(x -> System.out.println(x));
    }

    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println("count = " + count);
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(1);
        //{password=123456, gender=男, id=1, age=23, email=12345@qq.com, username=admin}
        System.out.println(map);
    }

    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        //[{password=123456, gender=男, id=1, age=23, email=12345@qq.com, username=admin},
        // {password=123456, gender=女, id=2, age=20, email=123@qq.com, username=root}]
        List<Map<String, Object>> users = mapper.getAllUserToMap();
        //{1={password=123456, gender=男, id=1, age=23, email=12345@qq.com, username=admin},
        // 2={password=123456, gender=女, id=2, age=20, email=123@qq.com, username=root}}
        //Map<String, Object> users = mapper.getAllUserToMap();
        System.out.println(users);
    }
}
