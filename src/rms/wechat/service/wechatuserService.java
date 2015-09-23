package rms.wechat.service;

import java.util.List;

import rms.po.wechatuser;

/**
 * 
* @ClassName: wechatuserService 
* @Description: 微信公众号相关业务
* @author 邹家兴 
* @date 2015年9月23日 上午12:44:02 
*
 */
public interface wechatuserService {
    /**
     * 
    * @Title: getWechatOpenid 
    * @Description: 获取用户的openid
    * @param @param code
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String getWechatOpenid(String code) throws Exception;
    /**
     * 
    * @Title: getaccess_token 
    * @Description: 获取access_token
    * @param @param user
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String getaccess_token(wechatuser user) throws Exception;
    /**
     * 
    * @Title: getjsapi_ticket 
    * @Description:  获取jsp_ticket
    * @param @param access_token
    * @param @param user
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String getjsapi_ticket(String access_token, wechatuser user) throws Exception;
    /**
     * 
    * @Title: getAll 
    * @Description: 得到所有的公众号信息
    * @param @return
    * @param @throws Exception    
    * @return List<wechatuser>    
    * @throws
     */
    public List<wechatuser> getAll() throws Exception;
    /**
     * 
    * @Title: findWechatUserByid 
    * @Description: 根据id查询微信公众号
    * @param @param id
    * @param @return
    * @param @throws Exception    
    * @return wechatuser    
    * @throws
     */
    public wechatuser findWechatUserByid(Integer id) throws Exception;
    /**
     * 
    * @Title: savewechatuser 
    * @Description: 添加微信公众号
    * @param @param user
    * @param @throws Exception    
    * @return void    
    * @throws
     */
    public void savewechatuser(wechatuser user) throws Exception;
    /**
     * 
    * @Title: updatewechatuser 
    * @Description: 更新微信公众号数据
    * @param @param user
    * @param @throws Exception    
    * @return void    
    * @throws
     */
    public void updatewechatuser(wechatuser user) throws Exception;
    /**
     * 
    * @Title: deletewechatuserbyId 
    * @Description:根据ID删除微信公众号
    * @param @param id
    * @param @throws Exception    
    * @return void    
    * @throws
     */
    public void deletewechatuserbyId(Integer id) throws Exception;
}
