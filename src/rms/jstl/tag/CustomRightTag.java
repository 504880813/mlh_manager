package rms.jstl.tag;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

import rms.po.CustomUser;
import rms.po.right;

/**
 * 
* @ClassName: CustomRightTag 
* @Description: 自定义权限控制标签 
* @author 邹家兴 
* @date 2015年10月23日 上午12:01:48 
*
 */
public class CustomRightTag extends SimpleTagSupport {

    
    private String uri;
    
    //注入uri属性
    public void setUri(String uri) {
        this.uri = uri;
    }

    
    @Override
    public void doTag() throws JspException, IOException {
	
	 JspFragment jf = this.getJspBody();  
	        //相当于jf.invoke(null); 
	HttpServletRequest request=(HttpServletRequest)((PageContext) this.getJspContext()).getRequest();
	try {
	    if(hasRight(uri, request)) {
		jf.invoke(null); 
	    }
	} catch (ServletException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
    }
    
    
    /**
     * 判断是否有权限
     * @throws IOException 
     * @throws ServletException 
     */
    public static boolean hasRight(String url ,HttpServletRequest request) throws ServletException, IOException {
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
		return false;
	    } else {
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
