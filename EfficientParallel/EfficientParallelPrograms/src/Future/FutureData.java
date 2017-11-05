package Future;

public class FutureData implements Data {
	private RealData realdata=null;
	private boolean isReady = false;
	public synchronized void setRealData(RealData realdata){
		if(isReady) return;
		this.realdata=realdata;
		isReady=true;
		notifyAll();
	}
	
	public synchronized String getResult() {
		//用isReady监听Realdata的生成与否，若已生成则执行Realdata中的函数
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
