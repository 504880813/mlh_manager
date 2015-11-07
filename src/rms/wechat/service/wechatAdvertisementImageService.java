package rms.wechat.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import rms.po.wechatAdvertisementImage;

/**
 * 
* @ClassName: wechatAdvertisementImageService 
* @Description: 微信广告图片操作接口 
* @author 邹家兴 
* @date 2015年10月29日 下午4:56:54 
*
 */
public interface wechatAdvertisementImageService {
    	 /**
    	  * 
    	 * @Title: getAll 
    	 * @Description: 得到所有的图片用于维护
    	 * @param @return
    	 * @param @throws Exception    
    	 * @return List<wechatAdvertisementImage>    
    	 * @throws
    	  */
         public  List<wechatAdvertisementImage> getAll() throws Exception;
         /**
          * 
         * @Title: getAllofusing 
         * @Description: 得到所有在使用的图片 
         * @param @return
         * @param @throws Exception    
         * @return List<wechatAdvertisementImage>    
         * @throws
          */
         public  List<wechatAdvertisementImage> getAllofusing() throws Exception;
         /**
          * 
         * @Title: findwechatAdvertisementImageByid 
         * @Description: 根据id查询微信广告图片 
         * @param @param id
         * @param @return
         * @param @throws Exception    
         * @return wechatAdvertisementImage    
         * @throws
          */
         public  wechatAdvertisementImage findwechatAdvertisementImageByid(Integer id)  throws Exception;
         /**
          * 
         * @Title: saveorupdatewechatAdvertisementImage 
         * @Description: 保存/更新微信广告图片
         * @param @param imageFile
         * @param @param wechatAdvertisementImage
         * @param @throws Exception    
         * @return void    
         * @throws
          */
         public  void saveorupdatewechatAdvertisementImage(MultipartFile imageFile,wechatAdvertisementImage wechatAdvertisementImage) throws Exception;
         
         /**
          * 
         * @Title: changewechatAdvertisementImageStautsByid 
         * @Description: 根据id将微信广告图片状态置反 
         * @param @param id
         * @param @throws Exception    
         * @return void    
         * @throws
          */
         public  void changewechatAdvertisementImageStautsByid(Integer id) throws Exception;
         
         /**
          * 
         * @Title: deletewechatAdvertisementImagebyId 
         * @Description: 根据id删除微信广告图片
         * @param @param id
         * @param @throws Exception    
         * @return void    
         * @throws
          */
         public  void deletewechatAdvertisementImagebyId(Integer id) throws Exception;
}
