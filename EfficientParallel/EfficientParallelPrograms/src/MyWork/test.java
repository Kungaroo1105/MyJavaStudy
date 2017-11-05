package MyWork;

import Future.Data;

public class test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		client c=new client();
		Data a = c.request("helloworld");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a.getResult());
	}
	
}
