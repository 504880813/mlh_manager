package rms.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import rms.mapper.CustommaterialsMapper;
import rms.mapper.materialsMapper;
import rms.mapper.materialsRecordMapper;
import rms.po.Custommaterials;
import rms.po.materials;
import rms.po.materialsExample;
import rms.po.materialsRecord;
import rms.po.materialsRecordExample;
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
	@Resource
	private materialsRecordMapper materialsRecordMapper;
	
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
	    
	    	Custommaterials custommaterials=findMaterialsByMaterialName(materials.getName());
	    	
	    	if(custommaterials!=null) {
	    	    BigDecimal dbSurplus=custommaterials.getSurplus();
	    	    BigDecimal newSurplus=materials.getSurplus();
	    	    custommaterials.setSurplus(dbSurplus.add(newSurplus));
	    	    updateMaterials(custommaterials.getId(), custommaterials,materials);
	    	}else {
	    	    custommaterialsMapper.insertSelectiveRetrunPk(materials);
	    	    //记录本次的操作记录
		    saveMaterialsRecord(materials,true);
	    	}
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: saveMaterialsRecord</p> 
	* <p>Description:保存存取记录</p> 
	* @param materials
	* @param issave
	* @throws Exception 
	* @see rms.service.MaterialsService#saveMaterialsRecord(rms.po.materials)
	 */
	public void saveMaterialsRecord(materials materials,boolean issave) throws Exception{
	    materialsRecord materialsRecord =new materialsRecord();
	    materialsRecord.setMaterialsName(materials.getName());
	    materialsRecord.setMaterialsSurplus(materials.getSurplus());
	    materialsRecord.setMaterialsUnit(materials.getUnit());
	    materialsRecord.setSave(issave);
	    materialsRecord.setTime(new Date());
	    materialsRecordMapper.insertSelective(materialsRecord);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: saveMaterialsRecord</p> 
	* <p>Description:保存存取记录</p> 
	* @param materialsRecord
	* @param issave
	* @throws Exception 
	* @see rms.service.MaterialsService#saveMaterialsRecord(rms.po.materialsRecord, boolean)
	 */
	public void saveMaterialsRecord(materialsRecord materialsRecord,boolean issave) throws Exception{
	    materialsRecord.setSave(issave);
	    materialsRecord.setTime(new Date());
	    materialsRecordMapper.insertSelective(materialsRecord);
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
	public void updateMaterials(Integer id, materials materials,materials changeMaterials)
			throws Exception {
	    	if(changeMaterials==null) {
        	    	materials.setId(id);
        		materialsMapper.updateByPrimaryKeySelective(materials);
	    	}else {
        	    	Custommaterials custommaterials=findMaterialsById(id);
        	    	int res=custommaterials.getSurplus().compareTo(materials.getSurplus());
        	    	materials.setId(id);
        	    	changeMaterials.setId(id);
        		materialsMapper.updateByPrimaryKeySelective(materials);
        		
        		//大于
        	    	if(res==1) {
        	    	 //记录本次的操作记录
        		  saveMaterialsRecord(changeMaterials,false);
        	    	}
        	    	//小于
        	    	if(res==-1){
        	    	 //记录本次的操作记录
        		  saveMaterialsRecord(changeMaterials,true);
        		}
	    	}
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
	/*
	 * (非 Javadoc) 
	* <p>Title: findMaterialsByMaterialName</p> 
	* <p>Description:根据原料名称查询原料 </p> 
	* @param name
	* @return
	* @throws Exception 
	* @see rms.service.MaterialsService#findMaterialsByMaterialName(java.lang.String)
	 */
	public Custommaterials findMaterialsByMaterialName(String name) throws Exception{
	    
	    materialsExample example=new materialsExample();
	    example.createCriteria().andNameEqualTo(name);
	    
	    List<materials> materialsList=materialsMapper.selectByExample(example);
	    if(materialsList!=null&&materialsList.size()>0) {
		materials materials=materialsList.get(0);
		Custommaterials custommaterials=new Custommaterials();
		BeanUtils.copyProperties(materials, custommaterials);
		return custommaterials;
	    }
	    return null;
	}
	
	/*
	 * (非 Javadoc) 
	* <p>Title: findMaterialsByIds</p> 
	* <p>Description:根据ids列表查询原料集合</p> 
	* @param rmaterialsid
	* @return
	* @throws Exception 
	* @see rms.service.MaterialsService#findMaterialsByIds(java.lang.String)
	 */
	@Override
	public List<materials> findMaterialsByIds(String rmaterialsid)
			throws Exception {
		return custommaterialsMapper.findMaterialsByIds(rmaterialsid);
	}
	
	/*
	 * (非 Javadoc) 
	* <p>Title: deleteMaterialsRecord</p> 
	* <p>Description:根据id删除存取记录</p> 
	* @param id
	* @throws Exception 
	* @see rms.service.MaterialsService#deleteMaterialsRecord(java.lang.Integer)
	 */
	@Override
	public void deleteMaterialsRecord(Integer id) throws Exception {
	    	materialsRecordMapper.deleteByPrimaryKey(id);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findAllMaterialsRecord</p> 
	* <p>Description:查询所有的存取记录</p> 
	* @return
	* @throws Exception 
	* @see rms.service.MaterialsService#findAllMaterialsRecord()
	 */
	@Override
	public List<materialsRecord> findAllMaterialsRecord() throws Exception {
	    
	    materialsRecordExample example=new materialsRecordExample();
	    
	    example.createCriteria().andIdIsNotNull();
	    
	    List<materialsRecord> materialsRecords=materialsRecordMapper.selectByExample(example);
	    
	    return materialsRecords;
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findMaterialsRecordByMaterialName</p> 
	* <p>Description:根据原料名称查询原料存取记录</p> 
	* @param name
	* @return
	* @throws Exception 
	* @see rms.service.MaterialsService#findMaterialsRecordByMaterialName(java.lang.String)
	 */
	@Override
	public List<materialsRecord> findMaterialsRecordByMaterialName(
		String name) throws Exception {
	    
	    materialsExample example=new materialsExample();
	    
	    example.createCriteria().andNameEqualTo(name);
	    
	    List<materials> materialsList=materialsMapper.selectByExample(example);
	    
	    if(materialsList==null||materialsList.size()<=0) return null;
	    
	    
	    materialsRecordExample Recordexample=new materialsRecordExample();
	    
	    Recordexample.createCriteria().andMaterialsNameEqualTo(materialsList.get(0).getName());
	    
	    List<materialsRecord> materialsRecords=materialsRecordMapper.selectByExample(Recordexample);
	    
	    return materialsRecords;
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findMaterialsRecordByMaterialNameAndTime</p> 
	* <p>Description: 根据原料名称查询一段时间内的原料存取记录  </p> 
	* @param name
	* @return
	* @throws Exception 
	* @see rms.service.MaterialsService#findMaterialsRecordByMaterialNameAndTime(java.lang.String)
	 */
	public List<materialsRecord> findMaterialsRecordByMaterialNameAndTime(String name,Date startTime,Date endTime) throws Exception{
	    
	    materialsExample example=new materialsExample();
	    
	    example.createCriteria().andNameEqualTo(name);
	    
	    List<materials> materialsList=materialsMapper.selectByExample(example);
	    
	    if(materialsList==null||materialsList.size()<=0) return null;
	    
	    
	    materialsRecordExample Recordexample=new materialsRecordExample();
	    
	    Recordexample.createCriteria().andMaterialsNameEqualTo(materialsList.get(0).getName()).andTimeBetween(startTime, endTime);
	    
	    List<materialsRecord> materialsRecords=materialsRecordMapper.selectByExample(Recordexample);
	    
	    return materialsRecords;
	}

}
