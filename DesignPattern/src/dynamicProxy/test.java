package dynamicProxy;

/**
 * 动态代理有以下特点: 
 * 1.代理对象,不需要实现接口 
 * 2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型) 
 * 3.动态代理也叫做:JDK代理,接口代理
 * 
	JDK中生成代理对象的API 代理类所在包:java.lang.reflect.Proxy JDK实现代理只需要使用newProxyInstance方法,但是该方法需要接收三个参数,完整的写法是:
	static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
	注意该方法是在Proxy类中是静态方法,且接收的三个参数依次为:
	ClassLoader loader,:指定当前目标对象使用类加载器,获取加载器的方法是固定的 Class<?>[] 
	interfaces,:目标对象实现的接口的类型,使用泛型方式确认类型
	InvocationHandler h:事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入 代码示例: 接口类IUserDao.java以及接口实现类,目标对象UserDao是一样的,没有做修改.在这个基础上,增加一个代理工厂类(ProxyFactory.java),将代理类写在这个地方,然后在测试类(需要使用到代理的代码)中先建立目标对象和代理对象的联系,然后代用代理对象的中同名方法
 */



/**
 * 测试类
 */
public class test {
    public static void main(String[] args) {
        // 目标对象
        IUserDao target = new IUserDao() {
			
			@Override
			public void save() {
				// TODO Auto-generated method stub
				System.out.println("1212");
			}
			
			@Override
			public void load() {
				// TODO Auto-generated method stub
				System.out.println("2323");
			}
		};
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.save();
        proxy.load();
    }
}