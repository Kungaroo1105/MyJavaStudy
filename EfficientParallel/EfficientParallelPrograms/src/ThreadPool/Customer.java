package ThreadPool;

import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable{
	private BlockingQueue<PCData> queue;
	private static final int SLEEPTIME = 1000;
	public Customer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.println("start customer id=" + Thread.currentThread().getId());
		try {
			while (true) {
				PCData data= queue.take();
				if(data!=null){
					int res=data.getData()*data.getData();
					System.out.println("result is "+res);
					Thread.sleep(300);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	
}
