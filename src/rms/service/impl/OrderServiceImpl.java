package rms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import rms.mapper.CustomorderMapper;
import rms.mapper.orderMapper;
import rms.mapper.orderdetailMapper;
import rms.po.CustomOrder;
import rms.po.orderdetail;
import rms.service.OrderService;
/**
 * 
* @ClassName: OrderServiceImpl 
* @Description: 订单相关业务实现类 
* @author random  
* @date 2015年7月22日 下午5:01:05 
*
 */
@Component
public class OrderServiceImpl implements OrderService {
	
	@Resource
	private orderMapper orderMapper;
	
	@Resource
	private CustomorderMapper customorderMapper;
	@Resource
	private orderdetailMapper orderdetailMapper;
	/*
	 * (非 Javadoc) 
	* <p>Title: saveOrder</p> 
	* <p>Description: 保存订单相关信息</p> 
	* @param customOrder
	* @throws Exception 
	* @see rms.service.OrderService#saveOrder(rms.po.CustomOrder)
	 */
	@Override
	public void saveOrder(CustomOrder customOrder) throws Exception {
		//保存订单基础数据
		customorderMapper.insertorder(customOrder);
		//保存订单明细数据
		List<orderdetail> orderdetails=customOrder.getOrderdetailList();
		for(orderdetail orderdetail:orderdetails){
			//明细关联到订单
			orderdetail.setCorderid(customOrder.getId());
			//保存每条明细
//			customorderMapper.insertorderdetail(orderdetail);
			orderdetailMapper.insertSelective(orderdetail);
		}
		
		
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: deleteOrder</p> 
	* <p>Description: 根据id删除订单</p> 
	* @param id
	* @throws Exception 
	* @see rms.service.OrderService#deleteOrder(java.lang.Integer)
	 */
	@Override
	public void deleteOrder(Integer id) throws Exception {
		//删除明细信息
		customorderMapper.deleteorderdetailByorderId(id);
		//删除基本数据信息
		orderMapper.deleteByPrimaryKey(id);
		
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: deleteOrderDetailsByiddetailsid</p> 
	* <p>Description:删除明细信息，根据明细id </p> 
	* @param id
	* @throws Exception 
	* @see rms.service.OrderService#deleteOrderDetailsByiddetailsid(java.lang.Integer)
	 */
	@Override
	public void deleteOrderDetailsBydetailsid(Integer id) throws Exception {
//		customorderMapper.deleteorderdetailBydetailId(id);
		orderdetailMapper.deleteByPrimaryKey(id);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: updateOrder</p> 
	* <p>Description: 更新订单信息以及明细</p> 
	* @param customOrder
	* @param id
	* @throws Exception 
	* @see rms.service.OrderService#updateOrder(rms.po.CustomOrder, java.lang.Integer)
	 */
	@Override
	public void updateOrder(CustomOrder customOrder, Integer id)
			throws Exception {
		customOrder.setId(id);
		//查询数据库中的明细
//		List<orderdetail> dborderdetails=customorderMapper.findOrderdetailsByid(id);
		//得到更新的明细
		//因为确保，只是更新操作,因此可以对比数据差异进行更新
		List<orderdetail> orderdetails=customOrder.getOrderdetailList();
		for(orderdetail now:orderdetails){
			now.setCorderid(id);
			customorderMapper.updateorderdetail(now);
		}
//		for(orderdetail now:orderdetails){
//			for(orderdetail old:dborderdetails){
//				if(now.getRdishid()==old.getRdishid()){
//					
//				}
//			}
//		}
		
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: changeOrderStatus</p> 
	* <p>Description:改变订单状态(以什么方式支付) </p> 
	* @param customOrder
	* @throws Exception 
	* @see rms.service.OrderService#changeOrderStatus(rms.po.CustomOrder)
	 */
	@Override
	public void changeOrderStatus(CustomOrder customOrder,Integer id) throws Exception {
		customOrder.setId(id);
		orderMapper.updateByPrimaryKey(customOrder);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findAllOrder</p> 
	* <p>Description:查询所有订单(基本信息)</p> 
	* @return
	* @throws Exception 
	* @see rms.service.OrderService#findAllOrder()
	 */
	@Override
	public List<CustomOrder> findAllOrderBystatus(CustomOrder customorder) throws Exception {
		return customorderMapper.findAllBystatus(customorder);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findOrderdetailsByid</p> 
	* <p>Description: 根据订单id查询订单明细</p> 
	* @param id
	* @return
	* @throws Exception 
	* @see rms.service.OrderService#findOrderdetailsByid(java.lang.Integer)
	 */
	@Override
	public CustomOrder findOrderdetailsByid(Integer id) throws Exception {
		//查询订单基础信息
		CustomOrder customOrder=customorderMapper.findorderByid(id);
		//查询所有订单明细
		List<orderdetail> orderdetails=customorderMapper.findOrderdetailsByorderid(id);
		
		customOrder.setOrderdetailList(orderdetails);
		
		return customOrder;
	}


}
