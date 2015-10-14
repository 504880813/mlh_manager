package rms.service;

import java.util.List;

import rms.po.CustomOrder;
import rms.po.cardRecord;
/**
 * 
* @ClassName: OrderService 
* @Description: 处理订单相关业务
* @author random  
* @date 2015年7月22日 下午5:00:23 
*
 */

public interface OrderService {
	/**
	 * 
	* @Title: saveOrder 
	* @Description: 保存订单相关所有信息
	* @param @param customOrder
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void saveOrder(CustomOrder customOrder) throws Exception;
	/**
	 * 
	* @Title: deleteOrder 
	* @Description: 根据订单id删除订单相关信息 
	* @param @param id
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteOrder(Integer id) throws Exception;
	
	/**
	 * 
	* @Title: deleteOrderDetailsBydetailsid 
	* @Description: 根据明细id删除订单明细
	* @param @param id
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void  deleteOrderDetailsBydetailsid(Integer id) throws Exception;
	
	/**
	 * 
	* @Title: updateOrder 
	* @Description: 根据id更新所有信息
	* @param @param customOrder
	* @param @param id
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateOrder(CustomOrder customOrder,Integer id) throws Exception;
	
	
	/**
	 * 
	* @Title: changeOrderStatus 
	* @Description: 改变订单的支付状态
	* @param @param customOrder
	* @param @param  id
	* @param @throws Exception   设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void changeOrderStatus(CustomOrder customOrder,Integer id) throws Exception;
	/**
	 * 
	* @Title: findAllOrder 
	* @Description: 根据订单状态查询所有订单(基础数据) 
	* @param  customorder
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<CustomOrder>    返回类型 
	* @throws
	 */
	public List<CustomOrder> findAllOrderBystatus(CustomOrder customorder) throws Exception;
	/**
	 * 
	* @Title: findOrderdetailsByid 
	* @Description:  根据订单id查询订单明细
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return CustomOrder    返回类型 
	* @throws
	 */
	public CustomOrder findOrderdetailsByid(Integer id) throws Exception;
	/**
	 * 
	* @Title: findOrderBydiningtableid 
	* @Description: 根据餐桌id查询订单信息包括明细
	* @param @param diningtableid
	* @param @return
	* @param @throws Exception    设定文件 
	* @return CustomOrder    返回类型 
	* @throws
	 */
	public CustomOrder findOrderBydiningtableid(Integer diningtableid) throws Exception;
	/**
	 * 
	* @Title: changeorderdiningtable 
	* @Description: 修改该订单对应的餐桌
	* @param @param orderid
	* @param @param newdiningtableid
	* @param @throws Exception    
	* @return void    
	* @throws
	 */
	public void changeorderdiningtable(Integer orderid,
		Integer newdiningtableid) throws Exception;
	/**
	 * 
	* @Title: checkoutByorderid 
	* @Description: 根据订单id结账 
	* @param @param customorder
	* @param @param id
	* @param @throws Exception    
	* @return void    
	* @throws
	 */
	public void checkoutByorderid(CustomOrder customorder, Integer id) throws Exception;
	/**
	 * 
	* @Title: MembercheckoutByorderid 
	* @Description: 会员结账
	* @param @param customorder
	* @param @param id
	* @param @param cardRecord
	* @param @throws Exception    
	* @return void    
	* @throws
	 */
	public void MembercheckoutByorderid(CustomOrder customorder,
		Integer id, cardRecord cardRecord) throws Exception;
}
