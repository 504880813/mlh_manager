package rms.mapper;

import java.util.List;

import rms.po.Customcategory;

/**
 * 
* @ClassName: CustomcategoryMapper 
* @Description: 分类mapper扩展类 
* @author random  
* @date 2015年7月16日 上午9:11:39 
*
 */
public interface CustomcategoryMapper {
	/**
	 * 
	* @Title: selectAllCategory 
	* @Description: 查询所有分类 
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List    返回类型 
	* @throws
	 */
	public List<Customcategory> selectAllCategory() throws Exception;
}