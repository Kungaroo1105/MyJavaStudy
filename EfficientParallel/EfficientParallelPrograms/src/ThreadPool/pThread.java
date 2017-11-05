package ThreadPool;

public class pThread extends Thread {
	private ThreadPool pool;
	private Runnable target;
	private boolean isShutdown= false;
	private boolean isIdle =false;
	
	public pThread(Runnable target, String name, ThreadPool pool){
		super(name);
		this.pool=pool;
		this.target=target;
	}
	public Runnable getTarget(){
		return target;
	}
	public boolean isIdle(){
		return isIdle;
	}
	
	public void run(){
		while(!isShutdown){
			isIdle=false;
			if(target!=null){
				target.run();
			}
			isIdle=true;
			try{
				pool.repool(this);
				synchronized (this) {
					wait();
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}isIdle=false;
		}
	}
	
	public synchronized void setTarget(java.lang.Runnable newTarget){
		target= newTarget;
		notifyAll();
	}
	
	public synchronized void shutdown(){
		isShutdown=true;
		notifyAll();
	}
}
