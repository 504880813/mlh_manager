package rms.mapper;

import java.util.List;
import java.util.Set;

import rms.po.CustomRole;
import rms.po.role_right_link;

/**
 * 
* @ClassName: CustomRoleMapper 
* @Description:自定义角色操作mapper
* @author 邹家兴 
* @date 2015年10月20日 下午5:42:40 
*
 */
public interface CustomRoleMapper {
    /**
     * 
    * @Title: insertRoleofPrimaryKey 
    * @Description: 保存角色基础信息，得到主键值
    * @param @param role
    * @param @return
    * @param @throws Exception    
    * @return int    
    * @throws
     */
    public int insertRoleofPrimaryKey(CustomRole role) throws Exception;
    /**
     * 
    * @Title: insert_Role_Right_Link_Message 
    * @Description: 保存角色与权限的关联关系
    * @param @param link
    * @param @throws Exception    
    * @return void    
    * @throws
     */
    public void insert_Role_Right_Link_Message(role_right_link link) throws Exception;
    /**
     * 
    * @Title: deleteRole_Right_LinkByRoleId 
    * @Description: 根据角色id删除角色和权限的关联关系
    * @param @param id
    * @param @throws Exception    
    * @return void    
    * @throws
     */
    public void deleteRole_Right_LinkByRoleId(Integer id) throws Exception;
    /**
     * 
    * @Title: selectRole_Right_LinkByRoleId 
    * @Description: 根据角色id查询关联关系
    * @param @param id
    * @param @return
    * @param @throws Exception    
    * @return List<role_right_link>    
    * @throws
     */
    public List<role_right_link> selectRole_Right_LinkByRoleId(Integer id) throws Exception;
}