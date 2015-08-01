package rms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import rms.mapper.CustommaterialsMapper;
import rms.mapper.materialsMapper;
import rms.po.Custommaterials;
import rms.po.materials;
import rms.service.MaterialsService;
/**
 * 
* @ClassName: MaterialsServiceImpl 
* @Description: 原料操作实现类
* @author random  
* @date 2015年7月16日 下午3:49:55 
*
 */
@Component
public class MaterialsServiceImpl implements MaterialsService {
	
	@Resource
	private materialsMapper materialsMapper;
	@Resource
	private CustommaterialsMapper custommaterialsMapper;
	
	/*
	 * (非 Javadoc) 
	* <p>Title: saveMaterials</p> 
	* <p>Description: 存储原料</p> 
	* @param materials
	* @throws Exception 
	* @see rms.service.MaterialsService#saveMaterials(rms.po.materials)
	 */
	@Override
	public void saveMaterials(materials materials) throws Exception {
		materialsMapper.insertSelective(materials);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: updateMaterials</p> 
	* <p>Description:更新原料 </p> 
	* @param id
	* @param materials
	* @throws Exception 
	* @see rms.service.MaterialsService#updateMaterials(java.lang.Integer, rms.po.materials)
	 */
	@Override
	public void updateMaterials(Integer id, materials materials)
			throws Exception {
		materials.setId(id);
		materialsMapper.updateByPrimaryKeySelective(materials);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: deleteMaterials</p> 
	* <p>Description: 删除原料</p> 
	* @param id
	* @throws Exception 
	* @see rms.service.MaterialsService#deleteMaterials(java.lang.Integer)
	 */
	@Override
	public void deleteMaterials(Integer id) throws Exception {
		materialsMapper.deleteByPrimaryKey(id);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findAllMaterials</p> 
	* <p>Description:查询所有原料 </p> 
	* @return
	* @throws Exception 
	* @see rms.service.MaterialsService#findAllMaterials()
	 */
	@Override
	public List<Custommaterials> findAllMaterials() throws Exception {
		return custommaterialsMapper.findAll();
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findMaterialsById</p> 
	* <p>Description: 根据id查询原料</p> 
	* @param id
	* @return
	* @throws Exception 
	* @see rms.service.MaterialsService#findMaterialsById(java.lang.Integer)
	 */
	@Override
	public Custommaterials findMaterialsById(Integer id) throws Exception {
		materials selectByPrimaryKey = materialsMapper.selectByPrimaryKey(id);
		Custommaterials custommaterials=new Custommaterials();
		BeanUtils.copyProperties(selectByPrimaryKey, custommaterials);
		return custommaterials;
	}
	@Override
	public List<materials> findMaterialsByIds(String rmaterialsid)
			throws Exception {
		return custommaterialsMapper.findMaterialsByIds(rmaterialsid);
	}

}
