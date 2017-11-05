package classAdapter;
//类适配
public class Adapter extends Adaptee implements target {

	@Override
	public void run() {
		super.testRun();
	}
	
	public static void main(String[] args) {
		//普通功能类
//		target realTarget= new RealTarget();
//		realTarget.run();
		
		//适配器模式
		target t=new Adapter();
		t.run();
	}
	
}
