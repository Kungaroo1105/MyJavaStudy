package GuardedSuspension;

public class ServerThread extends Thread {
    private RequestQueue requestQueue;
    public ServerThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }
    public void run() {
        // 线程一直存在，直到进程结束. 守护线程。
        while (true) {
            final Request request = requestQueue.getRequest();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " handles  " + request);            
        }
    }
}