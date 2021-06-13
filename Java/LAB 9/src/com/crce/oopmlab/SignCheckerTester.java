/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import java.util.Random;

/**
 * Sign Checker tester class
 * @author Gini Chacko
 *
 */

class RandomArray {
	
	/**
	 * private instance variable, not accessible from outside the class
	 */
	private int[] randomInput;
	private int size;
	
	/**
	 * @param size
	 */
	public RandomArray(int size) {
		this.size = size;
		randomInput = new int[size];
	}
	
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
	 * Method to find the random array
	 * @return randomInput
	 */
	public int[] randomArray() {
		int max = 25;
		int min = -15;
		Random random = new Random();
		
		for(int i=0;i<size;i++) {
			int number = random.nextInt(max-min) + min;
			randomInput[i] = number;
		}
		
		return randomInput;
	
	}
	
	/**
	 * Method to display array
	 */
	public void displayArray() {
		for(int i=0; i<randomInput.length; i++) {
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.print(randomInput[i] + "\t");
		}
		
		System.out.println();
	
	}
	
	/**
	 * Method to print positive even number
	 */
	public synchronized void printPositiveEvenNumber() {
		System.out.println();
		System.out.println("Positive Even numbers from given array are as follows");
		
		for(int i=0; i<randomInput.length; i++) {
			if(randomInput[i] % 2 == 0 && randomInput[i] > 0) {
				try {
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(randomInput[i]);
			}
		
		}
	}
	
	/**
	 * Method to print positive odd number
	 */
	public synchronized void printPositiveOddNumber() {
		System.out.println();
		System.out.println("Positive Odd numbers from given array are as follows: ");
		
		for(int i=0; i<randomInput.length; i++) {
			if(randomInput[i] % 2 != 0 && randomInput[i] > 0) {
				try {
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(randomInput[i]);
			}
		
		}
	}
	
	/**
	 * Method to print negative number
	 */
	public synchronized void printNegativeNumber() {
		System.out.println();
		System.out.println("Negative numbers from given array are as follows: ");
		
		for(int i=0; i<randomInput.length; i++) {
			if(randomInput[i] < 0) {
				try {
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(randomInput[i]);
			}
		
		}
	
	}
	
}


	class PositiveEvenNumCheckerThread implements Runnable {
		RandomArray randomArray;
	
	/**
	 * @param array
	 */
	public PositiveEvenNumCheckerThread(RandomArray array) {
		this.randomArray = array;
	}
	
	public void run() {
		randomArray.printPositiveEvenNumber();
	}

}


	class PositiveOddNumCheckerThread implements Runnable {
		RandomArray randomArray;
	
	/**
	 * @param array
	 */
	public PositiveOddNumCheckerThread(RandomArray array) {
		this.randomArray = array;
	}
	
	public void run() {
		randomArray.printPositiveOddNumber();
	}

}


	class NegativeNumCheckerThread implements Runnable {
		RandomArray randomArray;
	
	/**
	 * @param array
	 */
	public NegativeNumCheckerThread(RandomArray array) {
		this.randomArray = array;
	}
	
	public void run() {
		randomArray.printNegativeNumber();
	}

}


	public class SignCheckerTester {

	public static void main(String[] args) {
		RandomArray array = new RandomArray(12);
		array.randomArray();
		System.out.println("Random Array is: ");
		array.displayArray();
		
		PositiveEvenNumCheckerThread positiveEvenNumCheckerThread = new PositiveEvenNumCheckerThread(array);
		PositiveOddNumCheckerThread positiveOddNumCheckerThread = new PositiveOddNumCheckerThread(array);
		NegativeNumCheckerThread NegativeNumCheckerThread = new NegativeNumCheckerThread(array);
		
		Thread t1 = new Thread(positiveEvenNumCheckerThread);
		Thread t2 = new Thread(positiveOddNumCheckerThread);
		Thread t3 = new Thread(NegativeNumCheckerThread);
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}




