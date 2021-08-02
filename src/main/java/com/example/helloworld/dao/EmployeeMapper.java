package com.example.helloworld.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee> {
    List<Employee> findEmployee();
    int addEmployee(Employee employee);
    int deleteEmployee(long id);
    int changeEmployee(Employee employee);
    Employee find(long id);
}