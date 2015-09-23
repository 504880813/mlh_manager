package rms.wechat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import rms.controller.exception.CustomException;
import rms.mapper.wechatInterfaceMapper;
import rms.mapper.wechatTemplateMapper;
import rms.po.wechatInterface;
import rms.po.wechatInterfaceExample;
import rms.po.wechatTemplate;
import rms.po.wechatTemplateExample;
import rms.wechat.service.wechatInterfaceService;
import rms.wechat.service.wechatTemplateService;
/**
 * 
* @ClassName: wechatInterfaceServiceImpl 
* @Description: 微信本地接口crud逻辑操作
* @author 邹家兴 
* @date 2015年9月23日 下午11:17:15 
*
 */
@Component
public class wechatInterfaceServiceImpl implements wechatInterfaceService {
    
    @Resource
    private wechatInterfaceMapper wechatInterfaceMapper;
    /*
     * (非 Javadoc) 
    * <p>Title: getAll</p> 
    * <p>Description:得到所有的本地微信接口</p> 
    * @return
    * @throws Exception 
    * @see rms.wechat.service.wechatInterfaceService#getAll()
     */
    @Override
    public List<wechatInterface> getAll() throws Exception {
	wechatInterfaceExample example=new wechatInterfaceExample();
	example.createCriteria().andIdIsNotNull();
	return wechatInterfaceMapper.selectByExample(example);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: findWechatInterfaceByid</p> 
    * <p>Description:根据id查询本地微信接口</p> 
    * @param id
    * @return
    * @throws Exception 
    * @see rms.wechat.service.wechatInterfaceService#findWechatInterfaceByid(java.lang.Integer)
     */
    @Override
    public wechatInterface findWechatInterfaceByid(Integer id) throws Exception {
	return wechatInterfaceMapper.selectByPrimaryKey(id);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: savewechatInterface</p> 
    * <p>Description:保存本地微信接口</p> 
    * @param wechatinterface
    * @throws Exception 
    * @see rms.wechat.service.wechatInterfaceService#savewechatInterface(rms.po.wechatInterface)
     */
    @Override
    public void savewechatInterface(wechatInterface wechatinterface)
	    throws Exception {
	//确保name唯一
	wechatInterface dbwechatInterface=findWechatInterfaceByName(wechatinterface.getName());
	if(dbwechatInterface==null) {
	    wechatInterfaceMapper.insertSelective(wechatinterface);
	}else {
	    throw new CustomException("该名称已经存在，不能重复添加");
	}
	
    }
    /*
     * (非 Javadoc) 
    * <p>Title: updatewechatInterface</p> 
    * <p>Description:更新本地微信接口</p> 
    * @param wechatinterface
    * @throws Exception 
    * @see rms.wechat.service.wechatInterfaceService#updatewechatInterface(rms.po.wechatInterface)
     */
    @Override
    public void updatewechatInterface(wechatInterface wechatinterface)
	    throws Exception {
	//确保name唯一
	wechatInterface dbwechatInterface=findWechatInterfaceByName(wechatinterface.getName());
	if(dbwechatInterface==null) {
	    wechatInterfaceMapper.updateByPrimaryKey(wechatinterface);
	}else {
	    throw new CustomException("该名称已经存在，不能重复添加");
	}
    }
    /*
     * (非 Javadoc) 
    * <p>Title: deletewechatInterfacebyId</p> 
    * <p>Description:根据id删除本地微信接口</p> 
    * @param id
    * @throws Exception 
    * @see rms.wechat.service.wechatInterfaceService#deletewechatInterfacebyId(java.lang.Integer)
     */
    @Override
    public void deletewechatInterfacebyId(Integer id) throws Exception {
	wechatInterfaceMapper.deleteByPrimaryKey(id);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: findWechatInterfaceByName</p> 
    * <p>Description:根据名称查询微信本地接口</p> 
    * @param name
    * @return
    * @throws Exception 
    * @see rms.wechat.service.wechatInterfaceService#findWechatInterfaceByName(java.lang.String)
     */
    @Override
    public wechatInterface findWechatInterfaceByName(String name)
	    throws Exception {
	wechatInterfaceExample example=new wechatInterfaceExample();
	example.createCriteria().andNameEqualTo(name);
	List<wechatInterface> wechatInterfaces=wechatInterfaceMapper.selectByExample(example);
	if(wechatInterfaces!=null||wechatInterfaces.size()!=0) {
	    return wechatInterfaces.get(0);
	}
	return null;
    }

}
