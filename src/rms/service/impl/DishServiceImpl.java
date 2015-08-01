package rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import rms.mapper.CustomdishImageMapper;
import rms.mapper.CustomdishMapper;
import rms.mapper.dishImageMapper;
import rms.mapper.dishMapper;
import rms.po.Customdish;
import rms.po.Custommaterials;
import rms.po.dish;
import rms.po.dishImage;
import rms.po.dishcotent;
import rms.service.DishService;
import rms.untils.FileUtils;
/**
 * 
* @ClassName: DishServiceImpl 
* @Description: 菜品实现类
* @author random  
* @date 2015年7月20日 下午3:00:33 
*
 */
@Component
public class DishServiceImpl implements DishService {
	
	@Resource
	private dishMapper dishMapper;
	@Resource
	private CustomdishMapper customdishMapper;
	@Resource
	private dishImageMapper dishImageMapper;
	@Resource
	private CustomdishImageMapper customdishImageMapper;
	
	/*
	 * (非 Javadoc) 
	* <p>Title: findAllDish</p> 
	* <p>Description:查询菜品基础信息 </p> 
	* @return
	* @throws Exception 
	* @see rms.service.DishService#findAllDish()
	 */
	@Override
	public List<Customdish> findAllDish() throws Exception {
		List<Customdish> dishs=customdishMapper.findAllDish();
		return dishs;
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findAllDishByType</p> 
	* <p>Description:根据分类id查询分类下菜品基础信息</p> 
	* @param id
	* @return
	* @throws Exception 
	* @see rms.service.DishService#findAllDishByType(java.lang.Integer)
	 */
	@Override
	public List<Customdish> findAllDishByType(Integer id) throws Exception {
		return customdishMapper.findAllDishByType(id);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findDishWithImageById</p> 
	* <p>Description:根据id查询所有信息 </p> 
	* @param id
	* @return
	* @throws Exception 
	* @see rms.service.DishService#findDishWithImageById(java.lang.Integer)
	 */
	public Customdish findDishWithImageById(Integer id) throws Exception{
		//查询基础信息
		Customdish customdish=new Customdish();
		dish dish=dishMapper.selectByPrimaryKey(id);
		BeanUtils.copyProperties(dish, customdish);
		//查询图片信息
		List<dishImage> dishImages=customdishImageMapper.findDishImageBydishId(customdish.getId());
		customdish.setDishImagesList(dishImages);
		//查询子原料
		List<Custommaterials> custommaList=customdishMapper.findsubMaterialsBydishId(customdish.getId());
		
		if(custommaList!=null){
		customdish.setCustommaterials(custommaList);
		}
		
		//查询子菜品
		List<Customdish> customdishList=customdishMapper.findsubDishBydishId(customdish.getId());
		
		if(customdishList!=null){
		customdish.setSub_customdish(customdishList);;
		}

		return customdish;
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findAllDishWithImage</p> 
	* <p>Description:查询菜品基础信息 并包含图片 </p> 
	* @return
	* @throws Exception 
	* @see rms.service.DishService#findAllDishWithImage()
	 */
	@Override
	public List<Customdish> findAllDishWithImage() throws Exception {
		List<Customdish> dishs=customdishMapper.findAllDish();
		for(Customdish dish:dishs){
			List<dishImage> dishImages=customdishImageMapper.findDishImageBydishId(dish.getId());
			dish.setDishImagesList(dishImages);
		}
		return dishs;
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findAllDishByTypeWithImage</p> 
	* <p>Description:根据分类id查询分类下菜品基础信息并包含图片 </p> 
	* @param id
	* @return
	* @throws Exception 
	* @see rms.service.DishService#findAllDishByTypeWithImage(java.lang.Integer)
	 */
	@Override
	public List<Customdish> findAllDishByTypeWithImage(Integer id)
			throws Exception {
		List<Customdish> dishs=customdishMapper.findAllDishByType(id);
		for(Customdish dish:dishs){
			List<dishImage> dishImages=customdishImageMapper.findDishImageBydishId(dish.getId());
			dish.setDishImagesList(dishImages);
		}
		return dishs;
	}

	/*
	 * (非 Javadoc) 
	* <p>Title: saveDish</p> 
	* <p>Description: 保存菜品所有信息 </p> 
	* @param customdish
	* @throws Exception 
	* @see rms.service.DishService#saveDish(rms.po.Customdish)
	 */
	@Override
	public void saveDish(Customdish customdish) throws Exception {
		
		//存储基础数据并得到主键
		customdishMapper.insertSelectiveRetrunPk(customdish);
		//存储关联数据
		saveDishContent(customdish);
		
		Integer rDishId=customdish.getId();

		//存储图片
		List<dishImage> images=customdish.getDishImagesList();
		if(images!=null && images.size()>0){
			for(dishImage image: images){
				image.setRdishid(rDishId);
				dishImageMapper.insertSelective(image);
			}
		}
		
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: updateDish</p> 
	* <p>Description:更新菜品普通 信息</p> 
	* @param id
	* @param customdish
	* @throws Exception 
	* @see rms.service.DishService#updateDish(java.lang.Integer, rms.po.Customdish)
	 */
	@Override
	public void updateDish(Integer id, Customdish customdish) throws Exception {
		customdish.setId(id);
		//更新基本信息
		dishMapper.updateByPrimaryKeySelective(customdish);
		//更新关联信息
		updateDishContent(customdish);
	}
	
	/*
	 * (非 Javadoc) 
	* <p>Title: deleteDish</p> 
	* <p>Description:根据id删除菜品及图片</p> 
	* @param id
	* @throws Exception 
	* @see rms.service.DishService#deleteDish(java.lang.Integer)
	 */
	@Override
	public void deleteDish(Integer id) throws Exception {
		//删除本地图片数据
		String mappingPath="";
		List<dishImage> dishImages=customdishImageMapper.findDishImageBydishId(id);
		for(dishImage dishImage:dishImages){
			mappingPath=dishImage.getImagepath();
			FileUtils.deleteFileByMapping(FileUtils.dishpath,FileUtils.dishMappingPath,mappingPath);
		}
		//删除数据库图片数据
		customdishImageMapper.deleteDishImageBydishId(id);
		
		//删除数据库菜品数据
		dishMapper.deleteByPrimaryKey(id);
		//删除关联关系
		customdishMapper.deleteDishContentByid(id);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: uploadImage</p> 
	* <p>Description: 上传菜品图片文件</p> 
	* @param dishImages
	* @return 
	* @see rms.service.DishService#uploadImage(org.springframework.web.multipart.MultipartFile[])
	 */
	@Override
	public List<dishImage> uploadImage(MultipartFile[] dishImages) throws Exception {
		List<dishImage> images=null;
		if(dishImages!=null && dishImages.length>0){
			images=new ArrayList<dishImage>();
			for(int i=0;i<dishImages.length;i++){
				
				String imageName=FileUtils.uploadImage(dishImages[i], FileUtils.dishpath);
				
				dishImage dishImage=new dishImage();
				
				dishImage.setImagepath(FileUtils.dishMappingPath+imageName);
				
				images.add(dishImage);
			}
		}
		return images;
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: deleteDishImageByImageid</p> 
	* <p>Description: 根据图片id删除图片</p> 
	* @param imageid 
	* @see rms.service.DishService#deleteDishImageByImageid(java.lang.Integer)
	 */
	@Override
	public void deleteDishImageByImageid(Integer imageid) throws Exception {
		
		dishImage dishImage=dishImageMapper.selectByPrimaryKey(imageid);
		
		FileUtils.deleteFileByMapping(FileUtils.dishpath, FileUtils.dishMappingPath, dishImage.getImagepath());
		
		dishImageMapper.deleteByPrimaryKey(imageid);
		
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: saveDishImage</p> 
	* <p>Description: 根据菜品id保存菜品图片</p> 
	* @param dishImageList
	* @param dishId 
	* @see rms.service.DishService#saveDishImage(java.util.List, java.lang.Integer)
	 */
	@Override
	public void saveDishImage(List<dishImage> dishImageList, Integer dishId) throws Exception{

		for(dishImage image:dishImageList){
			
			image.setRdishid(dishId);
			
			dishImageMapper.insertSelective(image);
		}
		
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findDishByIds</p> 
	* <p>Description: </p> 
	* @param auxiliarydishes
	* @return
	* @throws Exception 
	* @see rms.service.DishService#findDishByIds(java.lang.String)
	 */
	@Override
	public List<Customdish> findDishByIds(String auxiliarydishes)
			throws Exception {
		return customdishMapper.findDishByIds(auxiliarydishes);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: saveDishContent</p> 
	* <p>Description:存储菜品关联关系 </p> 
	* @param customdish
	* @throws Exception 
	* @see rms.service.DishService#saveDishContent(rms.po.Customdish)
	 */
	@Override
	public void saveDishContent(Customdish customdish) throws Exception {
		dishcotent dishcotent=null;
		//原料集合
		List<Custommaterials> materialsList=customdish.getCustommaterials();
		//子菜品集合
		List<Customdish> dishList=customdish.getSub_customdish();
		
		//原料集合不为空则保存
		if(materialsList!=null && materialsList.size()>0){
			for(Custommaterials Custommaterials:materialsList){
				dishcotent=new dishcotent();
				
				dishcotent.setDishid(customdish.getId());
				dishcotent.setMaterialsid(Custommaterials.getId());
				dishcotent.setMaterialsquantity(Custommaterials.getQuantity());
				customdishMapper.insertDishRelation(dishcotent);
			}
		}
		//子菜品集合不为空则保存
		if(dishList!=null && dishList.size()>0){
			for(Customdish dish:dishList){
				dishcotent=new dishcotent();
				
				dishcotent.setDishid(customdish.getId());
				
				dishcotent.setSubdishid(dish.getId());
				dishcotent.setSubdishquantity(dish.getSub_customdish_quantity());
				customdishMapper.insertDishRelation(dishcotent);
			}
		}
	}
	/*
	 * 更新关联关系
	 */
	private void updateDishContent(Customdish customdish) throws Exception {
		
//		Customdish Dbdish=findDishWithImageById(customdish.getId());
		
		//删除数据库中原有关联
		customdishMapper.deleteDishContentByid(customdish.getId());
		
		//重新插入数据
		saveDishContent(customdish);
		
/*		dishcotent dishcotent=null;
		//原料集合
		List<Custommaterials> materialsList=customdish.getCustommaterials();
		//子菜品集合
		List<Customdish> dishList=customdish.getSub_customdish();
		
		//原料集合不为空则保存
		if(materialsList!=null && materialsList.size()>0){
			for(Custommaterials Custommaterials:materialsList){
				dishcotent=new dishcotent();
				dishcotent.setDishid(customdish.getId());
				dishcotent.setMaterialsid(Custommaterials.getId());
				dishcotent.setMaterialsquantity(Custommaterials.getQuantity());
				boolean isupdate=false;
				for(Custommaterials dbm:Dbdish.getCustommaterials()){
					if(dbm.getId()==Custommaterials.getId()){
						//更新
						customdishMapper.updateDishRelation(dishcotent);
						isupdate=true;
					}
				}
				if(!isupdate){
					//插入新纪录
					customdishMapper.insertDishRelation(dishcotent);
				}
				
			}
		}else{
			//清空原料相关关联数据
			dishcotent=new dishcotent();
			dishcotent.setDishid(customdish.getId());
			
			customdishMapper.updateDishRelation(dishcotent);
		}
		//子菜品集合不为空则保存
		if(dishList!=null && dishList.size()>0){
			for(Customdish dish:dishList){
				dishcotent=new dishcotent();
				dishcotent.setDishid(customdish.getId());
				dishcotent.setSubdishid(dish.getId());
				dishcotent.setSubdishquantity(dish.getSub_customdish_quantity());
				boolean isupdate=false;
				for(Customdish dbdish:Dbdish.getSub_customdish()){
					if(dbdish.getId()==dish.getId()){
						//更新
						customdishMapper.updateDishRelation(dishcotent);
						isupdate=true;
					}
				}
				if(!isupdate){
					//插入新纪录
					customdishMapper.insertDishRelation(dishcotent);
				}
			}
		}else{
			//清空菜品相关的关联数据
			dishcotent=new dishcotent();
			dishcotent.setDishid(customdish.getId());
			
			customdishMapper.updateDishRelation(dishcotent);
		}*/
		
	}


}
