package rms.controller.Interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import rms.service.RightService;

public class CatchUrlInterceptor extends HandlerInterceptorAdapter {
    
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
	String url = request.getRequestURI().toString();
	
	ServletContext sc = request.getServletContext();
//	ApplicationContext ac = (ApplicationContext) sc.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//	RightService rs = (RightService) ac.getBean("rightService");
	ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
	RightService rs = (RightService) ac.getBean("rightServiceImpl");
	rs.appendRightByURL(url);
        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
