package yhk.functions;

import yhk.annotation.Function;
import yhk.annotation.afterAnno;
import yhk.annotation.beforeAnno;
import yhk.spring.BeanFactoryOnMethod;
import yhk.spring.ProxyHandler;

public class Test implements TestInterface {

	/*
	 * 定义切面方法
	 */
	@Override
	public void test() {
		System.out.println("2nd step//////////////////this is the cutpoint");
	}

	/*
	 * 指定搜索范围 指定执行哪种注解 指定在某方法的前后执行
	 */
	public static void main(String[] args) {
		// 指定搜索包名，指定需要使用的注解，写配置文件
		BeanFactoryOnMethod.write("yhk", new Class[] { beforeAnno.class, afterAnno.class });
		// 读配置文件
		ProxyHandler handler = new ProxyHandler();
		// 指定切口方法
		handler.setMethods(new String[] { "test" });
		// 动态代理绑定切面方法
		TestInterface t = (TestInterface) handler.bind(new Test());
		//测试切口方法
		t.test();

	}
}
