/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Sorting operations tester class
 * @author Gini Chacko
 *
 */

class MyArrayList {
	
	/**
	 * private instance variable, not accessible from outside the class
	 */
	private int size;
	ArrayList<Integer> list = new ArrayList<Integer>();
	private int a[];
	
	/**
	 * Getter for instance variable size
	 * @return
	 */
	public int getSize() { 
		return size;
	}
	
	/**
	 * Setter for instance variable size
	 * @param size
	 */
	public void setSize(int size) { 
		this.size = size;
	}
	
	/**
	 * Constructor for array list size
	 * @param size
	 */
	public MyArrayList(int size) { 
		
		// TODO Auto-generated constructor stub
		super();
		this.size = size;
		a = new int[size];
		System.out.println(size);
		
	}
	
	/**
	 * Input Method
	 */
	public void input() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter some number: ");
		while (s.hasNextInt()) {
			list.add(s.nextInt());
		}
		System.out.println(list);
		s.close();
	}
	
	/**
	 * Takes user input in array
	 * @return a
	 */
	public int[] inputArray() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter all the elements: ");
		for(int i = 0; i < size; i++) {
			a[i] = s.nextInt();
		}
		s.close();
		return a;
	}
	
	/**
	 * Prints the array 
	 */
	public void displayArray() {
		for (int i = 0; i < a.length; i++) {
			
			System.out.println(a[i] + "\t");
			try {
				Thread.sleep(100); //sleep the running thread for 100 milli seconds
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	
	/**
	 * Sorting array in ascending order
	 */
	public synchronized void sortArrayInAscending() { 
		
		int temp=0;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(a[i] < a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		System.out.println("\nArray in Ascending Order: ");
		displayArray();
  
    }  
	
	/**
	 * Sorting array in descending order 
	 */
	public synchronized void sortArrayInDescending() { 

		int temp=0;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		System.out.println("\nArray in Descending Order: ");
		displayArray();
		  
    }  
	
}


class AscendingSortThread implements Runnable {
	MyArrayList arr;
	
	/**
	 * @param input
	 */
	public AscendingSortThread(MyArrayList input) {
		this.arr = input;
	}
	
	public void run() {
		arr.sortArrayInAscending();
	}
	
}


class DescendingSortThread implements Runnable {
	MyArrayList arr;
	
	/**
	 * @param input
	 */
	public DescendingSortThread(MyArrayList input) {
		this.arr = input;
	}
	
	public void run() {
		arr.sortArrayInDescending();
	}
	
}


class SortingOperationsTester {
	
	public static void main(String[] args) {
		MyArrayList arrayList = new MyArrayList(5);
		
		int[] in = arrayList.inputArray();
		System.out.println("Inputed Array is: ");
		arrayList.displayArray();
		
		AscendingSortThread ascendingSortThread = new AscendingSortThread(arrayList);
		DescendingSortThread descendingSortThread = new DescendingSortThread(arrayList);
		
		Thread t1 = new Thread(ascendingSortThread);
		Thread t2 = new Thread(descendingSortThread);
		
		t1.start();
		t2.start();
		
	}
	
}




