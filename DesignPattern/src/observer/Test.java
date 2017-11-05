package observer;
//ʹ��(ʵ��Observer�ӿڣ�
public class Test implements Observer{
	ConcreteObservable observable= ConcreteObservable.getInstance();
    public void onCreate(){
    	observable.registerObserver(ConcreteObserver.class);
        //ConcreteObservable.getInstance().registerObserver(Test.class);
    }
    //ʵ�ֽӿڴ���
    public void update(){
        //������������������ݣ�����UI��
    	observable.notifyObservers();
    }
    public static void main(String[] args) {
    	Test test= new Test();
    	test.onCreate();
    	test.update();
	}
}