package ThreadRunnable;

public class testThread {
	public static void main(String[] args) {
		MyThread m1= new MyThread();
//		MyThread m2= new MyThread();
//		MyThread m3= new MyThread();
		//无法共享资源
//		m1.start();
//		m2.start();
//		m3.start();
		//Thread类也是Runnable接口的子类，这种写法就相当于实现了runnable接口
		//最好不要这样创建线程，应该用线程池的方式，增强对线程进行管理
		new Thread(m1).start();
		new Thread(m1).start();
		new Thread(m1).start();
	}
	
}
