package rms.mapper;

import java.util.List;

import rms.po.CustomUser;
import rms.po.user_role_link;

/**
 * 
* @ClassName: CustomUserMapper 
* @Description:自定义用户操作mapper
* @author 邹家兴 
* @date 2015年10月20日 下午5:42:40 
*
 */
public interface CustomUserMapper {
    /**
     * 
    * @Title: insertUserofPrimaryKey 
    * @Description: 保存用户基础信息，得到主键值
    * @param @param User
    * @param @return
    * @param @throws Exception    
    * @return int    
    * @throws
     */
    public int insertUserofPrimaryKey(CustomUser User) throws Exception;
    /**
     * 
    * @Title: insert_User_Right_Link_Message 
    * @Description: 保存用户与角色的关联关系
    * @param @param link
    * @param @throws Exception    
    * @return void    
    * @throws
     */
    public void insert_User_Role_Link_Message(user_role_link link) throws Exception;
    /**
     * 
    * @Title: deleteUser_Right_LinkByUserId 
    * @Description: 根据用户id删除用户和角色的关联关系
    * @param @param id
    * @param @throws Exception    
    * @return void    
    * @throws
     */
    public void deleteUser_Role_LinkByUserId(Integer id) throws Exception;
    /**
     * 
    * @Title: selectUser_Right_LinkByUserId 
    * @Description: 根据用户id查询关联关系
    * @param @param id
    * @param @return
    * @param @throws Exception    
    * @return List<user_role_link>    
    * @throws
     */
    public List<user_role_link> selectUser_Role_LinkByUserId(Integer id) throws Exception;
}