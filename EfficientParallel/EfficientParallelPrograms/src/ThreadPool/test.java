package ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class test {
/*
 * 两个类（pThread、ThreadPool）模拟一个线程池
 * 
 */
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<PCData> queue= new LinkedBlockingQueue<>(5);
		Producer p1= new Producer(queue);
		Producer p2= new Producer(queue);
		Producer p3= new Producer(queue);
		Producer p4= new Producer(queue);
		Producer p5= new Producer(queue);
		Producer p6= new Producer(queue);
		Customer c1= new Customer(queue);
		Customer c2= new Customer(queue);
		ThreadPool pool = new ThreadPool();
		pool.start(p1);
		pool.start(p2);
		pool.start(p3);
		pool.start(p4);
		pool.start(p5);
		pool.start(p6);
		pool.start(c1);
		//pool.start(c2);
		Thread.sleep(3000);
		p1.stop();
		p2.stop();
		p3.stop();
		p4.stop();
		p5.stop();
		p6.stop();
		pool.shutDown();
	}

}
