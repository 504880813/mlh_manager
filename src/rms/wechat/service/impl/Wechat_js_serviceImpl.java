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
import rms.wechat.entity.Access_Token;
import rms.wechat.entity.Access_Token_Request;
import rms.wechat.entity.WechatCheck;
import rms.wechat.entity.jsapi_ticket;
import rms.wechat.service.Wechat_js_service;
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
    private cardMapper cardMapper;
    @Resource
    private wechatuserMapper wecahtuMapper;
    
    
    /*
     * (非 Javadoc) 
    * <p>Title: BindingMember</p> 
    * <p>Description:绑定会员 </p> 
    * @param cardid
    * @param openid
    * @return  正常返回 0  没有这个卡号返回1 未知错误，返回-1
    * @throws Exception 
    * @see rms.wechat.service.Wechat_js_service#BindingMember(java.lang.String, java.lang.String)
     */
    @Override
    public String BindingMember(String cardid, String openid) throws Exception{
	//查询是否有改卡号
	cardExample example=new cardExample();
	example.createCriteria().andCardidEqualTo(cardid);
	
	List<card> cards=cardMapper.selectByExample(example);
	
	if(cards==null || cards.size()==0) {
	    return "1";
	}
	card c=cards.get(0);
	c.setWechatOpenid(openid);
	
	cardMapper.updateByPrimaryKey(c);
	
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
	    String access_token=getaccess_token(user);
	    //获取jsapi_ticket
	    String jsapi_ticket=getjsapi_ticket(access_token,user);
	    //计算排序密钥，并返回认证对象
	    WechatCheck chenck=PastUtil.getSignature(jsapi_ticket,url);
	    chenck.setAppid(user.getAppid());
	    return chenck;
    }
    /**
     * 
    * @Title: getjsapi_ticket 
    * @Description: 获取jsp_ticket
    * @param @param access_token
    * @param @param user
    * @param @return    
    * @return String    
    * @throws
     */
    private String getjsapi_ticket(String access_token, wechatuser user) {
	  //判断jsapi_ticket是否超时
	    String jsapi_ticket=user.getJsapiTicket();
	    String jsapi_ticket_time_Str=user.getJsapiTicketExpiresTime();
	    long jsapi_ticket_time;
	    //预留三秒的耗时
	    long current_time = System.currentTimeMillis()-3000;
	    //获取到jsapi_ticket 
	    if(jsapi_ticket!=null && jsapi_ticket_time_Str!=null) {
		jsapi_ticket_time=Long.parseLong(jsapi_ticket_time_Str);
		long jsapi_ticket_last_time=Long.parseLong(user.getJsapiTicketExpiresLastTime());
		//判断是否超时
		if((current_time - jsapi_ticket_last_time) / 1000 >= Long.parseLong(user.getJsapiTicketExpiresTime())) {
		    //超时就重新获取jsapi_ticket 并存入数据库
		    return getserverjsapi_ticket(access_token,user);
		}else {
		    return jsapi_ticket;
		}
		
	    }else {
		//获取jsapi_ticket 并存入数据库
		 return getserverjsapi_ticket(access_token,user);
	    }
    }
   

    /**
     * 
    * @Title: getaccess_token 
    * @Description: 获取access_token
    * @param @param user
    * @param @return    
    * @return String    
    * @throws
     */
    private String getaccess_token(wechatuser user) {
	   //判断access_token是否超时
	    String access_token=user.getAccessToken();
	    String access_token_time_Str=user.getAccessTokenExpiresTime();
	    long access_token_time;
	    //预留三秒的耗时
	    long current_time = System.currentTimeMillis()-3000;
	    //获取到access_token
	    if(access_token!=null && access_token_time_Str!=null) {
		access_token_time=Long.parseLong(access_token_time_Str);
		long access_token_last_time=Long.parseLong(user.getAccessTokenExpiresLastTime());
		//判断是否超时
		if((current_time - access_token_last_time) / 1000 >= access_token_time) {
		    //超时就重新获取access_token 并存入数据库
		   return getserverAccess_token(user);
		}else {
		    return user.getAccessToken();
		}
	    //获取access_token 并存入数据库	
	    }else {
		return getserverAccess_token(user);
	    }
    }
    /**
     * 
    * @Title: getserverjsapi_ticket 
    * @Description: 从服务器获取jsapi_ticket 
    * @param @param access_token
    * @param @return    
    * @return String    
    * @throws
     */
    private String getserverjsapi_ticket(String access_token,wechatuser user) {
	try {
	    jsapi_ticket ticket=HttpUtils.getJsApiTicket(access_token);
	    //将新的jsapi_ticket存入数据库
	    user.setJsapiTicket(ticket.getTicket());
	    user.setJsapiTicketExpiresTime(ticket.getExpires_in());
	    user.setJsapiTicketExpiresLastTime(String.valueOf(System.currentTimeMillis()));
	    
	    wecahtuMapper.updateByPrimaryKey(user);
	    return ticket.getTicket();
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }
    /**
     * 
    * @Title: getserverAccess_token 
    * @Description: 从服务器获取新的access_token 并存入数据库
    * @param @param user
    * @param @return    
    * @return String    
    * @throws
     */
    private String getserverAccess_token(wechatuser user) {
	   Access_Token_Request RequestObject=new Access_Token_Request();
	    RequestObject.setAppid(user.getAppid());
	    RequestObject.setAppsecret(user.getAppsecret());
	    //获取新的access_token
	    try {
		 Access_Token server_access_token=HttpUtils.GETACCESS_TKOKEN(RequestObject);
		 user.setAccessToken(server_access_token.getAccess_token());
		 user.setAccessTokenExpiresTime(server_access_token.getExpires_in());
		 user.setAccessTokenExpiresLastTime(String.valueOf(System.currentTimeMillis()));
		 //将新的access_token存入数据库
		 wecahtuMapper.updateByPrimaryKey(user);
		 return server_access_token.getAccess_token();
	    } catch (Exception e) {
		e.printStackTrace();
		return null;
	    }
	
    }

}
