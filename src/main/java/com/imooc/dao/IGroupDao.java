package com.imooc.dao;

import java.util.List;

import com.imooc.pojo.Group;
import com.imooc.pojo.User;

public interface IGroupDao {
    int deleteByPrimaryKey(Integer gid);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);

	List<User> getUser();

	List<User> getUserByLeftJoin();

	List<String> getGroup();
}