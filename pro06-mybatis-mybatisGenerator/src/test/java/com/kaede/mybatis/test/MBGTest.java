package com.kaede.mybatis.test;

import com.kaede.mybatis.mapper.EmpMapper;
import com.kaede.mybatis.pojo.Emp;
import com.kaede.mybatis.pojo.EmpExample;
import com.kaede.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author kaede
 * @create 2022-07-22 15:56
 */

public class MBGTest {
    @Test
    public void testMBG() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //根据id查询数据
        //Emp emp = mapper.selectByPrimaryKey(1);
        //System.out.println(emp);

        //查询所有数据
        //List<Emp> emps = mapper.selectByExample(null);
        //emps.forEach(x -> System.out.println(x));

        //根据条件查询数据
        //EmpExample example = new EmpExample();
        //example.createCriteria().andEmpNameEqualTo("张三").andEmpAgeGreaterThanOrEqualTo(20);
        //example.or().andEmpGenderEqualTo("女");
        //List<Emp> emps = mapper.selectByExample(example);
        //emps.forEach(x -> System.out.println(x));

        Emp emp = new Emp(1, "小黑", null, "男");
        //测试普通修改功能
        //mapper.updateByPrimaryKey(emp);
        //测试选择性修改
        mapper.updateByPrimaryKeySelective(emp);
    }

}

