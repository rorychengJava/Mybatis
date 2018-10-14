package cn.itcast.mybatis.dao;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

/** 
* <p>Title:Mybatis</p>
* <p>Description:</p>
* @author rorycheng
* @Date 2018年10月8日 下午11:10:38
* @version 1.0 
*/
public class UserDaoImplTest {
	private SqlSessionFactory SqlSessionFactory;
	@Before
	//在Test方法执行之前执行初始化
	public void setUp() throws Exception {
		InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		
		UserDao userDao=new UserDaoImpl(SqlSessionFactory);
		List<User> list=userDao.findUserById(1);
		for (User user : list) {
			System.err.println(user.getUsername());
		}
	}

}
