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
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("hello");
		arg1.invoke(real, arg2);
		System.out.println("world");
		return null;
	}
	public Object createCglibProcy(){
		Enhancer en= new Enhancer();
		en.setCallback(this);
		en.setSuperclass(real.getClass());
		Object cglibProxy=en.create();
		return cglibProxy;
	}

}
