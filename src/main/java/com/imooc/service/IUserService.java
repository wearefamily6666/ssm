package com.imooc.service;

import java.util.List;
import com.imooc.pojo.User;

public interface IUserService {


	int deleteByPrimaryKey(int i);

	int addUser(User user);

	int updateUserById(User user);

	List<User> getAll();

	User getUserById(int id);

	int testGetCountByUser();

 

}
