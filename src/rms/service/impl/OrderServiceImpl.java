package rms.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import rms.controller.exception.CustomException;
import rms.mapper.CustomdishMapper;
import rms.mapper.CustommaterialsMapper;
import rms.mapper.CustomorderMapper;
import rms.mapper.diningTableMapper;
import rms.mapper.dishMapper;
import rms.mapper.materialsMapper;
import rms.mapper.orderMapper;
import rms.mapper.orderdetailMapper;
import rms.po.CustomOrder;
import rms.po.Customdish;
import rms.po.Custommaterials;
import rms.po.Customorderdetail;
import rms.po.card;
import rms.po.cardRecord;
import rms.po.diningTable;
import rms.po.dish;
import rms.po.order;
import rms.po.orderdetail;
import rms.service.DiningTableService;
import rms.service.DishService;
import rms.service.MaterialsService;
import rms.service.OrderService;
import rms.service.cardService;
import rms.wechat.Enumeration.wechatTemplateidKey;
import rms.wechat.entity.TemplateData;
import rms.wechat.entity.TemplateMessage;

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

    /**
     * service
     */
    @Resource
    private DiningTableService diningTableService;

    @Resource
    private DishService dishService;
    @Resource
    private MaterialsService materialsService;
    @Resource
    private cardService cardService;

    /**
     * dao_mapper
     */
    @Resource
    private orderMapper orderMapper;
    @Resource
    private CustomorderMapper customorderMapper;
    @Resource
    private orderdetailMapper orderdetailMapper;
    @Resource
    private CustomdishMapper customdishMapper;
    @Resource
    private dishMapper dishMapper;
    @Resource
    private diningTableMapper diningTableMapper;
    @Resource
    private materialsMapper materialsMapper;
    @Resource
    private CustommaterialsMapper custommaterialsMapper;

    /*
     * (非 Javadoc) <p>Title: saveOrder</p> <p>Description: 保存订单相关信息</p>
     * 
     * @param customOrder
     * 
     * @throws Exception
     * 
     * @see rms.service.OrderService#saveOrder(rms.po.CustomOrder)
     */
    @Override
    public void saveOrder(CustomOrder customOrder) throws Exception {
	// 保存订单基础数据
	customorderMapper.insertorder(customOrder);
	// 保存订单明细数据
	List<Customorderdetail> orderdetails = customOrder.getOrderdetailList();
	for (orderdetail orderdetail : orderdetails) {
	    // 明细关联到订单
	    orderdetail.setCorderid(customOrder.getId());
	    // 保存每条明细
	    // customorderMapper.insertorderdetail(orderdetail);
	    orderdetailMapper.insertSelective(orderdetail);
	    // 将明细的菜用到的原料删除
	    // 查询明细对应的菜品
	    // dish dish=dishMapper.selectByPrimaryKey();

	    Customdish dish = dishService.findDishWithImageById(orderdetail
		    .getRdishid());
	    // 判断是套餐还是单菜
	    if (dish.getCustommaterials() == null
		    || dish.getCustommaterials().size() == 0) {
		// 套餐
		for (Customdish sub_dish : dish.getSub_customdish()) {
		    ChangeMaterials(
			    customdishMapper.findsubMaterialsBydishId(sub_dish
				    .getId()), false,
			    sub_dish.getSub_customdish_quantity());
		}
	    } else {
		// 单菜
		ChangeMaterials(dish.getCustommaterials(), false,
			orderdetail.getDishnumber());
	    }

	}

    }

    /*
     * (非 Javadoc) <p>Title: deleteOrder</p> <p>Description: 根据id删除订单</p>
     * 
     * @param id
     * 
     * @throws Exception
     * 
     * @see rms.service.OrderService#deleteOrder(java.lang.Integer)
     */
    @Override
    public void deleteOrder(Integer id) throws Exception {

	// 先对明细中的每个菜对应的原料，还原
	List<Customorderdetail> orderdetails = customorderMapper
		.findOrderdetailsByorderid(id);

	for (Customorderdetail orderdetail : orderdetails) {
	    Customdish orderdish = dishService
		    .findDishWithImageById(orderdetail.getRdishid());
	    // 判断是套餐还是单菜
	    if (orderdish.getCustommaterials() == null
		    || orderdish.getCustommaterials().size() == 0) {
		// 套餐
		for (Customdish sub_dish : orderdish.getSub_customdish()) {
		    ChangeMaterials(
			    customdishMapper.findsubMaterialsBydishId(sub_dish
				    .getId()), true,
			    sub_dish.getSub_customdish_quantity());
		}
	    } else {
		// 单菜
		ChangeMaterials(orderdish.getCustommaterials(), true,
			orderdetail.getDishnumber());
	    }
	}
	// 删除明细信息
	customorderMapper.deleteorderdetailByorderId(id);
	// 删除基本数据信息
	orderMapper.deleteByPrimaryKey(id);

    }

    /*
     * (非 Javadoc) <p>Title: deleteOrderDetailsByiddetailsid</p>
     * <p>Description:删除明细信息，根据明细id </p>
     * 
     * @param id
     * 
     * @throws Exception
     * 
     * @see
     * rms.service.OrderService#deleteOrderDetailsByiddetailsid(java.lang.Integer
     * )
     */
    @Override
    public void deleteOrderDetailsBydetailsid(Integer id) throws Exception {
	// customorderMapper.deleteorderdetailBydetailId(id);
	orderdetail orderdetail = orderdetailMapper.selectByPrimaryKey(id);
	Customdish orderdish = dishService.findDishWithImageById(orderdetail
		.getRdishid());
	// 判断是套餐还是单菜
	if (orderdish.getCustommaterials() == null
		|| orderdish.getCustommaterials().size() == 0) {
	    // 套餐
	    for (Customdish sub_dish : orderdish.getSub_customdish()) {
		ChangeMaterials(
			customdishMapper.findsubMaterialsBydishId(sub_dish
				.getId()), true,
			sub_dish.getSub_customdish_quantity());
	    }
	} else {
	    // 单菜
	    ChangeMaterials(orderdish.getCustommaterials(), true,
		    orderdetail.getDishnumber());
	}

	orderdetailMapper.deleteByPrimaryKey(id);
    }

    /*
     * (非 Javadoc) <p>Title: updateOrder</p> <p>Description: 更新订单信息以及明细</p>
     * 
     * @param customOrder
     * 
     * @param id
     * 
     * @throws Exception
     * 
     * @see rms.service.OrderService#updateOrder(rms.po.CustomOrder,
     * java.lang.Integer)
     */
    @Override
    public void updateOrder(CustomOrder customOrder, Integer id)
	    throws Exception {
	customOrder.setId(id);

	// 先根据订单id更新订单的基础数据
	// customorderMapper.updateOrd
	orderMapper.updateByPrimaryKeySelective(customOrder);

	// 查询条件
	Customorderdetail orderdetailofselect = null;
	// 得到加菜更新的明细
	List<Customorderdetail> adddishorderdetails = customOrder
		.getAdddishList();
	if (adddishorderdetails != null) {
	    // 查询数据库中的加菜明细
	    orderdetailofselect = new Customorderdetail();
	    orderdetailofselect.setCorderid(id);
	    orderdetailofselect.setEchelon(2);
	    List<Customorderdetail> DBadddishorderdetails = customorderMapper
		    .findOrderdetailsByOrderdetail(orderdetailofselect);
	    // 临时，用来记录加菜更新数据
	    List<Customorderdetail> Tempadddishorderdetails = new ArrayList<>();
	    // 对比加菜明细，如果有相关菜，加菜记录，则更新，否则插入
	    for (Customorderdetail dbadddish : DBadddishorderdetails) {
		for (Customorderdetail adddish : adddishorderdetails) {
		    if (dbadddish.getRdishid() == adddish.getRdishid()) {
			Tempadddishorderdetails.add(adddish);
		    }
		}
	    }
	    // 更新加菜数据
	    for (Customorderdetail adddish : Tempadddishorderdetails) {
		// 更新原料仓库数据
		Customdish dish = dishService.findDishWithImageById(adddish
			.getRdishid());
		// 判断是套餐还是单菜
		if (dish.getCustommaterials() == null
			|| dish.getCustommaterials().size() == 0) {
		    // 套餐
		    for (Customdish sub_dish : dish.getSub_customdish()) {
			ChangeMaterials(
				customdishMapper.findsubMaterialsBydishId(sub_dish
					.getId()), false,
				sub_dish.getSub_customdish_quantity());
		    }
		} else {
		    // 单菜
		    ChangeMaterials(dish.getCustommaterials(), false,
			    adddish.getDishnumber());
		}
		//关联订单
		adddish.setCorderid(id);
		// 更新数据
		customorderMapper.updateorderdetail(adddish);
		
		adddishorderdetails.remove(adddish);
	    }
	    // 插入新加菜数据
	    for (Customorderdetail adddish : adddishorderdetails) {
		// 更新原料仓库数据
		Customdish dish = dishService.findDishWithImageById(adddish
			.getRdishid());
		// 判断是套餐还是单菜
		if (dish.getCustommaterials() == null
			|| dish.getCustommaterials().size() == 0) {
		    // 套餐
		    for (Customdish sub_dish : dish.getSub_customdish()) {
			ChangeMaterials(
				customdishMapper.findsubMaterialsBydishId(sub_dish
					.getId()), false,
				sub_dish.getSub_customdish_quantity());
		    }
		} else {
		    // 单菜
		    ChangeMaterials(dish.getCustommaterials(), false,
			    adddish.getDishnumber());
		}
		// 插入数据
		adddish.setCorderid(id);
		orderdetailMapper.insertSelective(adddish);
	    }
	}
	// 得到退菜更新的明细
	List<Customorderdetail> retreatdishorderdetails = customOrder
		.getRetreatdishList();
	if (retreatdishorderdetails != null) {
	    // 查询数据库中的退菜明细
	    orderdetailofselect = new Customorderdetail();
	    orderdetailofselect.setCorderid(id);
	    orderdetailofselect.setEchelon(0);
	    List<Customorderdetail> DBretreatdishorderdetails = customorderMapper
		    .findOrderdetailsByOrderdetail(orderdetailofselect);
	    // 临时，用来记录退菜更新数据
	    List<Customorderdetail> Tempretreatdishorderdetails = new ArrayList<>();
	    // 对比退菜明细，如果有相关菜，退菜记录，则更新，否则插入
	    for (Customorderdetail dbretreatdish : DBretreatdishorderdetails) {
		for (Customorderdetail retreatdish : retreatdishorderdetails) {
		    if (dbretreatdish.getRdishid() == retreatdish.getRdishid()) {
			Tempretreatdishorderdetails.add(retreatdish);
		    }
		}
	    }
	    // 更新退菜数据
	    for (Customorderdetail retreatdish : Tempretreatdishorderdetails) {
		Customdish dish = dishService.findDishWithImageById(retreatdish
			.getRdishid());
		// 判断是套餐还是单菜
		if (dish.getCustommaterials() == null
			|| dish.getCustommaterials().size() == 0) {
		    // 套餐
		    for (Customdish sub_dish : dish.getSub_customdish()) {
			ChangeMaterials(
				customdishMapper.findsubMaterialsBydishId(sub_dish
					.getId()), true,
				sub_dish.getSub_customdish_quantity());
		    }
		} else {
		    // 单菜
		    ChangeMaterials(dish.getCustommaterials(), true,
			    retreatdish.getDishnumber());
		}
		//关联订单
		retreatdish.setCorderid(id);
		customorderMapper.updateorderdetail(retreatdish);
		retreatdishorderdetails.remove(retreatdish);
	    }
	    // 插入新退菜数据
	    for (Customorderdetail retreatdish : retreatdishorderdetails) {
		Customdish dish = dishService.findDishWithImageById(retreatdish
			.getRdishid());
		// 判断是套餐还是单菜
		if (dish.getCustommaterials() == null
			|| dish.getCustommaterials().size() == 0) {
		    // 套餐
		    for (Customdish sub_dish : dish.getSub_customdish()) {
			ChangeMaterials(
				customdishMapper.findsubMaterialsBydishId(sub_dish
					.getId()), true,
				sub_dish.getSub_customdish_quantity());
		    }
		} else {
		    // 单菜
		    ChangeMaterials(dish.getCustommaterials(), true,
			    retreatdish.getDishnumber());
		}
		retreatdish.setCorderid(id);
		orderdetailMapper.insertSelective(retreatdish);
	    }
	}

    }

    /*
     * (非 Javadoc) <p>Title: changeOrderStatus</p>
     * <p>Description:改变订单状态(以什么方式支付) </p>
     * 
     * @param customOrder
     * 
     * @throws Exception
     * 
     * @see rms.service.OrderService#changeOrderStatus(rms.po.CustomOrder)
     */
    @Override
    public void changeOrderStatus(CustomOrder customOrder, Integer id)
	    throws Exception {
	customOrder.setId(id);
	orderMapper.updateByPrimaryKey(customOrder);
    }

    /*
     * (非 Javadoc) <p>Title: findAllOrder</p> <p>Description:查询所有订单(基本信息)</p>
     * 
     * @return
     * 
     * @throws Exception
     * 
     * @see rms.service.OrderService#findAllOrder()
     */
    @Override
    public List<CustomOrder> findAllOrderBystatus(CustomOrder customorder)
	    throws Exception {
	return customorderMapper.findorderByCustomOrderofList(customorder);
    }

    /*
     * (非 Javadoc) <p>Title: findOrderdetailsByid</p> <p>Description:
     * 根据订单id查询订单明细</p>
     * 
     * @param id
     * 
     * @return
     * 
     * @throws Exception
     * 
     * @see rms.service.OrderService#findOrderdetailsByid(java.lang.Integer)
     */
    @Override
    public CustomOrder findOrderdetailsByid(Integer id) throws Exception {
	// 构建查询信息
	CustomOrder query = new CustomOrder();
	query.setId(id);
	// 查询订单基础信息
	CustomOrder customOrder = customorderMapper
		.findorderByCustomOrder(query);
	// 查询所有订单明细
	List<Customorderdetail> orderdetails = customorderMapper
		.findOrderdetailsByorderid(id);

	customOrder.setOrderdetailList(orderdetails);

	return customOrder;
    }

    /*
     * (非 Javadoc) <p>Title: findOrderBydiningtableid</p> <p>Description:
     * 根据餐桌id查询订单信息包括明细</p>
     * 
     * @param diningtableid
     * 
     * @return
     * 
     * @throws Exception
     * 
     * @see rms.service.OrderService#findOrderBydiningtableid(java.lang.Integer)
     */
    @Override
    public CustomOrder findOrderBydiningtableid(Integer diningtableid)
	    throws Exception {
	// 构建查询信息
	CustomOrder query = new CustomOrder();
	query.setrDiningtableId(diningtableid);
	query.setIsbalance(false);
	// 查询订单基础信息
	CustomOrder customOrder = customorderMapper
		.findorderByCustomOrder(query);

	diningTable dt = diningTableMapper.selectByPrimaryKey(diningtableid);

	customOrder.setDiningTableName(dt.getSeatnumber());
	// 查询所有订单明细
	List<Customorderdetail> orderdetails = customorderMapper
		.findOrderdetailsByorderid(customOrder.getId());

	for (Customorderdetail orderdetail : orderdetails) {
	    dish dish = dishMapper.selectByPrimaryKey(orderdetail.getRdishid());
	    orderdetail.setDishName(dish.getName());
	}
	customOrder.setOrderdetailList(orderdetails);

	return customOrder;
    }

    /*
     * (非 Javadoc) <p>Title: changeorderdiningtable</p> <p>Description:
     * 修改订单对应的餐桌</p>
     * 
     * @param orderid
     * 
     * @param newdiningtableid
     * 
     * @throws Exception
     * 
     * @see rms.service.OrderService#changeorderdiningtable(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public void changeorderdiningtable(Integer orderid, Integer newdiningtableid)
	    throws Exception {
	order order = orderMapper.selectByPrimaryKey(orderid);
	// 修改餐桌状态
	diningTableService.updateStateById(order.getrDiningtableId(), true);

	diningTableService.updateStateById(newdiningtableid, false);
	order.setrDiningtableId(newdiningtableid);
	// 更新订单餐桌
	orderMapper.updateByPrimaryKeySelective(order);
	
    }

    /*
     * (非 Javadoc) <p>Title: checkoutByorderid</p> 
     * <p>Description:根据订单id结账 </p>
     * 
     * @param customorder
     * 
     * @param id
     * 
     * @throws Exception
     * 
     * @see rms.service.OrderService#checkoutByorderid(rms.po.CustomOrder,
     * java.lang.Integer)
     */
    @Override
    public void checkoutByorderid(CustomOrder customorder, Integer id)
	    throws Exception {
	customorder.setId(id);

	// 修改订单状态,并修改订单总价格
	orderMapper.updateByPrimaryKeySelective(customorder);
	// 修改餐桌状态
	diningTableService.updateStateById(customorder.getrDiningtableId(),
		true);
	// TODO 打印小票

    }
    
    /*
     * (非 Javadoc) 
    * <p>Title: MembercheckoutByorderid</p> 
    * <p>Description:会员结账</p> 
    * @param customorder
    * @param id
    * @param cardRecord
    * @throws Exception 
    * @see rms.service.OrderService#MembercheckoutByorderid(rms.po.CustomOrder, java.lang.Integer, rms.po.cardRecord)
     */
    @Override
    public void MembercheckoutByorderid(CustomOrder customorder, Integer id,
	    cardRecord cardRecord) throws Exception {
	//先处理会员卡
	card card=cardService.pay(cardRecord);
	//然后处理订单
	checkoutByorderid(customorder, id);
	
	if(card.getWechatOpenid()==null||card.getWechatOpenid().trim().equals("")) {
	    throw new CustomException("没有关联微信号，故未发送消费消息");
	}
	
	 //构建模板消息
	 Map<String,TemplateData> data=new HashMap<String, TemplateData>();
	 
	 data.put("price", new TemplateData(String.valueOf(cardRecord.getExpense()), "#173177"));
	 data.put("date", new TemplateData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "#173177"));
	 //构建模板实体
	 TemplateMessage message=new TemplateMessage();
	 message.setTemplate_id(wechatTemplateidKey.Instant_Consumption_Message.value);
	 message.setTouser(card.getWechatOpenid());
	 message.setData(data);
	 //发送模板消息
	 cardService.sendTemplateTocard(message);
    }

    /*
     * 根据原料列表数据，改变数据库中的原料
     */
    private void ChangeMaterials(List<Custommaterials> materialsList,
	    boolean isadd, Integer dishNumber) throws Exception {

	// =customdishMapper.findsubMaterialsBydishId(sub_dish.getId());
	for (Custommaterials materials : materialsList) {
	    Custommaterials dbmaterials = materialsService
		    .findMaterialsById(materials.getId());

	    BigDecimal nowQuantity = materials.getQuantity().multiply(
		    new BigDecimal(dishNumber));
	    
	    if (isadd) {
		nowQuantity = dbmaterials.getSurplus().add(nowQuantity);
	    } else {
		nowQuantity = dbmaterials.getSurplus().subtract(nowQuantity);
	    }
	    dbmaterials.setSurplus(nowQuantity);
	    int r = nowQuantity.compareTo(BigDecimal.ZERO); // 和0，Zero比较
	    if (r == -1) {// 小
		throw new Exception(materials.getName() + "库存不足");
	    } else {
		materialsService
			.updateMaterials(materials.getId(), dbmaterials);
	    }
	}
    }

}
