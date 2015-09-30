package rms.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import rms.controller.exception.CustomException;
import rms.mapper.cardMapper;
import rms.mapper.cardRecordMapper;
import rms.po.card;
import rms.po.cardExample;
import rms.po.cardRecord;
import rms.po.cardRecordExample;
import rms.po.wechatTemplate;
import rms.service.cardService;
import rms.wechat.entity.TemplateMessage;
import rms.wechat.service.wechatTemplateService;
/**
 * 
* @ClassName: cardServiceImpl 
* @Description: 微信本地接口crud逻辑操作
* @author 邹家兴 
* @date 2015年9月23日 下午11:17:15 
*
 */
@Component
public class cardServiceImpl implements cardService {
    
    @Resource
    private cardMapper cardMapper;
    @Resource
    private cardRecordMapper cardRecordMapper;
    @Resource
    private wechatTemplateService wechatTemplateService;
    /*
     * (非 Javadoc) 
    * <p>Title: getAll</p> 
    * <p>Description:得到所有的会员卡信息</p> 
    * @return
    * @throws Exception 
    * @see rms.wechat.service.cardService#getAll()
     */
    @Override
    public List<card> getAll() throws Exception {
	cardExample example=new cardExample();
	example.createCriteria().andIdIsNotNull();
	return cardMapper.selectByExample(example);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: findcardByid</p> 
    * <p>Description:根据id查询会员卡信息</p> 
    * @param id
    * @return
    * @throws Exception 
    * @see rms.wechat.service.cardService#findcardByid(java.lang.Integer)
     */
    @Override
    public card findcardByid(Integer id) throws Exception {
	return cardMapper.selectByPrimaryKey(id);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: findAllRecordsBycardid</p> 
    * <p>Description:根据会员卡id查询会员卡相关 如果是主卡，则查询主卡，及其子卡，，如果是子卡，则只查询子卡记录 </p> 
    * @param cardid
    * @return
    * @throws Exception 
    * @see rms.service.cardService#findAllRecordsBycardid(java.lang.Integer)
     */
    @Override
    public List<cardRecord> findAllRecordsBycardid(String cardid) throws Exception {
	card card=findcardBycardid(cardid);
	if(card==null) {
	    return null;
	}
	List<cardRecord> cardRecords=null;
	//主卡
	if(card.getBelongsCardid()==null||card.getBelongsCardid().trim().equals("")) {
	    //查询附属子卡
	    cardExample example=new cardExample();
	    example.createCriteria().andBelongsCardidEqualTo(cardid);
	    List<card> belongscards=cardMapper.selectByExample(example);
	    List<String> cardids=new ArrayList<>();
	    cardids.add(cardid);
	    for(card c:belongscards) {
		cardids.add(c.getCardid());
	    }
	    cardRecordExample cardRecordExample=new cardRecordExample();
	    cardRecordExample.createCriteria().andCardIdIn(cardids);
	    cardRecords=cardRecordMapper.selectByExample(cardRecordExample);
	}else {
	    //副卡
	    cardRecordExample cardRecordExample=new cardRecordExample();
	    cardRecordExample.createCriteria().andCardIdEqualTo(cardid);
	    cardRecords=cardRecordMapper.selectByExample(cardRecordExample);
	}
	return cardRecords;
    }
    /*
     * (非 Javadoc) 
    * <p>Title: savecard</p> 
    * <p>Description:保存会员卡信息</p> 
    * @param card
    * @throws Exception 
    * @see rms.wechat.service.cardService#savecard(rms.po.card)
     */
    @Override
    public void savecard(card card) throws Exception {
	    boolean isexist=maincardisexist(card);
	    if(!isexist) {
		throw new CustomException("该主卡号不存在");
	    }
	    //判断数据库中是否存在在卡号
	    card dbc=findcardBycardid(card.getCardid());
	    if(dbc!=null) {
		throw new CustomException("卡号已存在");
	    }
	    cardMapper.insertSelective(card);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: updatecard</p> 
    * <p>Description:更新会员卡信息</p> 
    * @param card
    * @throws Exception 
    * @see rms.wechat.service.cardService#updatecard(rms.po.card)
     */
    @Override
    public void updatecard(card card) throws Exception {
	    boolean isexist=maincardisexist(card);
	    if(!isexist) {
		throw new CustomException("该主卡号不存在");
	    }

	    cardMapper.updateByPrimaryKey(card);
    }
    
    /*
     * (非 Javadoc) 
    * <p>Title: BindingMemberCard</p> 
    * <p>Description: 绑定会员卡</p> 
    * @param card
    * @throws Exception 
    * @see rms.service.cardService#BindingMemberCard(rms.po.card)
     */
    @Override
    public void BindingMemberCard(card card) throws Exception {
	    //一个微信号只能绑定一张卡
	    if(card.getWechatOpenid()!=null&&!card.getWechatOpenid().trim().equals("")) {
		   card c=findcardBywechatOpneid(card.getWechatOpenid());
		   	if(c!=null) {
			    throw new CustomException("一个微信号只能绑定一张卡");
			}
	    }
	    cardMapper.updateByPrimaryKey(card);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: deletecardbyId</p> 
    * <p>Description:根据id删除会员卡信息</p> 
    * @param id
    * @throws Exception 
    * @see rms.wechat.service.cardService#deletecardbyId(java.lang.Integer)
     */
    @Override
    public void deletecardbyId(Integer id) throws Exception {
	cardMapper.deleteByPrimaryKey(id);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: FreezORactivationCard</p> 
    * <p>Description:冻结或激活指定卡号</p> 
    * @param id
    * @param isavailable 是否正常使用
    * @throws Exception 
    * @see rms.service.cardService#FreezORactivationCard(java.lang.Integer, boolean)
     */
    @Override
    public void FreezORactivationCard(Integer id, boolean isavailable)
	    throws Exception {
	//从数据库中查出老card
	card c=findcardByid(id);
	//改变到想切换的状态
	c.setIsavailable(isavailable);
	//更新状态
	cardMapper.updateByPrimaryKey(c);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: Rechargecard</p> 
    * <p>Description:为会员卡充值</p> 
    * @param id
    * @param RechargeMoney
    * @throws Exception 
    * @see rms.service.cardService#Rechargecard(java.lang.Integer, java.math.BigDecimal)
     */
    @Override
    public void Rechargecard(Integer id, BigDecimal RechargeMoney)
	    throws Exception {
	//先查询数据库的金额
	card c=findcardByid(id);
	BigDecimal dbmoney=c.getMoney();
	dbmoney=dbmoney.add(RechargeMoney);
	c.setMoney(dbmoney);
	//更新数据
	cardMapper.updateByPrimaryKey(c);
    }
    
    /*
     * (非 Javadoc) 
    * <p>Title: sendTemplateTocard</p> 
    * <p>Description:给指定卡号发送模板消息</p> 
    * @param message
    * @throws Exception 
    * @see rms.service.cardService#sendTemplateTocard(java.lang.String, java.lang.String, rms.wechat.entity.TemplateMessage)
     */
    @Override
    public void sendTemplateTocard(TemplateMessage message) throws Exception {
	
	//查询模板具体信息
	wechatTemplate template=wechatTemplateService.findWechatTemplateBytemplateid(message.getTemplate_id());
	message.setTopcolor(template.getTopcolor());
	message.setUrl(template.getUrl());
	
	wechatTemplateService.sendTemplateMessageTouser(message);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: findcardBywechatOpneid</p> 
    * <p>Description: 根据微信openid查询用户基本信息</p> 
    * @param fromUserName
    * @return
    * @throws Exception 
    * @see rms.service.cardService#findcardBywechatOpneid(java.lang.String)
     */
    @Override
    public card findcardBywechatOpneid(String fromUserName) throws Exception {
	cardExample example=new cardExample();
	example.createCriteria().andWechatOpenidEqualTo(fromUserName);
	List<card> cards=cardMapper.selectByExample(example);
	return cards==null||cards.size()==0?null:cards.get(0);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: findcardBycardid</p> 
    * <p>Description: 根据卡号查询会员卡</p> 
    * @param cardid
    * @return
    * @throws Exception 
    * @see rms.service.cardService#findcardBycardid(java.lang.String)
     */
    @Override
    public card findcardBycardid(String cardid) throws Exception {
	
	cardExample example=new cardExample();
	example.createCriteria().andCardidEqualTo(cardid);
	List<card> cards=cardMapper.selectByExample(example);
	if(cards==null||cards.size()==0) {
	    return null;
	}
	return cards.get(0);
    }
    /**
     * 
    * @Title: maincardisexist 
    * @Description: 根据传入的卡片判断是主卡还是副卡，如果是副卡，查看主卡号是否存在
    * @param @param c
    * @param @return
    * @param @throws Exception    
    * @return boolean    
    * @throws
     */
    private boolean maincardisexist(card c) throws Exception{
	if(c==null) { return false; }
	if(c.getBelongsCardid()==null) { return true; }
	card mainc=findcardBycardid(c.getBelongsCardid());
	return mainc==null?false:true;
    }
    /*
     * (非 Javadoc) 
    * <p>Title: pay</p> 
    * <p>Description: 支付相关操作</p> 
    * @param cardRecord
    * @throws Exception 
    * @see rms.service.cardService#pay(rms.po.cardRecord)
     */
    @Override
    public void pay(cardRecord cardRecord) throws Exception {
	//判断当前计算的卡的类型
	boolean ismain=true;
	
	//先查询数据库中卡信息
	card TheCard=findcardBycardid(cardRecord.getCardId());
	if(TheCard==null) {
	    throw new CustomException("该会员卡已过期");
	}
	//得到主卡
	card card=null;
	if(TheCard.getBelongsCardid()==null||TheCard.getBelongsCardid().equals("")) {
	    card=TheCard;
	}else {
	    //副卡
	    card=findcardBycardid(TheCard.getBelongsCardid());
	    ismain=false;
	}
	//-1 小于
	//0 等于
	//1 大于
	int resultCode=cardRecord.getExpense().compareTo(card.getMoney());
	if(ismain) {
	    BigDecimal nowMoney=null;
	    if((resultCode==-1||resultCode==0)) {
	    	//计算现在的余额
		nowMoney=card.getMoney().subtract(cardRecord.getExpense());
	    }else {
		nowMoney=BigDecimal.valueOf(0);  
	    }
	    card.setMoney(nowMoney);
	}
	if(card.getIsavailable()) {
	 //计算现在的月积分
	 Integer nowMonthIntegral=card.getMonthIntegral()+cardRecord.getExpense().intValue();
	 //计算现在的总积分
	 Integer nowAllIntegral=card.getAllIntegral()+cardRecord.getExpense().intValue();
	 card.setMonthIntegral(nowMonthIntegral);
	 card.setAllIntegral(nowAllIntegral);
	 }
	 //更新会员卡数据
	 cardMapper.updateByPrimaryKey(card);
	 
	 //插入消费记录
	 cardRecordMapper.insertSelective(cardRecord);
    }

}
