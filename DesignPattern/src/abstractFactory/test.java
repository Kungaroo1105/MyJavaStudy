package abstractFactory;

public class test {
	public static void main(String[] args) {
		AbstractFactory factory = new Factory1();
		Flyable flyable = factory.createFlyable();
		flyable.fly(1589);
		
		Moveable moveable = factory.createMoveable();
		moveable.move(87);
//
//		Writeable writeable = factory.createWriteable();
//		writeable.write("Hello World.");
	}
}
