package yhk.functions;

import yhk.annotation.Function;
import yhk.annotation.afterAnno;
import yhk.annotation.beforeAnno;
import yhk.spring.BeanFactoryOnMethod;
import yhk.spring.ProxyHandler;

public class Test implements TestInterface{
	
	@Override
	public void test(){
		System.out.println("middle");
	}
	/*
	 *  指定搜索范围
	 *  指定执行哪种注解
	 *	指定在某方法的前后执行 
	 */
	public static void main(String[] args) {
		//指定搜索包名
		BeanFactoryOnMethod.write("yhk",new Class[]{beforeAnno.class,afterAnno.class});
		//注册要被切面的方法
		ProxyHandler handler= new ProxyHandler();
		handler.setMethods(new String[]{"test"});
		TestInterface t= (TestInterface)handler.bind(new Test());
		t.test();
		
		
	}
}
