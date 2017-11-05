package MyWork;

public class client {
	futureData futuredata= new futureData();
	public futureData request(String str){
	new Thread(){
		public void run(){
			realData r= new realData(str);
			futuredata.setRealData(r);
		}
	}.start();
	return futuredata;	
	}
}

