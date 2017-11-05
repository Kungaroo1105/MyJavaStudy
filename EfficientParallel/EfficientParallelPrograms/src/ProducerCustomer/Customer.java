package ProducerCustomer;

import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable{
	private BlockingQueue<PCData> queue;
	private static final int SLEEPTIME = 1000;
	private volatile boolean isRunning=true;
	public Customer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.println("start customer id=" + Thread.currentThread().getId());
		try {
			while (isRunning) {
				PCData data= queue.take();
				if(data!=null){
					int res=data.getData()*data.getData();
					System.out.println("result is "+res);
					Thread.sleep(30);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	public void stop(){
		isRunning=false;
	}
	
}
