package qqq;

public class MyStackByLinkedList<E> {
	Node<E> top = null;
	
	public boolean isEmpty(){
		return top == null;
	}
	public E peek(){
		if(top == null){
			return null;
		}else{
			E e =  top.data;
			return e;
		}
	}
	public E pop(){
		E e = peek();
		top = top.next;
		return e;
	}
	public void push(E data){
		Node<E> node = new Node<E>(data);
		node.next = top;
		top = node;
	}

}

class Node<E>{
	Node<E> next = null;
	E data;
	public Node(E data){
		this.data = data;
	}
}
