package rms.wechat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import rms.wechat.adapter.Wechat_js_RequestAdapter;
/**
 * 
* @ClassName: WechatServlet 
* @Description: 微信验证servlet
* @author 邹家兴 
* @date 2015年8月11日 下午4:22:05 
*
 */
public class Wechat_js_Servlet extends AutowiredHttpServlet {

    private static final long serialVersionUID = 1L;
    @Autowired
    private Wechat_js_RequestAdapter adapter; 
    
    
    /**   
     * <p>   
     * 在Servlet中注入对象的步骤:   
     * 1.取得ServletContext   
     * 2.利用Spring的工具类WebApplicationContextUtils得到WebApplicationContext   
     * 3.WebApplicationContext就是一个BeanFactory,其中就有一个getBean方法   
     * 4.有了这个方法就可像平常一样为所欲为了,哈哈!   
     * </p>   
     */    
//    @Override    
//    public void init() throws ServletException {             
//        super.init();     
//                     
//        ServletContext servletContext = this.getServletContext();     
//                     
//        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);    
//                     
//        adapter = (Wechat_js_RequestAdapter)ctx.getBean("wechat_js_RequestAdapter");    
//    }  
    /**
     * The doGet method of the servlet. <br>
     * 
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	//获取要进行的下一步操作
	String method=request.getParameter("method");
	
	String fromURL = request.getHeader("Referer"); 
	String query=request.getQueryString();
	//将请求分发给不同的处理器处理
	adapter.distributeRequest(method, request, response);
    }
    /**
     * The doPost method of the servlet. <br>
     * 
     * This method is called when a form has its tag value method equals to
     * post.
     * 
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

}
