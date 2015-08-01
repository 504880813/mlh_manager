package rms.untils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 
* @ClassName: StringUtils 
* @Description: 用于字符校验以及字符格式转换
* @author random  
* @date 2015年7月20日 下午6:37:03 
*
 */
public class StringUtils {
	/**
	 * 
	* @Title: isvalid 
	* @Description: 校验字符是否有效 
	* @param @param str
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isvalid(String str){
		boolean flag=false;
		if(str!=null && !str.trim().equals("") && str.trim().length()>0){
			flag=true;
		}
		return flag;
	}
	/**
	 * 
	* @Title: Array2String 
	* @Description:	将字符数组转换成 ,逗号为分割符的字符数据 
	* @param @param array
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String Array2String(String[] array){
		StringBuffer sb=new StringBuffer();
		if(array!=null&&array.length>=1){
			for(int i=0;i<array.length;i++){
				sb.append(array[i]);
				sb.append(",");
			}
			sb.delete(sb.length()-1, sb.length());
		}
		return sb.toString();
	}
	/**
	 * 
	* @Title: String2Array 
	* @Description: 将逗号为分割符的字符数据，转换成字符数组
	* @param @param str
	* @param @return    设定文件 
	* @return ArrayList<String>    返回类型 
	* @throws
	 */
	public static String[] String2Array(String str){
		String[] array=null;
		if(isvalid(str))
			array=str.split(",");
		
		return array;
	}
	/**
	 * 
	* @Title: TrimNullcharacter 
	* @Description: 将数组中的""以及null去除
	* @param @param soruce
	* @param @return    设定文件 
	* @return String[]    返回类型 
	* @throws
	 */
	public static String[] TrimNullcharacter(String[] soruce){
		if(soruce==null||soruce.length<=0){
			return null;
		}
		List<String> templist=new ArrayList<>();
		for(int i=0;i<soruce.length;i++){
			if(isvalid(soruce[i])){
				templist.add(soruce[i]);
			}
		}
		String [] temp=new String[templist.size()];
		temp=templist.toArray(temp);
		return temp;
	}
	/**
	 * 
	* @Title: DateToString 
	* @Description: 将日期转换成指定的格式字符串
	* @param @param date
	* @param @param format
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static  String DateToString(Date date,String format){
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
//	public static void main(String[] args) {
//		String test =DateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
//		System.out.println(test);
//	}
	
}
