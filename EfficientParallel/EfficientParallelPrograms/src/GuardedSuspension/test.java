package GuardedSuspension;

/**
 * @author yhk
 * 其核心思想就是服务线程开始就准备好，不断查看是否有新的请求，如果有新的请求，就处理。
 * 但事实上，服务端的处理能力很有可能有限，但是作为程序的健壮性，不可能丢掉任何一个客户端请求，
 * 这种一个比较好的方案就是对客户端的请求进行排队，放到队列里面，然后服务线程一个一个处理。这样至少能避免服务端处理太多请求而崩溃。
 */
public class test {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        for(int i=0;i<10;i++) {
            new ServerThread(requestQueue, "ServerThread"+i).start();
        }
        for(int i=0;i<10;i++){
            new ClientThread(requestQueue, "ClientThread"+i).start();
        }
    }
}