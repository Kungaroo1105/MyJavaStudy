package abstractFactory;

public class Aircraft implements Flyable {

	@Override
	public void fly(int height) {
		// TODO Auto-generated method stub
		  System.out.println("����һ�ܿ��˻�����Ŀǰ�ķ��и߶�Ϊ��" + height + "ǧ�ס�");  
	}

	@Override
	public void move(int distance) {
		System.out.println("hello");
		
	}

}
