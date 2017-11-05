package MyWork;

import Future.Data;

public class realData implements Data {
	public String result;
	public realData(String str){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result=str;
	}
	@Override
	public String getResult() {
		return result;
	}

}
