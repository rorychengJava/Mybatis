package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.OrdersCustom;

/** 
* <p>Title:Mybatis</p>
* <p>Description:</p>
* @author rorycheng
* @Date 2018年10月23日 下午10:50:58
* @version 1.0 
*/
public interface OrdersCustomMapper {
	public List<OrdersCustom> findOrderList() throws Exception;
}
