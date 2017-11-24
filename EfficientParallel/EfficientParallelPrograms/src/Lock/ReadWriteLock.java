package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
	private static Lock lock= new ReentrantLock();
	private static ReentrantReadWriteLock rwlock= new ReentrantReadWriteLock();
	private static Lock readlock = rwlock.readLock();
	private static Lock writelock = rwlock.writeLock();	
	
	public static void handleWrite(Object obj) throws InterruptedException{
		try{
			writelock.lock();
			Thread.sleep(1);
		}finally {
			writelock.unlock();
		}
	}
	public static Object handleRead() throws InterruptedException{
		try{
			readlock.lock();
			Thread.sleep(1);
		}finally {
			readlock.unlock();
		}
		return null;
	}
	public static void main(String[] args) {
		ReadWriteLock rw= new ReadWriteLock();
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						rw.handleRead();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}, "ReadThread"+i).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						rw.handleWrite("hi");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}, "WriteThread"+i).start();
		}
		
	}

}
