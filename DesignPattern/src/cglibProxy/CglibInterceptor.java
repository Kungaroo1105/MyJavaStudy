package cglibProxy;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibInterceptor implements MethodInterceptor {
	
	Object real=null;
	public CglibInterceptor(Object real) {
		this.real=real;
	}
	/* (non-Javadoc)
	 * obj和proxy是代理对象自己的，method和param是被代理（父类）方法的
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] param, MethodProxy proxy) throws Throwable {
		System.out.println("hello");
		//调用父类方法
		proxy.invokeSuper(obj, param);
		//method.invoke(real, param);
		System.out.println("world");
		return null;
	}
//	public Object createCglibProcy(){
//		Enhancer en= new Enhancer();
//		en.setCallback(this);
//		en.setSuperclass(real.getClass());
//		Object cglibProxy=en.create();
//		return cglibProxy;
//	}

}
