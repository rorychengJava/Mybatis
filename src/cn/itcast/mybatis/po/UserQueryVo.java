package cn.itcast.mybatis.po;
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

	public UserCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(UserCustomer customer) {
		this.customer = customer;
	}
	
}
