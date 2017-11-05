package singleton;

public class Singleton {
	public static int count=0;
	private Singleton() {
	}

	private static Singleton singleton = null;

	public static Singleton getInstance() {
		// ����ʽ������.�ڵ�һ�ε��õ�ʱ��ʵ�����Լ�����������̳�ͻ
		if (singleton == null)
			try {
				//�ڴ˳��ֽ��̳�ͻ
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			singleton = new Singleton();	
		return singleton;
	}
	
//	���������������ɱ�����̳�ͻ�����ή��Ч��
	
//	public static synchronized Singleton getInstance() {  
//        if (singleton == null) {    
//        	try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        	singleton = new Singleton();  
//        }    
//        System.out.println(singleton.hashCode());
//       return singleton;  
//}
	
//	public static Singleton getInstance() {  
//    //������volatile���λᷢ��ָ������
//		if (singleton == null) {    
//            synchronized (Singleton.class) {    
//               if (singleton == null) {    
//            	  //�������벻��ԭ�Ӳ������Ƿ���洢�ռ䣬��ʼ������������singletonָ��շ�����ڴ��ַ��������
//            	  //������ָ����������
//            	  singleton = new Singleton();   
//               }    
//            }    
//        }    
//        return singleton;   
//    }
	
	
	public static void main(String[] args) {
		for(int i=0;i<99;i++){
			new MyThread().start();
		}
		}

}
