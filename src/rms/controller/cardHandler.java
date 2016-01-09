package rms.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import rms.controller.exception.CustomException;
import rms.po.CustomUser;
import rms.po.card;
import rms.po.cardLevel;
import rms.po.cardRecord;
import rms.po.wechatTemplate;
import rms.service.cardService;
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
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("addcard")
    public ModelAndView addcard() throws Exception{
	List<cardLevel> levels=cardService.getAllcardLevel();
	ModelAndView mav=new ModelAndView();
	mav.addObject("levels", levels);
	mav.setViewName("cardManager/saveoreditcard");
	return mav;
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
	List<cardLevel> levels=cardService.getAllcardLevel();
	ModelAndView mav=new ModelAndView();
	mav.addObject("card", card);
	mav.addObject("levels", levels);
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
    * @Title: selectRecordsPage 
    * @Description: 跳转到查询消费记录页面
    * @param @return
    * @param @throws Exception    
    * @return String   
    * @throws
     */
    @RequestMapping("selectRecordsPage")
    public String selectRecordsPage() throws Exception{
	return "cardManager/cardRecordList";
    }
    
    
    
    /**
     * 
    * @Title: selectAllRecordsBycardidofjson 
    * @Description: 查询消费接口并显示
    * @param @param cardid
    * @param @param startTime
    * @param @param endTime
    * @param @return null表示卡号不存在
    * @param @throws Exception    
    * @return List<cardRecord>    
    * @throws
     */
    @RequestMapping("selectAllRecordsBycardidofjson")
    public @ResponseBody List<cardRecord> selectAllRecordsBycardidofjson(String cardid,Date startTime,Date endTime) throws Exception{
	
	List<cardRecord> cardRecords=cardService.findAllRecordsBycardid(cardid,startTime,endTime);
	
/*	if(cardRecords==null) {
	    throw new CustomException("该卡号不存在");
	}*/
	return cardRecords;
    }
    
    
    /**
     * 
    * @Title: getMemberCardId 
    * @Description: 跳转到获取会员卡号页面
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("getMemberCardId")
    public String getMemberCardId() throws Exception{
	return "cardManager/getMembercardId";
    }
    
    
    /**
     * 
    * @Title: PayPage 
    * @Description: 跳转到缴费界面 
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("PayPage")
    public ModelAndView PayPage(String cardid) throws Exception{
	//查询数据库中记录
	card card=cardService.findcardBycardid(cardid);
	if(card==null) {
	    throw new CustomException("该会员卡已失效");
	}
	cardLevel cardLevel=cardService.findcardLevelBycardLevel(card.getLevel());
	ModelAndView mav=new ModelAndView();
	mav.addObject("card", card);
	mav.addObject("cardLevel", cardLevel);
	mav.setViewName("cardManager/paypage");
	return mav;
    }
    /**
     * 
    * @Title: PayPageSubMit 
    * @Description: 处理缴费页面提交请求
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("PayPageSubMit")
    public ModelAndView PayPageSubMit(cardRecord cardRecord) throws Exception{
	
	cardRecord.setTime(new Date());
	
	cardService.pay(cardRecord);
	
	ModelAndView mav=new ModelAndView();
	mav.addObject("message","计费成功");
	mav.setViewName("message");
	return mav;
    }
    /**
     * 
    * @Title: ReapplyCard 
    * @Description: 更换卡号页面
    * @param @param cardid
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("ReapplyCard")
    public ModelAndView ReapplyCard(String cardid,HttpServletRequest request) throws Exception{
	CustomUser user =(CustomUser) request.getSession().getAttribute("OnlineUser");
	
	String ValidationCode=cardService.sendValidationCodeTocard(cardid, user);

	request.getSession().setAttribute("ValidationCode", ValidationCode);
	
	ModelAndView mav=new ModelAndView();
	mav.addObject("oldcardid", cardid);
	mav.setViewName("cardManager/ReapplyCard");
	return mav;
    }
    
    /**
     * 
    * @Title: ReapplyCardSubMit
    * @Description: 更换卡号
    * @param @param oldcardid
    * @param @param newcardid
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("ReapplyCardSubMit")
    public ModelAndView ReapplyCardSubMit(String oldcardid,String newcardid,HttpServletRequest request,String PagevalidationCode) throws Exception{
	CustomUser user =(CustomUser) request.getSession().getAttribute("OnlineUser");
	String  ValidationCode=(String) request.getSession().getAttribute("ValidationCode");
	cardService.ReapplyCard(oldcardid,newcardid, user,ValidationCode,PagevalidationCode);
	
	ModelAndView mav=new ModelAndView();
	mav.setViewName("redirect:getAllcard.action");
	return mav;
    }
    
    /**
     * card_Level 相关请求
     */
    /**
     * 
    * @Title: getAllcardLevel 
    * @Description: 得到所有的会员卡等级信息
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("getAllcardLevel")
    public ModelAndView getAllcardLevel() throws Exception{
	List<cardLevel> cardLevels=cardService.getAllcardLevel();
	ModelAndView mav=new ModelAndView();
	mav.addObject("cardLevels", cardLevels);
	mav.setViewName("cardManager/cardLevelList");
	return mav;
    } 
    /**
     * 
    * @Title: addcardLevel 
    * @Description: 为添加会员卡等级信息准备数据
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("addcardLevel")
    public String addcardLevel() throws Exception{
	return "cardManager/saveoreditcardLevel";
    }
    /**
     * 
    * @Title: editcardLevel 
    * @Description:为修改会员卡等级信息准备数据 
    * @param @param id
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("editcardLevel")
    public ModelAndView editcardLevel(Integer id) throws Exception{
	cardLevel cardLevel=cardService.findcardLevelByid(id);
	ModelAndView mav=new ModelAndView();
	mav.addObject("cardLevel", cardLevel);
	mav.setViewName("cardManager/saveoreditcardLevel");
	return mav;
    }
    /**
     * 
    * @Title: addcardLevelSubmit 
    * @Description: 添加会员卡等级信息 
    * @param @param cardLevel
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("addcardLevelSubmit")
    public String addcardLevelSubmit(cardLevel cardLevel) throws Exception{
	cardService.addcardLevel(cardLevel);
	return "redirect:getAllcardLevel.action";
    }
    /**
     * 
    * @Title: editcardLevelSubmit 
    * @Description: 修改会员卡等级信息
    * @param @param id
    * @param @param cardLevel
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("editcardLevelSubmit")
    public String editcardLevelSubmit(Integer id,cardLevel cardLevel) throws Exception{
	cardService.editcardLevel(id, cardLevel);
	return "redirect:getAllcardLevel.action";
    }
    /**
     * 
    * @Title: deletecardLevel 
    * @Description:根据id删除会员卡等级信息
    * @param @param id
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("deletecardLevel")
    public String deletecardLevel(Integer id) throws Exception{
	cardService.deletecardLevelByid(id);
	return "redirect:getAllcardLevel.action";
    }
    
    /**
     * ajax
     */
    /**
     * 
    * @Title: sendVerificationCodeofajax 
    * @Description: 向用户发送验证码 
    * @param @param cardid
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
 /*   @RequestMapping("sendVerificationCodeofajax")
    public @ResponseBody String sendVerificationCodeofajax(HttpServletRequest request,String cardid) throws Exception{
	CustomUser user =(CustomUser) request.getSession().getAttribute("OnlineUser");
	String ValidationCode=cardService.sendValidationCodeTocard(cardid, user);
	request.getSession().setAttribute("ValidationCode", ValidationCode);
	return cardid;
    }*/
    /**
     * 
    * @Title: sendVerificationCodeofajax 
    * @Description: 向用户发送验证码 
    * @param @param cardid
    * @param @return
    * @param @throws Exception    
    * @return void    
    * @throws
     */
    @RequestMapping("sendVerificationCodeofajax")
    public void sendVerificationCodeofajax(HttpServletRequest request,HttpServletResponse response,String cardid) throws Exception{
	CustomUser user =(CustomUser) request.getSession().getAttribute("OnlineUser");
	String ValidationCode=cardService.sendValidationCodeTocard(cardid, user);

	request.getSession().setAttribute("ValidationCode", ValidationCode);
	
	response.setCharacterEncoding("utf-8");
	
//	response.setContentType("application/json;charset=utf-8");
	
	response.setContentType("text/html;charset=utf-8");
	
	response.getWriter().write(cardid);

	
//	response.getWriter().write(cardid);
	
//	return cardid;
    }
    
    
}
