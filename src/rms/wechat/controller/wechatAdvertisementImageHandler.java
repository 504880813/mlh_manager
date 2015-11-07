package rms.wechat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import rms.po.wechatAdvertisementImage;
import rms.wechat.service.wechatAdvertisementImageService;

/**
 * 
* @ClassName: wechatAdvertisementImageHandler 
* @Description:处理微信广告图片管理相关的请求
* @author 邹家兴 
* @date 2015年10月29日 下午5:53:10 
*
 */
@RequestMapping("wechatAdvertisementImage")
@Component
public class wechatAdvertisementImageHandler {
    
        @Resource
        private wechatAdvertisementImageService wechatAdvertisementImageService;
        /**
         * 
        * @Title: getAllAdvertisementImage 
        * @Description: 得到所有的微信广告图片用于管理
        * @param @return
        * @param @throws Exception    
        * @return ModelAndView    
        * @throws
         */
        @RequestMapping("getAllAdvertisementImage")
        public ModelAndView getAllAdvertisementImage() throws Exception{
        	
        	List<wechatAdvertisementImage> wechatAdvertisementImages=wechatAdvertisementImageService.getAll();
        	ModelAndView mav=new ModelAndView();
        	
        	mav.addObject("wechatAdvertisementImages", wechatAdvertisementImages);
        	
        	mav.setViewName("wechatAdvertisementImageManager/wechatAdvertisementImageList");
        	
        	return mav;
        }
        /**
         * 
        * @Title: addwechatAdvertisementImage 
        * @Description: 为添加本地微信广告图片准备数据
        * @param @return
        * @param @throws Exception    
        * @return String    
        * @throws
         */
        @RequestMapping("addwechatAdvertisementImage")
        public String addwechatAdvertisementImage() throws Exception{
    		return "wechatAdvertisementImageManager/saveoreditwechatAdvertisementImage";
        }
        /**
         * 
        * @Title: editwechatAdvertisementImage 
        * @Description: 根据id为本地微信广告图片
        * @param @param id
        * @param @return
        * @param @throws Exception    
        * @return String    
        * @throws
         */
        @RequestMapping("editwechatAdvertisementImage")
        public ModelAndView editwechatAdvertisementImage(Integer id) throws Exception{
        	wechatAdvertisementImage wechatAdvertisementImage=wechatAdvertisementImageService.findwechatAdvertisementImageByid(id);
        	ModelAndView mav=new ModelAndView();
        	mav.addObject("wechatAdvertisementImage", wechatAdvertisementImage);
        	mav.setViewName("wechatAdvertisementImageManager/saveoreditwechatAdvertisementImage");
        	return mav;
        }
        /**
         * 
        * @Title: addwechatAdvertisementImageSubmit 
        * @Description: 添加/修改 本地微信广告图片
        * @param @param imageFile
        * @param @param AdvertisementImage
        * @param @return    
        * @return String    
        * @throws
         */
        @RequestMapping("addoreditwechatAdvertisementImageSubmit")
        public String addoreditwechatAdvertisementImageSubmit(MultipartFile imageFile,wechatAdvertisementImage wechatAdvertisementImage) throws Exception{
        	wechatAdvertisementImageService.saveorupdatewechatAdvertisementImage(imageFile, wechatAdvertisementImage);
        	return "redirect:getAllAdvertisementImage.action";
        }
        /**
         * 
        * @Title: deletewechatAdvertisementImage 
        * @Description: 根据id删除本地微信广告图片
        * @param @param id
        * @param @return    
        * @return String    
        * @throws
         */
        @RequestMapping("deletewechatAdvertisementImage")
        public String deletewechatAdvertisementImage(Integer id) throws Exception{
        	wechatAdvertisementImageService.deletewechatAdvertisementImagebyId(id);
        	return "redirect:getAllAdvertisementImage.action";
        }
        
        
}
