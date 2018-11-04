package cn.itcast.mybatis.mapperTest;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustomer;
import cn.itcast.mybatis.po.UserQueryVo;

/** 
* <p>Title:Mybatis</p>
* <p>Description:使用mybatis代理mapper接口</p>
* @author rorycheng
* @Date 2018年10月14日 上午10:39:41
* @version 1.0 
*/
public class UserDaoMapperTest {
		private SqlSessionFactory SqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		String s="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(s);
		SqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	//二级缓存测试，
	@Test
	public void testcache2() throws Exception{
		//测试不同的sqlsession
		SqlSession sqlSession1=SqlSessionFactory.openSession();
		UserMapper userMapper1=sqlSession1.getMapper(UserMapper.class);
		List<User> list1=userMapper1.findUserById(1);
		System.out.println(list1);
		sqlSession1.close();//只有将sqlsession对象关闭了，才能将数据写到二级缓存区域中
		SqlSession sqlSession3 = SqlSessionFactory.openSession();
		//使用sqlSession3执行commit()操作
		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		List<User> list3 = userMapper3.findUserById(1);
		User user=new User();
		user.setId(1);
		user.setUsername("张明明");
		userMapper3.updateUser(user);
		//执行提交，清空UserMapper下边的二级缓存
		sqlSession3.commit();
		sqlSession3.close();
		
		SqlSession sqlSession2=SqlSessionFactory.openSession();
		UserMapper userMapper2=sqlSession2.getMapper(UserMapper.class);
		List<User> list2=userMapper2.findUserById(1);
		System.out.println(list2);
		sqlSession2.close();
	}
	
	//一级缓存测试，mybatis中默认开启一级缓存
	@Test
	public void testCache1() throws Exception {
		SqlSession sqlSession=SqlSessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		//首先进行第一次查询
		List<User> listUser1=userMapper.findUserById(1);
		for (User user1 : listUser1) {
			System.out.println(user1);
		}
		//在两次查询之间加入更新删除插入等commit操作，会清空一级缓存区域
		User user=new User();
		user.setId(1);
		user.setUsername("王五五");
		userMapper.updateUser(user);
		sqlSession.commit();
		//第二次查询
		List<User> listUser2=userMapper.findUserById(1);
		for (User user2 : listUser2) {
			System.out.println(user2);
		}
		sqlSession.close();
	}
	
	@Test
	public void findUserByListMap() throws Exception {
		//通过会话工厂获得sqlsession对象
		SqlSession sqlSession=SqlSessionFactory.openSession();
		//这个sqlsession对象是加载配置文件，然后读取xml中文件
		UserMapper daoMapper=sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustomer customer=new UserCustomer();
		customer.setSex("1");
		customer.setAddress("安徽合肥");
		userQueryVo.setCustomer(customer);
		
		List<UserCustomer> list =daoMapper.findUserByListMap(userQueryVo);
		System.out.println(list);
		
		sqlSession.close();
	}
	
	@Test
	public void findUserByList() throws Exception {
		//通过会话工厂获得sqlsession对象
		SqlSession sqlSession=SqlSessionFactory.openSession();
		//这个sqlsession对象是加载配置文件，然后读取xml中文件
		UserMapper daoMapper=sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustomer customer=new UserCustomer();
		customer.setSex("1");
		customer.setAddress("安徽合肥");
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(24);
		ids.add(27);
		userQueryVo.setIds(ids);
		userQueryVo.setCustomer(customer);
		
		List<UserCustomer> list =daoMapper.findUserByList(userQueryVo);
		System.out.println(list);
		
		sqlSession.close();
	}

	@Test
	public void test() throws Exception {
		//通过会话工厂获得sqlsession对象
		SqlSession sqlSession=SqlSessionFactory.openSession();
		//这个sqlsession对象是加载配置文件，然后读取xml中文件
		UserMapper daoMapper=sqlSession.getMapper(UserMapper.class);
		//mybatis自动生成daoMapper代理对象
		List<User> list=daoMapper.findUserById(1);
		for (User user : list) {
			System.out.println(user.getAddress());
		}
		sqlSession.close();
		
	}

}
