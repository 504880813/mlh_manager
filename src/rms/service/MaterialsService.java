package rms.service;

import java.util.Date;
import java.util.List;

import rms.po.Custommaterials;
import rms.po.materials;
import rms.po.materialsRecord;

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
	* @Title: saveMaterialsRecord 
	* @Description:保存存取记录
	* @param @param materials
	*  @param @param issave
	* @param @throws Exception    
	* @return void    
	* @throws
	 */
	public void saveMaterialsRecord(materials materials,boolean issave) throws Exception;
	
	/**
	 * 
	* @Title: saveMaterialsRecord 
	* @Description: 保存入库记录
	* @param @param materialsRecord
	* @param @param issave
	* @param @throws Exception    
	* @return void    
	* @throws
	 */
	public void saveMaterialsRecord(materialsRecord materialsRecord,boolean issave) throws Exception;
	/**
	 * 
	* @Title: updateMaterials 
	* @Description: 更新原料 
	* @param @param id
	* @param @param materials
	* @param @param changeMaterials
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateMaterials(Integer id,materials materials,materials changeMaterials) throws Exception;
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
	* @Title: deleteMaterialsRecord 
	* @Description: 根据id删除存取记录
	* @param @param id
	* @param @throws Exception    
	* @return void    
	* @throws
	 */
	public void deleteMaterialsRecord(Integer id) throws Exception;
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
	* @Title: findAllMaterialsRecord 
	* @Description: 查询所有存取记录
	* @param @return
	* @param @throws Exception    
	* @return List<materialsRecord>    
	* @throws
	 */
	public List<materialsRecord> findAllMaterialsRecord() throws Exception;
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
	 * 
	* @Title: findMaterialsByMaterialName 
	* @Description: 根据原料名称查询原料
	* @param @param name
	* @param @return   
	* @param @throws Exception    
	* @return Custommaterials    
	* @throws
	 */
	public Custommaterials findMaterialsByMaterialName(String name) throws Exception;
	
	/**
	 * 
	* @Title: findMaterialsRecordByMaterialName 
	* @Description: 根据原料名称查询原料存取记录 
	* @param @param name
	* @param @return
	* @param @throws Exception    
	* @return List<materialsRecord>    
	* @throws
	 */
	public List<materialsRecord> findMaterialsRecordByMaterialName(String name) throws Exception;
	
	
	/**
	 * 
	* @Title: findMaterialsRecordByMaterialNameAndTime 
	* @Description: 根据原料名称查询一段时间内的原料存取记录 
	* @param @param name
	* @param @param startTime
	* @param @param endTime
	* @param @return
	* @param @throws Exception    
	* @return List<materialsRecord>    
	* @throws
	 */
	public List<materialsRecord> findMaterialsRecordByMaterialNameAndTime(String name,Date startTime,Date endTime) throws Exception;
	
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
