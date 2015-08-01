package rms.po;

import java.util.List;

/**
 * 
* @ClassName: CustomOrder 
* @Description: 自定义订单pojo 
* @author random  
* @date 2015年7月22日 下午5:03:03 
*
 */
public class CustomOrder extends order {
	
	//订单类的所有订单项
	private List<orderdetail> orderdetailList;

	public List<orderdetail> getOrderdetailList() {
		return orderdetailList;
	}

	public void setOrderdetailList(List<orderdetail> orderdetailList) {
		this.orderdetailList = orderdetailList;
	}
	
	
}
