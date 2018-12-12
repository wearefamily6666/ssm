package com.imooc.service;

import java.util.List;

import com.imooc.pojo.User;

/**
 * Group类业务层接口
 * @author Administrator
 *
 */
public interface IGroupService {

	List<User> testGetUser();

	List<User> testGetUserByLeftJoin();

	List<String> testGetGroup();

}
