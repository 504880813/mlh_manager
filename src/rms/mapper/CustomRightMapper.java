package rms.mapper;

import rms.po.right;

/**
 * 
* @ClassName: CustomRightMapper 
* @Description:自定义权限操作mapper 
* @author 邹家兴 
* @date 2015年10月19日 下午10:10:29 
*
 */
public interface CustomRightMapper {
    /**
     * 
    * @Title: findMaxPosAndMaxCode 
    * @Description: 查询最大权限位的最大权限码
    * @param @return
    * @param @throws Exception    
    * @return right    
    * @throws
     */
    public right findMaxPosAndMaxCode() throws Exception;
}
