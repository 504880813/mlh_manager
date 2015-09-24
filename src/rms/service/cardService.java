package rms.service;

import java.math.BigDecimal;
import java.util.List;

import rms.po.card;
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
         * @Title: findAllRecordsBycardid 
         * @Description: 根据会员卡id查询会员卡相关 如果是主卡，则查询主卡，及其子卡，，如果是子卡，则只查询子卡记录
         * @param @param cardid
         * @param @return
         * @param @throws Exception    
         * @return List<cardRecord>    
         * @throws
          */
         public  List<cardRecord> findAllRecordsBycardid(String cardid) throws Exception;
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
}
