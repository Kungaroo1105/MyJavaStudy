package simpleFactory;

import java.lang.reflect.InvocationTargetException;

public class SimpleFactory {

	public <T> T create(Class<T> clazz) {
//		if (clazz.getName().equals(Plane.class.getName())) {
//			
//			
//			return createPlane();
//		} else if (clazz.getName().equals(Broom.class.getName())) {
//			return createBroom();
//		}
		try {
			return clazz.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Broom createBroom() {
		return new Broom();
	}

	private Plane createPlane() {
		return new Plane();
	}
}