package rms.wechat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import rms.mapper.cardMapper;
import rms.mapper.wechatuserMapper;
import rms.wechat.service.Wechat_service;
/**
 * 
* @ClassName: Wechat_serviceImpl 
* @Description: 处理微信非页面的相关逻辑
* @author 邹家兴 
* @date 2015年9月22日 下午11:52:53 
*
 */
@Component
public class Wechat_serviceImpl implements Wechat_service {
    	
    	@Resource
    	private cardMapper cardMapper;
    	@Resource
    	private wechatuserMapper wechatuserMapper;
    	
    	
    	
}
