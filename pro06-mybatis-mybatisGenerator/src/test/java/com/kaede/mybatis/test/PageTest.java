package com.kaede.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaede.mybatis.mapper.EmpMapper;
import com.kaede.mybatis.pojo.Emp;
import com.kaede.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author kaede
 * @create 2022-07-22 18:27
 */

public class PageTest {

    /**
     * PageInfo{pageNum=1, pageSize=4, size=4, startRow=1, endRow=4, total=25, pages=7,
     * list=Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4, total=25, pages=7,
     * reasonable=false, pageSizeZero=false}
     * [Emp{empId=1, empName='小黑', empAge=20, empGender='男', deptId=1},
     *  Emp{empId=2, empName='李四', empAge=22, empGender='男', deptId=2},
     *  Emp{empId=3, empName='王五', empAge=23, empGender='男', deptId=3},
     *  Emp{empId=4, empName='赵六', empAge=24, empGender='男', deptId=1}],
     * prePage=0, nextPage=2, isFirstPage=true, isLastPage=false, hasPreviousPage=false, hasNextPage=true,
     * navigatePages=5, navigateFirstPage=1, navigateLastPage=5, navigatepageNums=[1, 2, 3, 4, 5]}
     *
     * pageNum：当前页的页码
     * pageSize：每页显示的条数
     * size：当前页显示的真实条数
     * total：总记录数
     * pages：总页数
     * prePage：上一页的页码
     * nextPage：下一页的页码
     * isFirstPage/isLastPage：是否为第一页/最后一页
     * hasPreviousPage/hasNextPage：是否存在上一页/下一页
     * navigatePages：导航分页的页码数
     * navigatepageNums：导航分页的页码，[1,2,3,4,5]
     */

    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询功能之前开启分页功能
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> emps = mapper.selectByExample(null);
        //在查询功能之后可以获取分页相关的所有数据
        PageInfo<Emp> pageInfo = new PageInfo<>(emps, 5);
        emps.forEach(x -> System.out.println(x));
        System.out.println(page);
        System.out.println(pageInfo);
    }
}
