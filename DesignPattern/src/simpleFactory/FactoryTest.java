package simpleFactory;



public class FactoryTest {

	public static void main(String[] args) {
		// �򵥹���ģʽ����
		SimpleFactory simpleFactory = new SimpleFactory();
		Broom broom = simpleFactory.create(Broom.class);
		broom.run();
	}
}