package rms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rms.po.CustomOrder;
import rms.po.Customcategory;
import rms.po.CustomdiningTable;
import rms.po.Customdish;
import rms.po.Customorderdetail;
import rms.po.diningTable;
import rms.service.CategoryService;
import rms.service.DiningTableService;
import rms.service.DishService;
import rms.service.OrderService;
import rms.untils.StringUtils;

/**
 * 
* @ClassName: OrderHandler 
* @Description: 订单处理器
* @author random  
* @date 2015年7月22日 下午4:57:00 
*
 */
@Controller
@RequestMapping("order")
public class OrderHandler {
	
	@Resource
	private DishService dishservice;
	
	@Resource
	private OrderService orderService;
	@Resource
	private DiningTableService diningTableService;
	@Resource
	private CategoryService categoryService;
//	@Resource
//	private DishService dishService;
	
	/**
	 * 
	* @Title: startOrder 
	* @Description: 为初始化订单准备数据
	* @param @param diningTableId
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("startOrder")
	public ModelAndView startOrder(Integer diningTableId,String diningTableSeatnumber) throws Exception{
		
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("diningTableId", diningTableId);
		mav.addObject("diningTableSeatnumber", diningTableSeatnumber);
		mav.addObject("createtime",StringUtils.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		
		mav.setViewName("order/startorder");
		
		return mav;
	}
	/**
	 * 
	* @Title: startorderSubmit 
	* @Description: 处理初始化订单请求，并为订单明细准备数据。 
	* @param @param diningTableId
	* @param @param customOrder
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("startorderSubmit")
	public ModelAndView startorderSubmit(Integer diningTableId,CustomOrder customOrder) throws Exception{
		//绑定餐桌
		customOrder.setrDiningtableId(diningTableId);
		//转换日期格式
		String startTime=StringUtils.DateToString(customOrder.getCreatetime(), "yyyy-MM-dd HH:mm:ss");
		
		List<Customdish> dishs=dishservice.findAllDish();
		
		List<Customcategory> categorys=categoryService.findAllCategory();
		
		
		ModelAndView mav=new ModelAndView();
		

		mav.addObject("startTime", startTime);
		mav.addObject("categorys", categorys);
		mav.addObject("order",customOrder);
		mav.addObject("dishs", dishs);
		
		mav.setViewName("order/startOrderofdish");
		
		return mav;
	}
	/**
	 * 
	* @Title: startOrderofdishSubmit 
	* @Description: 保存订单信息同时将餐桌换成忙碌
	* @param @param customOrder
	* @param @param bindingResult
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("startOrderofdishSubmit")
	public ModelAndView startOrderofdishSubmit(@Validated CustomOrder customOrder,BindingResult bindingResult) throws Exception{
		ModelAndView mav=new ModelAndView();
		if(bindingResult.hasErrors()){
			mav.addObject("errors", bindingResult.getAllErrors());
			mav.setViewName("error");
			return mav;
		}
		//保存订单以及关联信息
		orderService.saveOrder(customOrder);
		//改变餐桌状态信息 变为忙碌状态
		diningTableService.updateStateById(customOrder.getrDiningtableId(), false);
		//跳转到餐桌界面 
		mav.setViewName("redirect:/diningTable/getAllDiningTableoforder.action");
		
		return mav;
	}
	
	/**
	 * @throws Exception 
	 * 
	* @Title: getAllOrderofNotCheckout 
	* @Description: 得到未结账的账单列表
	* @param @return    
	* @return ModelAndView    
	* @throws
	 */
	@RequestMapping("getAllOrderofNotCheckout")
	public ModelAndView getAllOrderofNotCheckout() throws Exception {
	    
	    ModelAndView mav=new ModelAndView();
	    CustomOrder queryorder=new CustomOrder();
	    queryorder.setIsbalance(false);
	    List<CustomOrder> orders=orderService.findAllOrderBystatus(queryorder);
	    
	    for(CustomOrder order:orders) {
		
		diningTable dt=diningTableService.findDiningTableById(order.getrDiningtableId());
		
		order.setDiningTableName(dt.getSeatnumber());
	    }
	    
	    mav.addObject("orders", orders);
	    mav.setViewName("order/OrderList");
	    
	    return mav;
	}
	
	
	/**
	 * 
	* @Title: Checkoutofdiningtableid 
	* @Description: 根据餐桌id付款 
	* @param @param diningtableid
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("Checkoutofdiningtableid")
	public ModelAndView Checkoutofdiningtableid(Integer diningtableid) throws Exception{
		
		CustomOrder order=orderService.findOrderBydiningtableid(diningtableid);
		
		order.setrDiningtableId(diningtableid);
		ModelAndView mav=new ModelAndView();
		//包括明细数据
		mav.addObject("order", order);
		mav.addObject("endtime",StringUtils.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		mav.setViewName("order/Ordercheckout");
		
		return mav;
	}
	/**
	 * 
	* @Title: Checkout 
	* @Description: 结账
	* @param @param customorder
	* @param @return
	* @param @throws Exception    
	* @return String    
	* @throws
	 */
	@RequestMapping("Checkout")
	public String Checkout(CustomOrder customorder,Integer id) throws Exception{
	    orderService.checkoutByorderid(customorder,id);
	    return "redirect:/order/getAllOrderofNotCheckout.action";
	}
	
