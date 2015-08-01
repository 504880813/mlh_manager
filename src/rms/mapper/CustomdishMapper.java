package rms.mapper;

import java.util.List;

import rms.po.Customdish;
import rms.po.Custommaterials;
import rms.po.dishcotent;

/**
 * 
* @ClassName: CustomdishMapper 
* @Description: 自定义菜品mapper 
* @author random  
* @date 2015年7月16日 下午4:22:57 
*
 */
public interface CustomdishMapper {
	/**
	 * 
	* @Title: findAllDish 
	* @Description: 查询所有菜品信息 
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<Customdish>    返回类型 
	* @throws
	 */
	public List<Customdish> findAllDish() throws Exception;
	
	/**
	 * 
	* @Title: findAllDishByType 
	* @Description: 根据分类ID查询分类所有菜品信息 
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<Customdish>    返回类型 
	* @throws
	 */
	public List<Customdish> findAllDishByType(Integer id) throws Exception; 
	/**
	 * 
	* @Title: insertSelectiveRetrunPk 
	* @Description: 插入菜品信息，并返回主键(返回到customdish的id里)
	* @param @param customdish
	* @param @return
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void insertSelectiveRetrunPk(Customdish customdish) throws Exception;
	/**
	 * 
	* @Title: findDishByIds 
	* @Description: 查询id在auxiliarydishes内的菜品
	* @param @param auxiliarydishes  形如 1,2,3
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<Customdish>    返回类型 
	* @throws
	 */
	public List<Customdish> findDishByIds(String auxiliarydishes)throws Exception;
	/**
	 * 
	* @Title: findsubMaterialsBydishId 
	* @Description: 根据菜品id查询原料
	* @param @param id
	* @param @return    设定文件 
	* @return List<Custommaterials>    返回类型 
	* @throws
	 */
	public List<Custommaterials> findsubMaterialsBydishId(Integer id) throws Exception;
	/**
	 * 
	* @Title: findsubDishBydishId 
	* @Description: 根据菜品id查询子菜品
	* @param @param id
	* @param @return    设定文件 
	* @return List<Customdish>    返回类型 
	* @throws
	 */
	public List<Customdish> findsubDishBydishId(Integer id) throws Exception;
	/**
	 * 
	* @Title: insertDishRelation 
	* @Description: 存储菜品关联数据 
	* @param @param dishcotent    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void insertDishRelation(dishcotent dishcotent) throws Exception;
	/**
	 * 
	* @Title: updateDishRelation 
	* @Description: 更新菜品关联数据 
	* @param @param dishcotent
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateDishRelation(dishcotent dishcotent) throws Exception;
	
	/**
	 * 
	* @Title: deleteDishContentByid 
	* @Description: 根据id 删除数据库中原有的关联关系 
	* @param @param id
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteDishContentByid(Integer id) throws Exception;
	
}