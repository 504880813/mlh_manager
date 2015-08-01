package rms.mapper;

import java.util.List;

import rms.po.CustomdiningTable;

/**
 * 
* @ClassName: CustomdiningTableMapper 
* @Description: 自定义餐桌mapper用于扩展 
* @author random  
* @date 2015年7月15日 上午11:49:17 
*
 */
public interface CustomdiningTableMapper {
	
	/**
	 * 
	* @Title: updateStateByid 
	* @Description: 根据id修改餐桌状态
	* @param @param customdiningTable
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateStateByid(CustomdiningTable customdiningTable) throws Exception;
	
	/**
	 * 
	* @Title: findAlldiningTable 
	* @Description: 查询所有餐桌信息
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<CustomdiningTable>    返回类型 
	* @throws
	 */
	public List<CustomdiningTable> findAlldiningTable() throws Exception;
	/**
	 * 
	* @Title: findDefultImage 
	* @Description: 查询餐桌默认图片
	* @param @return    设定文件 
	* @return CustomdiningTable    返回类型 
	* @throws
	 */
	public CustomdiningTable findDefultImage() throws Exception;
	/**
	 * 
	* @Title: updateImage 
	* @Description: 更新餐桌图
	* @param @param customdiningTable    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateImage(CustomdiningTable customdiningTable);
}