package qqq;

import java.util.Stack;
import java.util.Arrays;

public class MyStackByArray<E> {
	private Object[] stack;
	private int size;
	public MyStackByArray(){
		stack = new Object[10];
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public E peek(){
		if(size == 0){
			return null;
		}
		else{
			E e=(E) stack[size-1];
			return e;
		}
	}
	
	public E pop(){
			E e = peek();
			stack[size-1] = null;
			size--;
			return e;
	}
	public E push(E item){
		ensureCapacity(size+1);
		stack[size] = item;
		size++;
		return item;
	}
	public void ensureCapacity(int size){
		if(size > stack.length){
			int newLength = stack.length+10;
			stack = Arrays.copyOf(stack, newLength);
		}
	}
}
 


//class Node{
//	Node next = null;
//	int data
//}
