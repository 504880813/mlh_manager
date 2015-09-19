package rms.wechat.entity;
/**
 * 
* @ClassName: PageACCESS_TOKEN 
* @Description: 网页的密钥
* @author 邹家兴 
* @date 2015年9月16日 下午4:20:48 
*
 */
public class PageAccess_Token {
    /**
     * 网页接口调用凭证
     */
    private String access_token;
    /**
     * 网页接口调用凭证国企时间  秒
     */
    private String expires_in;
    /**
     * 刷新密钥凭证
     */
    private String refresh_token;
    /**
     * 用户的openid
     */
    private String openid;
    /**
     * 请求域
     */
    private String scope;
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
    public String getRefresh_token() {
        return refresh_token;
    }
    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public String getScope() {
        return scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }
    
    
}
