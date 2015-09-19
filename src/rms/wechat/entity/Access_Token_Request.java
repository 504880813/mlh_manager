package rms.wechat.entity;
/**
 * 
* @ClassName: Access_Token_Request 
* @Description: 普通客户端请求密钥的请求数据
* @author 邹家兴 
* @date 2015年9月19日 下午10:09:13 
*
 */
public class Access_Token_Request {
    /**
     * 公众号id
     */
    private String appid;
    /**
     * 公众号secret
     */
    private String appsecret;
    
    public String getAppid() {
        return appid;
    }
    public void setAppid(String appid) {
        this.appid = appid;
    }
    public String getAppsecret() {
        return appsecret;
    }
    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }
    
    
}
