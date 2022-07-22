package com.kaede.mybatis.mapper;

import com.kaede.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kaede
 * @create 2022-07-21 17:27
 */

public interface DynamicSQLMapper {
    //根据条件查询员工信息
    List<Emp> getEmpByCondition(Emp emp);

    //使用choose查询员工信息
    List<Emp> getEmpByChoose(Emp emp);

    //添加多个员工信息
    void insertMoreEmp(@Param("emps") List<Emp> emps);

    //批量删除
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);
}
