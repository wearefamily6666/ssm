package com.imooc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.imooc.pojo.User;
/**
 * user类dao层接口
 * @author Administrator
 *
 */
public interface IUserDao {
    int deleteByPrimaryKey(Integer id);
	
    int insert(User record);
	
    int insertSelective(User record);
    
    User selectByPrimaryKey(Integer id);
  
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    List<User> selectAll();

	int getCount();
   
}