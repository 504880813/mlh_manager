package rms.jstl.tag;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import rms.po.CustomUser;
import rms.po.right;
/**
 * 
* @ClassName: CustomCheckRight_A_Tag 
* @Description: 自定义a标签，，检查是否有权限后输出
* @author 邹家兴 
* @date 2015年10月23日 上午1:10:07 
*
 */
public class CustomCheckRight_A_Tag extends SimpleTagSupport {
     
     private String uri;
     
     
     
     private String a_TagContent;
     
     private String cssclass;
     
     //注入uri属性
     public void setUri(String uri) {
         this.uri = uri;
     }
     //注入a_TagContent属性
     public void setA_TagContent(String a_TagContent) {
	 this.a_TagContent = a_TagContent;
    }
    //注入cssclass属性
    public void setCssclass(String cssclass) {
        this.cssclass = cssclass;
    }
    @Override
     public void doTag() throws JspException, IOException {
 	
 	 JspFragment jf = this.getJspBody();  
 	        //相当于jf.invoke(null); 
 	HttpServletRequest request=(HttpServletRequest)((PageContext) this.getJspContext()).getRequest();
 	try {
 	    if(hasRight(uri, request)) {
 		 StringWriter sw = new StringWriter();  
 		 jf.invoke(sw); 
 		 String content = sw.toString(); 
 		 StringBuilder builder=new StringBuilder();
 		 builder.append("<a href =");
 		 builder.append("'");
 		 builder.append(uri);
 		 builder.append("'");
 		 builder.append(" class =");
 		 builder.append("'");
 		 builder.append(cssclass);
 		 builder.append("'");
 		 builder.append(">");
 		 builder.append(content);
 		 builder.append("</a>");
 		 content = builder.toString();  
 		 this.getJspContext().getOut().write(content);  
// 		 jf.invoke(null); 
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
