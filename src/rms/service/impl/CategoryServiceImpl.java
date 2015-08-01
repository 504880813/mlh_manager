package rms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import rms.mapper.CustomcategoryMapper;
import rms.mapper.categoryMapper;
import rms.po.Customcategory;
import rms.po.category;
import rms.service.CategoryService;
/**
 * 
* @ClassName: CategoryServiceImpl 
* @Description: 分类实现 
* @author random  
* @date 2015年7月16日 上午9:22:58 
*
 */
@Component
public class CategoryServiceImpl implements CategoryService {
	
	@Resource
	private CustomcategoryMapper customcategoryMapper;
	@Resource
	private categoryMapper categoryMapper;
	/*
	 * (非 Javadoc) 
	* <p>Title: saveCategory</p> 
	* <p>Description:保存分类 </p> 
	* @param customcategory
	* @throws Exception 
	* @see rms.service.impl.CategoryService#saveCategory(rms.po.Customcategory)
	 */
	@Override
	public void saveCategory(Customcategory customcategory) throws Exception {
		categoryMapper.insertSelective(customcategory);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: updateCategory</p> 
	* <p>Description:更新分类 </p> 
	* @param id
	* @param customcategory
	* @throws Exception 
	* @see rms.service.impl.CategoryService#updateCategory(java.lang.Integer, rms.po.Customcategory)
	 */
	@Override
	public void updateCategory(Integer id, Customcategory customcategory)
			throws Exception {
		customcategory.setId(id);
		categoryMapper.updateByPrimaryKeySelective(customcategory);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: deleteCategory</p> 
	* <p>Description:根据id删除分类 </p> 
	* @param id
	* @throws Exception 
	* @see rms.service.impl.CategoryService#deleteCategory(java.lang.Integer)
	 */
	@Override
	public void deleteCategory(Integer id) throws Exception {
		categoryMapper.deleteByPrimaryKey(id);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findAllCategory</p> 
	* <p>Description: 查询所有分类</p> 
	* @throws Exception 
	* @see rms.service.impl.CategoryService#findAllCategory()
	 */
	@Override
	public List<Customcategory> findAllCategory() throws Exception {
//		categoryMapper.selectByPrimaryKey(id);
		return customcategoryMapper.selectAllCategory();
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findCategoryById</p> 
	* <p>Description:根据id查询分类 </p> 
	* @param id
	* @throws Exception 
	* @see rms.service.impl.CategoryService#findCategoryById(java.lang.Integer)
	 */
	@Override
	public Customcategory findCategoryById(Integer id) throws Exception {

		Customcategory customcategory=new Customcategory();
		category category=categoryMapper.selectByPrimaryKey(id);
		BeanUtils.copyProperties(category, customcategory);
		return customcategory;
	
	}

}
