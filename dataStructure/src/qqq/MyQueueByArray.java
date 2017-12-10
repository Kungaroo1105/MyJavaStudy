package qqq;

import java.util.LinkedList;

public class MyQueueByArray<E> {
	private LinkedList<E> list = new LinkedList<E>();
	private int size =0;
	
	public boolean isEmpty(){
		return size == 0;
	}
	public void put(E data){
		list.add(data);
		size++;
	}
	public E pop(){
		if(isEmpty())
			return null;
		else{
			E e = list.get(0);
			list.removeFirst();
			size--;
			return e;
		}
	}
	public int size(){
		return size;
	}
	

}
