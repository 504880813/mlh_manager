package rms.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rms.po.card;
import rms.po.cardRecord;
import rms.po.wechatTemplate;
import rms.service.cardService;
import rms.wechat.entity.TemplateData;
import rms.wechat.entity.TemplateMessage;
import rms.wechat.service.wechatTemplateService;
/**
 * 
* @ClassName: cardHandler 
* @Description: 处理会员卡相关页面请求
* @author 邹家兴 
* @date 2015年9月24日 上午12:01:01 
*
 */
@Controller
@RequestMapping("card")
public class cardHandler {
    
    @Resource
    private cardService cardService;
    @Resource
    private wechatTemplateService wechatTemplateService;
    
    /**
     * 
    * @Title: getAllcard 
    * @Description: 得到所有的会员卡信息
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("getAllcard")
    public ModelAndView getAllcard() throws Exception{
	List<card> cards=cardService.getAll();
	ModelAndView mav=new ModelAndView();
	mav.addObject("cards", cards);
	mav.setViewName("cardManager/cardList");
	
	return mav;
    }
    /**
     * 
    * @Title: addcard 
    * @Description: 为添加会员卡准备数据
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("addcard")
    public String addcard() throws Exception{
	return "cardManager/saveoreditcard";
    }
    /**
     * 
    * @Title: editcard 
    * @Description: 根据id为修改会员卡信息准备数据
    * @param @param id
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("editcard")
    public ModelAndView editcard(Integer id) throws Exception{
	card card=cardService.findcardByid(id);
	ModelAndView mav=new ModelAndView();
	mav.addObject("card", card);
	mav.setViewName("cardManager/saveoreditcard");
	return mav;
    }
    /**
     * 
    * @Title: addcardSubmit 
    * @Description: 添加会员卡
    * @param @param card
    * @param @return    
    * @return String    
    * @throws
     */
    @RequestMapping("addcardSubmit")
    public String addcardSubmit(card card) throws Exception{
	cardService.savecard(card);
	return "redirect:getAllcard.action";
    }
    /**
     * 
    * @Title: editcardSubmit 
    * @Description: 修改会员卡
    * @param @param user
    * @param @return    
    * @return String    
    * @throws
     */
    @RequestMapping("editcardSubmit")
    public String editcardSubmit(card card) throws Exception{
	cardService.updatecard(card);
	return "redirect:getAllcard.action";
    }
    /**
     * 
    * @Title: deletecard 
    * @Description: 根据id删除会员卡
    * @param @param id
    * @param @return    
    * @return String    
    * @throws
     */
    @RequestMapping("deletecard")
    public String deletecard(Integer id) throws Exception{
	cardService.deletecardbyId(id);
	return "redirect:getAllcard.action";
    }
    
    /**
     * 
    * @Title: getAllTemplate 
    * @Description: 得到所有的模板数据去发送
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("getAllTemplateTosend")
    public ModelAndView getAllTemplateTosend(String useropenid) throws Exception{
	List<wechatTemplate> wechatTemplates=wechatTemplateService.getAll();
	ModelAndView mav=new ModelAndView();
	mav.addObject("openid", useropenid);
	mav.addObject("wechatTemplates", wechatTemplates);
	mav.setViewName("cardManager/wechatTemplateListTosend");
	return mav;
    }
    /**
     * 
    * @Title: sendTemplageMessage 
    * @Description: 为发送模板消息准备数据
    * @param @param openid
    * @param @param templateId
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("sendTemplageMessage")
    public ModelAndView sendTemplageMessage(String openid,String templateId) throws Exception{
	ModelAndView mav=new ModelAndView();
	mav.addObject("touser", openid);
	mav.addObject("template_id", templateId);
	mav.setViewName("cardManager/sendExample");
	return mav;
    }
    /**
     * 
    * @Title: changecardstatus 
    * @Description: 改变会员卡状态
    * @param @param id
    * @param @param isavailable
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("changecardstatus")
    public String changecardstatus(Integer id,boolean isavailable) throws Exception {
	//改变会员卡状态
	cardService.FreezORactivationCard(id, !isavailable);
	
	return "redirect:getAllcard.action";
    }
    /**
     * 
    * @Title: Rechargecard 
    * @Description:  为充值会员卡准备数据
    * @param @param id
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("Rechargecard")
    public ModelAndView Rechargecard(Integer id) throws Exception{
	card c=cardService.findcardByid(id);
	ModelAndView mav=new ModelAndView();
	mav.addObject("card", c);
	mav.setViewName("cardManager/Rechargecard");
	return mav;
    }
    /**
     * 
    * @Title: RechargecardSubMit 
    * @Description: 充值会员卡
    * @param @param id
    * @param @param RechargeMoney
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("RechargecardSubMit")
    public String RechargecardSubMit(Integer id,BigDecimal RechargeMoney) throws Exception{
	cardService.Rechargecard(id, RechargeMoney);
	return "redirect:getAllcard.action";
    }
    
    
    /**
     * 
    * @Title: sendTemplageMessageSubMit 
    * @Description: 发送模板消息 
    * @param @param openid
    * @param @param templateId
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("sendTemplageMessageSubMit")
    public ModelAndView sendTemplageMessageSubMit(TemplateMessage message) throws Exception{
	cardService.sendTemplateTocard(message);
	ModelAndView mav=new ModelAndView();
	mav.addObject("message","发送成功");
	mav.setViewName("message");
	return mav;
    }
    /**
     * 
    * @Title: selectRecordsBycardid 
    * @Description: 查询消费接口并显示
    * @param @param cardid
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("selectAllRecordsBycardid")
    public ModelAndView selectAllRecordsBycardid(String cardid) throws Exception{
	
	List<cardRecord> cardRecords=cardService.findAllRecordsBycardid(cardid);
	
	ModelAndView mav=new ModelAndView();
	mav.addObject("cardRecords", cardRecords);
	mav.setViewName("cardManager/cardRecordList");
	return mav;
    }
    
    
    
}
