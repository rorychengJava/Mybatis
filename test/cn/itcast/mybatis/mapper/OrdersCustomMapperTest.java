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

import cn.itcast.mybatis.po.OrdersCustom;

/** 
* <p>Title:Mybatis</p>
* <p>Description:</p>
* @author rorycheng
* @Date 2018年10月23日 下午10:59:29
* @version 1.0 
*/
public class OrdersCustomMapperTest {
	//会话工厂是单列模式
		private SqlSessionFactory sessionFactory;
	@Before
	public void setUp() throws Exception {
		InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
		sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void findOrderList() throws Exception {
		SqlSession sqlSession=sessionFactory.openSession();
		//通过会话工厂生成代理对象
		OrdersCustomMapper customMapper=sqlSession.getMapper(OrdersCustomMapper.class);
		List<OrdersCustom> list=customMapper.findOrderList();
		System.out.println(list);
	}

}