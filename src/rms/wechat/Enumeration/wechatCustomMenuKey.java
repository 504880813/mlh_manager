package rms.wechat.Enumeration;
/**
 * 
* @ClassName: wechatCustomsss 
* @Description: 自定义菜单响应key
* @author 邹家兴 
* @date 2015年9月24日 下午7:24:04 
*
 */
public enum wechatCustomMenuKey {
    /**
     * 获取用户的基本信息
     */
    get_UserBasicInformation("get_UserBasicInformation");
    
    
    /**
     * 方便获取数据
     */
    public String value;  
    wechatCustomMenuKey( String value ) {  
           this.value = value;  
    }
}
