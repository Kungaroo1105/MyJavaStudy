package observer;

import java.util.ArrayList;
import java.util.Iterator;
//���۲��ߣ�һ�������࣬������չ��
public abstract class Observable {
	   public final ArrayList<Class<?>> obserList = new ArrayList<Class<?>>();
	   
	    /**AttachObserver��ͨ��ʵ��ע��۲��ߣ�
	    *<b>Notice:</b>ob can't be null,or it will throw NullPointerException
	    **/
	    public<T> void registerObserver(T ob){
	        if(ob==null) throw new NullPointerException();
	        this.registerObserver(ob.getClass());
	    }
	 
	    /**
	    *AttachObserver��ͨ��Classע��۲��ߣ�
	    *@paramcls
	    */
	    public void registerObserver(Class<?> cls){
	        if(cls==null) throw new NullPointerException();
	        synchronized(obserList){
	            if(!obserList.contains(cls)){
	                obserList.add(cls);
	            }
	        }
	    }
	 
	    /**UnattachObserver��ע���۲��ߣ�
	    *<b>Notice:</b>
	    *<b>ItreverseswithattachObserver()method</b>
	    **/
	    public<T>void unRegisterObserver(T ob){
	        if(ob==null) throw new NullPointerException();
	        this.unRegisterObserver(ob.getClass());
	    }
	 
	    /**UnattachObserver��ע���۲��ߣ���ʱ����δ��ȡ��ʵ��ʹ�ã�
	    *<b>Notice:</b>
	    *<b>ItreverseswithattachObserver()method</b>
	    **/
	    public void unRegisterObserver(Class<?>cls){
	        if(cls==null) throw new NullPointerException();
	        synchronized(obserList){
	            Iterator<Class<?>>iterator=obserList.iterator();
	            while(iterator.hasNext()){
	                if(iterator.next().getName().equals(cls.getName())){
	                    iterator.remove();
	                    break;
	                }
	            }
	        }
	    }
	 
	    /**detachallobservers*/
	    public void unRegisterAll(){
	        synchronized(obserList){
	            obserList.clear();
	        }
	    }
	 
	    /**Ruturnthesizeofobservers*/
	    public int countObservers(){
	        synchronized(obserList){
	            return obserList.size();
	        }
	    }
	 
	    /**
	    *notify all observer��֪ͨ���й۲��ߣ���������ʵ�֣�
	    *@paramobjs
	    */
	    public abstract void notifyObservers();
	 
	    /**
	    *notify one certain observer��֪ͨĳһ��ȷ���Ĺ۲��ߣ�
	    *@paramcls
	    *@paramobjs
	    */
	    public abstract void notifyObserver(Class<?> cls);
	 
	    /**
	    *notifyonecertainobserver
	    *@paramcls
	    *@paramobjs
	    */
	    public abstract<T> void notifyObserver(T t, Object... objs);
}
