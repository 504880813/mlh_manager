package rms.service;

import java.util.List;
import java.util.Set;

import rms.po.CustomRole;
import rms.po.CustomUser;
import rms.po.role;
import rms.po.user;

/**
 * 
* @ClassName: UserService 
* @Description: 操作用户service
* @author 邹家兴 
* @date 2015年10月20日 上午12:15:34 
*
 */
public interface UserService {
    /**
     * 
    * @Title: findUsers 
    * @Description:查询所有的用户列表  不包含关联
    * @param @return
    * @param @throws Exception    
    * @return List<user>    
    * @throws
     */
    public List<user> findUsers() throws Exception;
    /**
     * 
    * @Title: saveOrUpdateUser 
    * @Description: 保存或更新用户
    * @param @param User
    * @param @param ownRoleIds
    * @param @throws Exception    
    * @return void    
    * @throws
     */
    public void saveOrUpdateUser(CustomUser User,Integer[] ownRoleIds) throws Exception;
    /**
     * 
    * @Title: findUserById 
    * @Description: 根据用户id查询用户
    * @param @param id
    * @param @return
    * @param @throws Exception    
    * @return CustomUser    
    * @throws
     */
    public CustomUser findUserById(Integer id) throws Exception;
    /**
     * 
    * @Title: findUserNmaeIsExist 
    * @Description: 查询用户名是否存在
    * @param @param username
    * @param @return
    * @param @throws Exception    
    * @return boolean    
    * @throws
     */
    public boolean findUserNmaeIsExist(String username) throws Exception;
    /**
     * 
    * @Title: deleteUserByID 
    * @Description: 根据用户id删除用户 以及关联关系
    * @param @param id
    * @param @throws Exception    
    * @return void    
    * @throws
     */
    public void deleteUserByID(Integer id) throws Exception;
    /**
     * 
    * @Title: login 
    * @Description: 登陆，登陆成功则返回完整用户信息
    * @param @param user
    * @param @return
    * @param @throws Exception    
    * @return CustomUser    
    * @throws
     */
    public CustomUser login(CustomUser user) throws Exception;
    
    

}
