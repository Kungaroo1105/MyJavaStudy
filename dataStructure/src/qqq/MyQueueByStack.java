package qqq;

import java.util.Stack;

public class MyQueueByStack<E> {
	Stack<E> A = new Stack<E>();
	Stack<E> B = new Stack<E>();
    public boolean isEmpty(){
    	return A.isEmpty() && B.isEmpty();
    }
    public void put(E data){
    	A.push(data);
    }
    public E pop(){
    	if(B.isEmpty()){
    			while(!A.isEmpty())
    				B.push(A.pop());
    	}
    	return B.pop();
    }
}
