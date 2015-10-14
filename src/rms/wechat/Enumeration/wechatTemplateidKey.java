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
    Instant_Consumption_Message("_lUqhg3B8DAjlueOPUXWc3Er-H-nISm-YvABmeuKn5Y");
    /**
     * 方便获取数据
     */
    public String value;  
    wechatTemplateidKey( String value ) {  
           this.value = value;  
    }
}
