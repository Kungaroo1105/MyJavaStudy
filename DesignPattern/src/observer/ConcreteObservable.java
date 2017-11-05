package observer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//目标被观察者
public class ConcreteObservable extends Observable{
	  private static ConcreteObservable instance = null;
	    private ConcreteObservable(){};
	    public static synchronized ConcreteObservable getInstance(){
	        if(instance == null){
	            instance=new ConcreteObservable();
	        }
	        return instance;
	    }
	 
	    @Override
	    public <T> void notifyObserver(T t, Object... objs){
	        if(t == null) throw new NullPointerException();
	        this.notifyObserver(t.getClass(), objs);
	    }
	 
	    @Override
	    public void notifyObservers(){
	        for(Class<?>cls : obserList){
	            this.notifyObserver(cls);
	        }
	    }
	 
	 
	    //通过java反射机制实现调用
	    @Override
	    public void notifyObserver(Class<?>cls){
	        if(cls == null) throw new NullPointerException();
	        Method[] methods = cls.getDeclaredMethods();
	        for(Method method : methods){
	            if(method.getName().equals("update")){
	                try{
	                    try {
							method.invoke(cls.newInstance());
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                    break;
	                }catch(IllegalArgumentException e){
	                    e.printStackTrace();
	                }catch(IllegalAccessException e){
	                    e.printStackTrace();
	                }catch(InvocationTargetException e){
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
}
