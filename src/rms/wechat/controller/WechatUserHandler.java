package rms.wechat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rms.mapper.wechatuserMapper;
import rms.po.wechatuser;
import rms.po.wechatuserExample;
import rms.wechat.service.wechatuserService;
/**
 * 
* @ClassName: WechatUserHandler 
* @Description: 处理微信公众号的管理页面请求
* @author 邹家兴 
* @date 2015年9月22日 下午11:56:19 
*
 */
@Controller
@RequestMapping("wechatuser")
public class WechatUserHandler {
    
    @Resource
    private wechatuserService wechatuserService;
    /**
     * 
    * @Title: getAllUser 
    * @Description: 得到微信公众号信息
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("getAllUser")
    public ModelAndView getAllUser() throws Exception{
	
	List<wechatuser> wechatUsers=wechatuserService.getAll();
	ModelAndView mav=new ModelAndView();
	mav.addObject("wechatUsers", wechatUsers);
	
	mav.setViewName("wechatMessageManager/wechatUserList");
	
	return mav;
    }
    /**
     * 
    * @Title: addwechatuser 
    * @Description: 为添加公众号准备数据
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("addwechatuser")
    public String addwechatuser() throws Exception{
	return "wechatMessageManager/saveoreditWechatUser";
    }
    /**
     * 
    * @Title: editWechatuser 
    * @Description: 根据id为修改公众号信息准备数据
    * @param @param id
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("editWechatuser")
    public ModelAndView editWechatuser(Integer id) throws Exception{
	wechatuser wechatuser=wechatuserService.findWechatUserByid(id);
	ModelAndView mav=new ModelAndView();
	mav.addObject("wechatuser", wechatuser);
	mav.setViewName("wechatMessageManager/saveoreditWechatUser");
	return mav;
    }
    /**
     * 
    * @Title: addwechatuserSubmit 
    * @Description: 添加公众号
    * @param @param user
    * @param @return    
    * @return String    
    * @throws
     */
    @RequestMapping("addwechatuserSubmit")
    public String addwechatuserSubmit(wechatuser user) throws Exception{
	wechatuserService.savewechatuser(user);
	return "redirect:getAllUser.action";
    }
    /**
     * 
    * @Title: editwechatuserSubmit 
    * @Description: 修改公众号信息
    * @param @param user
    * @param @return    
    * @return String    
    * @throws
     */
    @RequestMapping("editwechatuserSubmit")
    public String editwechatuserSubmit(wechatuser user) throws Exception{
	wechatuserService.updatewechatuser(user);
	return "redirect:getAllUser.action";
    }
    /**
     * 
    * @Title: deleteWechatuser 
    * @Description: 根据id删除公众号
    * @param @param id
    * @param @return    
    * @return String    
    * @throws
     */
    @RequestMapping("deleteWechatuser")
    public String deleteWechatuser(Integer id) throws Exception{
	wechatuserService.deletewechatuserbyId(id);
	return "redirect:getAllUser.action";
    }
    
    
    
}
