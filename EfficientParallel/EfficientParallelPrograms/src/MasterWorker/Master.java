package MasterWorker;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	protected Queue<Object>workQueue=new ConcurrentLinkedQueue<Object>();
	protected Map<String, Thread> threadMap= new Hashtable<String,Thread>();
	protected volatile Map<String, Object> resultMap= new ConcurrentHashMap<String,Object>();
	protected long result;
	public boolean isComplete(){
		for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
			if(entry.getValue().getState()!=Thread.State.TERMINATED){
				System.out.println(entry.getValue().getState());
				return false;
			}
		}
		return true;
//		return workQueue.isEmpty();
	}
	//构造函数需要一个worker和worker的数量
	public Master(Worker worker,int count){
		worker.setWorkQueue(workQueue);
		worker.setResultMap(resultMap);
		for (int i = 0; i < count; i++) {
			threadMap.put(Integer.toString(i), new Thread(worker,Integer.toString(i)));
		}
	}
	
	public void submit(Object obj){
		workQueue.add(obj);
	}
	
	public Map<String, Object> getResultMap(){
		return resultMap;
	}
	public void execute(){
		for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
			entry.getValue().start();
		}
		
	}
}
