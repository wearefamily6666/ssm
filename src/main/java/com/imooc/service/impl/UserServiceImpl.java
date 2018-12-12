package com.imooc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.imooc.dao.IUserDao;
import com.imooc.pojo.Employee;
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
    
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub 
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
