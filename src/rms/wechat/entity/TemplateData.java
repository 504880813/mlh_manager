package rms.wechat.entity;
/**
 * 
* @ClassName: TemplateData 
* @Description: 模板消息内置数据 
* @author 邹家兴 
* @date 2015年9月19日 下午9:44:51 
*
 */
public class TemplateData {
    	/**
    	 * 该行数据的值
    	 */
	private String value;
	/**
	 * 背景色
	 */
	private String color;
	
	
	//方便赋值
	public TemplateData(String value, String color) {
	    super();
	    this.value = value;
	    this.color = color;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
