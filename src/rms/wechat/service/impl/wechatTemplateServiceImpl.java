package rms.wechat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import rms.mapper.wechatTemplateMapper;
import rms.po.wechatTemplate;
import rms.po.wechatTemplateExample;
import rms.wechat.service.wechatTemplateService;
/**
 * 
* @ClassName: wechatTemplateServiceImpl 
* @Description: 微信模板消息相关逻辑处理
* @author 邹家兴 
* @date 2015年9月23日 下午3:58:47 
*
 */
@Component
public class wechatTemplateServiceImpl implements wechatTemplateService {
    
    @Resource
    private wechatTemplateMapper wechatTemplateMapper;
    /*
     * (非 Javadoc) 
    * <p>Title: getAll</p> 
    * <p>Description:得到所有的消息模板 </p> 
    * @return
    * @throws Exception 
    * @see rms.wechat.service.wechatTemplateService#getAll()
     */
    @Override
    public List<wechatTemplate> getAll() throws Exception {
	wechatTemplateExample example=new wechatTemplateExample();
	example.createCriteria().andIdIsNotNull();
	return wechatTemplateMapper.selectByExample(example);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: findWechatTemplateByid</p> 
    * <p>Description:根据id查询消息模板</p> 
    * @param id
    * @return
    * @throws Exception 
    * @see rms.wechat.service.wechatTemplateService#findWechatTemplateByid(java.lang.Integer)
     */
    @Override
    public wechatTemplate findWechatTemplateByid(Integer id) throws Exception {
	return wechatTemplateMapper.selectByPrimaryKey(id);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: savewechatTemplate</p> 
    * <p>Description:保存消息模板</p> 
    * @param template
    * @throws Exception 
    * @see rms.wechat.service.wechatTemplateService#savewechatTemplate(rms.po.wechatTemplate)
     */
    @Override
    public void savewechatTemplate(wechatTemplate template) throws Exception {
	wechatTemplateMapper.insertSelective(template);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: updatewechatTemplate</p> 
    * <p>Description: 更新消息模板</p> 
    * @param template
    * @throws Exception 
    * @see rms.wechat.service.wechatTemplateService#updatewechatTemplate(rms.po.wechatTemplate)
     */
    @Override
    public void updatewechatTemplate(wechatTemplate template) throws Exception {
	wechatTemplateMapper.updateByPrimaryKey(template);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: deletewechatTemplatebyId</p> 
    * <p>Description: 根据id删除消息模板</p> 
    * @param id
    * @throws Exception 
    * @see rms.wechat.service.wechatTemplateService#deletewechatTemplatebyId(java.lang.Integer)
     */
    @Override
    public void deletewechatTemplatebyId(Integer id) throws Exception {
	wechatTemplateMapper.deleteByPrimaryKey(id);
    }

}
