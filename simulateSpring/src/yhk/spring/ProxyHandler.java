package yhk.spring;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ProxyHandler implements InvocationHandler {
    private Object target = null;
    //指定的被切面的方法
    private List methods=new ArrayList<>();
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

	private List<Map<String,String>> beans= new ArrayList<Map<String, String>>();
	public ProxyHandler() {
		SAXBuilder sb= new SAXBuilder();
		try {
			Document doc= sb.build("beanConfig.xml");
			Element root=doc.getRootElement();
			List<Element> list= root.getChildren();
			for (int i = 0; i < list.size(); i++) {
				String location= list.get(i).getAttributeValue("location");
				String methodName= list.get(i).getAttributeValue("methodName");
				String methodAnno= list.get(i).getAttributeValue("methodAnno");
				Map<String, String> bean =new HashMap<>();
				bean.put("location", location);
				bean.put("methodName", methodName);
				bean.put("methodAnno", methodAnno);
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
	
	public void setMethods(String[] methods){
		for (String string : methods) {
			this.methods.add(string);
		}
	}

	public void invokeBefore() {
		for (Map<String, String> bean : beans) {
				try {
					Class<?> clz= Class.forName(bean.get("location"));
					Method m= clz.getDeclaredMethod(bean.get("methodName"));
					m.invoke(clz.newInstance());
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
		}
	}
	public void invokeAfter() {
		for (Map<String, String> bean : beans) {
			if (bean.get("methodName").equals("afterAnno")){
				try {
					Class<?> clz= Class.forName(bean.get("location"));
					Method m= clz.getDeclaredMethod(bean.get("methodName"));
					m.invoke(clz.newInstance());
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		}
	}
	
	public void invokeIt(Method method, Object[] args) {
		invokeBefore();
		try {
			Object result = method.invoke(target, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		invokeAfter();
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		ProxyHandler a= new ProxyHandler();
		if (methods.isEmpty()){method.invoke(target, args);}
		else if (methods.contains(method.getName())){
			invokeIt(method, args);
		}
		
		return null;
	}
	
}
