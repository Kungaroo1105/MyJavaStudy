package MasterWorker;

public class RealWorker extends Worker{
	public Object handle(Object input){
		Integer i=(Integer)input;
		return i*i*i;
	}
}
