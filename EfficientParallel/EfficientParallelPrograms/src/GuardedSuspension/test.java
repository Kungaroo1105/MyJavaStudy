package GuardedSuspension;

/**
 * @author yhk
 * �����˼����Ƿ����߳̿�ʼ��׼���ã����ϲ鿴�Ƿ����µ�����������µ����󣬾ʹ���
 * ����ʵ�ϣ�����˵Ĵ����������п������ޣ�������Ϊ����Ľ�׳�ԣ������ܶ����κ�һ���ͻ�������
 * ����һ���ȽϺõķ������ǶԿͻ��˵���������Ŷӣ��ŵ��������棬Ȼ������߳�һ��һ���������������ܱ������˴���̫�������������
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