package rms.wechat.Enumeration;
/**
 * 
* @ClassName: wechatTemplateidKey 
* @Description: 用于获取templateid的枚举key 
* @author 邹家兴 
* @date 2015年10月10日 下午3:50:08 
*
 */
public enum wechatTemplateidKey {
    /**
     * 发送即时消费消息模板id
     */
    Instant_Consumption_Message("HiOP-ab8jgFci3mYTuZXXFnm0m8AtJCkEbxiTLtSCyE"),
    /**
     * 验证码信息模板id
     */
    Verification_Code_Message("--E4jmjuEBjIAJveGunDw_X6kn8gsZWAoJlzGxki_8M");
    /**
     * 方便获取数据
     */
    public String value;  
    wechatTemplateidKey( String value ) {  
           this.value = value;  
    }
}
