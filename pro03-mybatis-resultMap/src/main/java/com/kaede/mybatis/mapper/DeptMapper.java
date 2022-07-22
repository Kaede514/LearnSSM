package com.kaede.mybatis.mapper;

import com.kaede.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author kaede
 * @create 2022-07-21 14:01
 */

public interface DeptMapper {
    //通过分步查询获取员工以及所对应的部门信息的第二步
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    //通过部门id查询部门以及部门中的员工信息
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    //通过分步查询获取部门以及所对应的员工信息的第一步
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
