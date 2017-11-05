package staticProxy;
/*	
 * 模拟保存动作,定义一个保存动作的接口:IUserDao.java,
	然后目标对象实现这个接口的方法UserDao.java,
	此时如果使用静态代理方式,就需要在代理对象(UserDaoProxy.java)中也实现IUserDao接口.
	调用的时候通过调用代理对象的方法来调用目标对象. 
	需要注意的是,代理对象与目标对象要实现相同的接口,然后通过调用相同的方法来调用目标对象的方法
*/
public class test {
	 public static void main(String[] args) {
	        //目标对象
	        UserDao target = new UserDao();

	        //代理对象,把目标对象传给代理对象,建立代理关系
	        UserDaoProxy proxy = new UserDaoProxy(target);

	        proxy.save();//执行的是代理的方法
	    }
	}