package staticProxy;
/*	
 * ģ�Ᵽ�涯��,����һ�����涯���Ľӿ�:IUserDao.java,
	Ȼ��Ŀ�����ʵ������ӿڵķ���UserDao.java,
	��ʱ���ʹ�þ�̬����ʽ,����Ҫ�ڴ������(UserDaoProxy.java)��Ҳʵ��IUserDao�ӿ�.
	���õ�ʱ��ͨ�����ô������ķ���������Ŀ�����. 
	��Ҫע�����,���������Ŀ�����Ҫʵ����ͬ�Ľӿ�,Ȼ��ͨ��������ͬ�ķ���������Ŀ�����ķ���
*/
public class test {
	 public static void main(String[] args) {
	        //Ŀ�����
	        UserDao target = new UserDao();

	        //�������,��Ŀ����󴫸��������,���������ϵ
	        UserDaoProxy proxy = new UserDaoProxy(target);

	        proxy.save();//ִ�е��Ǵ���ķ���
	    }
	}