package rms.service;

import java.util.List;

import rms.po.Custommaterials;
import rms.po.materials;

/**
 * 
* @ClassName: MaterialsService 
* @Description: 原料操作接口 
* @author random  
* @date 2015年7月16日 下午1:54:24 
*
 */
public interface MaterialsService {
	/**
	 * 
	* @Title: saveMaterials 
	* @Description: 存储原料
	* @param @param materials
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void saveMaterials(materials materials) throws Exception;
	/**
	 * 
	* @Title: updateMaterials 
	* @Description: 更新原料 
	* @param @param id
	* @param @param materials
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateMaterials(Integer id,materials materials) throws Exception;
	/**
	 * 
	* @Title: deleteMaterials 
	* @Description: 根据id删除原料
	* @param @param id
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteMaterials(Integer id) throws Exception;
	/**
	 * 
	* @Title: findAllMaterials 
	* @Description:	查询所有原料
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<Custommaterials>    返回类型 
	* @throws
	 */
	public List<Custommaterials> findAllMaterials() throws Exception;
	/**
	 * 
	* @Title: findMaterialsById 
	* @Description: 根据id查询原料
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return Custommaterials    返回类型 
	* @throws
	 */
	public Custommaterials findMaterialsById(Integer id) throws Exception;
	/**
	* @Title: findMaterialsByIds 
	* @Description: 查询id在rmaterialsid字符串类的原料
	* @param @param rmaterialsid 形如  1,2,3
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<materials>    返回类型 
	* @throws
	 */
	public List<materials> findMaterialsByIds(String rmaterialsid) throws Exception;
}
