package rms.wechat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import rms.controller.exception.CustomException;
import rms.mapper.wechatAdvertisementImageMapper;
import rms.po.wechatAdvertisementImage;
import rms.po.wechatAdvertisementImageExample;
import rms.untils.FileUtils;
import rms.wechat.service.wechatAdvertisementImageService;
/**
 * 
* @ClassName: wechatAdvertisementImageServiceImpl 
* @Description: 微信广告图片接口实现 
* @author 邹家兴 
* @date 2015年10月29日 下午5:23:53 
*
 */
@Component
public class wechatAdvertisementImageServiceImpl implements
	wechatAdvertisementImageService {

    @Resource
    private wechatAdvertisementImageMapper wechatAdvertisementImageMapper;
    
    
    
    /*
     * (非 Javadoc) 
    * <p>Title: getAll</p> 
    * <p>Description:得到所有的微信广告图片用于管理</p> 
    * @return
    * @throws Exception 
    * @see rms.wechat.service.wechatAdvertisementImageService#getAll()
     */
    @Override
    public List<wechatAdvertisementImage> getAll() throws Exception {
	wechatAdvertisementImageExample example=new wechatAdvertisementImageExample();
	example.createCriteria().andIdIsNotNull();
	return wechatAdvertisementImageMapper.selectByExample(example);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: getAllofusing</p> 
    * <p>Description:查询所有正在使用的微信广告图片 </p> 
    * @return
    * @throws Exception 
    * @see rms.wechat.service.wechatAdvertisementImageService#getAllofusing()
     */
    @Override
    public List<wechatAdvertisementImage> getAllofusing() throws Exception {
	wechatAdvertisementImageExample example=new wechatAdvertisementImageExample();
	example.createCriteria().andIdIsNotNull().andUsingstatusEqualTo(true);
	List<wechatAdvertisementImage> images=wechatAdvertisementImageMapper.selectByExample(example);
	return images;
	
    }
    /*
     * (非 Javadoc) 
    * <p>Title: findwechatAdvertisementImageByid</p> 
    * <p>Description:根据id查询微信广告图片</p> 
    * @param id
    * @return
    * @throws Exception 
    * @see rms.wechat.service.wechatAdvertisementImageService#findwechatAdvertisementImageByid(java.lang.Integer)
     */
    @Override
    public wechatAdvertisementImage findwechatAdvertisementImageByid(Integer id)
	    throws Exception {
	wechatAdvertisementImageExample example=new wechatAdvertisementImageExample();
	example.createCriteria().andIdEqualTo(id);
	List<wechatAdvertisementImage> images=wechatAdvertisementImageMapper.selectByExample(example);
	return (images==null||images.size()<=0)?null:images.get(0);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: saveorupdatewechatAdvertisementImage</p> 
    * <p>Description:保存或更新图片</p> 
    * @param @param imageFile
    * @param @param wechatAdvertisementImage
    * @throws Exception 
    * @see rms.wechat.service.wechatAdvertisementImageService#saveorupdatewechatAdvertisementImage(rms.po.wechatAdvertisementImage)
     */
    @Override
    public void saveorupdatewechatAdvertisementImage(MultipartFile imageFile,
	    wechatAdvertisementImage wechatAdvertisementImage) throws Exception {
	if(wechatAdvertisementImage==null) throw new CustomException("数据异常");
	
	//添加
	if(wechatAdvertisementImage.getId()==null) {
	    //是否有图片
	    if(imageFile!=null&&imageFile.getSize()>0) {
		wechatAdvertisementImage=uploadImage(imageFile, wechatAdvertisementImage);
	    }
	    //保存数据
	    wechatAdvertisementImageMapper.insertSelective(wechatAdvertisementImage);
	}else {
	//修改
	    //是否有图片
	    if(imageFile!=null&&imageFile.getSize()>0) {
		wechatAdvertisementImage=uploadImage(imageFile, wechatAdvertisementImage);
	    }
	    //更新数据
	    wechatAdvertisementImageMapper.updateByPrimaryKey(wechatAdvertisementImage);
	}
	
    }
    /*
     * (非 Javadoc) 
    * <p>Title: changewechatAdvertisementImageStautsByid</p> 
    * <p>Description:改变微信广告图片状态</p> 
    * @param id
    * @throws Exception 
    * @see rms.wechat.service.wechatAdvertisementImageService#changewechatAdvertisementImageStautsByid(java.lang.Integer)
     */
    @Override
    public void changewechatAdvertisementImageStautsByid(Integer id)
	    throws Exception {
	//查询
	wechatAdvertisementImage image=wechatAdvertisementImageMapper.selectByPrimaryKey(id);
	boolean useingstatus=image.getUsingstatus();
	image.setUsingstatus(!useingstatus);
	//更新
	wechatAdvertisementImageMapper.updateByPrimaryKey(image);
    }
    /*
     * (非 Javadoc) 
    * <p>Title: deletewechatAdvertisementImagebyId</p> 
    * <p>Description:根据id删除微信广告图片</p> 
    * @param id
    * @throws Exception 
    * @see rms.wechat.service.wechatAdvertisementImageService#deletewechatAdvertisementImagebyId(java.lang.Integer)
     */
    @Override
    public void deletewechatAdvertisementImagebyId(Integer id) throws Exception {
	//先删除图片
	wechatAdvertisementImage image=wechatAdvertisementImageMapper.selectByPrimaryKey(id);
	
	FileUtils.deleteFileByMapping(FileUtils.wechatAdvertisementpath, FileUtils.wechatAdvertisementMappingPath, image.getPath());
	//删除数据库记录
	wechatAdvertisementImageMapper.deleteByPrimaryKey(id);
    }
    
    /**
     * 
    * @Title: uploadImage 
    * @Description: 上传图片
    * @param @param imageFile
    * @param @param wechatAdvertisementImage
    * @param @return
    * @param @throws Exception    
    * @return wechatAdvertisementImage    
    * @throws
     */
    private wechatAdvertisementImage uploadImage(MultipartFile imageFile,wechatAdvertisementImage wechatAdvertisementImage) throws Exception{
	
	String ImageMapperpath=FileUtils.uploadImage(imageFile, FileUtils.wechatAdvertisementpath);
	
	wechatAdvertisementImage.setPath(FileUtils.wechatAdvertisementMappingPath+ImageMapperpath);
	
	return wechatAdvertisementImage;
    }

}
