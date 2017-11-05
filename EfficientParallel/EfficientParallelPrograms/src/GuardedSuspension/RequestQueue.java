package GuardedSuspension;

import java.util.LinkedList;

public class RequestQueue {
	 private final LinkedList<Request> queue = new LinkedList<Request>();
	 
	    public synchronized Request getRequest(){
	        while(queue.size()<=0){
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	         
	        return queue.removeFirst();
	    }
	     
	    public synchronized void addRequest(Request request){
	        queue.addLast(request);
	        notifyAll();
	    }
	}