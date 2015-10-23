package rms.service;

import java.util.List;
import java.util.Set;

import rms.po.CustomdiningTable;
import rms.po.right;

/**
 * 
* @ClassName: RightService 
* @Description: 操作权限接口 
* @author 邹家兴 
* @date 2015年10月19日 下午9:59:16 
*
 */
public interface RightService {
    
    
    	/**
	 * 
	* @Title: findRights 
	* @Description: 查询所有的权限
	* @param @return
	* @param @throws Exception    
	* @return List<right>    
	* @throws
	 */
	public List<right> findRights() throws Exception;
    	
    	
    	/**
    	 * 
    	* @Title: saveOrUpdateRight 
    	* @Description: 保存或更新权限
    	* @param @param model    
    	* @return void    
    	* @throws
    	 */
    	public void saveOrUpdateRight(right model) throws Exception;
    	
	/**
	 * 按照url追加权限
	 */
//	public void appendRightByURL(String url) throws Exception;

	/**
	 * 批量更新权限
	 */
	public void batchUpdateRights(List<right> allRights) throws Exception;

	/**
	 * 查询在指定范围中的权限
	 */
	public List<right> findRightsInRange(Integer[] ids) throws Exception;

	/**
	 * 查询不在指定范围中的权限
	 */
	public List<right> findRightsNotInRange(Set<right> rights) throws Exception;

	/**
	 * 查询最大权限位
	 */
	public int getMaxRightPos() throws Exception;

	/**
	 * 
	* @Title: findRightById 
	* @Description: 根据权限id查询id 
	* @param @param id
	* @param @return
	* @param @throws Exception    
	* @return right    
	* @throws
	 */
	public right findRightById(Integer id) throws Exception ;

	/**
	 * 
	* @Title: deleteRightByID 
	* @Description: 根据权限id删除权限
	* @param @param id
	* @param @throws Exception    
	* @return void    
	* @throws
	 */
	public void deleteRightByID(Integer id) throws Exception ;

	/**
	 * 
	* @Title: findRightsAndidNotInList 
	* @Description: 查询不在权限集合里面的权限
	* @param @param rights
	* @param @return
	* @param @throws Exception    
	* @return List<right>    
	* @throws
	 */
	public List<right> findRightsAndidNotInList(Set<right> rights) throws Exception;

	/**
	 * 
	* @Title: appendRightByURL 
	* @Description:根据url追加权限
	* @param @param url
	* @param @throws Exception    
	* @return void    
	* @throws
	 */
	public void appendRightByURL(String url) throws Exception;
	
}
