package singleton;

public class Singleton {
	public static int count=0;
	private Singleton() {
	}

	private static Singleton singleton = null;

	public static Singleton getInstance() {
		// 懒汉式单例类.在第一次调用的时候实例化自己，会产生进程冲突
		if (singleton == null)
			try {
				//在此出现进程冲突
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			singleton = new Singleton();	
		return singleton;
	}
	
//	将整个方法加锁可避免进程冲突，但会降低效率
	
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
//    //若不用volatile修饰会发生指令重排
//		if (singleton == null) {    
//            synchronized (Singleton.class) {    
//               if (singleton == null) {    
//            	  //本条代码不是原子操作，是分配存储空间，初始化变量和设置singleton指向刚分配的内存地址三个步骤
//            	  //将导致指令重排问题
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
