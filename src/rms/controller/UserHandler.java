package rms.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import rms.po.CustomUser;
import rms.po.role;
import rms.po.user;
import rms.service.RightService;
import rms.service.RoleService;
import rms.service.UserService;

/**
 * 
* @ClassName: UserHandler 
* @Description: 用户页面响应操作 
* @author 邹家兴 
* @date 2015年10月19日 下午10:39:06 
*
 */
@Controller
@RequestMapping("user")
public class UserHandler {
	/**
	 * 注入用户service
	 */
	@Resource
	private UserService Userservice;
	@Resource
	private RoleService roleService;
	@Resource
	private RightService rightService;
 
	/**
	 * 
	* @Title: getAllUserofManager 
	* @Description: 查询所有的用户列表用于管理
	* @param @return
	* @param @throws Exception    
	* @return ModelAndView    
	* @throws
	 */
	@RequestMapping("getAllUserofManager")
	public ModelAndView getAllUserofManager() throws Exception {
		List<user> Users = Userservice.findUsers();
		ModelAndView mav = new ModelAndView();
		mav.addObject("users", Users);
		mav.setViewName("user/userList");
		return mav;
	}
	
	
	/**
	 * 
	* @Title: addUser 
	* @Description: 为添加页面准备数据
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("addUser")
	public ModelAndView addUser() throws Exception {
	    	//查询所有未拥有的权限
	    	List<role> Noroles=roleService.findRoles();
	    	ModelAndView mav=new ModelAndView();
	    	mav.addObject("Noroles", Noroles);
	    	mav.setViewName("user/saveOrEdituser");
		return mav;
	}
	/**
	 * 
	* @Title: addUserSubmit 
	* @Description: 添加用户
	* @param @param User
	* * @param @param ownRightIds
	* @throws
	 */
	@RequestMapping("addUserSubmit")
	public String addUserSubmit(CustomUser User, Integer[] ownRoleIds) throws Exception {
		Userservice.saveOrUpdateUser(User,ownRoleIds);
		return "redirect:getAllUserofManager.action";
	}
	/**
	 * 
	* @Title: editUser 
	* @Description: 为修改页面准备数据
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("editUser")
	public ModelAndView editUser(Integer id)throws Exception{
	    	CustomUser User=Userservice.findUserById(id);
	    	//查询所有未拥有的权限
	    	List<role> Noroles=roleService.findRolesAndidNotInList(User.getRoles());
	    	
		ModelAndView mav=new ModelAndView();
		mav.addObject("user", User);
		mav.addObject("Noroles", Noroles);
		mav.setViewName("user/saveOrEdituser");
		return mav;
	}
	/**
	 * 
	* @Title: editUserSubmit 
	* @Description: 修改权限
	* @param @param User
	* @param @param ownRightIds
	* @throws
	 */
	@RequestMapping("editUserSubmit")
	public String editUserSubmit(Integer id,CustomUser User,Integer[] ownRoleIds) throws Exception {
	    	User.setId(id);
		Userservice.saveOrUpdateUser(User,ownRoleIds);
		return "redirect:getAllUserofManager.action";
	}
	/**
	 * 
	* @Title: deleteUser 
	* @Description: 根据id删除权限
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("deleteUser")
	public String deleteUser(Integer id) throws Exception{
		Userservice.deleteUserByID(id);
		return "redirect:getAllUserofManager.action";
	}
	/**
	 * 
	* @Title: login 
	* @Description: 跳转到登陆界面
	* @param @throws Exception    
	* @return String    
	* @throws
	 */
	@RequestMapping("login")
	public String login() throws Exception{
	    	return "user/login";
	}
	/**
	 * 
	* @Title: loginSubmit 
	* @Description: 登陆
	* @param @param user
	* @param @param request
	* @param @return
	* @param @throws Exception    
	* @return ModelAndView    
	* @throws
	 */
	@RequestMapping("loginSubmit")
	public ModelAndView loginSubmit(CustomUser user,HttpServletRequest request) throws Exception{
	    
	    	CustomUser cuser=Userservice.login(user);
	    	ModelAndView mav=new ModelAndView();
	    	if(cuser!=null) {
	    	    //初始化权限总和数组
		    int maxRightPos = rightService.getMaxRightPos();
		    cuser.setRightSum(new long[maxRightPos + 1]);
		    //计算用户的权限总和
		    cuser.calculateRightSum();
	    	    request.getSession().setAttribute("OnlineUser", cuser);
	    	    mav.setViewName("forward:/index.jsp");
	    	}else {
	    	    mav.addObject("message", "登陆失败");
	    	    mav.setViewName("error");
	    	}
	    	return mav;
	}
	/**
	 * 
	* @Title: logout 
	* @Description: 注销用户
	* @param @return
	* @param @throws Exception    
	* @return String    
	* @throws
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) throws Exception{
	    request.getSession().removeAttribute("OnlineUser");
	    return "forward:/index.jsp";
	}

}
