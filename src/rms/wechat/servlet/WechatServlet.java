package rms.wechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import rms.wechat.adapter.WechatRequestAdapter;
import rms.wechat.untils.CheckUtils;
/**
 * 
* @ClassName: WechatServlet 
* @Description: 微信验证servlet
* @author 邹家兴 
* @date 2015年8月11日 下午4:22:05 
*
 */
public class WechatServlet extends AutowiredHttpServlet{

    private static final long serialVersionUID = 1L;
    private static final String token = "sbs";
    
    @Autowired
    private WechatRequestAdapter adapter;

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
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	// 微信加密签名
	String signature = request.getParameter("signature");
	// 时间戳
	String timestamp = request.getParameter("timestamp");
	// 随机数
	String nonce = request.getParameter("nonce");
	// 随机字符串
	String echostr = request.getParameter("echostr");

	List eqList = new ArrayList<>();

	eqList.add(token);
	eqList.add(timestamp);
	eqList.add(nonce);
	//是否验证成功
	if (CheckUtils.VerificationAccess(eqList, signature)) {
	    //验证成功就返回echostr
	    PrintWriter out =response.getWriter();
	    out.write(echostr);
	    out.close();
	};

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
//	request.get
//        WechatRequestAdapter adapter=new WechatRequestAdapter();
//        
        String respMessage="";
	try {
	    respMessage = adapter.distributeRequest(sb.toString());
	} catch (Exception e) {
	    e.printStackTrace();
	}
        
        System.out.println("responseuserMessage="+respMessage);
	 // 调用核心业务类接收消息、处理消息
//	String respMessage = CoreService.processRequest(request); 
        if(respMessage!=null && !respMessage.trim().equals("")) {
            	// 响应消息
        	PrintWriter out = response.getWriter(); 
    
        	out.write(respMessage);
        	out.close();
        }
	
    }

}

// }
