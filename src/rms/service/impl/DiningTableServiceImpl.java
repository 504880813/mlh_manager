package rms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import rms.mapper.CustomdiningTableMapper;
import rms.mapper.diningTableMapper;
import rms.po.CustomdiningTable;
import rms.po.diningTable;
import rms.service.DiningTableService;
import rms.untils.FileUtils;

@Component
public class DiningTableServiceImpl implements DiningTableService {
	
	@Resource
	private CustomdiningTableMapper CustomdiningTablemMapper;
	@Resource
	private diningTableMapper diningTableMapper;

	@Override
	/*
	 * (非 Javadoc) 
	* <p>Title: saveDiningTable</p> 
	* <p>Description: 存储餐桌信息</p> 
	* @param diningTable
	* @throws Exception 
	* @see rms.service.impl.DiningTableService#saveDiningTable(rms.po.diningTable)
	 */
	public void saveDiningTable(CustomdiningTable diningTable) throws Exception {
		int i=diningTableMapper.insertSelective(diningTable);
		System.out.println("testSaveReturnValue-------->"+i);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: updateDiningTableById</p> 
	* <p>Description: 根据id更新餐桌信息</p> 
	* @param id
	* @param diningTable
	* @throws Exception 
	* @see rms.service.impl.DiningTableService#updateDiningTableById(java.lang.Integer, rms.po.diningTable)
	 */
	@Override
	public void updateDiningTableById(Integer id, CustomdiningTable diningTable)
			throws Exception {
		diningTable.setId(id);
		int i=diningTableMapper.updateByPrimaryKeySelective(diningTable);
		System.out.println("testUpdateReturnValue-------->"+i);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: updateStateById</p> 
	* <p>Description: 根据id更新餐桌状态</p> 
	* @param id
	* @param isfree
	* @throws Exception 
	* @see rms.service.impl.DiningTableService#updateStateById(java.lang.Integer, java.lang.Boolean)
	 */
	@Override
	public void updateStateById(Integer id, Boolean isfree) throws Exception {
		CustomdiningTable customdiningTable=new CustomdiningTable();
		customdiningTable.setId(id);
		customdiningTable.setIsfree(isfree);
		CustomdiningTablemMapper.updateStateByid(customdiningTable);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: deleteDiningTableByID</p> 
	* <p>Description: 根据id删除餐桌信息</p> 
	* @param id
	* @throws Exception 
	* @see rms.service.impl.DiningTableService#deleteDiningTableByID(java.lang.Integer)
	 */
	@Override
	public void deleteDiningTableByID(Integer id) throws Exception {
		diningTableMapper.deleteByPrimaryKey(id);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: fingAllDiningTable</p> 
	* <p>Description: 查询所有餐桌信息</p> 
	* @return
	* @throws Exception 
	* @see rms.service.impl.DiningTableService#fingAllDiningTable()
	 */
	@Override
	public List<CustomdiningTable> fingAllDiningTable() throws Exception {
		return CustomdiningTablemMapper.findAlldiningTable();
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: fingDiningTableDefultImage</p> 
	* <p>Description:查询餐桌默认图片 </p> 
	* @return
	* @throws Exception 
	* @see rms.service.impl.DiningTableService#fingDiningTableDefultImage()
	 */
	@Override
	public CustomdiningTable fingDiningTableDefultImage() throws Exception {
		return CustomdiningTablemMapper.findDefultImage();
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findDiningTableById</p> 
	* <p>Description:根据id查询餐桌信息 </p> 
	* @param id
	* @return
	* @throws Exception 
	* @see rms.service.impl.DiningTableService#findDiningTableById(java.lang.String)
	 */
	public CustomdiningTable findDiningTableById(Integer id) throws Exception {
		diningTable diningTable=diningTableMapper.selectByPrimaryKey(id);
		CustomdiningTable custom=new CustomdiningTable();
		if(diningTable!=null){
			BeanUtils.copyProperties(diningTable, custom);
		}
		return custom;
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: updateImage</p> 
	* <p>Description: 修改背景图</p> 
	* @param freeimageFile
	* @param busyimageFile
	* @throws Exception 
	* @see rms.service.impl.DiningTableService#updateImage(java.lang.String, java.lang.String)
	 */
	@Override
	public void updateImage(MultipartFile freeimageFile, MultipartFile busyimageFile)
			throws Exception {
		
		//清空文件目录 成功则进行上传新图片
		if(FileUtils.clearDir(FileUtils.diningTablepath)){
			CustomdiningTable customdiningTable=new CustomdiningTable();
			customdiningTable=uploadImage(freeimageFile, busyimageFile, customdiningTable);
			CustomdiningTablemMapper.updateImage(customdiningTable);
		}
		
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: uploadImage</p> 
	* <p>Description: 上传餐桌图片</p> 
	* @param freeimageFile
	* @param busyimageFile
	* @throws Exception 
	* @see rms.service.impl.DiningTableService#uploadImage(org.springframework.web.multipart.MultipartFile, org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public CustomdiningTable uploadImage(MultipartFile freeimageFile,
			MultipartFile busyimageFile,CustomdiningTable customdiningTable) throws Exception {
		String freeFileName=FileUtils.uploadImage(freeimageFile, FileUtils.diningTablepath);
		
		String busyFileName=FileUtils.uploadImage(busyimageFile, FileUtils.diningTablepath);
		
		customdiningTable.setFreeimage(FileUtils.diningTableMappingPath+freeFileName);
		customdiningTable.setBusyimage(FileUtils.diningTableMappingPath+busyFileName);
		
		return customdiningTable;
	}


}
