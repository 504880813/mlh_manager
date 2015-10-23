package rms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rms.po.CustomRole;
import rms.po.right;
import rms.po.role;
import rms.service.RightService;
import rms.service.RoleService;

/**
 * 
* @ClassName: RoleHandler 
* @Description: 角色页面响应操作 
* @author 邹家兴 
* @date 2015年10月19日 下午10:39:06 
*
 */
@Controller
@RequestMapping("role")
public class RoleHandler {
	/**
	 * 注入角色service
	 */
	@Resource
	private RoleService roleservice;
	@Resource
	private RightService rightService;

	/**
	 * 
	* @Title: getAllRoleofManager 
	* @Description: 查询所有的角色列表用于管理
	* @param @return
	* @param @throws Exception    
	* @return ModelAndView    
	* @throws
	 */
	@RequestMapping("getAllRoleofManager")
	public ModelAndView getAllRoleofManager() throws Exception {
		List<role> roles = roleservice.findRoles();
		ModelAndView mav = new ModelAndView();
		mav.addObject("roles", roles);
		mav.setViewName("role/roleList");
		return mav;
	}
	
	
	/**
	 * 
	* @Title: addrole 
	* @Description: 为添加页面准备数据
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("addrole")
	public ModelAndView addrole() throws Exception {
	    	
	    	//查询所有未拥有的权限
	    	
	    	List<right> Norights=rightService.findRights();
	    	
	    	ModelAndView mav=new ModelAndView();
	    	mav.addObject("Norights", Norights);
	    	mav.setViewName("role/saveOrEditrole");
		return mav;
	}
	/**
	 * 
	* @Title: addroleSubmit 
	* @Description: 添加角色
	* @param @param role
	* * @param @param ownRightIds
	* @throws
	 */
	@RequestMapping("addroleSubmit")
	public String addroleSubmit(CustomRole role, Integer[] ownRightIds) throws Exception {
		roleservice.saveOrUpdaterole(role,ownRightIds);
		return "redirect:getAllRoleofManager.action";
	}
	/**
	 * 
	* @Title: editrole 
	* @Description: 为修改页面准备数据
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("editrole")
	public ModelAndView editrole(Integer id)throws Exception{
	    	CustomRole role=roleservice.findroleById(id);
	    	//查询所有未拥有的权限
	    	List<right> Norights=rightService.findRightsAndidNotInList(role.getRights());
	    	
		ModelAndView mav=new ModelAndView();
		mav.addObject("role", role);
		mav.addObject("Norights", Norights);
		mav.setViewName("role/saveOrEditrole");
		return mav;
	}
	/**
	 * 
	* @Title: editroleSubmit 
	* @Description: 修改权限
	* @param @param role
	* @param @param ownRightIds
	* @throws
	 */
	@RequestMapping("editroleSubmit")
	public String editroleSubmit(Integer id,CustomRole role,Integer[] ownRightIds) throws Exception {
	    	role.setId(id);
		roleservice.saveOrUpdaterole(role,ownRightIds);
		return "redirect:getAllRoleofManager.action";
	}
	/**
	 * 
	* @Title: deleterole 
	* @Description: 根据id删除权限
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("deleterole")
	public String deleterole(Integer id) throws Exception{
		roleservice.deleteroleByID(id);
		return "redirect:getAllRoleofManager.action";
	}

}
