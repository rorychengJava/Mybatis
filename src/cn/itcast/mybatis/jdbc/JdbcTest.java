package cn.itcast.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** 
* <p>Title:Mybatis</p>
* <p>Description:</p>
* @author rorycheng
* @Date 2018年9月17日 下午9:43:08
* @version 1.0 
*/
public class JdbcTest {
	public static void main(String[] args) {
		//以下对象创建，选择的类为java.sql  而不为mysql.sql ，因为前者为接口，如果数据库换为oracle，该类就不起作用
		//建立数据库连接对象
		Connection con=null;
		//预编译对象，有利于数据库执行SQL性能（对于相同SQL，数据库不会重复编译）
		PreparedStatement pre=null;
		//创建结果集对象
		ResultSet res=null;
		
		try {
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//通过驱动管理类获取数据库连接
			con= 
	DriverManager.getConnection("jdbc:mysql://localhost:3306/rory?characterEncoding=utf-8","root","123456");
			String sql="select * from user where username=?";
			//将sql放进预编译对象中
			pre=con.prepareStatement(sql);
			pre.setString(1, "王五");
			//向数据库发送SQL，得查询结果
			res=pre.executeQuery();
			//遍历查询结果集
			while(res.next()) {
				System.out.println(res.getString("id")+" "+res.getString("username"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//释放资源
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pre!=null) {
				try {
					pre.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
