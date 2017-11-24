package Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;




public class NewProxy {
	public <T> T testProxy(Class<T> cls) {
		T temp = null;
		try {
			temp = cls.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		java.lang.reflect.Field[] fields = cls.getDeclaredFields();
		for (java.lang.reflect.Field field : fields) {
			// ≈–∂œ «∑Ò «¡–
			boolean isColumn = field.isAnnotationPresent(NewAnnotation.class);
			if (isColumn) {
				try {
					Character f = field.getName().charAt(0);
					if (Character.isLowerCase(f)) {
						f = Character.toUpperCase(f);
					}
					String setMethodName = "set" + f
							+ field.getName().substring(1);
					Method method = cls.getMethod(setMethodName,
							field.getType());
					System.out.println("setting value");
					method.invoke(temp,"changedValue");
					System.out.println("value has been set");
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return temp;
	}
}
