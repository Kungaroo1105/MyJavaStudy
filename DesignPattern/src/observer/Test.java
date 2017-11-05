package observer;
//使用(实现Observer接口）
public class Test implements Observer{
	ConcreteObservable observable= ConcreteObservable.getInstance();
    public void onCreate(){
    	observable.registerObserver(ConcreteObserver.class);
        //ConcreteObservable.getInstance().registerObserver(Test.class);
    }
    //实现接口处理
    public void update(){
        //做操作，比如更新数据，更新UI等
    	observable.notifyObservers();
    }
    public static void main(String[] args) {
    	Test test= new Test();
    	test.onCreate();
    	test.update();
	}
}