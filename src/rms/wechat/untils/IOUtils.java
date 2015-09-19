package rms.wechat.untils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *   
* @ClassName: IOUtils 
* @Description: io辅助类 
* @author random  
* @date 2015年7月29日 上午10:45:13 
*
 */
public class IOUtils  
{  
    /** 
     * 读取输入流为byte[]数组 
     */  
    public static byte[] read(InputStream instream) throws IOException  
    {  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        while ((len = instream.read(buffer)) != -1)  
        {  
            bos.write(buffer, 0, len);  
        }  
        return bos.toByteArray();  
    }  
    
} 