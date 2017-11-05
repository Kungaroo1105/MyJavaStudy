package objectAdapter;
//��������
public class Adapter implements Target {
	private Adaptee adaptee;
	public Adapter(Adaptee adaptee){
		this.adaptee=adaptee;
	}
	public void request(){
		this.adaptee.specifiedRequest();
	}
	
	public static void main(String[] args) {
		//��ͨ������
		Target target= new RealTarget(); 
		target.request();
		
		//������ģʽ
		Target specifiedTarget = new Adapter(new Adaptee());
		specifiedTarget.request();
	}
}
