package yhk.spring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ClassPathXmlApplicationContext{

	private List<Map<String,String>> beans= new ArrayList<Map<String, String>>();
	public  ClassPathXmlApplicationContext() {
		SAXBuilder sb= new SAXBuilder();
		try {
			Document doc= sb.build("beanConfig.xml");
			Element root=doc.getRootElement();
			List<Element> list= root.getChildren();
			for (int i = 0; i < list.size(); i++) {
				String location= list.get(i).getAttributeValue("location");
				String methodName= list.get(i).getAttributeValue("methodName");
				Map<String, String> bean =new HashMap<>();
				bean.put("location", location);
				bean.put("methodName", methodName);
				beans.add(bean);
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object getBean(String o) {
		for (Map<String, String> bean : beans) {
			if(bean.get("methodName").equals(o)) {
				return bean.get("location");
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext a= new ClassPathXmlApplicationContext();
		System.out.println(a.getBean("YHK"));
	}
	
}
