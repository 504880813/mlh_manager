package rms.wechat.adapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import rms.wechat.Processor.Wechat_js_Processor;

/**
 * 
* @ClassName: Wechat_js_RequestAdapter 
* @Description: 用来分析关于微信页面的请求数据，并分发给响应方法
* @author 邹家兴 
* @date 2015年9月20日 下午7:46:09 
*
 */
@Component
public class Wechat_js_RequestAdapter {
    
    /**
     * 注入处理器
     */
    @Resource
    private Wechat_js_Processor processor;
    
    /**
     * 
    * @Title: distributeRequest 
    * @Description: 根据请求的方法，将请求分发给不同的处理器处理 
    * @param @param method
    * @param @param request
    * @param @param response    
    * @return void    
    * @throws
     */
    public void distributeRequest(String method,HttpServletRequest request,
	    HttpServletResponse response) {
	if("ValidationMemberPage".equals(method)) {
	    processor.ToValidationMemberPage(request,response);
        }
        if("ValidationMember".equals(method)) {
            processor.BindingMember(request,response);
        }
    }
}
