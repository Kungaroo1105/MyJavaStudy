package MyWork;

import Future.Data;

public class futureData implements Data {
	private realData realdata= null;
	private boolean isReady=false;
	public synchronized void setRealData(realData realdata){
		if(isReady) return;
		this.realdata=realdata;
		isReady=true;
		notifyAll();
		}

	@Override
	public synchronized String getResult() {
		while(!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realdata.getResult();
	}

}
