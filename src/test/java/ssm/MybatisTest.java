package ssm;


import static org.junit.Assert.*;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.dao.IUserDao;
import com.imooc.pojo.User;

public class MybatisTest {
 
@Test
public void testName() throws Exception {
	ApplicationContext act = new ClassPathXmlApplicationContext("spring/applicationContext-mybatis.xml");
 	PageHelper.startPage(2, 4);
	IUserDao userDao=act.getBean(IUserDao.class);
	List<User> selectAll = userDao.selectAll();
	PageInfo<User> pageInfo=new PageInfo<User>(selectAll);
	List<User> list = pageInfo.getList();
	for (User user : list) {
		System.out.println(user);
	 }
	}
 
}
