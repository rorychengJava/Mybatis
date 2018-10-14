package cn.itcast.mybatis.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.po.User;

/** 
* <p>Title:Mybatis</p>
* <p>Description:</p>
* @author rorycheng
* @Date 2018年10月8日 下午10:46:00
* @version 1.0 
*/
public class UserDaoImpl implements UserDao{
	private SqlSessionFactory sqlSessionFactory;
	//没有注入之前，先通过构造函数直接传入参数直接新建sqlsession对象 
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}
	public List<User> findUserById(int id) throws Exception {
		//sqlsession放在方法内，避免线程不安全
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<User> list=sqlSession.selectList("test.findUserById", id);
		return list;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser", id);
		sqlSession.commit();
		sqlSession.close();
	}
		
	
}
