package observer2;

public interface Subject {
	/**
     * ע��۲���
     */
   void registerObserver(Observer observer);

   /**
    * �Ƴ��۲���
     */
   void removeObserver(Observer observer);

   /**
     * ֪ͨ�۲���
     */
   void notifyObservers();

}
