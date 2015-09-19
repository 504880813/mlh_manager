package rms.wechat.untils;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


/**
 * 用来处理xml相关操作
 * @author zjx
 *
 */
public class XmlUtils {
	/**
	 * 将字符串转化成xmlDocument对象
	 * 
	 * @param xmlStr
	 * @return Xml文档对象
	 * @throws Exception
	 */
	public static Document StringToXML(String xmlStr) throws Exception{
		StringReader sr = new StringReader(xmlStr);  
		InputSource is = new InputSource(sr);  
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		DocumentBuilder builder=factory.newDocumentBuilder();  
		Document doc = builder.parse(is);
		return doc;
	}
	
	/**
	 * 从传入的xml中查找标签的值
	 * @param xml xml文档对象
	 * @param TagName 标签名
	 * @param attributeName 属性名
	 * @return 上传是否成功
	 * @throws Exception
	 */
	public static List<String> findValueByXml(Document xml,String TagName,String attributeName) throws Exception{
//		NodeList list=xml.getElementsByTagName("h:IsSuccess");
		NodeList list=xml.getElementsByTagName(TagName);
		
		List<String> values=new ArrayList<>();
		for(int i=0;i<list.getLength();i++){
			Node node=list.item(i);
	
			String value="";
			if(attributeName==null){
				value=node.getTextContent();
			}else{
				Node chirdNode=node.getAttributes().getNamedItem(attributeName);
				if(chirdNode!=null){
					value=chirdNode.getTextContent();
				}
			}
			values.add(value);
		}
		return values;
	}
	/**
	 * 
	* @Title: findChrildByXml 
	* @Description: 从传入的xml中找到指定元素
	* @param @param responexml
	* @param @param TagName
	* @param @param ValueTagName
	* @param @param attributeName
	* @param @return    设定文件 
	* @return List<List<String>>    返回类型 
	* @throws
	 */
	public static List<List<String>> findChrildByXml(Document responexml,
			String TagName,String ValueTagName, String attributeName) {
		
		NodeList list=responexml.getElementsByTagName(TagName);
		
		List<List<String>> valuesList=new ArrayList<>();
		List<String> values=null;
		
		for(int i=0;i<list.getLength();i++){
			values=new ArrayList<>();
			NodeList ChrildList=list.item(i).getChildNodes();
			for(int k=0;k<ChrildList.getLength();k++){
				NodeList valueList=ChrildList.item(k).getChildNodes();
				for(int j=0;j<valueList.getLength();j++){
					
					System.out.println(valueList.item(j).getNodeName());
					
					if(valueList.item(j).getNodeName().equals(ValueTagName)){
						String value="";
						if(attributeName==null){
							value=valueList.item(j).getTextContent();
						}else{
							value=valueList.item(j).getAttributes().getNamedItem(attributeName).getTextContent();
						}
						values.add(value);
					}
				}
			}
			valuesList.add(values);
		}
		return valuesList;
	}
	
	
	
}
