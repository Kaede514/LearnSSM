package com.kaede.controller;

import com.kaede.dao.EmployeeDAO;
import com.kaede.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author kaede
 * @create 2022-07-28 14:58
 *
 * 需实现的功能：
 * 访问首页
 * 查询所有的员工信息 --> /employee --> GET
 * 跳转到添加页面 --> /to/add --> GET
 * 新增员工信息 --> /employee --> POST
 * 跳转到修改页面 --> /employee/1 --> GET
 * 修改员工信息 --> /employee --> PUT
 * 删除员工信息 --> /employee/1 --> DELETE
 *
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/employee")
    public String getAllEmployee(Model model) {
        //获取所有员工信息
        Collection<Employee> allEmployee = employeeDAO.getAll();
        //将所有的员工信息在请求域中共享
        model.addAttribute("allEmployee",allEmployee);
        //跳转到列表页面
        return "employee_list";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        //保存员工信息
        employeeDAO.save(employee);
        //重定向到列表功能：/employee
        //相当于在地址栏直接输入地址，请求方式为GET
        //如果使用内部转发，地址栏里显示的还是添加的地址，刷新页面之后又会重新访问添加功能，会死循环
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        //根据id查询员工信息
        Employee employee = employeeDAO.get(id);
        //将员工信息共享到请求域中
        model.addAttribute("employee", employee);
        //跳转到employee_update
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee) {
        //修改员工信息
        employeeDAO.save(employee);
        //重定向到列表功能：/employee
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDAO.delete(id);
        //重定向到列表功能：/employee
        return "redirect:/employee";
    }

}
