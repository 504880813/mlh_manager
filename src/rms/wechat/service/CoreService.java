package rms.wechat.service;

import rms.wechat.entity.ReceiveXmlEntity;

/**
 * 
* @ClassName: CoreService 
* @Description: 微信客户端信息核心处理器
* @author 邹家兴 
* @date 2015年9月24日 下午6:24:46 
*
 */
public interface CoreService {
    /**
     * 
    * @Title: processTextMessage 
    * @Description: 处理文本消息
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String processTextMessage(ReceiveXmlEntity request) throws Exception;
    /**
     * 
    * @Title: processImageMessage 
    * @Description: 处理图片消息
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String processImageMessage(ReceiveXmlEntity request)throws Exception;
    /**
     * 
    * @Title: processVoiceMessage 
    * @Description: 处理语音消息
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String processVoiceMessage(ReceiveXmlEntity request)throws Exception;
    /**
     * 
    * @Title: processVideoMessage 
    * @Description: 处理视频消息
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String processVideoMessage(ReceiveXmlEntity request)throws Exception;
    /**
     * 
    * @Title: processShortVideoMessage 
    * @Description: 处理小视频消息
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String processShortVideoMessage(ReceiveXmlEntity request)throws Exception;
    /**
     * 
    * @Title: processLocationMessage 
    * @Description: 处理地理位置消息
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String processLocationMessage(ReceiveXmlEntity request)throws Exception;
    /**
     * 
    * @Title: processLinkMessage 
    * @Description: 处理链接消息
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String processLinkMessage(ReceiveXmlEntity request)throws Exception;
    /**
     * 
    * @Title: processSubscribeEventMessage 
    * @Description: 处理关注/取消关注事件消息
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String processSubscribeEventMessage(ReceiveXmlEntity request)throws Exception;
    /**
     * 
    * @Title: processSCANEventMessage 
    * @Description: 处理用户已关注时的事件推送消息
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String processSCANEventMessage(ReceiveXmlEntity request)throws Exception;
    /**
     * 
    * @Title: processLOCATIONEventMessage 
    * @Description: 处理上报地理位置事件消息
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String processLOCATIONEventMessage(ReceiveXmlEntity request)throws Exception;
    /**
     * 
    * @Title: processCLICKEventMessage 
    * @Description: 处理点击菜单拉取消息时的事件推送消息
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String processCLICKEventMessage(ReceiveXmlEntity request)throws Exception;
    /**
     * 
    * @Title: processVIEWEventMessage 
    * @Description:处理点击菜单跳转链接时的事件推送消息
    * @param @param request
    * @param @return
    * @param @throws Exception    
    * @return String    
    * @throws
     */
    public String processVIEWEventMessage(ReceiveXmlEntity request)throws Exception;

}
