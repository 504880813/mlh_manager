package rms.wechat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import rms.controller.exception.CustomException;
import rms.mapper.wechatTemplateMapper;
import rms.po.wechatInterface;
import rms.po.wechatTemplate;
import rms.po.wechatTemplateExample;
import rms.po.wechatuser;
import rms.wechat.Enumeration.wechatInterfaceEnumeration;
import rms.wechat.entity.TemplateMessage;
import rms.wechat.service.wechatInterfaceService;
import rms.wechat.service.wechatTemplateService;
import rms.wechat.service.wechatuserService;
import rms.wechat.untils.HttpUtils;
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
    @Resource
    private wechatuserService wechatuserService;
    @Resource
    private wechatInterfaceService wechatInterfaceService;
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
	wechatTemplate dbtemplate=findWechatTemplateBytemplateid(template.getTemplateId());
	if(dbtemplate==null) {
	    wechatTemplateMapper.insertSelective(template);
	}else {
	    throw new CustomException("已经存在相同模板");
	}
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
    /*
     * (非 Javadoc) 
    * <p>Title: sendTemplateMessageTouser</p> 
    * <p>Description:发送模板消息</p> 
    * @param message
    * @throws Exception 
    * @see rms.wechat.service.wechatTemplateService#sendTemplateMessageTouser(rms.wechat.entity.TemplateMessage)
     */
    @Override
    public void sendTemplateMessageTouser(TemplateMessage message)
	    throws Exception {
	List<wechatuser> user=wechatuserService.getAll();
	if(user==null||user.size()==0) {
	    throw new CustomException("暂无公众号信息，请先初始化公众号");
	}
	String access_token=wechatuserService.getaccess_token(user.get(0));
	wechatInterface wechatinterface=wechatInterfaceService.findWechatInterfaceByName(wechatInterfaceEnumeration.sendTemplateMessage.value);
	if(wechatinterface==null||wechatinterface.getUrl()==null) {
	    throw new CustomException("微信接口信息不全，请先检查本地接口配置");
	}
	HttpUtils.sendTemplateMessage(message,access_token,wechatinterface.getUrl());
    }
    /*
     * (非 Javadoc) 
    * <p>Title: findWechatTemplateBytemplateid</p> 
    * <p>Description: 根据模板id查询模板</p> 
    * @param templateId
    * @return
    * @throws Exception 
    * @see rms.wechat.service.wechatTemplateService#findWechatTemplateBytemplateid(java.lang.String)
     */
    @Override
    public wechatTemplate findWechatTemplateBytemplateid(String templateId)
	    throws Exception {
	wechatTemplateExample example=new wechatTemplateExample();
	example.createCriteria().andTemplateIdEqualTo(templateId);
	List<wechatTemplate> templates=wechatTemplateMapper.selectByExample(example);
	if(templates==null||templates.size()==0) {
	    return null;
	}
	return templates.get(0);
    }

}
