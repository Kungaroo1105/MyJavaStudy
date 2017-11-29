package spring;
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
import org.jdom2.output.XMLOutputter;
/**
 * 首先要明确导入的是哪些类
 *  1、Document用于生成文档，定义了格式
 *  2、Element用于为xml文档中的元素设置key和value
 *  3、XMLOutputter用于将已经设置好值的document输出到一个xml文档中。
 */
public class WriteXML {
	
	 public static void printXml(List<Map<String,String>>list){
	  //定义一个root作为xml文档的根元素
	  Element root = new Element("beans"); 
	  //生成一个文档
	  Document Doc = new Document(root);   
	  for (int i = 0; i < list.size(); i++) { 
	      Element elements = new Element("bean");   
	      Map<String,String> beanPropertyMap= list.get(i);
	    	  	Set attribute= beanPropertyMap.keySet();
	    	  	for (Object attr : attribute) {
	    	  		elements.setAttribute((String)attr, beanPropertyMap.get(attr) );   
	      }
	      //将已经设置好值的elements赋给root
	      root.addContent(elements); 
	     } 
	     //定义一个用于输出xml文档的类
	     XMLOutputter XMLOut = new XMLOutputter();  
	     
	     try {
	   //将生成的xml文档Doc输出到c盘的test.xml文档中
	   XMLOut.output(Doc, new FileOutputStream("beanConfig.xml"));
	  } catch (FileNotFoundException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  } 
	 }
	 /**
	  * 测试
	  * @param args
	  */
	 public static void main(String[] args) {
	  // TODO Auto-generated method stub
		 List<Map<String,String>>list= new ArrayList<Map<String,String>>();
		 Map<String, String> a= new HashMap<String,String>();
		 Map<String, String> b= new HashMap<String,String>();
		 a.put("className", "yhk");
		 a.put("location", "spring.");
		 b.put("className", "YHK");
		 b.put("location", "src.spring.");
		 list.add(a);
		 list.add(b);
		 printXml(list);
	 }
	
}
