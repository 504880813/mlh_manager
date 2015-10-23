package rms.po;
/**
 * 
* @ClassName: role_right_link 
* @Description: 自定义角色和权限维护对象，方便crud
* @author 邹家兴 
* @date 2015年10月20日 下午6:08:47 
*
 */
public class role_right_link {
    
    	private Integer roleid;
    	private Integer rightid;
	public Integer getRoleid() {
	    return roleid;
	}
	public void setRoleid(Integer roleid) {
	    this.roleid = roleid;
	}
	public Integer getRightid() {
	    return rightid;
	}
	public void setRightid(Integer rightid) {
	    this.rightid = rightid;
	}
    	
    	
}
