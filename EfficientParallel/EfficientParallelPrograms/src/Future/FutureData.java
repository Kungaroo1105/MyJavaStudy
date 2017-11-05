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
		//��isReady����Realdata�������������������ִ��Realdata�еĺ���
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
