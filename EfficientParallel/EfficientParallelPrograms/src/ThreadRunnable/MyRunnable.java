package ThreadRunnable;

public class MyRunnable implements Runnable{
	private int ticket=10;
	@Override
	public void run() {
		for (int i=0;i<10;i++){
			if (ticket>0){
				System.out.println("ticket "+ ticket +" sold");
				ticket--;
			}
		}
	}
	
}
