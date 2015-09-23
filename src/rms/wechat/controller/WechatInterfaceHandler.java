package rms.wechat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rms.mapper.wechatuserMapper;
import rms.po.wechatInterface;
import rms.po.wechatuser;
import rms.po.wechatuserExample;
import rms.wechat.service.wechatInterfaceService;
import rms.wechat.service.wechatInterfaceService;
import rms.wechat.service.wechatuserService;
/**
 * 
* @ClassName: WechatInterfaceHandler 
* @Description: 处理微信公众号接口url的管理页面请求
* @author 邹家兴 
* @date 2015年9月23日 下午11:07:15 
*
 */
@Controller
@RequestMapping("wechatInterface")
public class WechatInterfaceHandler {
    
    @Resource
    private wechatInterfaceService wechatInterfaceService;
    /**
     * 
    * @Title: getAllInterface 
    * @Description: 得到所有的本地微信接口
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("getAllInterface")
    public ModelAndView getAllInterface() throws Exception{
	
	List<wechatInterface> wechatInterfaces=wechatInterfaceService.getAll();
	ModelAndView mav=new ModelAndView();
	mav.addObject("wechatInterfaces", wechatInterfaces);
	
	mav.setViewName("wechatInterfaceManager/wechatInterfaceList");
	
	return mav;
    }
    /**
     * 
    * @Title: addwechatInterface 
    * @Description: 为添加本地微信接口准备数据
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("addwechatInterface")
    public String addwechatInterface() throws Exception{
	return "wechatInterfaceManager/saveoreditWechatInterface";
    }
    /**
     * 
    * @Title: editWechatInterface 
    * @Description: 根据id为本地微信接口
    * @param @param id
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("editWechatInterface")
    public ModelAndView editWechatInterface(Integer id) throws Exception{
	wechatInterface wechatInterface=wechatInterfaceService.findWechatInterfaceByid(id);
	ModelAndView mav=new ModelAndView();
	mav.addObject("wechatInterface", wechatInterface);
	mav.setViewName("wechatInterfaceManager/saveoreditWechatInterface");
	return mav;
    }
    /**
     * 
    * @Title: addwechatInterfaceSubmit 
    * @Description: 添加本地微信接口
    * @param @param Interface
    * @param @return    
    * @return String    
    * @throws
     */
    @RequestMapping("addwechatInterfaceSubmit")
    public String addwechatInterfaceSubmit(wechatInterface Interface) throws Exception{
	wechatInterfaceService.savewechatInterface(Interface);
	return "redirect:getAllInterface.action";
    }
    /**
     * 
    * @Title: editwechatInterfaceSubmit 
    * @Description: 修改本地微信接口
    * @param @param user
    * @param @return    
    * @return String    
    * @throws
     */
    @RequestMapping("editwechatInterfaceSubmit")
    public String editwechatInterfaceSubmit(wechatInterface Interface) throws Exception{
	wechatInterfaceService.updatewechatInterface(Interface);
	return "redirect:getAllInterface.action";
    }
    /**
     * 
    * @Title: deleteWechatInterface 
    * @Description: 根据id删除本地微信接口
    * @param @param id
    * @param @return    
    * @return String    
    * @throws
     */
    @RequestMapping("deleteWechatInterface")
    public String deleteWechatInterface(Integer id) throws Exception{
	wechatInterfaceService.deletewechatInterfacebyId(id);
	return "redirect:getAllInterface.action";
    }
    
    
    
}