	/**
	 * 
	* @Title: editOrderofdiningtableid 
	* @Description: 根据餐桌id为修改订单基础数据准备数据
	* @param @param diningtableid
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("editOrderofdiningtableid")
	public ModelAndView editOrderofdiningtableid(Integer diningtableid) throws Exception{
		
		CustomOrder order=orderService.findOrderBydiningtableid(diningtableid);
		
		List<Customdish> dishList=dishservice.findAllDish();
		
		ModelAndView mav=new ModelAndView();
		//包括明细数据
		mav.addObject("order", order);
		mav.addObject("dishList", dishList);
		mav.addObject("endtime",StringUtils.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		mav.setViewName("order/editOrder");
		return mav;
	}
	
	/**
	 * 
	* @Title: editorder 
	* @Description: 修改订单(加/退菜)
	* @param @param customOrder
	* @param @return
	* @param @throws Exception    
	* @return ModelAndView    
	* @throws
	 */
	@RequestMapping("editorder")
	public ModelAndView editorder(CustomOrder customOrder,Integer id) throws Exception{
	    
	    	orderService.updateOrder(customOrder, id);
	    	
	    	ModelAndView mav=new ModelAndView();
	    	
	    	mav.setViewName("redirect:/order/getAllOrderofNotCheckout.action");
	    	
	    	return mav;
	}
	
	/**
	 * 
	* @Title: changeOrderdiningtableofdiningtableid 
	* @Description:为修改订单的餐桌操作准备数据 
	* @param @param diningtableid
	* @param @return
	* @param @throws Exception    
	* @return ModelAndView    
	* @throws
	 */
	@RequestMapping("changeOrderdiningtableofdiningtableid")
	public ModelAndView changeOrderdiningtableofdiningtableid(Integer orderid) throws Exception{
	    	
	    	
	    	List<CustomdiningTable> diningTables = diningTableService
			.fingAllDiningTable();
		ModelAndView mav=new ModelAndView();
		//包括明细数据
		mav.addObject("orderid",orderid);
		mav.addObject("diningTables", diningTables);
		mav.setViewName("order/diningTableList");
		return mav;
	}
	/**
	 * 
	* @Title: changeOrderdiningtableofdiningtableidSubmit 
	* @Description: 根据餐桌信息修改 
	* @param @param olddiningtableid
	* @param @param newdiningtableid
	* @param @return
	* @param @throws Exception    
	* @return ModelAndView    
	* @throws
	 */
	@RequestMapping("changeOrderdiningtableofdiningtableidSubmit")
	public ModelAndView changeOrderdiningtableofdiningtableidSubmit(Integer orderid,Integer newdiningtableid) throws Exception{
	    
	    orderService.changeorderdiningtable(orderid,newdiningtableid);
	    
	    ModelAndView mav=new ModelAndView();
	    mav.setViewName("redirect:/order/getAllOrderofNotCheckout.action");
	    return mav;
	}
	
	/**
	 * 
	* @Title: ChangeOrderservingstatus 
	* @Description: TODO ChangeOrderservingstatus 暂定
	* @param @param orderid
	* @param @param dishid
	* @param @return
	* @param @throws Exception    
	* @return ModelAndView    
	* @throws
	 */
	public ModelAndView ChangeOrderservingstatus(String orderid,String dishid) throws Exception{
	    
	    
	    ModelAndView mav=new ModelAndView();
	    
	    mav.setViewName("");
	    
	    return mav;
	    
	}



}
