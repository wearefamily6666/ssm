package com.imooc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.imooc.dao.IEmployeeDao;
import com.imooc.pojo.Employee;
import com.imooc.service.IEmployeeService;

/**
 * employee业务层实现类
 * @author Administrator
 *
 */
@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService{
	@Resource
	private IEmployeeDao employeeDao;

	public int addEmployee(Employee employee) {
		return employeeDao.insertSelective(employee);
	}

}
