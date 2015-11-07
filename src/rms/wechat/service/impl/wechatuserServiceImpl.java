package rms.wechat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import rms.controller.exception.CustomException;
import rms.mapper.wechatuserMapper;
import rms.po.wechatInterface;
import rms.po.wechatuser;
import rms.po.wechatuserExample;
import rms.wechat.Enumeration.wechatInterfaceEnumeration;
import rms.wechat.entity.Access_Token;
import rms.wechat.entity.Access_Token_Request;
import rms.wechat.entity.jsapi_ticket;
import rms.wechat.service.wechatInterfaceService;
import rms.wechat.service.wechatuserService;
import rms.wechat.untils.HttpUtils;
/**
 * 
* @ClassName: wechatuserServiceImpl 
* @Description: 微信公众号存储相关逻辑处理
* @author 邹家兴 
* @date 2015年9月23日 上午12:45:12 
*
 */
@Component
public class wechatuserServiceImpl implements wechatuserService {
    
    @Resource
    private wechatuserMapper wechatuserMapper;
    @Resource
    private wechatInterfaceService wecahtInterfaceService;
    
    
    
    
    /*
     * (非 Javadoc) 
    * <p>Title: getAll</p> 
    * <p>Description:得到所有的公众号信息 </p> 
    * @return
    * @throws Exception 
    * @see rms.wechat.service.wechatuserService#getAll()
     */
    @Override
    public List<wechatuser> getAll() throws Exception {
	wechatuserExample example=new wechatuserExample();
	
	example.createCriteria().andAppidIsNotNull();
	
	return wechatuserMapper.selectByExample(example);
    }

    /*
     * (非 Javadoc) 
    * <p>Title: findWechatUserByid</p> 
    * <p>Description:根据id查询公众号信息 </p> 
    * @param id
    * @return
    * @throws Exception 
    * @see rms.wechat.service.wechatuserService#findWechatUserByid(java.lang.String)
     */
    @Override
    public wechatuser findWechatUserByid(Integer id) throws Exception {
	return wechatuserMapper.selectByPrimaryKey(id);
    }
  
    /*
     * (非 Javadoc) 
    * <p>Title: savewechatuser</p> 
    * <p>Description: 保存微信公众号 </p> 
    * @param user
    * @throws Exception 
    * @see rms.wechat.service.wechatuserService#savewechatuser(rms.po.wechatuser)
     */
    @Override
    public void savewechatuser(wechatuser user) throws Exception {
	 //查看数据库中是否有记录
	List<wechatuser> wechatusers=getAll();
	//数据库中有记录，则不能插入
	if(wechatusers==null||wechatusers.size()==0) {
	    wechatuserMapper.insertSelective(user);
	}else {
	    throw new CustomException("有且只能有一个公众号");
	}
    }
    /*
     * (非 Javadoc) 
    * <p>Title: updatewechatuser</p> 
    * <p>Description:更新公众号数据</p> 
    * @param user
    * @throws Exception 
    * @see rms.wechat.service.wechatuserService#updatewechatuser(rms.po.wechatuser)
     */
    @Override
    public void updatewechatuser(wechatuser user) throws Exception {
	wechatuserMapper.updateByPrimaryKey(user);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: deletewechatuserbyId</p> 
    * <p>Description:根据id删除微信公众号 </p> 
    * @param id
    * @throws Exception 
    * @see rms.wechat.service.wechatuserService#deletewechatuserbyId(java.lang.String)
     */
    @Override
    public void deletewechatuserbyId(Integer id) throws Exception {
	wechatuserMapper.deleteByPrimaryKey(id);
    }
    
    
    
    /*
     * (非 Javadoc) 
    * <p>Title: getWechatOpenid</p> 
    * <p>Description: 获取用户的openid</p> 
    * @param code
    * @return
    * @throws Exception 
    * @see rms.wechat.service.Wechat_js_service#getWechatOpenid(java.lang.String)
     */
    @Override
    public String getWechatOpenid(String code) throws Exception {
	    wechatuserExample example=new wechatuserExample();
   	    example.createCriteria().andAppidIsNotNull();
	    wechatuser user=wechatuserMapper.selectByExample(example).get(0);
	    if(user!=null) {
		//查询pageaccess_token调用url
		wechatInterface wechatinerface=wecahtInterfaceService.findWechatInterfaceByName(wechatInterfaceEnumeration.getPageACCESS_TOKEN.value);
		return HttpUtils.getPageACCESS_TOKEN(code, user.getAppid(), user.getAppsecret(),wechatinerface.getUrl());
	    }
	    return null;
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
    public String getjsapi_ticket(String access_token, wechatuser user) {
	  //判断jsapi_ticket是否超时
	    String jsapi_ticket=user.getJsapiTicket();
	    String jsapi_ticket_time_Str=user.getJsapiTicketExpiresTime();
	    long jsapi_ticket_time;
	    //预留三秒的耗时
	    long current_time = System.currentTimeMillis()-3000;
	    //获取到jsapi_ticket 
	    if(jsapi_ticket!=null && jsapi_ticket_time_Str!=null && !jsapi_ticket.trim().equals("") && !jsapi_ticket_time_Str.trim().equals("")) {
		jsapi_ticket_time=Long.parseLong(jsapi_ticket_time_Str);
		long jsapi_ticket_last_time=Long.parseLong(user.getJsapiTicketExpiresLastTime());
		//判断是否超时
		if((current_time - jsapi_ticket_last_time) / 1000 >= Long.parseLong(user.getJsapiTicketExpiresTime())) {
		    //超时就重新获取jsapi_ticket 并存入数据库
		    return getserverjsapi_ticket(access_token,user);
		}else {
		    //
		    
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
    public String getaccess_token(wechatuser user) {
	   //判断access_token是否超时
	    String access_token=user.getAccessToken();
	    String access_token_time_Str=user.getAccessTokenExpiresTime();
	    long access_token_time;
	    //预留三秒的耗时
	    long current_time = System.currentTimeMillis()-3000;
	    //获取到access_token
	    if(access_token!=null && access_token_time_Str!=null && !access_token.trim().equals("") && !access_token_time_Str.trim().equals("")) {
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
	    //查询调用接口url
	    wechatInterface wechatinerface=wecahtInterfaceService.findWechatInterfaceByName(wechatInterfaceEnumeration.getjsapiticket.value);
	    jsapi_ticket ticket=HttpUtils.getJsApiTicket(access_token,wechatinerface.getUrl());
	    //将新的jsapi_ticket存入数据库
	    user.setJsapiTicket(ticket.getTicket());
	    user.setJsapiTicketExpiresTime(ticket.getExpires_in());
	    user.setJsapiTicketExpiresLastTime(String.valueOf(System.currentTimeMillis()));
	    
	    wechatuserMapper.updateByPrimaryKey(user);
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
		 //查询调用接口url
		 wechatInterface wechatinerface=wecahtInterfaceService.findWechatInterfaceByName(wechatInterfaceEnumeration.getACCESS_TKOKEN.value);
		 Access_Token server_access_token=HttpUtils.GETACCESS_TKOKEN(RequestObject,wechatinerface.getUrl());
		 user.setAccessToken(server_access_token.getAccess_token());
		 user.setAccessTokenExpiresTime(server_access_token.getExpires_in());
		 user.setAccessTokenExpiresLastTime(String.valueOf(System.currentTimeMillis()));
		 //将新的access_token存入数据库
		 wechatuserMapper.updateByPrimaryKey(user);
		 return server_access_token.getAccess_token();
	    } catch (Exception e) {
		e.printStackTrace();
		return null;
	    }
	
    }

}
