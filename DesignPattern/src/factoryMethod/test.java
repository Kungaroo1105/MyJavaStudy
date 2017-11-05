package factoryMethod;

public class test {
	public static void main(String[] args) {
		 VehicleFactory factory = new BroomFactory();  
		  Moveable moveable = factory.create();  
		  moveable.run();
	}
}
