package rms.untils;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
* @ClassName: FileUtils 
* @Description: 文件相关操作类
* @author random  
* @date 2015年7月20日 下午3:26:38 
*
 */
public class FileUtils {
	/**
	 * 餐桌图片的实际路径以及映射路径
	 */
	public static final String diningTablepath="C:\\tempImage\\rms\\diningTable\\";
	public static final String diningTableMappingPath="/pic/rms/diningTable/";
	/**
	 * 菜品图片的实际路径以及映射路径
	 */
	public static final String dishpath="C:\\tempImage\\rms\\dish\\";
	public static final String dishMappingPath="/pic/rms/dish/";
	/**
	 * 微信广告图片的实际路径以及映射路径
	 */
	public static final String wechatAdvertisementpath="C:\\tempImage\\rms\\wechatAdvertisement\\";
	public static final String wechatAdvertisementMappingPath="/pic/rms/wechatAdvertisement/";
	/**
	 * 
	* @Title: uploadImage 
	* @Description: 上传文件到指定位置
	* @param @param imageFile
	* @param @param path
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String uploadImage(MultipartFile imageFile,String path) throws Exception{
		String image=imageFile.getOriginalFilename();
		if(image!=null &&image.trim().length()>0){
		String NewImageFileName=UUID.randomUUID()+image.substring(image.lastIndexOf("."));
		File newIamgeFile=new File(path+NewImageFileName);
		imageFile.transferTo(newIamgeFile);
		return NewImageFileName;
		}
		return null;
	}
	/**
	 * 
	* @Title: clearDir 
	* @Description: 清空文件目录 
	* @param @param dirPath
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean clearDir(String dirPath){
		boolean flag=false;
		File dir=new File(dirPath);
		File[] files=dir.listFiles();
		for(File f:files){
			if(f.isFile()){
				flag=f.delete();
			}
			System.out.println(f.getName());
		}
		return flag;
	}
	/**
	 * 
	* @Title: deleteFileByMapping 
	* @Description: 根据本地路径以及映射路径以及映射完整路径删除文件
	* @param @param path
	* @param @param mappingPath    设定文件 
	* @param @param mappingUrlPath    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void deleteFileByMapping(String path,String mappingPath, String mappingUrlPath) {
		String fileName=mappingUrlPath.replaceAll(mappingPath, "");
		String filepath=path+fileName;
//		System.out.println(filepath);
		File temp=new File(filepath);
		temp.delete();
	}
	
//	public static void main(String[] args) {
//		deleteFileByMapping(dishpath,dishMappingPath,"/pic/rms/dish/34022291-c8fa-4f63-a7c4-854aa8e39002.jpg");
//	}
	
}
