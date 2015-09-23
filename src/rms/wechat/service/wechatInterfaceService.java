package rms.wechat.service;

import java.util.List;

import rms.po.wechatInterface;
import rms.po.wechatTemplate;


/**
 * 
* @ClassName: wechatInterfaceService 
* @Description: 微信接口url管理相关接口
* @author 邹家兴 
* @date 2015年9月23日 下午11:13:10 
*
 */
public interface wechatInterfaceService {
    	/**
    	 * 
    	* @Title: getAll 
    	* @Description: 得到所有的本地微信接口信息
    	* @param @return
    	* @param @throws Exception    
    	* @return List<wechatInterface>    
    	* @throws
    	 */
         public  List<wechatInterface> getAll() throws Exception;
         /**
          * 
         * @Title: findWechatInterfaceByid 
         * @Description:根据id查询本地微信接口信息
         * @param @param id
         * @param @return
         * @param @throws Exception    
         * @return wechatTemplate    
         * @throws
          */
         public  wechatInterface findWechatInterfaceByid(Integer id)  throws Exception;
        /**
         * 
        * @Title: savewechatInterface 
        * @Description: 保存本地微信接口
        * @param     wechatinterface
        * @return void    
        * @throws
         */
         public  void savewechatInterface(wechatInterface wechatinterface) throws Exception;
         /**
          * 
         * @Title: updatewechatInterface 
         * @Description: 更新本地微信接口
         * @param @param wechatinterface
         * @param @throws Exception    
         * @return void    
         * @throws
          */
         public  void updatewechatInterface(wechatInterface wechatinterface) throws Exception;
        /**
         * 
        * @Title: deletewechatInterfacebyId 
        * @Description: 根据id删除本地微信接口
        * @param @param id
        * @param @throws Exception    
        * @return void    
        * @throws
         */
         public  void deletewechatInterfacebyId(Integer id) throws Exception;
         /**
          * 
         * @Title: findWechatInterfaceByName 
         * @Description: 根据名称查询url
         * @param @param name
         * @param @throws Exception    
         * @return wechatInterface    
         * @throws
          */
	 public wechatInterface findWechatInterfaceByName(String name)throws Exception;
}
