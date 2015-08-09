package rms.service;

import java.util.List;

import rms.po.Customcategory;


/**
 * 
* @ClassName: CategoryService 
* @Description: 分类操作接口 
* @author random
* @date 2015年7月15日 上午11:37:23 
*
 */
public interface CategoryService {
	/**
	 * 
	* @Title: saveCategory 
	* @Description: 保存分类
	* @param @param customcategory
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void saveCategory(Customcategory customcategory) throws Exception;
	/**
	 * 
	* @Title: updateCategory 
	* @Description: 更新
	* @param @param id
	* @param @param customcategory
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateCategory(Integer id,Customcategory customcategory) throws Exception;
	/**
	 * 
	* @Title: deleteCategory 
	* @Description: 根据ID删除分类 
	* @param @param id
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteCategory(Integer id) throws Exception;
	/**
	 * 
	* @Title: findAllCategory 
	* @Description: 查询所有分类
	* @param @throws Exception    设定文件 
	* @return List<Customcategory>    返回类型 
	* @throws
	 */
	public List<Customcategory> findAllCategory()throws Exception;
	/**
	 * 
	* @Title: findCategoryById 
	* @Description: 根据id查询分类
	* @param @param id
	* @param @throws Exception    设定文件 
	* @return Customcategory    返回类型 
	* @throws
	 */
	public Customcategory findCategoryById(Integer id)throws Exception;
}
