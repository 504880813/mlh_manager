package rms.controller.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import rms.po.right;
import rms.service.RightService;

/**
 * 
* @ClassName: IniRightListener 
* @Description: 初始化权限监听器 
* @author 邹家兴 
* @date 2015年10月21日 下午8:18:15 
*
 */
@Component
public class IniRightListener implements ApplicationListener,ServletContextAware{

	@Resource
	private RightService rs ;
	
	//注入servlet上下文
	private ServletContext sc;
	
	public void onApplicationEvent(ApplicationEvent arg0) {
		//判断是不是上下文刷新时间
		if(arg0 instanceof ContextRefreshedEvent){
			List<right> list = null;
			try {
			    list = rs.findRights();
			    Map<String, right> map = new HashMap<String, right>();
				for(right r : list){
					map.put(r.getUrl(), r);
				}
				if(sc != null){
					sc.setAttribute("all_rights_map", map);
				}
			} catch (Exception e) {
			    e.printStackTrace();
			    System.out.println("初始化权限失败");
			}
			
		}
	}

	public void setServletContext(ServletContext servletContext) {
		//
		System.out.println("初始化权限成功！！");
		this.sc = servletContext ;
	}
}
