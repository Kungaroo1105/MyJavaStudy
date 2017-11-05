package Future;

public class Client {
	public Data request(final String str){
		final FutureData future=new FutureData();
		new Thread(){
			public void run(){
				System.out.println("RealData 开始创建");
				RealData realdata= new RealData(str);
				System.out.println("RealData 创建完毕");
				future.setRealData(realdata);
			}		
		}.start();
		return future;
	}
}
