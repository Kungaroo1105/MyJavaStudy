package singleton;

public class MyThread extends Thread {

	private int i = 0;

	@Override
	public void run() {
		for (i = 0; i < 100; i++) {
			//Singleton.getInstance();
			System.out.println(Singleton.getInstance().hashCode());
			System.out.println(Thread.currentThread().getName() + " " + i);
			
		}
	}
}