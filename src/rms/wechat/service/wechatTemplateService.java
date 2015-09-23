package rms.wechat.service;

import java.util.List;

import rms.po.wechatTemplate;


/**
 * 
* @ClassName: wechatTemplateService 
* @Description: 微信模板消息相关业务
* @author 邹家兴 
* @date 2015年9月23日 下午3:57:45 
*
 */
public interface wechatTemplateService {
    	 /**
    	  * 
    	 * @Title: getAll 
    	 * @Description: 得到所有的消息模板 
    	 * @param @return
    	 * @param @throws Exception    
    	 * @return List<wechatTemplate>    
    	 * @throws
    	  */
         public  List<wechatTemplate> getAll() throws Exception;
         /**
          * 
         * @Title: findWechatTemplateByid 
         * @Description: 根据id查询消息模板 
         * @param @param id
         * @param @return
         * @param @throws Exception    
         * @return wechatTemplate    
         * @throws
          */
         public  wechatTemplate findWechatTemplateByid(Integer id)  throws Exception;
         /**
          * 
         * @Title: savewechatTemplate 
         * @Description: 保存消息模板
         * @param @param template
         * @param @throws Exception    
         * @return void    
         * @throws
          */
         public  void savewechatTemplate(wechatTemplate template) throws Exception;
         /**
          * 
         * @Title: updatewechatTemplate 
         * @Description: 更新消息模板
         * @param @param template
         * @param @throws Exception    
         * @return void    
         * @throws
          */
         public  void updatewechatTemplate(wechatTemplate template) throws Exception;
         /**
          * 
         * @Title: deletewechatTemplatebyId 
         * @Description: 根据id删除消息模板
         * @param @param id
         * @param @throws Exception    
         * @return void    
         * @throws
          */
         public  void deletewechatTemplatebyId(Integer id) throws Exception;
}
