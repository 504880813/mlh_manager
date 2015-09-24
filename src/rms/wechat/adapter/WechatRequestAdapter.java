package rms.wechat.adapter;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import rms.wechat.entity.ReceiveXmlEntity;
import rms.wechat.service.CoreService;
import rms.wechat.untils.XmlUtils;

/**
 * 
* @ClassName: WechatRequestAdapter 
* @Description: 用来分析微信服务器传递过来的请求数据，并分发给响应方法
* @author 邹家兴 
* @date 2015年8月13日 下午2:09:12 
*
 */
@Component
public class WechatRequestAdapter {
    
    @Resource
    private CoreService coreService;
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
	return processRequest(requestMessage);
	
//	coreService.processTextMessage(request);

//	return "<xml>"+
//	"<ToUserName><![CDATA["+FromUserName+"]]></ToUserName>"+
//	"<FromUserName><![CDATA["+ToUserName+"]]></FromUserName>"+
//	"<CreateTime>154354</CreateTime>"+
//	"<MsgType><![CDATA[text]]></MsgType>"+
//	"<Content><![CDATA[你好]]></Content>"+
//	"</xml>";
    }
    /**
     * 
    * @Title: processRequest 
    * @Description: 将请求数据转换成一个ReceiveXmlEntity对象 并分发给不同的处理器处理
    * @param @param requestMessage
    * @param @return    
    * @return String    
    * @throws
     */
    private String processRequest(String requestMessage) {
	ReceiveXmlEntity request=null;
	
	try {
	    
	    Document requestXml=XmlUtils.StringToXML(requestMessage);
	    
	    //基础数据
	    String ToUserName=XmlUtils.findValueByXml(requestXml, "ToUserName", null).get(0);
	    String FromUserName=XmlUtils.findValueByXml(requestXml, "FromUserName", null).get(0);
	    String CreateTime=XmlUtils.findValueByXml(requestXml, "CreateTime", null).get(0);
	    String MsgType=XmlUtils.findValueByXml(requestXml, "MsgType", null).get(0);
	    
	    //封装基本数据
	    request=new ReceiveXmlEntity();
	    BeanUtils.setProperty(request, "toUserName", ToUserName);
	    BeanUtils.setProperty(request, "fromUserName", FromUserName);
	    BeanUtils.setProperty(request, "createTime", CreateTime);
	    BeanUtils.setProperty(request, "msgType", MsgType);
	    
	    List<String> msgids=XmlUtils.findValueByXml(requestXml, "MsgId", null);
	    if(msgids!=null&&msgids.size()>0) {
		 String MsgId=msgids.get(0);
		 BeanUtils.setProperty(request, "msgId", MsgId);
	    }
	    //根据不同的类型查询并封装数据
	    //文本消息
	    if("text".equals(MsgType)) {
		String Content=XmlUtils.findValueByXml(requestXml, "Content", null).get(0);
		BeanUtils.setProperty(request, "content", Content);
		return coreService.processTextMessage(request);
	    }
	    //图片数据
	    else if("image".equals(MsgType)) {
		String PicUrl=XmlUtils.findValueByXml(requestXml, "PicUrl", null).get(0);
		String MediaId=XmlUtils.findValueByXml(requestXml, "MediaId", null).get(0);
		BeanUtils.setProperty(request, "picUrl", PicUrl);
		BeanUtils.setProperty(request, "mediaId", MediaId);
		return coreService.processImageMessage(request);
	    }
	    //语言消息
	    else if("voice".equals(MsgType)) {
		String Format=XmlUtils.findValueByXml(requestXml, "Format", null).get(0);
		String MediaId=XmlUtils.findValueByXml(requestXml, "MediaId", null).get(0);
		String Recognition=XmlUtils.findValueByXml(requestXml, "Recognition", null).get(0);
		BeanUtils.setProperty(request, "format", Format);
		BeanUtils.setProperty(request, "mediaId", MediaId);
		BeanUtils.setProperty(request, "recognition", Recognition);
		return coreService.processVoiceMessage(request);
	    }
	    //视频消息
	    else if("video".equals(MsgType)) {
		String MediaId=XmlUtils.findValueByXml(requestXml, "MediaId", null).get(0);
		String ThumbMediaId=XmlUtils.findValueByXml(requestXml, "ThumbMediaId", null).get(0);
		BeanUtils.setProperty(request, "mediaId", MediaId);
		BeanUtils.setProperty(request, "thumbMediaId", ThumbMediaId);
		return coreService.processVideoMessage(request);
	    }
	    //小视频消息
	    else if("shortvideo".equals(MsgType)) {
		String MediaId=XmlUtils.findValueByXml(requestXml, "MediaId", null).get(0);
		String ThumbMediaId=XmlUtils.findValueByXml(requestXml, "ThumbMediaId", null).get(0);
		BeanUtils.setProperty(request, "mediaId", MediaId);
		BeanUtils.setProperty(request, "thumbMediaId", ThumbMediaId);
		return coreService.processShortVideoMessage(request);
	    }
	    //地理位置消息
	    else if("location".equals(MsgType)) {
		String Location_X=XmlUtils.findValueByXml(requestXml, "Location_X", null).get(0);
		String Location_Y=XmlUtils.findValueByXml(requestXml, "Location_Y", null).get(0);
		String Scale=XmlUtils.findValueByXml(requestXml, "Scale", null).get(0);
		String Label=XmlUtils.findValueByXml(requestXml, "Label", null).get(0);
		BeanUtils.setProperty(request, "location_X", Location_X);
		BeanUtils.setProperty(request, "location_Y", Location_Y);
		BeanUtils.setProperty(request, "scale", Scale);
		BeanUtils.setProperty(request, "label", Label);
		return coreService.processLocationMessage(request);
	    }
	    //链接消息
	    else if("link".equals(MsgType)) {
		String Title=XmlUtils.findValueByXml(requestXml, "Title", null).get(0);
		String Description=XmlUtils.findValueByXml(requestXml, "Description", null).get(0);
		String Url=XmlUtils.findValueByXml(requestXml, "Url", null).get(0);
		BeanUtils.setProperty(request, "title", Title);
		BeanUtils.setProperty(request, "description", Description);
		BeanUtils.setProperty(request, "url", Url);
		return coreService.processLinkMessage(request);
	    }
	    //事件推送
	    else if("event".equals(MsgType)) {
		//判断是什么类型的事件
		String Event=XmlUtils.findValueByXml(requestXml, "Event", null).get(0);
		//关注/取消关注事件
		if("subscribe".equals(Event)) {
		    return coreService.processSubscribeEventMessage(request);
		}
		//用户已关注时的事件推送
		else if("SCAN".equals(Event)){
		    String EventKey=XmlUtils.findValueByXml(requestXml, "EventKey", null).get(0);
		    String Ticket=XmlUtils.findValueByXml(requestXml, "Ticket", null).get(0);
		    BeanUtils.setProperty(request, "eventKey", EventKey);
		    BeanUtils.setProperty(request, "ticket", Ticket);
		    return coreService.processSCANEventMessage(request);
		}
		//上报地理位置事件
                else if("LOCATION".equals(Event)){
                    String Latitude=XmlUtils.findValueByXml(requestXml, "Latitude", null).get(0);
		    String Longitude=XmlUtils.findValueByXml(requestXml, "Longitude", null).get(0);
		    String Precision=XmlUtils.findValueByXml(requestXml, "Precision", null).get(0);
		    BeanUtils.setProperty(request, "latitude", Latitude);
		    BeanUtils.setProperty(request, "longitude", Longitude);
		    BeanUtils.setProperty(request, "precision", Precision);
		    return coreService.processLOCATIONEventMessage(request);	    
                }
		//点击菜单拉取消息时的事件推送
                else if("CLICK".equals(Event)){
                    String EventKey=XmlUtils.findValueByXml(requestXml, "EventKey", null).get(0);
    		    BeanUtils.setProperty(request, "eventKey", EventKey);
    		    return coreService.processCLICKEventMessage(request);	
                }
		//点击菜单跳转链接时的事件推送
                else if("VIEW".equals(Event)){
                    String EventKey=XmlUtils.findValueByXml(requestXml, "EventKey", null).get(0);
    		    BeanUtils.setProperty(request, "eventKey", EventKey);
    		    return coreService.processVIEWEventMessage(request);
                }
	    }
	    else {
		 throw new RuntimeException("处理请求数据异常");
	    }
	    
	} catch (Exception e) {
	    throw new RuntimeException("处理请求数据异常");
	}
	return null;
    }
    
}
