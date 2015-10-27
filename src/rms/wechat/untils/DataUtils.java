package rms.wechat.untils;

import java.security.MessageDigest;
import java.util.Random;

/**
 * 
* @ClassName: DataUtils 
* @Description: 数据操作工具类
* @author 邹家兴 
* @date 2015年10月21日 下午8:54:10 
*
 */
public class DataUtils {
    	/**
	 * 采用md5加密
	 */
	public static String md5(String src){
		try {
			StringBuffer buffer = new StringBuffer();
			char[] chars= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] data = md.digest(src.getBytes());
			for(byte b : data){
				//高4位
				buffer.append(chars[(b >> 4) & 0x0F]);
				//低4位
				buffer.append(chars[b & 0x0F]);
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	/**
	 * 
	* @Title: GenerationValidationCode 
	* @Description: 随机生成验证码并返回
	* @param @return    
	* @return String    
	* @throws
	 */
	public static String GenerationValidationCode(int length,int range) {
	    StringBuilder sb=new StringBuilder();
	    for(int i=0;i<length;i++) {
		Random r=new Random();
		sb.append(r.nextInt(range));
	    }
	    if(sb.length()==4) {
		return sb.toString();
	    }else {
		return GenerationValidationCode(length,range);
	    }
	}
	
	
	/*public static void main(String[] args) {
	    int k=0;
	    for(int i=0;i<100;i++) {
		String temp=GenerationValidationCode(4,10);
		System.out.println(temp);
	    }
//	    System.out.println(k);
	}*/
}
