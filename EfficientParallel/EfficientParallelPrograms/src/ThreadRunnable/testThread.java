package ThreadRunnable;

public class testThread {
	public static void main(String[] args) {
		MyThread m1= new MyThread();
//		MyThread m2= new MyThread();
//		MyThread m3= new MyThread();
		//�޷�������Դ
//		m1.start();
//		m2.start();
//		m3.start();
		//Thread��Ҳ��Runnable�ӿڵ����࣬����д�����൱��ʵ����runnable�ӿ�
		//��ò�Ҫ���������̣߳�Ӧ�����̳߳صķ�ʽ����ǿ���߳̽��й���
		new Thread(m1).start();
		new Thread(m1).start();
		new Thread(m1).start();
	}
	
}
