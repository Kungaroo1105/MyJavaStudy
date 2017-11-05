package ProducerCustomer;

public class PCData {
	private final int data;
	public PCData(int d){
		data=d;
	}
	public PCData(String d){
		data=Integer.valueOf(d);
	}
	public int getData(){
		return data;
	}
	@Override
	public String toString() {
		return "PCData [data=" + data + "]";
	}
	
}
