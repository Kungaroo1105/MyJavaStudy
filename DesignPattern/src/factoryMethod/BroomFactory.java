package factoryMethod;

public class BroomFactory extends VehicleFactory {

	@Override
	public Moveable create() {
		return new Broom();  
	}
}
