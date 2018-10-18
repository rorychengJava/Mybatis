package cn.itcast.mybatis.po;

import java.util.List;

/** 
* <p>Title:Mybatis</p>
* <p>Description:pojo传递参数的包装类型</p>
* @author rorycheng
* @Date 2018年10月15日 下午9:08:50
* @version 1.0 
*/
public class UserQueryVo {
	//private User user;
	private UserCustomer customer;
	private List<Integer> ids;
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public UserCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(UserCustomer customer) {
		this.customer = customer;
	}
	
}
