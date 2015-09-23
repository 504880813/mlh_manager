package rms.wechat.Enumeration;
/**
 * 
* @ClassName: wechatInterfaceEnumeration 
* @Description: 微信接口和数据库对应key调用
* @author 邹家兴 
* @date 2015年9月23日 下午11:36:05 
*
 */
public enum wechatInterfaceEnumeration {
    	/**
    	 * 发送模板消息url对应key
    	 */
    	sendTemplateMessage("sendTemplateMessage"),
    	/**
    	 * 获取网页access_token凭证url对应key
    	 */
    	getPageACCESS_TOKEN("getPageACCESS_TOKEN"),
    	/**
    	 * 获取客户端access_token凭证url对应key
    	 */
    	getACCESS_TKOKEN("getACCESS_TKOKEN"),
    	/**
    	 * 获取jsapi调用凭据url对应的key
    	 */
    	getjsapiticket("getjsapiticket");
	
	/**
	 * 方便获取数据
	 */
	public String value;  
        wechatInterfaceEnumeration( String value ) {  
               this.value = value;  
        }
}
