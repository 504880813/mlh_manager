package rms.mapper;

import java.util.List;

import rms.po.Custommaterials;
import rms.po.materials;

/**
 * 
* @ClassName: CustommaterialsMapper 
* @Description: 原料操作扩展mapper 
* @author random  
* @date 2015年7月16日 下午3:54:25 
*
 */
public interface CustommaterialsMapper {
    	
    
    	/**
    	 * 
    	* @Title: insertSelectiveRetrunPk 
    	* @Description: 保存原料并返回主键
    	* @param @param materials
    	* @param @return
    	* @param @throws Exception    
    	* @return Integer    
    	* @throws
    	 */
    	public Integer insertSelectiveRetrunPk(materials materials) throws Exception;
	/**
	 * 
	* @Title: findAll 
	* @Description: 查询所有原料
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<Custommaterials>    返回类型 
	* @throws
	 */
	public List<Custommaterials> findAll() throws Exception;
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
	public List<materials> findMaterialsByIds(String rmaterialsid) throws Exception;
    
}