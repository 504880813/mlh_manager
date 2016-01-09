package rms.wechat.Processor;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import rms.po.card;
import rms.po.cardRecord;
import rms.po.wechatAdvertisementImage;
import rms.service.cardService;
import rms.wechat.entity.Access_Token_Request;
import rms.wechat.entity.WechatCheck;
import rms.wechat.entity.jsapi_ticket;
import rms.wechat.service.Wechat_js_service;
import rms.wechat.service.wechatAdvertisementImageService;
import rms.wechat.service.wechatuserService;
import rms.wechat.untils.HttpUtils;
import rms.wechat.untils.PastUtil;


/**
 * 
* @ClassName: Wechat_js_RequestAdapter 
* @Description: 用来分析关于微信页面的请求数据，并分发给响应方法
* @author 邹家兴 
* @date 2015年9月20日 下午7:46:09 
*
 */
@Component
public class Wechat_js_Processor {
    
    @Resource
    private Wechat_js_service Wechat_js_service;
    @Resource
    private wechatuserService wechatuserService;
    @Resource
    private wechatAdvertisementImageService wecahtAdvertisementImageService;
    @Resource
    private cardService cardService;
    /**
     * 
    * @Title: ToValidationMemberPage 
    * @Description: 处理跳转到绑定页面的请求
    * @param @param request
    * @param @param response    
    * @return void    
    * @throws
     */
    public void ToValidationMemberPage(HttpServletRequest request,
	    HttpServletResponse response) {
	 try {
	    //用于获取网页access_token 的密钥
	    String code=request.getParameter("code");
	    WechatCheck chenck=Wechat_js_service.getWechatCheckData(code,request.getRequestURL().toString()+"?"+request.getQueryString() );
	    String openid = wechatuserService.getWechatOpenid(code);
	    request.setAttribute("chenck", chenck);
	    request.setAttribute("openid", openid);
	    request.getRequestDispatcher("/WEB-INF/jsp/wechat/ValidationMemberPage.jsp").forward(request, response);
	    } catch (Exception e) {
		e.printStackTrace();
	     try {
		request.setAttribute("message", "未知错误，无法访问绑定页面");
		request.getRequestDispatcher("/WEB-INF/jsp/wechat/message.jsp").forward(request, response);
	     } catch(Exception e1) {
		e.printStackTrace();
	    }
	   }
    }
    
    /**
     * 
    * @Title: ToshowAdvertisingAndMoney 
    * @Description: 处理广告和余额显示页面跳转 
    * @param @param request
    * @param @param response    
    * @return void    
    * @throws
     */
    public void ToshowAdvertisingAndMoney(HttpServletRequest request,
	    HttpServletResponse response) {
	try {
	    //用于获取网页access_token 的密钥
	    String code=request.getParameter("code");
	    WechatCheck chenck=Wechat_js_service.getWechatCheckData(code,request.getRequestURL().toString()+"?"+request.getQueryString() );
	    String openid = wechatuserService.getWechatOpenid(code);
	    
	    String cardid=request.getParameter("cardid");
	    
	    List<cardRecord> cardRecords=cardService.findAllRecordsBycardid(cardid,null,new Date());
            card card=cardService.findcardBycardid(cardid);
            cardRecords=cardRecords.subList(cardRecords.size()-10, cardRecords.size());
            
            //获取广告图片
            List<wechatAdvertisementImage> wechatAdvertisementImages=wecahtAdvertisementImageService.getAllofusing();

            request.setAttribute("wechatAdvertisementImages", wechatAdvertisementImages);
            request.setAttribute("card",card);
            request.setAttribute("cardRecords", cardRecords);
	    request.setAttribute("chenck", chenck);
	    request.setAttribute("openid", openid);
	    
	    request.getRequestDispatcher("/WEB-INF/jsp/wechat/showAdvertisingAndMoney.jsp").forward(request, response);
	    } catch (Exception e) {
		e.printStackTrace();
	     try {
		request.setAttribute("message", "未知错误，无法访问绑定页面");
		request.getRequestDispatcher("/WEB-INF/jsp/wechat/message.jsp").forward(request, response);
	     } catch(Exception e1) {
		e.printStackTrace();
	    }
	   }
	
    }
    
    
    /**
     * 
    * @Title: BindingMember 
    * @Description: 绑定会员
    * @param @param request
    * @param @param response    
    * @return void    
    * @throws
     */
    public void BindingMember(HttpServletRequest request,
	    HttpServletResponse response) {
	try {
	    String openid=request.getParameter("openid");
	    String cardid=request.getParameter("cardid");
	    
	    String responseCode=Wechat_js_service.BindingMember(cardid, openid);

	    if("1".equals(responseCode)) {
		request.setAttribute("message", "没有这个卡号");
	    }else if("2".equals(responseCode)){
		request.setAttribute("message", "该卡号已被绑定");
	    }else {
		request.setAttribute("message", "绑定成功");
	    }
	    	request.getRequestDispatcher("/WEB-INF/jsp/wechat/message.jsp").forward(request, response);
	} catch (Exception e) {
	    try {
		if(e.getMessage()==null) {
		    e.printStackTrace();
		    request.setAttribute("message", "未知错误，绑定失败");
		}else {
		    request.setAttribute("message", e.getMessage());
		}
		request.getRequestDispatcher("/WEB-INF/jsp/wechat/message.jsp").forward(request, response);
	    } catch (Exception e1) {
		e1.printStackTrace();
	    }
	}
	
    }


/*    //单例
    private static Wechat_js_Processor pricessor;
    
    private Wechat_js_Processor(){};
    *//**
     * 
    * @Title: getInstance 
    * @Description: 获取唯一实例
    * @param @return    
    * @return Wechat_js_Processor    
    * @throws
     *//*
    public static Wechat_js_Processor getInstance() {
	if(pricessor==null) {
	    pricessor=new Wechat_js_Processor();
	}
	return pricessor;
    }*/
    
}
