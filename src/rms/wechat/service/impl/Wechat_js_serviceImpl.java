package rms.wechat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import rms.mapper.cardMapper;
import rms.mapper.wechatuserMapper;
import rms.po.card;
import rms.po.cardExample;
import rms.po.wechatuser;
import rms.po.wechatuserExample;
import rms.service.cardService;
import rms.wechat.entity.Access_Token;
import rms.wechat.entity.Access_Token_Request;
import rms.wechat.entity.WechatCheck;
import rms.wechat.entity.jsapi_ticket;
import rms.wechat.service.Wechat_js_service;
import rms.wechat.service.wechatuserService;
import rms.wechat.untils.HttpUtils;
import rms.wechat.untils.PastUtil;
/**
 * 
* @ClassName: Wechat_js_serviceImpl 
* @Description: 处理微信页面相关的逻辑 
* @author 邹家兴 
* @date 2015年9月20日 下午8:11:28 
*
 */
@Component
public class Wechat_js_serviceImpl implements Wechat_js_service{
    
    @Resource
    private cardService cardService;
    @Resource
    private wechatuserMapper wecahtuMapper;
    @Resource
    private wechatuserService wechatuserService;
    
    
    /*
     * (非 Javadoc) 
    * <p>Title: BindingMember</p> 
    * <p>Description:绑定会员 </p> 
    * @param cardid
    * @param openid
    * @return  正常返回 0  没有这个卡号返回1 改卡号已被绑定返回2  未知错误，返回-1
    * @throws Exception 
    * @see rms.wechat.service.Wechat_js_service#BindingMember(java.lang.String, java.lang.String)
     */
    @Override
    public String BindingMember(String cardid, String openid) throws Exception{
	//查询是否有改卡号
	cardExample example=new cardExample();
	example.createCriteria().andCardidEqualTo(cardid);
	
	card card=cardService.findcardBycardid(cardid);
	
	if(card==null) {
	    return "1";
	}
	if(card.getWechatOpenid()!=null&&!card.getWechatOpenid().trim().equals("")) {
	    return "2";
	}
	
	card.setWechatOpenid(openid);
	
	cardService.BindingMemberCard(card);
	
	return "0";
    }

    /*
     * (非 Javadoc) 
    * <p>Title: getWechatCheckData</p> 
    * <p>Description: </p> 
    * @param code
    * @return
    * @throws Exception 
    * @see rms.wechat.service.Wechat_js_service#getWechatCheckData(java.lang.String)
     */
    public WechatCheck getWechatCheckData(String code,String url) throws Exception {
    	    wechatuserExample example=new wechatuserExample();
    	    example.createCriteria().andAppidIsNotNull();
	    wechatuser user=wecahtuMapper.selectByExample(example).get(0);
//	    RequestObject.setAppid("wxc353d4bcc5948754");
//	    RequestObject.setAppsecret("aad44094d4f388907216e8810e31c6d5");
	    
	    //获取access_token
	    String access_token=wechatuserService.getaccess_token(user);
	    //获取jsapi_ticket
	    String jsapi_ticket=wechatuserService.getjsapi_ticket(access_token,user);
	    //计算排序密钥，并返回认证对象
	    WechatCheck chenck=PastUtil.getSignature(jsapi_ticket,url);
	    chenck.setAppid(user.getAppid());
	    return chenck;
    }
   
}
