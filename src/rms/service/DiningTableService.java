package rms.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import rms.po.CustomdiningTable;

/**
 * 
* @ClassName: DiningTableService 
* @Description: 餐桌操作接口 
* @author random
* @date 2015年7月15日 上午11:37:23 
*
 */
public interface DiningTableService {
	/**
	* @Title: saveDiningTable 
	* @Description: 存储餐桌信息
	* @param @param diningTable
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void saveDiningTable(CustomdiningTable diningTable)throws Exception;
	/**
	 * 
	* @Title: updateDiningTableById 
	* @Description: 根据id修改餐桌信息
	* @param @param id
	* @param @param diningTable
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateDiningTableById(Integer id,CustomdiningTable diningTable) throws Exception;
	/**
	 * 
	* @Title: updateStateById 
	* @Description: 根据id修改餐桌状态(繁忙，空闲) 
	* @param @param id
	* @param @param isfree 当前状态
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateStateById(Integer id,Boolean isfree) throws Exception;
	/**
	 * 
	* @Title: deleteDiningTableByID 
	* @Description: 根据id删除餐桌信息
	* @param @param id
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteDiningTableByID(Integer id) throws Exception;
	/**
	 * 
	* @Title: findAllDiningTable 
	* @Description: 查询所有餐桌信息
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<CustomdiningTable>    返回类型 
	* @throws
	 */
	public List<CustomdiningTable> findAllDiningTable() throws Exception;
	/**
	 * 
	* @Title: findDiningTableDefultImage 
	* @Description: 查询餐桌默认图片
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public CustomdiningTable findDiningTableDefultImage() throws Exception;
	/**
	 * 
	* @Title: findDiningTableById 
	* @Description: 根据id查询餐桌信息 
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return CustomdiningTable    返回类型 
	* @throws
	 */
	public CustomdiningTable findDiningTableById(Integer id) throws Exception;
	/**
	 * 
	* @Title: updateImage 
	* @Description: 修改桌面背景图片
	* @param @param freeimageFile
	* @param @param busyimageFile
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateImage(MultipartFile freeimageFile, MultipartFile busyimageFile) throws Exception;
	/**
	 * @param customdiningTable 
	 * 
	* @Title: uploadImage 
	* @Description: 上传餐桌图片 
	* @param @param freeimageFile
	* @param @param busyimageFile
	* @param @throws Exception    设定文件 
	* @return CustomdiningTable   返回类型 
	* @throws
	 */
	public CustomdiningTable uploadImage(MultipartFile freeimageFile,
			MultipartFile busyimageFile, CustomdiningTable customdiningTable) throws Exception;
	
	
}
