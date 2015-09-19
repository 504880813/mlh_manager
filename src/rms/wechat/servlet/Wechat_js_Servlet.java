package rms.wechat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rms.wechat.untils.HttpUtils;
/**
 * 
* @ClassName: WechatServlet 
* @Description: 微信验证servlet
* @author 邹家兴 
* @date 2015年8月11日 下午4:22:05 
*
 */
public class Wechat_js_Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
	//用于获取网页acc 的密钥
	String code=request.getParameter("code");
	
	try {
	    String openid=HttpUtils.getPageACCESS_TOKEN(code);
	    request.setAttribute("openid", openid);
		
	    request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request, response);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	
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
