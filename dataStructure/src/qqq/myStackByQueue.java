package qqq;

import qqq.MyQueue;
public class myStackByQueue<E> {
	private MyQueue<E> A = new MyQueue<E>();
	private MyQueue<E> B = new MyQueue<E>();
	public  boolean isEmpty(){
		return A.size() == 0;
	}
	public void push(E data){
		A.put(data);
	}
	public E pop(){
		E result = null;
		if(A.size() <=1){
			result = A.pop();
		}else{
			for(int i = A.size();i>0;i--){
				if(i>1){
					B.put(A.pop());
				}else{
					result = A.pop();
				}
			}
			while(!A.isEmpty()){
				A.put(B.pop());
			}
		}
		
		return result;
	}
	
	public E peek(){
		E result = null;   
		if(A.size() <=1){
			result = A.pop();
		}else{
			for(int i = A.size();i>0;i--){
				if(i>1){
					B.put(A.pop());
				}else{
					E tmp = A.pop();
					B.put(tmp);
					result =tmp;
				}
			}
			while(!B.isEmpty()){
				A.put(B.pop());
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		myStackByQueue<Integer> test = new myStackByQueue<Integer>();
		test.push(12);
		test.push(23);
		test.push(4444);
		System.out.println(test.peek());
		System.out.println(test.pop());
		test.push(233);
		System.out.println(test.pop());
		
	}

}
