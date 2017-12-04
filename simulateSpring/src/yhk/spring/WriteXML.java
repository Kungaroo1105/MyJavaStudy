package yhk.spring;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * 首先要明确导入的是哪些类 1、Document用于生成文档，定义了格式 2、Element用于为xml文档中的元素设置key和value
 * 3、XMLOutputter用于将已经设置好值的document输出到一个xml文档中
 */
public class WriteXML {

	public static void printXml(List<Map<String, String>> list) {
		// 定义一个root作为xml文档的根元素
		Element root = new Element("beans");
		Document Doc = new Document(root);
		for (int i = 0; i < list.size(); i++) {
			Element elements = new Element("bean");
			Map<String, String> beanPropertyMap = list.get(i);
			Set attribute = beanPropertyMap.keySet();
			for (Object attr : attribute) {
				elements.setAttribute((String) attr, beanPropertyMap.get(attr));
			}
			// 将已经设置好值的elements赋给root
			root.addContent(elements);
		}
		
		//格式化XML
		Format format = Format.getCompactFormat();  
        format.setEncoding("utf-8");  
        //这行保证输出后的xml的格式  
        format.setIndent(" ");  
        // 定义一个用于输出xml文档的类
        XMLOutputter XMLOut = new XMLOutputter(format);  
		
		try {
			// 将生成的xml文档Doc输出到本地的beanConfig.xml文档
			XMLOut.output(Doc, new FileOutputStream("beanConfig.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> a = new HashMap<String, String>();
		Map<String, String> b = new HashMap<String, String>();
		a.put("methodName", "yhk");
		a.put("location", "spring.");
		b.put("methodName", "YHK");
		b.put("location", "src.spring.");
		list.add(a);
		list.add(b);
		printXml(list);
	}

}
