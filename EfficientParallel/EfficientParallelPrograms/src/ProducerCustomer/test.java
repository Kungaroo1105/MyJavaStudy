package ProducerCustomer;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/*
 * ����һ��data���У�queue
 * Producer��Customer�������̣߳��ֱ��queue����offer��take����
 * ��ExecutorService�ṩ���̳߳ضԿ����ģ��������߳̽��й���
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
//		        // ��ѧ�������������Ϻ������ʾ�⣡��  
//		        service.shutdown();  
//		   
//		        // ��thread����ݲ�������ȴ�  
//		        // (���е����񶼽�����ʱ�򣬷���TRUE)  
//		        if(!service.awaitTermination(1000, TimeUnit.MILLISECONDS)){  
//		            // ��ʱ��ʱ�����̳߳������е��̷߳����ж�(interrupted)��  
//		            service.shutdownNow();  
//		        }  
//		    } catch (InterruptedException e) {  
//		        // awaitTermination�������жϵ�ʱ��Ҳ��ֹ�̳߳���ȫ�����̵߳�ִ�С�  
//		        System.out.println("awaitTermination interrupted: " + e);  
//		        service.shutdownNow();  
//		    }  
		Thread.sleep(1000);
		System.out.println(service.isTerminated());

	}
}
