package com.imooc.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.imooc.dao.IUserDao;
import com.imooc.pojo.User;
import com.imooc.service.IUserService;
/**
 * user业务层实现类
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource  
    private IUserDao userDao;  
    
    @Value("${TEST_URL}")
    private String teString;
 
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub 
    	System.out.println("获得properties属性值：  "+teString);
    		return this.userDao.selectByPrimaryKey(userId); 
    }

	public int deleteByPrimaryKey(int i) {
		return this.userDao.deleteByPrimaryKey(i);
	}

	public int addUser(User user) {
	return	userDao.insertSelective(user);
	}

	public int updateUserById(User user) {
		return userDao.updateByPrimaryKeySelective(user);
	}

	public List<User> getAll() {
		// TODO Auto-generated method stub
	 return userDao.selectAll();
	}

	public int testGetCountByUser() {
		return userDao.getCount();
	}

 
}
