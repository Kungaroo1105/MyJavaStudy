package SynchronizeTest;

/*
 * ������̹߳���˶�����һ��һ��ִ�д�����е�����
 * �����static����Ҳ����ThreadTest.Class����˼�ǹ��������JVM���ɵ�Class��ʵ����
 * ����Ƿ�static��������this����˼�ǹ������ʵ��������this�ǵ���������Ķ���
 * synchronize���εķ�������̬����Ĭ����ThreadTest.Class���Ǿ�̬Ĭ����this
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
