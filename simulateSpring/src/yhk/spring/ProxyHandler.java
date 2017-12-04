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
	// 指定的被切面的方法
	private List methods = new ArrayList<>();

	/**
	 * 绑定对象，创建动态代理
	 * @param target
	 * @return
	 */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	private List<Map<String, String>> beforeBeans = new ArrayList<Map<String, String>>();
	private List<Map<String, String>> afterBeans = new ArrayList<Map<String, String>>();
	private List<Map<String, String>> otherBeans = new ArrayList<Map<String, String>>();

	/**
	 * 读配置文件beanConfig.xml，提取其中的带注解的方法
	 */
	public ProxyHandler() {
		SAXBuilder sb = new SAXBuilder();
		try {
			Document doc = sb.build("beanConfig.xml");
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (int i = 0; i < list.size(); i++) {
				String location = list.get(i).getAttributeValue("location");
				String methodName = list.get(i).getAttributeValue("methodName");
				String methodAnno = list.get(i).getAttributeValue("methodAnno");
				Map<String, String> bean = new HashMap<>();
				bean.put("location", location);
				bean.put("methodName", methodName);
				if (methodAnno.equals("beforeAnno"))
					beforeBeans.add(bean);
				else if (methodAnno.equals("afterAnno"))
					afterBeans.add(bean);
				else
					otherBeans.add(bean);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 指定被切面的类名，可以选择多个
	 * @param methods
	 */
	public void setMethods(String[] methods) {
		if (methods.length==0) System.err.println("no methods selected as cutpoint");
		for (String string : methods) {
			this.methods.add(string);
		}
	}

	public void invokeBefore() {
		for (Map<String, String> bean : beforeBeans) {
			try {
				Class<?> clz = Class.forName(bean.get("location"));
				Method m = clz.getDeclaredMethod(bean.get("methodName"));
				m.invoke(clz.newInstance());
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}

		}
	}

	public void invokeAfter() {
		for (Map<String, String> bean : afterBeans) {
			try {
				Class<?> clz = Class.forName(bean.get("location"));
				Method m = clz.getDeclaredMethod(bean.get("methodName"));
				m.invoke(clz.newInstance());
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}

		}
	}

	public void invokeIt(Method method, Object[] args) {
		invokeBefore();
		try {
			method.invoke(target, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		invokeAfter();
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (methods.isEmpty()) {
			method.invoke(target, args);
		} else if (methods.contains(method.getName())) {
			invokeIt(method, args);
		}
		return null;
	}

}
