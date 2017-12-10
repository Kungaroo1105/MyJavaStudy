package qqq;

public class MyQueue<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	
	public boolean isEmpty(){
		return size()== 0;
	}
	public void put(E data){
		Node<E> node = new Node<E>(data);
		if(isEmpty()){
			head = node;
			tail = node;
		}else{
			tail.next = node;
			tail = node;
		}
	}
	public E pop(){
		if(isEmpty())
			return null;
		else{
			E data = head.data;
			head = head.next;
			return data;
		}
	}
	public int size(){
		Node<E> tmp = head;
		int size = 0;
		while(tmp != null){
			size++;
			tmp = tmp.next;
		}
		return size;
	}

}
//class Node<E>{
//	queueNode<E> next = null;
//	E data;
//	public Node(E data){
//		this.data = data;
//	}
//}
