package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

/** 
* <p>Title:Mybatis</p>
* <p>Description:入门程序</p>
* @author rorycheng
* @Date 2018年9月18日 下午11:15:49
* @version 1.0 
*/
public class MybatisFirst {
	
	@Test
	public void findUserByIdTest() throws IOException {
		
		String resource="SqlMapConfig.xml";
		
		InputStream inputStream=Resources.getResourceAsStream(resource);
		
		//创建会话工厂  传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂创建sqlsession对象
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//通过sqlsession对象操作数据库
		//第一个参数：stament中的id指的是对应配置文件中相对应的sql
		//第二个参数：就是传入的参数
		User user=sqlSession.selectOne("test.findUserById",1);
		System.out.println(user.getId()+" "+user.getUsername());
		System.out.println(user);
		//释放资源
		sqlSession.close();
	}
	
	@Test
	public void findUserByUsername() throws IOException {
		
		InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sessionFactory.openSession();
		
		List<User> list=session.selectList("test.findUserByUsername", "小明");
		System.out.println(list);
		
		session.close();
	}
	
	@Test
	public void insertUser() throws IOException {
		
		InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sessionFactory.openSession();
		User user=new User();
		user.setUsername("rory");
		user.setBirthday(new Date(System.currentTimeMillis()));
		user.setSex("1");
		user.setAddress("安徽桐城");
		
		session.insert("test.insertUser", user);
		session.commit();
		
		System.out.println(user.getId());
		session.close();
		
	}
	
	//删除用户
	@Test
	public void deleteUser() throws IOException {
		
		InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sessionFactory.openSession();
		User user=new User();
		user.setUsername("rory");
		user.setBirthday(new Date(System.currentTimeMillis()));
		user.setSex("1");
		user.setAddress("安徽桐城");
		
		session.delete("test.deleteUser", 25);
		session.commit();
		session.close();
	}

	//更新
	@Test
	public void updateUser() throws IOException {
		
		InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sessionFactory.openSession();
		User user=new User();
		user.setUsername("rorycheng");
		user.setId(24);
		user.setAddress("安徽合肥");
		session.update("test.updateUser", user);
		session.commit();
		session.close();
	}

}
