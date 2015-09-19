package rms.wechat.entity;

import java.util.Map;

/**
 * 
* @ClassName: TemplateMessage 
* @Description: 微信模板消息 
* @author 邹家兴 
* @date 2015年9月19日 下午9:39:13 
*
 */
public class TemplateMessage {
    /**
     * 要送达的用户的openid
     */
    private String touser;
    /**
     * 要发送的模板的id
     */
    private String template_id;
    /**
     * 用户点击模板后，响应的url
     */
    private String url;
    /**
     * 主模板的背景色
     */
    private String topcolor;
    /**
     * 模板消息的数据
     * String 模板消息列名
     * TemplateData 对应的数据值
     */
    private Map<String,TemplateData> data;
    
    public String getTouser() {
        return touser;
    }
    public void setTouser(String touser) {
        this.touser = touser;
    }
    public String getTemplate_id() {
        return template_id;
    }
    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTopcolor() {
        return topcolor;
    }
    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }
    public Map<String, TemplateData> getData() {
        return data;
    }
    public void setData(Map<String, TemplateData> data) {
        this.data = data;
    }
    
    
    
}
