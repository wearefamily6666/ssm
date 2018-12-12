package com.imooc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.imooc.dao.IGroupDao;
import com.imooc.pojo.User;
import com.imooc.service.IGroupService;
/**
 * Group业务层实现类
 * @author Administrator
 *
 */
@Service("groupService")
public class GroupServiceImpl implements IGroupService {

@Resource
private IGroupDao groupDao;
	public List<User> testGetUser() {
		return groupDao.getUser();
	}
	public List<User> testGetUserByLeftJoin() {
		return groupDao.getUserByLeftJoin();
	}
	public List<String> testGetGroup() {
		return groupDao.getGroup();
	}

}
