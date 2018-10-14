package cn.itcast.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

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

	@Test
	public void test() throws Exception {
		//通过会话工厂获得sqlsession对象
		SqlSession sqlSession=SqlSessionFactory.openSession();
		//这个sqlsession对象是加载配置文件，然后读取xml中文件
		UserDaoMapper daoMapper=sqlSession.getMapper(UserDaoMapper.class);
		//mybatis自动生成daoMapper代理对象
		List<User> list=daoMapper.findUserById(1);
		for (User user : list) {
			System.out.println(user.getAddress());
		}
		sqlSession.close();
		
		
	}

}
