package rms.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import rms.mapper.CustomRightMapper;
import rms.mapper.rightMapper;
import rms.po.right;
import rms.po.rightExample;
import rms.service.RightService;
/**
 * 
* @ClassName: RightServiceImpl 
* @Description: 权限操作实现
* @author 邹家兴 
* @date 2015年10月19日 下午10:01:02 
*
 */
@Component
public class RightServiceImpl implements RightService {
    
    	@Resource
    	private rightMapper rightMapper;
    	@Resource
    	private CustomRightMapper customRightMapper;
    	
	/**
	 * 保存/更新权限
	 */
	public void saveOrUpdateRight(right model) throws Exception{
		//insert
		if(model.getId() == null){
			int rightPos = 0 ;
			long rightCode = 1 ;
			//查询最大权限位上的最大权限码
//			String hql = "select max(r.rightPos),max(r.rightCode) from Right r " +
//					"where r.rightPos = (select max(rr.rightPos) from Right rr)" ;
//			Object[] arr = (Object[]) this.uniqueResult(hql);
			
			right maxPosAndMaxCode=customRightMapper.findMaxPosAndMaxCode();
			
			Integer topRightPos = maxPosAndMaxCode==null?null:maxPosAndMaxCode.getPos() ;
			Long topRightCode = maxPosAndMaxCode==null?null:maxPosAndMaxCode.getCode();
			
			if(topRightPos == null){
				rightPos = 0 ;
				rightCode = 1 ;
			}
			else{
				if(topRightCode >= (1L << 60)){
					rightPos = topRightPos + 1;
					rightCode = 1 ;
				}
				else{
					rightPos = topRightPos ;
					rightCode = topRightCode << 1 ;
				}
			}
			model.setPos(rightPos);
			model.setCode(rightCode);
			
			rightMapper.insert(model);
		}else {
		    	//update
		    	rightMapper.updateByPrimaryKey(model);
		}
	}
	
	/**
	 * 按照url追加权限
	 */
/*	public void appendRightByURL(String url){
		String hql = "select count(*) from Right r where r.rightUrl = ?" ;
		Long count = (Long)this.uniqueResult(hql,url);
		if(count == 0){
			Right r = new Right();
			r.setRightUrl(url);
			this.saveOrUpdateRight(r);
		}
	}*/
	

	/**
	 * 批量更新权限
	 */
	public void batchUpdateRights(List<right> list) throws Exception{
		for(right r : list){
		    rightMapper.updateByPrimaryKey(r);
		}
	}
	
	/**
	 * 查询在指定范围中的权限
	 */
	public List<right> findRightsInRange(Integer[] ids) throws Exception{
		rightExample example=new rightExample();
		
		List<Integer> idList=Arrays.asList(ids);
		
		example.createCriteria().andIdIn(idList);
		
		return rightMapper.selectByExample(example);
	}
	

	/**
	 * 查询不在指定范围中的权限
	 */
	public List<right> findRightsNotInRange(Set<right> rights) throws Exception{
		rightExample example=new rightExample();
		
		List<Integer> ids=new ArrayList<>();
		for(right r:rights) {
		    ids.add(r.getId());
		}
		
		example.createCriteria().andIdNotIn(ids);
		
		return rightMapper.selectByExample(example);
	}
	
	/**
	 * 查询最大权限位
	 * @throws Exception 
	 */
	public int getMaxRightPos() throws Exception{
		right r=customRightMapper.findMaxPosAndMaxCode();
		Integer max = r.getPos();
		return max == null ? 0 : max ;
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findRights</p> 
	* <p>Description:查询所有的权限 </p> 
	* @return
	* @throws Exception 
	* @see rms.service.RightService#findRights()
	 */
	@Override
	public List<right> findRights() throws Exception {
	    rightExample example=new rightExample();
	    example.createCriteria().andIdIsNotNull();
	    return rightMapper.selectByExample(example);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findRightById</p> 
	* <p>Description:根据 id查询权限</p> 
	* @param id
	* @return
	* @throws Exception 
	* @see rms.service.RightService#findRightById(java.lang.Integer)
	 */
	@Override
	public right findRightById(Integer id) throws Exception {
	    rightExample example=new rightExample();
	    example.createCriteria().andIdEqualTo(id);
	    List<right> rights=rightMapper.selectByExample(example);
	    return rights==null || rights.size()<=0? null : rights.get(0);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: deleteRightByID</p> 
	* <p>Description:根据id删除</p> 
	* @param id
	* @throws Exception 
	* @see rms.service.RightService#deleteRightByID(java.lang.Integer)
	 */
	@Override
	public void deleteRightByID(Integer id) throws Exception {
	    	rightMapper.deleteByPrimaryKey(id);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: findRightsAndidNotInList</p> 
	* <p>Description:查询不再权限集合里的权限</p> 
	* @param rights
	* @return
	* @throws Exception 
	* @see rms.service.RightService#findRightsAndidNotInList(java.util.Set)
	 */
	@Override
	public List<right> findRightsAndidNotInList(Set<right> rights)
		throws Exception {
	    rightExample example=new rightExample();
	    
	    List<Integer> values=new ArrayList<>();
	    
	    for(right r:rights) {
		values.add(r.getId());
	    }
	    
	    if(values==null||values.size()==0) {
		 example.createCriteria().andIdIsNotNull();
	    }else {
		 example.createCriteria().andIdNotIn(values);
	    }
	    return rightMapper.selectByExample(example);
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: appendRightByURL</p> 
	* <p>Description: 根据url追加权限</p> 
	* @param url
	* @throws Exception 
	* @see rms.service.RightService#appendRightByURL(java.lang.String)
	 */
	@Override
	public void appendRightByURL(String url) throws Exception {
	    rightExample example=new rightExample();
	    example.createCriteria().andUrlEqualTo(url);
	    List<right> rights=rightMapper.selectByExample(example);
	    if(rights==null||rights.size()==0) {
		right r=new right();
		r.setCode(0L);
		r.setCommon(false);
		r.setName("未命名");
		r.setUrl(url);
		this.saveOrUpdateRight(r);
	    }
	}
}
