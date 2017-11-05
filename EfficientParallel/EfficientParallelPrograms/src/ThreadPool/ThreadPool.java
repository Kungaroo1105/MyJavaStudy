package ThreadPool;

import java.util.List;
import java.util.Vector;

public class ThreadPool {
	private static ThreadPool instance;
	private List<pThread> idleThreads;
	private int threadCount;
	private boolean isShutdown;
	ThreadPool(){
		this.idleThreads= new Vector(5);
		threadCount=0;
	}
	
	public int getThreadCount() {
		return threadCount;
	}

	public synchronized static ThreadPool getInstance(){
		if(instance==null){
			instance = new ThreadPool();
		}
		return instance;
	}
	public synchronized void repool(pThread t){
		if(!isShutdown){
			idleThreads.add(t);
		}else t.shutdown();
	}
	public synchronized void shutDown(){
		isShutdown=true;
		for(int i=0;i<idleThreads.size();i++){
			pThread idleThread= (pThread)idleThreads.get(i);
			idleThread.shutdown();
		}
	}
	
	public synchronized void start(Runnable target){
		pThread t =null;
		if(idleThreads.size()>0){
			int lastIndex=idleThreads.size()-1;
			t = (pThread)idleThreads.get(lastIndex);
			idleThreads.remove(lastIndex);
			t.setTarget(target);
		}
		//否则创建新线程
		else {
			threadCount++;
			t= new pThread(target,"pThread #"+threadCount,this);
			t.start();
		}
	}
}
