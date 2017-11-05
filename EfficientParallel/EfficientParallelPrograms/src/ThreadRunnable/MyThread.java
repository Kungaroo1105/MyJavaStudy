package ThreadRunnable;

public class MyThread extends Thread{
	private int ticket=10;
	public synchronized void run(){
		while(ticket>0){
			if (ticket>0){
				System.out.println("ticket "+ ticket +" sold");
				ticket--;
			}
		}
	}
}
