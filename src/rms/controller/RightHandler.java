package rms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rms.po.right;
import rms.service.RightService;

/**
 * 
* @ClassName: RightHandler 
* @Description: 权限页面响应操作 
* @author 邹家兴 
* @date 2015年10月19日 下午10:39:06 
*
 */
@Controller
@RequestMapping("right")
public class RightHandler {
	/**
	 * 注入权限service
	 */
	@Resource
	private RightService rightService;

	/**
	 * 
	* @Title: getAllRightofManager 
	* @Description: 查询所有的权限列表用于管理
	* @param @return
	* @param @throws Exception    
	* @return ModelAndView    
	* @throws
	 */
	@RequestMapping("getAllRightofManager")
	public ModelAndView getAllRightofManager() throws Exception {
		List<right> rights = rightService.findRights();
		ModelAndView mav = new ModelAndView();
		mav.addObject("rights", rights);
		mav.setViewName("right/rightList");
		return mav;
	}
	
	
	/**
	 * 
	* @Title: addright 
	* @Description: 为添加页面准备数据
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("addright")
	public String addright() throws Exception {
		return "right/saveOrEditRight";
	}
	/**
	 * 
	* @Title: addrightSubmit 
	* @Description: 添加权限
	* @param @param right
	* @throws
	 */
	@RequestMapping("addrightSubmit")
	public String addrightSubmit(right right) throws Exception {
		rightService.saveOrUpdateRight(right);
		return "redirect:getAllRightofManager.action";
	}
	/**
	 * 
	* @Title: editright 
	* @Description: 为修改页面准备数据
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("editright")
	public ModelAndView editright(Integer id)throws Exception{
		right right=rightService.findRightById(id);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("right", right);
		mav.setViewName("right/saveOrEditRight");
		return mav;
	}
	/**
	 * 
	* @Title: editrightSubmit 
	* @Description: 修改权限
	* @param @param right
	* @throws
	 */
	@RequestMapping("editrightSubmit")
	public String editrightSubmit(Integer id,right right) throws Exception {
	    	right.setId(id);
		rightService.saveOrUpdateRight(right);
		return "redirect:getAllRightofManager.action";
	}
	/**
	 * 
	* @Title: deleteright 
	* @Description: 根据id删除权限
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("deleteright")
	public String deleteRight(Integer id) throws Exception{
		rightService.deleteRightByID(id);
		return "redirect:getAllRightofManager.action";
	}

}
