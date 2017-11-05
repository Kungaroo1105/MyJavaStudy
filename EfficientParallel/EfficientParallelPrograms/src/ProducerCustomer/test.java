package ProducerCustomer;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/*
 * 设置一个data队列：queue
 * Producer和Customer是两种线程，分别对queue进行offer和take操作
 * 用ExecutorService提供的线程池对开启的（六个）线程进行管理
 */
public class test {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<PCData> queue= new LinkedBlockingQueue<>(20);
		int a=Runtime.getRuntime().availableProcessors();
		Producer p1= new Producer(queue);
		Producer p2= new Producer(queue);
		Producer p3= new Producer(queue);
		Customer c1= new Customer(queue);
		Customer c2= new Customer(queue);
		Customer c3= new Customer(queue);
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(p1);
		service.execute(p2);
		service.execute(p3);
		service.execute(c1);
		service.execute(c2);
		service.execute(c3);
		Thread.sleep(1000);
		p1.stop();
		p2.stop();
		p3.stop();
		Thread.sleep(3000);
		c1.stop();
		c2.stop();
		c3.stop();
		service.shutdown();
		service.shutdownNow();

//		 try {  
//		        // 向学生传达“问题解答完毕后请举手示意！”  
//		        service.shutdown();  
//		   
//		        // 向thread传达“暂不处理”后等待  
//		        // (所有的任务都结束的时候，返回TRUE)  
//		        if(!service.awaitTermination(1000, TimeUnit.MILLISECONDS)){  
//		            // 超时的时候向线程池中所有的线程发出中断(interrupted)。  
//		            service.shutdownNow();  
//		        }  
//		    } catch (InterruptedException e) {  
//		        // awaitTermination方法被中断的时候也中止线程池中全部的线程的执行。  
//		        System.out.println("awaitTermination interrupted: " + e);  
//		        service.shutdownNow();  
//		    }  
		Thread.sleep(1000);
		System.out.println(service.isTerminated());

	}
}
