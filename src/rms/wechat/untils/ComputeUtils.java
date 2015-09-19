package rms.wechat.untils;

import java.security.MessageDigest;

public class ComputeUtils {

    /**
     * 
    * @Title: getSha1 
    * @Description: 得到sha1加密后的字符
    * @param @param str
    * @param @return    
    * @return String    
    * @throws
     */
    public  static String getSha1(String str) {  
	if (str == null) {  
	    return null;  
	}  
	try {  
	    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");  
	    messageDigest.update(str.getBytes());  
	    return getFormattedText(messageDigest.digest());  
	} catch (Exception e) {  
	    throw new RuntimeException(e);  
	}  
    }
    
    private static String getFormattedText(byte[] bytes){
	char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',  
	    '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};  

	int len = bytes.length;  
	StringBuilder buf = new StringBuilder(len * 2);  
	// 把密文转换成十六进制的字符串形式  
	for (int j = 0; j < len; j++) {  
	    buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);  
	    buf.append(HEX_DIGITS[bytes[j] & 0x0f]);  
	}  
	return buf.toString();  
    }  
}  

