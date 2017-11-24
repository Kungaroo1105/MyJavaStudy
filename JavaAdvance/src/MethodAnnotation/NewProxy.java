package MethodAnnotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;




public class NewProxy {
	public <T> T testProxy(Object bean,String methodName, Object... obj) {
		Class<? extends Object> cls=bean.getClass();
		try {
					
			java.lang.reflect.Method[] methods= cls.getDeclaredMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(MethodAnno.class)){
					if(method.getName().equals(methodName)){
					System.out.println("setting value through method "+methodName);
					method.invoke(bean,obj);
					System.out.println("value has been set");
					}
				}
			}
			
			
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return (T) bean;
	}
}
