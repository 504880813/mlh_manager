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
	
	//订单类的所有普通订单项
	private List<Customorderdetail> orderdetailList;
	
	//订单类的所有加菜订单项
	List<Customorderdetail> adddishList;
	//订单类的所有退菜订单项
	List<Customorderdetail> retreatdishList;
	
	//餐桌名称用于显示
	private String diningTableName;
	
	
	public List<Customorderdetail> getAdddishList() {
	    return adddishList;
	}

	public void setAdddishList(List<Customorderdetail> adddishList) {
	    this.adddishList = adddishList;
	}

	public List<Customorderdetail> getRetreatdishList() {
	    return retreatdishList;
	}

	public void setRetreatdishList(List<Customorderdetail> retreatdishList) {
	    this.retreatdishList = retreatdishList;
	}

	public String getDiningTableName() {
	    return diningTableName;
	}

	public void setDiningTableName(String diningTableName) {
	    this.diningTableName = diningTableName;
	}

	public List<Customorderdetail> getOrderdetailList() {
		return orderdetailList;
	}

	public void setOrderdetailList(List<Customorderdetail> orderdetailList) {
		this.orderdetailList = orderdetailList;
	}
	
	
}
