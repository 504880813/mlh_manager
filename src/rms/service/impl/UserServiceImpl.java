package rms.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import rms.controller.exception.CustomException;
import rms.mapper.CustomUserMapper;
import rms.mapper.rightMapper;
import rms.mapper.roleMapper;
import rms.mapper.userMapper;
import rms.po.CustomRole;
import rms.po.CustomUser;
import rms.po.right;
import rms.po.role;
import rms.po.user;
import rms.po.userExample;
import rms.po.user_role_link;
import rms.service.RoleService;
import rms.service.UserService;
import rms.wechat.untils.DataUtils;
/**
 * 
* @ClassName: UserServiceImpl 
* @Description: 操作用户接口实现
* @author 邹家兴 
* @date 2015年10月20日 下午5:40:35 
*
 */
@Component
public class UserServiceImpl implements UserService {
    
    
    @Resource
    private RoleService roleService;
    
    @Resource
    private userMapper UserMapper;
    @Resource
    private CustomUserMapper customUserMapper;
    @Resource
    private roleMapper roleMapper;
  
    
    /*
     * (非 Javadoc) 
    * <p>Title: findUsers</p> 
    * <p>Description:查询所有用户信息，不包含关联</p> 
    * @return
    * @throws Exception 
    * @see rms.service.UserService#findUsers()
     */
    @Override
    public List<user> findUsers() throws Exception {
	userExample example=new userExample();
	example.createCriteria().andIdIsNotNull();
	return UserMapper.selectByExample(example);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: saveOrUpdateUser</p> 
    * <p>Description:保存或更新数据，包括关联</p> 
    * @param User
    * @throws Exception 
    * @see rms.service.UserService#saveOrUpdateUser(rms.po.CustomUser)
     */
    @Override
    public void saveOrUpdateUser(CustomUser User,Integer[] ownRoleIds) throws Exception {
	  //查询是否有效
	 if(findUserNmaeIsExist(User.getUsername())) {
	     if(User.getId()==null) {
		 throw new CustomException("该用户名已存在");
	     }else {
		 CustomUser dbuser=findUserById(User.getId());
		 if(!(dbuser.getUsername().equals(User.getUsername()))) {
		     throw new CustomException("该用户名已存在");
		 }
	     }
	  }
	//将密码进行md5加密
	String TempPassword=DataUtils.md5(User.getPassword());
	User.setPassword(TempPassword);
	//保存
	if(User.getId()==null) {
	    //先保存基础信息
	    customUserMapper.insertUserofPrimaryKey(User);
	
	}else {
	    //更新
	    //先更新基础信息
	    UserMapper.updateByPrimaryKey(User);
	    //更新关联关系
	    //先根据用户id 删除关联
	    customUserMapper.deleteUser_Role_LinkByUserId(User.getId());
	}
	
	 //保存关联信息
	   if(ownRoleIds==null||ownRoleIds.length<=0) {
			return;
	   }
	    user_role_link link=null;
	    for(Integer role_id:ownRoleIds) {
		link=new user_role_link();
		link.setRoleid(role_id);;
		link.setUserid(User.getId());
		customUserMapper.insert_User_Role_Link_Message(link);
	    }
    }
    /*
     * (非 Javadoc) 
    * <p>Title: findUserById</p> 
    * <p>Description: 根据id查询用户信息 包括关联</p> 
    * @param id
    * @return
    * @throws Exception 
    * @see rms.service.UserService#findUserById(java.lang.Integer)
     */
    @Override
    public CustomUser findUserById(Integer id) throws Exception {
	
	//先查询普通信息
	user User=UserMapper.selectByPrimaryKey(id);
	
	//然后查询关联
	List<user_role_link> user_role_links=customUserMapper.selectUser_Role_LinkByUserId(id);
	
	//初始化关联集合
	Set<CustomRole> roles=new HashSet<>();
	
	for(user_role_link link:user_role_links) {
	    
	    CustomRole r=roleService.findroleById(link.getRoleid());
	    
	    roles.add(r);
	}
	CustomUser cUser=new CustomUser();
	
	BeanUtils.copyProperties(cUser, User);
	
	cUser.setRoles(roles);
	
	return cUser;
    }
    /*
     * (非 Javadoc) 
    * <p>Title: findUserNmaeIsExist</p> 
    * <p>Description:查询用户名是否存在</p> 
    * @param username
    * @return
    * @throws Exception 
    * @see rms.service.UserService#findUserNmaeIsExist(java.lang.String)
     */
    @Override
    public boolean findUserNmaeIsExist(String username) throws Exception {
	if(username==null||username.trim().equals("")) return true;
	
	userExample example=new userExample();
	example.createCriteria().andUsernameEqualTo(username.trim());
	
	List<user> users=UserMapper.selectByExample(example);
	
	if(users!=null&&users.size()>0) {
	    return true;
	}
	
	return false;
    }
    
    
    
    /*
     * (非 Javadoc) 
    * <p>Title: deleteUserByID</p> 
    * <p>Description:根据用户id删除用户信息 包括 关联</p> 
    * @param id
    * @throws Exception 
    * @see rms.service.UserService#deleteUserByID(java.lang.Integer)
     */
    @Override
    public void deleteUserByID(Integer id) throws Exception {
	//删除基本信息
	UserMapper.deleteByPrimaryKey(id);
	
	//删除关联
	customUserMapper.deleteUser_Role_LinkByUserId(id);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: login</p> 
    * <p>Description:登陆。成功后返回全部用户信息</p> 
    * @param user
    * @return
    * @throws Exception 
    * @see rms.service.UserService#login(rms.po.CustomUser)
     */
    @Override
    public CustomUser login(CustomUser user) throws Exception {
	userExample example=new userExample();
	example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(DataUtils.md5(user.getPassword()));
	
	List<user> users=UserMapper.selectByExample(example);
	if(users==null || users.size()== 0) {
	    return null;
	}else {
	    return this.findUserById(users.get(0).getId());
	}
    }

}
