package abstractFactory;

public class Car implements Moveable{

	@Override
	public void move(int distance) {
		System.out.println("hello "+distance);
		
	}
	
}
