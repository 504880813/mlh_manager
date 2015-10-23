package rms.po;

import java.util.HashSet;
import java.util.Set;

/**
 * 
* @ClassName: CustomRole 
* @Description: 自定义扩展角色类
* @author 邹家兴 
* @date 2015年10月19日 下午9:49:53 
*
 */
public class CustomRole extends role {
    
    	// 建立从Role到Right之间多对多关联关系
 	private Set<right> rights = new HashSet<right>();

	public Set<right> getRights() {
	    return rights;
	}

	public void setRights(Set<right> rights) {
	    this.rights = rights;
	}
 	
 	
 	
}
