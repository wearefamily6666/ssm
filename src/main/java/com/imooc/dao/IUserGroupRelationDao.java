package com.imooc.dao;

import com.imooc.pojo.UserGroupRelation;

public interface IUserGroupRelationDao {
    int deleteByPrimaryKey(Integer userGroupId);

    int insert(UserGroupRelation record);

    int insertSelective(UserGroupRelation record);

    UserGroupRelation selectByPrimaryKey(Integer userGroupId);

    int updateByPrimaryKeySelective(UserGroupRelation record);

    int updateByPrimaryKey(UserGroupRelation record);
}