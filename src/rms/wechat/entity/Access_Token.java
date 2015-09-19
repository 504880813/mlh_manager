package rms.wechat.entity;
/**
 * 
* @ClassName: Access_Token 
* @Description:客户端调用接口密钥
* @author 邹家兴 
* @date 2015年9月19日 下午10:13:48 
*
 */
public class Access_Token {
        /**
         * 调用接口凭证
         */
    	private String access_token;
    	/**
    	 * 凭证有效期，秒。
    	 */
    	private String expires_in;
	public String getAccess_token() {
	    return access_token;
	}
	public void setAccess_token(String access_token) {
	    this.access_token = access_token;
	}
	public String getExpires_in() {
	    return expires_in;
	}
	public void setExpires_in(String expires_in) {
	    this.expires_in = expires_in;
	}
    	
    	
}
