package abstractFactory;

public class Aircraft implements Flyable {

	@Override
	public void fly(int height) {
		// TODO Auto-generated method stub
		  System.out.println("我是一架客运机，我目前的飞行高度为：" + height + "千米。");  
	}

	@Override
	public void move(int distance) {
		System.out.println("hello");
		
	}

}
