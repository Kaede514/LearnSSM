package com.kaede.mybatis.mapper;

import com.kaede.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author kaede
 * @create 2022-07-22 11:17
 */

public interface CacheMapper {
    //根据员工id查询员工信息
    Emp getEmpById(@Param("empId") Integer empId);

    //添加员工信息
    void insertEmp(Emp emp);
}
