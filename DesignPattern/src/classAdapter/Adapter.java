package classAdapter;
//������
public class Adapter extends Adaptee implements target {

	@Override
	public void run() {
		super.testRun();
	}
	
	public static void main(String[] args) {
		//��ͨ������
//		target realTarget= new RealTarget();
//		realTarget.run();
		
		//������ģʽ
		target t=new Adapter();
		t.run();
	}
	
}
