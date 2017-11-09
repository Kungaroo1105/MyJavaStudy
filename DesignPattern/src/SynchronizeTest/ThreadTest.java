package SynchronizeTest;

/*
 * 若多个线程共享此对象，则一个一个执行代码块中的内容
 * 如果是static方法也可用ThreadTest.Class，意思是共享类对象（JVM生成的Class类实例）
 * 如果是非static方法可用this，意思是共享类的实例变量（this是调这个方法的对象）
 * synchronize修饰的方法：静态方法默认锁ThreadTest.Class，非静态默认锁this
 */
public class ThreadTest {
	public static ThreadTest singleton= new ThreadTest();
	
	public synchronized static void a(){
		System.out.println("a is running");
	}
	public static void b(){
		synchronized (singleton) {
			System.out.println("b is running");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void c(){
		synchronized (ThreadTest.class) {
			System.out.println("c is running");
		}
	}
	public synchronized void d(){
		System.out.println("d is running");
	}
	public void e(){
		synchronized (this) {
			System.out.println("e is running");
		}
	}
	public void f(){
		synchronized (singleton) {
			System.out.println("f is running");
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Runnable() {			
			@Override
			public void run() {
				ThreadTest.b();
			}
		},"thread1").start();
		new Thread(new Runnable() {			
			@Override
			public void run() {
				singleton.d();
			}
		},"thread2").start();
	}
}
