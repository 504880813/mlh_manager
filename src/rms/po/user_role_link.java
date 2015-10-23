package rms.po;
/**
 * 
* @ClassName: user_role_link 
* @Description: 自定义角色和用户维护对象，方便crud
* @author 邹家兴 
* @date 2015年10月20日 下午6:08:47 
*
 */
public class user_role_link {
    
    	private Integer roleid;
    	private Integer userid;
	public Integer getRoleid() {
	    return roleid;
	}
	public void setRoleid(Integer roleid) {
	    this.roleid = roleid;
	}
	public Integer getUserid() {
	    return userid;
	}
	public void setUserid(Integer userid) {
	    this.userid = userid;
	}
	
    	
}
