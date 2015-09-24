package rms.wechat.service.impl;

import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import rms.po.card;
import rms.service.cardService;
import rms.wechat.Enumeration.wechatCustomMenuKey;
import rms.wechat.entity.ReceiveXmlEntity;
import rms.wechat.service.CoreService;
import rms.wechat.untils.IOUtils;
/**
 * 
* @ClassName: CoreServiceImpl 
* @Description: 微信客户端请求的相关逻辑处理器
* @author 邹家兴 
* @date 2015年9月24日 下午6:25:22 
*
 */
@Component
public class CoreServiceImpl implements CoreService {
    
    @Resource
    private cardService cardService;
    
    @Override
    public String processTextMessage(ReceiveXmlEntity request) throws Exception {
	InputStream instream =CoreServiceImpl.class.getResourceAsStream("/wechat/responseXml/TextMessage.xml");
	String XMLTemplate = new String(IOUtils.read(instream), "UTF-8");  
	String sendXML = XMLTemplate.replaceAll("\\$toUser", request.getFromUserName())
				    .replaceAll("\\$fromUser", request.getToUserName())
				    .replaceAll("\\$createTime", String.valueOf(System.currentTimeMillis()))
				    .replaceAll("\\$content", request.getContent());
	return sendXML;
    }

    @Override
    public String processImageMessage(ReceiveXmlEntity request)
	    throws Exception {
	return null;
    }

    @Override
    public String processVoiceMessage(ReceiveXmlEntity request)
	    throws Exception {
	return null;
    }
    @Override
    public String processVideoMessage(ReceiveXmlEntity request)
	    throws Exception {
	return null;
    }
    @Override
    public String processShortVideoMessage(ReceiveXmlEntity request)
	    throws Exception {
	return null;
    }
    @Override
    public String processLocationMessage(ReceiveXmlEntity request)
	    throws Exception {
	return null;
    }

    @Override
    public String processLinkMessage(ReceiveXmlEntity request) throws Exception {
	return null;
    }

    @Override
    public String processSubscribeEventMessage(ReceiveXmlEntity request)
	    throws Exception {
	return null;
    }

    @Override
    public String processSCANEventMessage(ReceiveXmlEntity request)
	    throws Exception {
	return null;
    }

    @Override
    public String processLOCATIONEventMessage(ReceiveXmlEntity request)
	    throws Exception {
	return null;
    }

    @Override
    public String processCLICKEventMessage(ReceiveXmlEntity request)
	    throws Exception {
	
	InputStream instream =CoreServiceImpl.class.getResourceAsStream("/wechat/responseXml/TextMessage.xml");
	String XMLTemplate = new String(IOUtils.read(instream), "UTF-8");  
	
	String eventkey=request.getEventKey();
	//获取用户基本数据并返回
	if(wechatCustomMenuKey.get_UserBasicInformation.value.equals(eventkey)) {
	    //查询基本信息，根据openid
	    card usercard=cardService.findcardBywechatOpneid(request.getFromUserName());
	    String content = "";
	    if(usercard==null) {
		content="请先绑定会员卡";
	    }else {
		content+="卡号:";
		content+=usercard.getCardid();
		content+="\n 用户名:";
		content+=usercard.getUsername();
		content+="\n 电话:";
		content+=usercard.getPhone();
		content+="\n 使用状态:";
		content+=usercard.getIsavailable()?"正常使用":"冻结";
		content+="\n 余额:";
		content+=usercard.getMoney();
		content+="\n 月积分:";
		content+=usercard.getMonthIntegral();
		content+="\n 总积分:";
		content+=usercard.getAllIntegral();
	    }
	    String sendXML = XMLTemplate.replaceAll("\\$toUser", request.getFromUserName())
		    .replaceAll("\\$fromUser", request.getToUserName())
		    .replaceAll("\\$createTime", String.valueOf(System.currentTimeMillis()))
		    .replaceAll("\\$content", content);
	    return sendXML;
	}
	
	return null;
	
    }
    
    @Override
    public String processVIEWEventMessage(ReceiveXmlEntity request)
	    throws Exception {
	return null;
    }

}
