package rms.service;

import java.util.List;
import java.util.Set;

import rms.po.CustomRole;
import rms.po.role;

/**
 * 
* @ClassName: RoleService 
* @Description: 操作角色service
* @author 邹家兴 
* @date 2015年10月20日 上午12:15:34 
*
 */
public interface RoleService {
    /**
     * 
    * @Title: findRoles 
    * @Description:查询所有的角色列表  不包含关联
    * @param @return
    * @param @throws Exception    
    * @return List<role>    
    * @throws
     */
    public List<role> findRoles() throws Exception;
    /**
     * 
    * @Title: saveOrUpdaterole 
    * @Description: 保存或更新角色
    * @param @param role
    * @param @param ownRightIds
    * @param @throws Exception    
    * @return void    
    * @throws
     */
    public void saveOrUpdaterole(CustomRole role,Integer[] ownRightIds) throws Exception;
    /**
     * 
    * @Title: findroleById 
    * @Description: 根据角色id查询角色
    * @param @param id
    * @param @return
    * @param @throws Exception    
    * @return CustomRole    
    * @throws
     */
    public CustomRole findroleById(Integer id) throws Exception;
    /**
     * 
    * @Title: deleteroleByID 
    * @Description: 根据角色id删除角色 以及关联关系
    * @param @param id
    * @param @throws Exception    
    * @return void    
    * @throws
     */
    public void deleteroleByID(Integer id) throws Exception;
    /**
     * 
    * @Title: findRolesAndidNotInList 
    * @Description: 查询未拥有的角色
    * @param @param roles
    * @param @return
    * @param @throws Exception    
    * @return List<role>    
    * @throws
     */
    public List<role> findRolesAndidNotInList(Set<CustomRole> roles) throws Exception;

}
