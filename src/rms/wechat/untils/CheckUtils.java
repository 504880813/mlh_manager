package rms.wechat.untils;

import java.util.Collections;
import java.util.List;

/**
 * 
* @ClassName: CheckUtils 
* @Description: 校验工具类
* @author 邹家兴 
* @date 2015年8月11日 下午3:58:38 
*
 */
public class CheckUtils {
    /**
     * 
    * @Title: VerificationAccess 
    * @Description: 将字符串数组进行字典排序sha1加密后与第二个参数进行对比 
    * @param @param eqList
    * @param @param eq
    * @param @return    
    * @return boolean    
    * @throws
     */
    public static boolean VerificationAccess(List<String> eqList,String eq) {
	
	Collections.sort(eqList);
	StringBuffer sb=new StringBuffer();
	for(int i=0;i<eqList.size();i++) {
	    sb.append(eqList.get(i));
	}
	String temp=ComputeUtils.getSha1(sb.toString());
	
	return temp.equals(eq);
	
    }
    
    
}
