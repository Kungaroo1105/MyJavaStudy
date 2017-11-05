package objectAdapter;
//对象适配
public class Adapter implements Target {
	private Adaptee adaptee;
	public Adapter(Adaptee adaptee){
		this.adaptee=adaptee;
	}
	public void request(){
		this.adaptee.specifiedRequest();
	}
	
	public static void main(String[] args) {
		//普通功能类
		Target target= new RealTarget(); 
		target.request();
		
		//适配器模式
		Target specifiedTarget = new Adapter(new Adaptee());
		specifiedTarget.request();
	}
}
