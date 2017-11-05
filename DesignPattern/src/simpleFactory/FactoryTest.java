package simpleFactory;



public class FactoryTest {

	public static void main(String[] args) {
		// 简单工厂模式测试
		SimpleFactory simpleFactory = new SimpleFactory();
		Broom broom = simpleFactory.create(Broom.class);
		broom.run();
	}
}