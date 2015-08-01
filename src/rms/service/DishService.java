package rms.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import rms.po.Customdish;
import rms.po.dishImage;

/**
 * 
* @ClassName: DishService 
* @Description: 菜品操作接口
* @author random  
* @date 2015年7月16日 下午4:24:16 
*
 */
public interface DishService {
	/**
	 * 
	* @Title: findAllDish 
	* @Description: 查询所有菜品 
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<Customdish>    返回类型 
	* @throws
	 */
	public List<Customdish> findAllDish() throws Exception;
	
	/**
	 * 
	* @Title: findAllDishByType 
	* @Description: 根据分类id查询分类下的所有菜品 
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<Customdish>    返回类型 
	* @throws
	 */
	public List<Customdish> findAllDishByType(Integer id) throws Exception;
	
	/**
	 * 
	* @Title: findAllDishWithImage 
	* @Description: 查询所有菜品信息包括图片
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<Customdish>    返回类型 
	* @throws
	 */
	public List<Customdish> findAllDishWithImage() throws Exception;
	
	/**
	 * 
	* @Title: findAllDishWithImage 
	* @Description: 根据id查询菜品信息包括图片
	* @param @return
	* @param @throws Exception    设定文件 
	* @return Customdish    返回类型 
	* @throws
	 */
	public Customdish findDishWithImageById(Integer id) throws Exception;
	
	/**
	 * 
	* @Title: findAllDishByTypeWithImage 
	* @Description: 根据分类ID查询分类所有菜品信息 包括图片
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<Customdish>    返回类型 
	* @throws
	 */
	public List<Customdish> findAllDishByTypeWithImage(Integer id) throws Exception; 
	
	/**
	 * 
	* @Title: saveDish 
	* @Description: 存储菜品信息 
	* @param @param customdish
	* @param @throws Exception    设定文件 
	* @return void
	* @throws
	 */
	public void saveDish(Customdish customdish) throws Exception;
	/**
	 * 
	* @Title: updateDish 
	* @Description: 更新菜品信息
	* @param @param id
	* @param @param customdish
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateDish(Integer id,Customdish customdish) throws Exception;
	/**
	 * 
	* @Title: deleteDish 
	* @Description: 删除菜品信息
	* @param @param id
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteDish(Integer id) throws Exception;
	/**
	 * 
	* @Title: uploadImage 
	* @Description: 上传菜品图片文件
	* @param @param dishImages
	* @param @return    设定文件 
	* @return List<dishImage>    返回类型 
	* @throws
	 */
	public List<dishImage> uploadImage(MultipartFile[] dishImages) throws Exception;
	/**
	 * 
	* @Title: deleteDishImageByImageid 
	* @Description: 根据图片id删除图片
	* @param @param imageid    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteDishImageByImageid(Integer imageid) throws Exception;
	/**
	 * 
	* @Title: saveDishImage 
	* @Description: 根据菜品id保存菜品图片
	* @param @param dishImageList
	* @param @param dishId    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void saveDishImage(List<dishImage> dishImageList, Integer dishId) throws Exception;
	/**
	 * 
	* @Title: findDishByIds 
	* @Description: 查询id在auxiliarydishes字符串类的菜品
	* @param @param auxiliarydishes 形如  1,2,3
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<Customdish>    返回类型 
	* @throws
	 */
	public List<Customdish> findDishByIds(String auxiliarydishes) throws Exception;
	/**
	 * 
	* @Title: saveDishContent 
	* @Description: 
	* @param @throws EXception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void saveDishContent(Customdish customdish) throws Exception;
	
}	