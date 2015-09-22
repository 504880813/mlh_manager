package rms.wechat.entity;
/**
 * 
* @ClassName: jsapi_ticket 
* @Description:  jsapi_ticket是公众号用于调用微信JS接口的临时票据
* @author 邹家兴 
* @date 2015年9月20日 下午5:10:10 
*
 */
public class jsapi_ticket {
    /**
     * 调用错误返回码
     */
    private String errcode;
    /**
     * 调用错误信息
     */
    private String errmsg;
    /**
     * 凭据
     */
    private String ticket;
    /**
     * 有效时长 秒
     */
    private String expires_in;
    public String getErrcode() {
        return errcode;
    }
    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }
    public String getErrmsg() {
        return errmsg;
    }
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    public String getTicket() {
        return ticket;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    public String getExpires_in() {
        return expires_in;
    }
    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }
    
    
    
}
