package com.imooc.service;

import java.util.List;

import com.imooc.pojo.Employee;

/**
 * Department类业务层接口
 * @author Administrator
 *
 */
public interface IDepartmentService {

	List<Employee> selectEmployeesByDid(int i);
	
}
