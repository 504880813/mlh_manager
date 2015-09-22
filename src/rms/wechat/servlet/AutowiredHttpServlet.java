package rms.wechat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public abstract class AutowiredHttpServlet extends HttpServlet {

  private static final long serialVersionUID = -2000909174467653847L;

  public void init() throws ServletException {
    super.init();
    WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    AutowireCapableBeanFactory factory = ctx.getAutowireCapableBeanFactory();
    factory.autowireBean(this);
  }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
  }
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
  }
}
