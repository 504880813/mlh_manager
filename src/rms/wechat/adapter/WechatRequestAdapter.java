package rms.wechat.adapter;

import org.apache.commons.beanutils.BeanUtils;
import org.w3c.dom.Document;

import rms.wechat.entity.ReceiveXmlEntity;
import rms.wechat.untils.XmlUtils;

/**
 * 
* @ClassName: WechatRequestAdapter 
* @Description: 用来分析微信服务器传递过来的请求数据，并分发给响应方法
* @author 邹家兴 
* @date 2015年8月13日 下午2:09:12 
*
 */
public class WechatRequestAdapter {
    
    /**
     * @throws Exception 
     * 
    * @Title: distributeRequest 
    * @Description: 将微信服务器传递过来的数据分发给不同的处理器
    * @param @param requestMessage
    * @param @return    
    * @return String    
    * @throws
     */
    public String distributeRequest(String requestMessage) throws Exception {
	
	//处理请求数据，并转换成一个对象
//	ReceiveXmlEntity request=processRequest(requestMessage);
	
	Document requestXml=XmlUtils.StringToXML(requestMessage);
	    String ToUserName=XmlUtils.findValueByXml(requestXml, "ToUserName", null).get(0);
	    String FromUserName=XmlUtils.findValueByXml(requestXml, "FromUserName", null).get(0);
//	    String CreateTime=XmlUtils.findValueByXml(requestXml, "CreateTime", null).get(0);
//	    String MsgType=XmlUtils.findValueByXml(requestXml, "MsgType", null).get(0);
//	    String MsgId=XmlUtils.findValueByXml(requestXml, "MsgId", null).get(0);

	return "<xml>"+
	"<ToUserName><![CDATA["+FromUserName+"]]></ToUserName>"+
	"<FromUserName><![CDATA["+ToUserName+"]]></FromUserName>"+
	"<CreateTime>154354</CreateTime>"+
	"<MsgType><![CDATA[text]]></MsgType>"+
	"<Content><![CDATA[你好]]></Content>"+
	"</xml>";
    }
    /**
     * 
    * @Title: processRequest 
    * @Description: 将请求数据转换成一个ReceiveXmlEntity对象
    * @param @param requestMessage
    * @param @return    
    * @return ReceiveXmlEntity    
    * @throws
     */
    private ReceiveXmlEntity processRequest(String requestMessage) {
	ReceiveXmlEntity request=null;
	
	try {
	    
	    Document requestXml=XmlUtils.StringToXML(requestMessage);
	    
	    //基础数据
	    String ToUserName=XmlUtils.findValueByXml(requestXml, "ToUserName", null).get(0);
	    String FromUserName=XmlUtils.findValueByXml(requestXml, "FromUserName", null).get(0);
	    String CreateTime=XmlUtils.findValueByXml(requestXml, "CreateTime", null).get(0);
	    String MsgType=XmlUtils.findValueByXml(requestXml, "MsgType", null).get(0);
	    String MsgId=XmlUtils.findValueByXml(requestXml, "MsgId", null).get(0);

	    //封装基本数据
	    request=new ReceiveXmlEntity();
	    BeanUtils.setProperty(request, "ToUserName", ToUserName);
	    BeanUtils.setProperty(request, "FromUserName", FromUserName);
	    BeanUtils.setProperty(request, "CreateTime", CreateTime);
	    BeanUtils.setProperty(request, "MsgType", MsgType);
	    BeanUtils.setProperty(request, "MsgId", MsgId);
	    //根据不同的类型查询并封装数据
	    //文本消息
	    if("text".equals(MsgType)) {
		String Content=XmlUtils.findValueByXml(requestXml, "Content", null).get(0);
		BeanUtils.setProperty(request, "Content", Content);
		return request;
	    }
	    //图片数据
	    else if("image".equals(MsgType)) {
		String PicUrl=XmlUtils.findValueByXml(requestXml, "PicUrl", null).get(0);
		String MediaId=XmlUtils.findValueByXml(requestXml, "MediaId", null).get(0);
		BeanUtils.setProperty(request, "PicUrl", PicUrl);
		BeanUtils.setProperty(request, "MediaId", MediaId);
		return request;
	    }
	    //语言消息
	    else if("voice".equals(MsgType)) {
		String Format=XmlUtils.findValueByXml(requestXml, "Format", null).get(0);
		String MediaId=XmlUtils.findValueByXml(requestXml, "MediaId", null).get(0);
		String Recognition=XmlUtils.findValueByXml(requestXml, "MediaId", null).get(0);
		BeanUtils.setProperty(request, "Format", Format);
		BeanUtils.setProperty(request, "MediaId", MediaId);
		BeanUtils.setProperty(request, "Recognition", Format);
		return request;
	    }
	    else if("".equals(MsgType)) {
		
	    }
	    else if("".equals(MsgType)) {
		
	    }
	    else if("".equals(MsgType)) {
		
	    }
	    else if("".equals(MsgType)) {
		
	    }
	    else if("".equals(MsgType)) {
		
	    }
	    else {
		
	    }
	    
	} catch (Exception e) {
	    throw new RuntimeException("处理请求数据异常");
	}
	
	return request;
    }
    
}
