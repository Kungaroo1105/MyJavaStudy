package Future;

public class Client {
	public Data request(final String str){
		final FutureData future=new FutureData();
		new Thread(){
			public void run(){
				System.out.println("RealData ��ʼ����");
				RealData realdata= new RealData(str);
				System.out.println("RealData �������");
				future.setRealData(realdata);
			}		
		}.start();
		return future;
	}
}
