package com.kaede.mybatis.mapper;

import com.kaede.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author kaede
 * @create 2022-07-21 11:01
 */

public interface EmpMapper {
    //根据empId查询员工信息
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    //获取员工以及所对应的部门信息
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    //通过分步查询获取员工以及所对应的部门信息的第一步
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    //通过分步查询获取部门以及所对应的员工信息的第二步
    List<Emp> getDeptAndDeptByStepTwo(@Param("deptId") Integer deptId);
}
