package com.imooc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.imooc.dao.IDepartmentDao;
import com.imooc.pojo.Employee;
import com.imooc.service.IDepartmentService;
/**
 * Department类业务层实现类
 * @author Administrator
 *
 */
@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService {
	
	@Resource 
	private IDepartmentDao departmentDao;
	public List<Employee> selectEmployeesByDid(int i) {
		return departmentDao.selectEmployeesByDid(i);
	}

}
