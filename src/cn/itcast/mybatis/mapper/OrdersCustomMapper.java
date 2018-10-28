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
	
	//一对多的高级映射
	public List<Orders> findOrderDetail() throws Exception;

}

//[Orders [id=3, userId=1, number=1000010, createtime=Wed Feb 04 13:22:35 CST 2015, note=null, 
//user=User [id=3, username=王五, sex=null, birthday=null, address=null], 
//orderdetails=[Orderdetail [id=1, ordersId=3, itemsId=1, itemsNum=1], 
//              Orderdetail [id=2, ordersId=3, itemsId=2, itemsNum=3]]], 
//Orders [id=4, userId=1, number=1000011, createtime=Tue Feb 03 13:22:41 CST 2015, note=null, 
//user=User [id=4, username=王五, sex=null, birthday=null, address=null], 
//orderdetails=[Orderdetail [id=3, ordersId=4, itemsId=3, itemsNum=4],                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
//             Orderdetail [id=4, ordersId=4, itemsId=2, itemsNum=3]]]]

//[Orders [id=3, userId=1, number=1000010, createtime=Wed Feb 04 13:22:35 CST 2015, note=null, 
//user=User [id=3, username=王五, sex=null, birthday=null, address=null], 
//orderdetail=Orderdetail [id=2, ordersId=3, itemsId=2, itemsNum=3]], 
// 
// Orders [id=4, userId=1, number=1000011, createtime=Tue Feb 03 13:22:41 CST 2015, note=null, 
// user=User [id=4, username=王五, sex=null, birthday=null, address=null], 
// orderdetail=Orderdetail [id=4, ordersId=4, itemsId=2, itemsNum=3]]]