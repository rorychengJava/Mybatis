package cn.itcast.mybatis.mapper;
/** 
* <p>Title:Mybatis</p>
* <p>Description:查询增删Dao接口方法</p>
* @author rorycheng
* @Date 2018年10月8日 下午10:26:13
* @version 1.0 
*/

import java.util.List;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustomer;
import cn.itcast.mybatis.po.UserQueryVo;

public interface UserMapper {
		
	//根据多个信息进行高级查询
	public List<UserCustomer> findUserByList(UserQueryVo userQueryVo) throws Exception;
	//根据高级映射查询
	public List<UserCustomer> findUserByListMap(UserQueryVo userQueryVo)throws Exception;
	//根据id查询用户信息
	public List<User> findUserById(int id) throws Exception;
	//添加用户信息
//	public void insertUser(User user) throws Exception;
//	//根据id删除用户
//	public void deleteUser(int id) throws Exception;
	//根据信息更新用户
	public void updateUser(User user) throws Exception;
}
