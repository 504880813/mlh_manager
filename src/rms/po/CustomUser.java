package rms.po;

import java.util.HashSet;
import java.util.Set;

/**
 * 
* @ClassName: CustomUser 
* @Description: 扩展user对象，方便对象操作
* @author 邹家兴 
* @date 2015年10月19日 下午9:44:31 
*
 */
public class CustomUser extends user{
    
    	//角色集合
  	private Set<CustomRole> roles = new HashSet<CustomRole>();
  	
  	//用户权限总和
  	private long[] rightSum;

  	/**
	 * 计算用户的权限总和
	 */
	public void calculateRightSum() {
		int pos = 0 ;
		long code = 0 ;
		for(CustomRole role : roles){
			//判断超级管理员
			if("-1".equals(role.getValue())){
				setSuperadmin(true);
				roles = null ;
				return ;
			}
			for(right r : role.getRights()){
				pos = r.getPos();
				code = r.getCode();
				rightSum[pos] = rightSum[pos] | code ;
			}
		}
		roles = null ;
	}

	/**
	 * 判断用户是否有指定的权限
	 */
	public boolean hasRight(right r) {
		int pos = r.getPos();
		long code = r.getCode();
		long ret = rightSum[pos] & code ;
		return !(ret == 0);
	}
  	
  	
  	
  	
	public Set<CustomRole> getRoles() {
	    return roles;
	}

	public void setRoles(Set<CustomRole> roles) {
	    this.roles = roles;
	}

	public long[] getRightSum() {
	    return rightSum;
	}

	public void setRightSum(long[] rightSum) {
	    this.rightSum = rightSum;
	}
  	
  	
}
