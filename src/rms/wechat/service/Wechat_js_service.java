package rms.wechat.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import rms.po.card;
import rms.po.cardRecord;
import rms.wechat.entity.WechatCheck;

/**
 * 
* @ClassName: Wechat_js_service 
* @Description: 微信页面相关的逻辑接口
* @author 邹家兴 
* @date 2015年9月20日 下午8:11:49 
*
 */
public interface Wechat_js_service {
    /**
     * 
    * @Title: BindingMember 
    * @Description: 绑定会员
    * @param @param cardid
    * @param @param openid
    * @param @return
    * @param @throws Exception    
    * @return String  正常返回 0  没有这个卡号返回1 未知错误，返回-1 
    * @throws
     */
    public String BindingMember(String cardid,String openid) throws Exception;
    /**
     * 
    * @Title: getWechatCheckData 
    * @Description: 获取微信验证数据
    * @param @param code
    * @param @return
    * @param @throws Exception    
    * @return WechatCheck    
    * @throws
     */
    public WechatCheck getWechatCheckData(String code,String url) throws Exception;
    
}
