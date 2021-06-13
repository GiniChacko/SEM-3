/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

/**
 * Stack operation tester class
 * @author Gini Chacko
 *
 */
class Stack {
	
	/**
	 * private instance variable, not accessible from outside the class
	 */
	private int arr[];
	private int top;
	private int capacity;
	
	/**
	 * Constructor to initialize stack
	 * @param size
	 */
	Stack(int size) { 
		arr = new int[size];
		capacity = size;
		top = -1;
		
	}
	
	/**
	 * Method to push the elements into the stack
	 * @param x
	 */
	public synchronized void push(int x) { //utility function to add an element x in the stack
		if( isFull()) { //check for stack overflow
			System.out.println("Stack Overflow \n Program Terminated\n");
			System.exit(1);
		}
		
		System.out.println("Inserting " + x);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		arr[++top] = x;
		
	}
	
	/**
	 * Method to pop the elements out of the stack
	 * @return the popped element 
	 */
	public synchronized int pop() { //utility function to pop top element from the stack
		if( isEmpty()) {
			System.out.println("Stack Underflow\n Program Terminated");
			System.exit(1);
		}
		
		System.out.println("Removing  " + peek());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return arr[top--]; //decrease the stack size by 1 & return the popped element
		
	}

	/**
	 * Method to return the top most element in the stack
	 * @return top most element in the stack
	 */
	private int peek() { //utility function to return top element in a stack
		// TODO Auto-generated method stub
		if(!isEmpty()) {
			return arr[top];
		}
		else
			System.exit(1);
		return -1;
		
	}
	
	/**
	 * Method to know the size of the stack
	 * @return the size of the stack
	 */
	public int size() {
		try {
			Thread.sleep(100);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return (top+1);
	
	}

	/**
	 * Method to check if the stack is empty
	 * @return stack is empty or no
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top == -1);
	}
	
	/**
	 * Method to check if the stack is full
	 * @return stack is full or no
	 */
	private boolean isFull() {
		// TODO Auto-generated method stub
		return (top == capacity - 1);
	}
	
}


class PushThread implements Runnable {
	Stack stack;
	int num;
	
	/** 
	 * @param s
	 * @param number
	 */
	public PushThread(Stack s,int number) {
		this.stack = s;
		this.num = number;
	}
	
	public void run() {
		stack.push( num);
		stack.push( ++num);
		stack.push( ++num);
		stack.push( ++num);
		
	}
	
}


class PopThread implements Runnable {
	Stack stack;
	
	/**
	 * @param s
	 */
	public PopThread(Stack s) {
		this.stack = s;
	}
	
	public void run() {
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
		
	}
	
}


public class StackOperationsTester {
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		Stack stack = new Stack(5);
		
		PushThread pushThread = new PushThread(stack, 10);
		PopThread popThread = new PopThread(stack);
		
		Thread t1 = new Thread(pushThread);
		Thread t2 = new Thread(popThread);
		
		t1.start();
		t2.start();
		

	}

}





