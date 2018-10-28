package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;

/** 
* <p>Title:Mybatis</p>
* <p>Description:</p>
* @author rorycheng
* @Date 2018年10月23日 下午10:50:58
* @version 1.0 
*/
public interface OrdersCustomMapper {
	// 通过resultType映射到pojo类的方法
	//	public List<OrdersCustom> findOrderList() throws Exception;
	
	//通过resultMap映射方法
	public List<Orders> findOrderListMap() throws Exception;

}
