package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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
		sqlSession.selectOne("test.findUserByID",1);
		
		//释放资源
		sqlSession.close();
		
		
		
	}
}
