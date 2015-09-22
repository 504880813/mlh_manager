package rms.wechat.entity;
/**
 * 
* @ClassName: WechatCheck 
* @Description: 微信校验数据封装类 
* @author 邹家兴 
* @date 2015年9月20日 下午5:35:08 
*
 */
public class WechatCheck {
    /**
     * 公众号id
     */
    private String appid;
    /**
     * 时间戳
     */
    private String timestamp;
    /**
     * 随机数
     */
    private String nonceStr;
    /**
     * 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
     */
    private String signature;
    /**
     * 随机字符串，平台接入时，使用
     */
    private String echostr;
    public String getAppid() {
        return appid;
    }
    public void setAppid(String appid) {
        this.appid = appid;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getNonceStr() {
        return nonceStr;
    }
    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public String getEchostr() {
        return echostr;
    }
    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
    
    
}
