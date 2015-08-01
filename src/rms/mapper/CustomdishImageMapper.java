package rms.mapper;

import java.util.List;

import rms.po.dishImage;

/**
 * 
* @ClassName: CustomdishImageMapper 
* @Description: 自定义菜品图片mapper
* @author random  
* @date 2015年7月20日 下午3:08:19 
*
 */
public interface CustomdishImageMapper {
    /**
     * 
    * @Title: findDishImageBydishId 
    * @Description: 根据菜品id查询菜品图片 
    * @param @param dishId
    * @param @return
    * @param @throws Exception    设定文件 
    * @return List<dishImage>    返回类型 
    * @throws
     */
	public List<dishImage> findDishImageBydishId(Integer dishId) throws Exception;
	
	/**
	 * 
	* @Title: deleteDishImageBydishId 
	* @Description: 根据菜品id删除菜品图片信息
	* @param @param dishId
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteDishImageBydishId(Integer dishId) throws Exception;
}