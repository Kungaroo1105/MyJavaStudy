package ProducerCustomer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
	private volatile boolean isRunning = true;
	private BlockingQueue<PCData> queue;
	private static AtomicInteger count = new AtomicInteger();

	public Producer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		PCData data = null;
		System.out.println("start producer id=" + Thread.currentThread().getId());
		try {
			while (isRunning) {
				Thread.sleep(300);
				data= new PCData(count.incrementAndGet());
				System.out.println(data +" is put into queue");
				System.out.println("queue size is: "+queue.size());
				if(!queue.offer(data,2,TimeUnit.SECONDS)){
					System.err.println("failed to put data "+ data);
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
