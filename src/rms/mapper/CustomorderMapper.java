package rms.mapper;

import java.util.List;

import rms.po.CustomOrder;
import rms.po.Customorderdetail;
import rms.po.orderdetail;
/**
 * 
* @ClassName: CustomorderMapper 
* @Description: 自定义订单mapper
* @author random  
* @date 2015年7月22日 下午5:04:59 
*
 */
public interface CustomorderMapper {
	/**
	 * 
	* @Title: insertorder 
	* @Description: 保存订单基础信息，并返回自增主键
	* @param @param customOrder
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void insertorder(CustomOrder customOrder) throws Exception;
	/**
	 * 
	* @Title: deleteorderdetailByorderId 
	* @Description: 根据订单id删除订单明细信息
	* @param @param id
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteorderdetailByorderId(Integer id) throws Exception;
	/**
	 * 
	* @Title: updateorderdetail 
	* @Description: 根据菜品id和订单id更新明细数据 
	* @param @param now
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateorderdetail(orderdetail now) throws Exception;

//	/**
//	 * 
//	* @Title: findAllBystatus 
//	* @Description: 根据状态查询状态下所有订单 
//	* @param @param customorder
//	* @param @return
//	* @param @throws Exception    设定文件 
//	* @return List<CustomOrder>    返回类型 
//	* @throws
//	 */
//	public List<CustomOrder> findAllBystatus(CustomOrder customorder) throws Exception;
//	/**
//	 * 
//	* @Title: findorderByid 
//	* @Description: 根据订单ID查询订单基础信息
//	* @param @param id
//	* @param @return
//	* @param @throws Exception    设定文件 
//	* @return CustomOrder    返回类型 
//	* @throws
//	 */
//	public CustomOrder findorderByid(Integer id) throws Exception;
	/**
	 * 
	* @Title: findOrderdetailsByorderid 
	* @Description: 根据订单Id查询订单明细 
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<orderdetail>    返回类型 
	* @throws
	 */
	public List<Customorderdetail> findOrderdetailsByorderid(Integer id) throws Exception;
	/**
	 * 
	* @Title: findorderByCustomOrder 
	* @Description: 将查询条件设置进入customorder中，定制查询条件  返回一条记录
	* @param @param customorder
	* @param @return
	* @param @throws Exception    设定文件 
	* @return CustomOrder    返回类型 
	* @throws
	 */
	public CustomOrder findorderByCustomOrder(
			CustomOrder customorder) throws Exception;
	
	/**
	 * 
	* @Title: findorderByCustomOrderofList 
	* @Description:将查询条件设置进入customorder中，定制查询条件  返回所有查询到的记录
	* @param @param customOrder
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<CustomOrder>    返回类型 
	* @throws
	 */
	public List<CustomOrder> findorderByCustomOrderofList(CustomOrder customOrder) throws Exception;
	
	/**
	 * 
	* @Title: findOrderdetailsByOrderdetail 
	* @Description: 根据传入的订单明细类属性值，构建查询条件，查询符合的订单明细
	* @param @param customorderdetail
	* @param @return
	* @param @throws Exception    
	* @return List<Customorderdetail>    
	* @throws
	 */
	public List<Customorderdetail> findOrderdetailsByOrderdetail(Customorderdetail customorderdetail) throws Exception;
    
}