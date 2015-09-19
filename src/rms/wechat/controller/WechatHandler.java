package rms.wechat.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

import rms.wechat.untils.CheckUtils;
import rms.wechat.untils.XmlUtils;

/**
 * 
* @ClassName: WechatHandler 
* @Description: 处理微信认证相关的信息，以及一些被动基础信息
* @author 邹家兴 
* @date 2015年9月16日 下午5:08:46 
*
 */
@Controller
@RequestMapping("wechat")
public class WechatHandler {
    
    private static final String token = "sbs";
    
    @RequestMapping(value="MessageReceiver",method=RequestMethod.GET)
    public void MessageReceiver_GET(String signature,String timestamp,String nonce,String echostr,PrintWriter out) throws Exception{
	List eqList = new ArrayList<>();
	eqList.add(token);
	eqList.add(timestamp);
	eqList.add(nonce);
	ModelAndView mav=new ModelAndView();
	//是否验证成功
	if (CheckUtils.VerificationAccess(eqList, signature)) {
	    System.out.println("-------------------------------->111111111");
	    //验证成功就返回echostr
	    out.write(echostr);
	    out.flush();
	    out.close();
	};
    }
    
    @RequestMapping(value="MessageReceiver",method=RequestMethod.POST)
    public void MessageReceiver_POST(HttpServletRequest request,HttpServletResponse response) throws Exception{
	
	 	// 将请求、响应的编码均设置为UTF-8(防止中文乱码)
		request.setCharacterEncoding("UTF-8"); 

		response.setCharacterEncoding("UTF-8"); 
		// 1、获取微信发送的信息
		Scanner scanner = new Scanner(request.getInputStream());
		   
	        StringBuffer sb = new StringBuffer();
	        while (scanner.hasNextLine()) {
	            sb.append(scanner.nextLine());
	        }
	        //接收消息，处理消息接口
	        System.out.println("getuserMessage="+sb.toString());
//		request.get
//	        WechatRequestAdapter adapter=new WechatRequestAdapter();
	        String respMessage=
	        "<xml>"+
		"<ToUserName><![CDATA["+123+"]]></ToUserName>"+
		"<FromUserName><![CDATA["+123+"]]></FromUserName>"+
		"<CreateTime>154354</CreateTime>"+
		"<MsgType><![CDATA[text]]></MsgType>"+
		"<Content><![CDATA[你好]]></Content>"+
		"</xml>";
		try {
//		    respMessage = adapter.distributeRequest(sb.toString());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	        
	        System.out.println("responseuserMessage="+respMessage);
		 // 调用核心业务类接收消息、处理消息
//		String respMessage = CoreService.processRequest(request); 
	        
	        
//	        respMessage=new String(respMessage.getBytes("GBK"),"UTF-8");
		 // 响应消息
		PrintWriter out = response.getWriter(); 
		
//		
		out.print(respMessage);
		out.flush();
		out.close();
//		return respMessage;
    }
    
}
