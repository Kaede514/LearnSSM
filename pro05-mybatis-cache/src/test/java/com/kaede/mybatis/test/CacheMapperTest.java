package com.kaede.mybatis.test;

import com.kaede.mybatis.mapper.CacheMapper;
import com.kaede.mybatis.pojo.Emp;
import com.kaede.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author kaede
 * @create 2022-07-22 11:48
 */

public class CacheMapperTest {

    /**
     * MyBatis的一级缓存：
     *          是SqlSession级别的，即通过同一个SqlSession查询的数据会被
     *          缓存，再次使用同一个SqlSession查询同一条数据，会从缓存中获取（默认开启）
     * 使一级缓存失效的四种情况：
     *          1、不同的SqlSession对应不同的一级缓存
     *          2、同一个SqlSession但是查询的条件不同
     *          3、同一个SqlSession两次查询期间执行了任何一次增删改操作
     *          4、同一个SqlSession两次查询期间手动清空了缓存
     *
     * MyBatis的二级缓存：
     *          是SqlSessionFactory级别的，即通过同一个SqlSessionFactory所获取的SqlSession
     *          对象查询的数据会被缓存，再次通过同一个SqlSessionFactory所获取的SqlSession查询
     *          相同的数据会从缓存中获取
     * MyBatis二级缓存开启的条件：
     *          1、在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
     *          2、在映射文件中设置标签<cache/>
     *          3、二级缓存必须在SqlSession关闭或提交之后有效
     *          4、查询的数据所转换的实体类类型必须实现序列化接口
     * 使二级缓存失效的情况：
     *          同一个SqlSessionFactory所获取的SqlSession两次查询期间执行了任何一次增删改操作
     */

    @Test
    public void testGetEmpById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);
        //sqlSession.clearCache();
        //mapper1.insertEmp(new Emp(null,"小红",25,"女"));
        Emp emp2 = mapper.getEmpById(1);
        System.out.println(emp2);

        //SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        //CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        //Emp emp3 = mapper2.getEmpById(1);
        //System.out.println(emp3);
    }

    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessioinFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
        sqlSession2.close();
    }
}
