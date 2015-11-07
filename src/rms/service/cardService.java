package rms.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import rms.po.CustomUser;
import rms.po.card;
import rms.po.cardLevel;
import rms.po.cardRecord;
import rms.wechat.entity.TemplateMessage;


/**
 * 
* @ClassName: cardService 
* @Description: 会员卡操作接口
* @author 邹家兴 
* @date 2015年9月24日 上午12:03:20 
*
 */
public interface cardService {
    	/**
    	 * 
    	* @Title: getAll 
    	* @Description: 得到所有的会员卡
    	* @param @return
    	* @param @throws Exception    
    	* @return List<card>    
    	* @throws
    	 */
         public  List<card> getAll() throws Exception;
         
         /**
          * 
         * @Title: findcardByid 
         * @Description:根据id查询会员卡信息
         * @param @param id
         * @param @return
         * @param @throws Exception    
         * @return wechatTemplate    
         * @throws
          */
         public  card findcardByid(Integer id)  throws Exception;

         
         /**
          * 
         * @Title: findcardsByphoneNumber 
         * @Description: 根据电话号码查询卡片列表
         * @param @param phoneNumber
         * @param @return
         * @param @throws Exception    
         * @return List<card>    
         * @throws
          */
         public  List<card> findcardsByphoneNumber(String phoneNumber) throws Exception;
         
         /**
          * 
         * @Title: findAllRecordsBycardid 
         * @Description: 根据会员卡id查询会员卡一段时间消费记录 如果是主卡，则查询主卡，及其子卡，，如果是子卡，则只查询子卡记录
         * @param @param cardid
         * @param @param startTime
         * @param @param endTime
         * @param @return
         * @param @throws Exception    
         * @return List<cardRecord>    
         * @throws
          */
         public  List<cardRecord> findAllRecordsBycardid(String cardid,Date startTime,Date endTime) throws Exception;
        /**
         * 
        * @Title: savecard 
        * @Description: 保存会员卡信息
        * @param     card
        * @return void    
        * @throws
         */
         public  void savecard(card card) throws Exception;
         /**
          * 
         * @Title: updatecard 
         * @Description: 更新会员卡信息
         * @param @param card
         * @param @throws Exception    
         * @return void    
         * @throws
          */
         public  void updatecard(card card) throws Exception;
        /**
         * 
        * @Title: deletecardbyId 
        * @Description: 根据id删除会员卡信息
        * @param @param id
        * @param @throws Exception    
        * @return void    
        * @throws
         */
         public void deletecardbyId(Integer id) throws Exception;
         
         /**
          * 
         * @Title: Rechargecard 
         * @Description: 充值金额
         * @param @param id
         * @param @param RechargeMoney
         * @param @throws Exception    
         * @return void    
         * @throws
          */
         public void Rechargecard(Integer id,BigDecimal RechargeMoney) throws Exception;
         
         /**
          * 
         * @Title: FreezORactivationCard 
         * @Description: 冻结/激活指定卡号
         * @param @param id
         * @param @param isavailable 是否正常使用
         * @param @throws Exception    
         * @return void    
         * @throws
          */
         public void FreezORactivationCard(Integer id,boolean isavailable) throws Exception;
         
         /**
          * 
         * @Title: sendTemplateTocard 
         * @Description:  给指定卡号发送模板消息
         * @param @param message
         * @param @throws Exception    
         * @return void    
         * @throws
          */
	public void sendTemplateTocard(TemplateMessage message) throws Exception;
	/**
	 * 
	* @Title: findcardBywechatOpneid 
	* @Description: 根据用户微信openid查询会员卡基本信息
	* @param @param fromUserName
	* @param @return
	* @param @throws Exception    
	* @return card    
	* @throws
	 */
	public card findcardBywechatOpneid(String fromUserName) throws Exception;
	/**
	 * 
	* @Title: findcardBycardid 
	* @Description: 根据卡号查询会员卡
	* @param @param cardid
	* @param @return
	* @param @throws Exception    
	* @return card    
	* @throws
	 */
	public card findcardBycardid(String cardid) throws Exception;
	/**
	 * 
	* @Title: BindingMemberCard 
	* @Description: 绑定会员卡
	* @param @param card
	* @param @throws Exception    
	* @return void    
	* @throws
	 */
	public void BindingMemberCard(card card) throws Exception;
	/**
	 * @return 
	 * 
	* @Title: pay 
	* @Description: 完成支付相关的流程操作
	* @param @param cardRecord
	* @param @throws Exception    
	* @return card    
	* @throws
	 */
	public card pay(cardRecord cardRecord) throws Exception;
	/**
	 * 
	* @Title: getAllcardLevel 
	* @Description: 获取所有的会员卡等级
	* @param @return
	* @param @throws Exception    
	* @return List<cardLevel>    
	* @throws
	 */
	public List<cardLevel> getAllcardLevel() throws Exception;
	
	/**
	 * 
	* @Title: findcardLevelByid 
	* @Description: 根据id查询会员卡等级信息
	* @param @param id
	* @param @return
	* @param @throws Exception    
	* @return cardLevel    
	* @throws
	 */
        public  cardLevel findcardLevelByid(Integer id)  throws Exception;
	/**
	 * 
	* @Title: addcardLevel 
	* @Description: 添加新的会员等级 
	* @param @param level
	* @param @throws Exception    
	* @return void    
	* @throws
	 */
	public void addcardLevel(cardLevel level) throws Exception;
	/**
	 * 
	* @Title: editcardLevel 
	* @Description: 修改会员等级信息
	* @param @param id
	* @param @param level
	* @param @throws Exception    
	* @return void    
	* @throws
	 */
	public void editcardLevel(Integer id,cardLevel level) throws Exception;
	/**
	 * 
	* @Title: deletecardLevelByid 
	* @Description: 删除会员信息根据id
	* @param @param id
	* @param @throws Exception    
	* @return void    
	* @throws
	 */
	public void deletecardLevelByid(Integer id) throws Exception;
	/**
	 * 
	* @Title: findcardLevelBycardLevel 
	* @Description: 根据会员卡等级，查询等级信息 
	* @param @param level
	* @param @return
	* @param @throws Exception    
	* @return rms.po.cardLevel    
	* @throws
	 */
	public cardLevel findcardLevelBycardLevel(String level) throws Exception;
	/**
	 * 
	* @Title: ReapplyCard 
	* @Description: 给指定卡号发送验证码并 返回验证码
	* @param @param cardid
	* @param @param user
	* @param @throws Exception    
	* @return String    
	* @throws
	 */
	public String sendValidationCodeTocard(String cardid, CustomUser user) throws Exception;
	/**
	 * 
	* @Title: ReapplyCard 
	* @Description: 更换卡号
	* @param @param oldcardid
	* @param @param newcardid
	* @param @param user
	* @param @param SessionvalidationCode
	* @param @param PagevalidationCode
	* @param @throws Exception    
	* @return void    
	* @throws
	 */
	public void ReapplyCard(String oldcardid, String newcardid, CustomUser user,
		String SessionvalidationCode,String PagevalidationCode) throws Exception;
	/**
	 * 
	* @Title: ValidationCodecorrectOrwrong 
	* @Description: 验证验证码是否正确
	* @param @param user
	* @param @param sessionValidationCode
	* @param @param pageValidationCode
	* @param @throws Exception    
	* @return boolean    
	* @throws
	 */
	public boolean ValidationCodecorrectOrwrong(CustomUser user,String sessionValidationCode,String pageValidationCode) throws Exception;
}
