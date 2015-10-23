package rms.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import rms.mapper.CustomRoleMapper;
import rms.mapper.rightMapper;
import rms.mapper.roleMapper;
import rms.po.CustomRole;
import rms.po.right;
import rms.po.role;
import rms.po.roleExample;
import rms.po.role_right_link;
import rms.service.RoleService;
/**
 * 
* @ClassName: RoleServiceImpl 
* @Description: 操作角色接口实现
* @author 邹家兴 
* @date 2015年10月20日 下午5:40:35 
*
 */
@Component
public class RoleServiceImpl implements RoleService {
    
    
    @Resource
    private roleMapper roleMapper;
    @Resource
    private CustomRoleMapper customRoleMapper;
    @Resource
    private rightMapper rightMapper;
    
    /*
     * (非 Javadoc) 
    * <p>Title: findRoles</p> 
    * <p>Description:查询所有角色信息，不包含关联</p> 
    * @return
    * @throws Exception 
    * @see rms.service.RoleService#findRoles()
     */
    @Override
    public List<role> findRoles() throws Exception {
	roleExample example=new roleExample();
	example.createCriteria().andIdIsNotNull();
	return roleMapper.selectByExample(example);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: saveOrUpdaterole</p> 
    * <p>Description:保存或更新数据，包括关联</p> 
    * @param role
    * @throws Exception 
    * @see rms.service.RoleService#saveOrUpdaterole(rms.po.CustomRole)
     */
    @Override
    public void saveOrUpdaterole(CustomRole role,Integer[] ownRightIds) throws Exception {
	//保存
	if(role.getId()==null) {
	    //先保存基础信息
	    customRoleMapper.insertRoleofPrimaryKey(role);
	 
	}else {
	    //更新
	    //先更新基础信息
	    roleMapper.updateByPrimaryKey(role);
	    //更新关联关系
	    
	    //先根据角色id 删除关联
	    customRoleMapper.deleteRole_Right_LinkByRoleId(role.getId());
	    
//	    //重新插入新的关联
//	    role_right_link link=null;
//	    for(Integer right_id:ownRightIds) {
//		link=new role_right_link();
//		link.setRightid(right_id);
//		link.setRoleid(role.getId());
//		customRoleMapper.insert_Role_Right_Link_Message(link);
//	    }
	    
	}
	   //保存关联信息
	    role_right_link link=null;
	    if(ownRightIds==null || ownRightIds.length<=0) {
		return;
	    }
	    for(Integer right_id:ownRightIds) {
		link=new role_right_link();
		link.setRightid(right_id);
		link.setRoleid(role.getId());
		customRoleMapper.insert_Role_Right_Link_Message(link);
	    }
	    
    }
    /*
     * (非 Javadoc) 
    * <p>Title: findroleById</p> 
    * <p>Description: 根据id查询角色信息 包括关联</p> 
    * @param id
    * @return
    * @throws Exception 
    * @see rms.service.RoleService#findroleById(java.lang.Integer)
     */
    @Override
    public CustomRole findroleById(Integer id) throws Exception {
	
	//先查询普通信息
	role role=roleMapper.selectByPrimaryKey(id);
	
	//然后查询关联
	List<role_right_link> role_right_links=customRoleMapper.selectRole_Right_LinkByRoleId(id);
	
	//初始化关联集合
	Set<right> rights=new HashSet<>();
	
	for(role_right_link link:role_right_links) {
	    
	    right r=rightMapper.selectByPrimaryKey(link.getRightid());
		    
	    rights.add(r);
	}
	CustomRole crole=new CustomRole();
	
	BeanUtils.copyProperties(crole, role);
	
	crole.setRights(rights);
	
	return crole;
    }
    /*
     * (非 Javadoc) 
    * <p>Title: deleteroleByID</p> 
    * <p>Description:根据角色id删除角色信息 包括 关联</p> 
    * @param id
    * @throws Exception 
    * @see rms.service.RoleService#deleteroleByID(java.lang.Integer)
     */
    @Override
    public void deleteroleByID(Integer id) throws Exception {
	//删除基本信息
	roleMapper.deleteByPrimaryKey(id);
	
	//删除关联
	customRoleMapper.deleteRole_Right_LinkByRoleId(id);
	
    }
    
    /*
     * (非 Javadoc) 
    * <p>Title: findRolesAndidNotInList</p> 
    * <p>Description:查询未拥有的角色 </p> 
    * @param roles
    * @return
    * @throws Exception 
    * @see rms.service.UserService#findRolesAndidNotInList(java.util.Set)
     */
    @Override
    public List<role> findRolesAndidNotInList(Set<CustomRole> roles)
	    throws Exception {
	roleExample example=new roleExample();
	List<Integer> values=new ArrayList<>();
	for(CustomRole role :roles) {
	    values.add(role.getId());
	}
	if(values==null||values.size()<=0) {
	    example.createCriteria().andIdIsNotNull();
	}else {
	    example.createCriteria().andIdNotIn(values);
	}
	return roleMapper.selectByExample(example);
	
    }
}
