package dynamicProxy;

/**
 * ��̬�����������ص�: 
 * 1.�������,����Ҫʵ�ֽӿ� 
 * 2.������������,������JDK��API,��̬�����ڴ��й����������(��Ҫ����ָ�������������/Ŀ�����ʵ�ֵĽӿڵ�����) 
 * 3.��̬����Ҳ����:JDK����,�ӿڴ���
 * 
	JDK�����ɴ�������API ���������ڰ�:java.lang.reflect.Proxy JDKʵ�ִ���ֻ��Ҫʹ��newProxyInstance����,���Ǹ÷�����Ҫ������������,������д����:
	static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
	ע��÷�������Proxy�����Ǿ�̬����,�ҽ��յ�������������Ϊ:
	ClassLoader loader,:ָ����ǰĿ�����ʹ���������,��ȡ�������ķ����ǹ̶��� Class<?>[] 
	interfaces,:Ŀ�����ʵ�ֵĽӿڵ�����,ʹ�÷��ͷ�ʽȷ������
	InvocationHandler h:�¼�����,ִ��Ŀ�����ķ���ʱ,�ᴥ���¼��������ķ���,��ѵ�ǰִ��Ŀ�����ķ�����Ϊ�������� ����ʾ��: �ӿ���IUserDao.java�Լ��ӿ�ʵ����,Ŀ�����UserDao��һ����,û�����޸�.�����������,����һ����������(ProxyFactory.java),��������д������ط�,Ȼ���ڲ�����(��Ҫʹ�õ�����Ĵ���)���Ƚ���Ŀ�����ʹ���������ϵ,Ȼ����ô���������ͬ������
 */



/**
 * ������
 */
public class test {
    public static void main(String[] args) {
        // Ŀ�����
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
        // ��ԭʼ������ class cn.itcast.b_dynamic.UserDao��
        System.out.println(target.getClass());

        // ��Ŀ����󣬴����������
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   �ڴ��ж�̬���ɵĴ������
        System.out.println(proxy.getClass());

        // ִ�з���   ���������
        proxy.save();
        proxy.load();
    }
}