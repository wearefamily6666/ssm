package com.imooc.dao;

import java.util.List;

import com.imooc.pojo.Department;
import com.imooc.pojo.Employee;

public interface IDepartmentDao {
    int deleteByPrimaryKey(Integer did);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    List<Employee> selectEmployeesByDid(int did);
} 