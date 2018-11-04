package cn.itcast.mybatis.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
* <p>Title:Mybatis</p>
* <p>Description:针对Mybatis中查询结果封装在一个java对象中</p>
* @author rorycheng
* @Date 2018年9月18日 下午11:00:25
* @version 1.0 
*/
public class User implements Serializable{
	private int id;
	private String username;// 用户姓名
	private String sex;// 性别
	private Date birthday;// 生日
	private String address;// 地址
	
	private List<Orders> orders;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + ", orders=" + orders + "]";
	}

	
		
	
}
