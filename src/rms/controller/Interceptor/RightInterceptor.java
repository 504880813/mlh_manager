package rms.controller.Interceptor;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import rms.po.CustomUser;
import rms.po.right;

public class RightInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String url = request.getRequestURI().toString();
        System.out.println(">>>: " + url);
        if(hasRight(url, request,response)) {
            flag=true;
        }else {
            flag=false;
            request.setAttribute("message", "没有权限");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
        return flag;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
    
    
    /**
     * 判断是否有权限
     * @throws IOException 
     * @throws ServletException 
     */
    @SuppressWarnings("unchecked")
    public static boolean hasRight(String url ,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

	// 处理?参数
	if (url.contains("?")) {
	    url = url.substring(0, url.indexOf("?"));
	}

	HttpSession s = request.getSession();
	ServletContext sc = s.getServletContext();
	Map<String, right> map = (Map<String, right>) sc
		.getAttribute("all_rights_map");
	right r = map.get(url);
	// 公共资源
	if (r == null || r.getCommon()) {
	    return true;
	} else {
	    CustomUser user = (CustomUser) s.getAttribute("OnlineUser");
	    // 登录?
	    if (user == null) {
	        request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request, response);
		return false;
	    } else {
		// userAware
//		if (action != null && action instanceof UserAware) {
//		    ((UserAware) action).setUser(user);
//		}
		// 超级管理员?
		if (user.getSuperadmin()) {
		    return true;
		} else {
		    // 有权限?
		    if (user.hasRight(r)) {
			return true;
		    } else {
			return false;
		    }
		}
	    }

	}
    }

}
