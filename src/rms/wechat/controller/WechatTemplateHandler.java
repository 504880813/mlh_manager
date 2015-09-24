package rms.wechat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rms.mapper.wechatuserMapper;
import rms.po.wechatTemplate;
import rms.po.wechatuser;
import rms.po.wechatuserExample;
import rms.wechat.service.wechatTemplateService;
import rms.wechat.service.wechatuserService;
/**
 * 
* @ClassName: WechatTemplateHandler 
* @Description: 处理微信公众号相关消息模板的管理页面请求
* @author 邹家兴 
* @date 2015年9月23日 下午3:56:18 
*
 */
@Controller
@RequestMapping("wechatTemplate")
public class WechatTemplateHandler {
    
    @Resource
    private wechatTemplateService wechatTemplateService;
    /**
     * 
    * @Title: getAllTemplate 
    * @Description: 得到所有的模板数据
    * @param @return
    * @param @throws Exception    
    * @return ModelAndView    
    * @throws
     */
    @RequestMapping("getAllTemplate")
    public ModelAndView getAllTemplate() throws Exception{
	
	List<wechatTemplate> wechatTemplates=wechatTemplateService.getAll();
	ModelAndView mav=new ModelAndView();
	mav.addObject("wechatTemplates", wechatTemplates);
	
	mav.setViewName("wechatTemplateManager/wechatTemplateList");
	
	return mav;
    }
 
    /**
     * 
    * @Title: addwechatTemplate 
    * @Description: 为添加模板准备数据
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("addwechatTemplate")
    public String addwechatTemplate() throws Exception{
	return "wechatTemplateManager/saveoreditWechatTemplate";
    }
    /**
     * 
    * @Title: editWechatTemplate 
    * @Description: 根据id为修改公众号消息模板准备数据
    * @param @param id
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    @RequestMapping("editWechatTemplate")
    public ModelAndView editWechatTemplate(Integer id) throws Exception{
	wechatTemplate wechatTemplate=wechatTemplateService.findWechatTemplateByid(id);
	ModelAndView mav=new ModelAndView();
	mav.addObject("wechatTemplate", wechatTemplate);
	mav.setViewName("wechatTemplateManager/saveoreditWechatTemplate");
	return mav;
    }
    /**
     * 
    * @Title: addwechatTemplateSubmit 
    * @Description: 添加消息模板
    * @param @param template
    * @param @return    
    * @return String    
    * @throws
     */
    @RequestMapping("addwechatTemplateSubmit")
    public String addwechatTemplateSubmit(wechatTemplate template) throws Exception{
	wechatTemplateService.savewechatTemplate(template);
	return "redirect:getAllTemplate.action";
    }
    /**
     * 
    * @Title: editwechatTemplateSubmit 
    * @Description: 修改消息模板信息
    * @param @param user
    * @param @return    
    * @return String    
    * @throws
     */
    @RequestMapping("editwechatTemplateSubmit")
    public String editwechatTemplateSubmit(wechatTemplate template) throws Exception{
	wechatTemplateService.updatewechatTemplate(template);
	return "redirect:getAllTemplate.action";
    }
    /**
     * 
    * @Title: deleteWechatTemplate 
    * @Description: 根据id消息模板
    * @param @param id
    * @param @return    
    * @return String    
    * @throws
     */
    @RequestMapping("deleteWechatTemplate")
    public String deleteWechatTemplate(Integer id) throws Exception{
	wechatTemplateService.deletewechatTemplatebyId(id);
	return "redirect:getAllTemplate.action";
    }
    
    
    
}
