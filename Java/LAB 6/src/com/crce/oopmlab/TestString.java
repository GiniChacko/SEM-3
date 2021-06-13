/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import java.util.Scanner;
/**
 * String Testor class
 * @author Gini Chacko
 *
 */
public class TestString {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		testAll();

	}
	/**
	 * Test All method containing all the methods to be tested
	 */
	public static void testAll() {
		testReverse();
		testReverseRec();
		testFetchCount();
		testPalindrome();
		testCountVowelsConsonants();
		testFreqInOrderOfOccur();
		testEvenFreqInOrderOfOccur();
		testOddFreqInOrderOfOccur();
		testprintCharDecOrderOfFreq();
		testWordReverse();
		
	}
	
	/**
	 * Tester method to reverse the string
	 */
	public static void testReverse() {
		 StringOps s =new StringOps();
		 System.out.println("*****Printing reverse of a sentence -  without recursion*****");
		 System.out.println();
		 System.out.println("Enter a string to reverse : ");
	     Scanner sc = new Scanner(System.in);
	     String str = sc.nextLine();
		 str = s.reverse(str);
		 System.out.println();
		 System.out.println("Reversed string is "+str);
		 System.out.println("----------------------------------------------------------------------");
	}
	
	/**
	 * Tester method to reverse the string recursively
	 */
	public static void testReverseRec() {
		 StringOps s =new StringOps();
		 System.out.println("*****Printing reverse of a sentence – with recursion*****");
		 System.out.println();
		 System.out.println("Enter a string to reverse (recursive method) : ");
		 Scanner sc = new Scanner(System.in);
	     String str = sc.nextLine();
		 str = s.reverseRec(str);
		 System.out.println();
		 System.out.println("Reversed string is "+str);
		 System.out.println("----------------------------------------------------------------------");
	}
	
	/**
	 * Tester method to fetch the count
	 */
	public static void testFetchCount() {
		
		System.out.println("*****Fetching no of words in the file*****");
		int count=FileOperation.fetchCount();
		System.out.println();
		System.out.println("Total no of words in the file is "+count);
		System.out.println("----------------------------------------------------------------------");
	}
	
	/**
	 * Tester method to check if palindrome or no
	 */
	public static void testPalindrome() {
		StringOps s =new StringOps();
		System.out.println("*****Printing whether the given  string is palindrome or not*****");
		System.out.println();
		System.out.println("Enter a string to check if palindrome or not : ");
		Scanner sc = new Scanner(System.in);
	    String str = sc.nextLine();
	    System.out.println();
		if(s.palindrome(str)) {
		  System.out.println("The word " +str+ " is a palindrome");
		}
		else
		  System.out.println("The word " +str+ " is not a palindrome");	
		System.out.println("----------------------------------------------------------------------");
	}
	
	/**
	 * Tester method to count the vowels and consonants
	 */
	public static void testCountVowelsConsonants() {
		StringOps s =new StringOps();
		System.out.println("*****Printing  Number of vowels and consonants in a given sentence*****");
		System.out.println();
		System.out.println("Enter a string to count no of vowels and consonants : ");
	    Scanner sc = new Scanner(System.in);
	    String str = sc.nextLine();
	    System.out.println();
		System.out.println("No. of vowels in the string = "+s.countVowels(str));
		System.out.println("No. of consonants in the string = "+s.countConsonants(str));
		System.out.println("----------------------------------------------------------------------");
	}
	
	/**
	 * Tester method to test the frequency in order of occurence
	 */
	public static void testFreqInOrderOfOccur() {
		 StringOps s =new StringOps();
		 System.out.println("*****Printing the character and its frequency in order of its occurrence*****");
		 System.out.println();
		 System.out.println("Enter a string to get frequency of characters in order of occurence : ");
		 Scanner sc = new Scanner(System.in);
	     String str = sc.nextLine();
	     System.out.println();
		 s.FreqInOrderOfOccur(str);
		 System.out.println("----------------------------------------------------------------------");
	}
	
	/**
	 * Tester method to test the even frequency in order of occurence
	 */
	public static void testEvenFreqInOrderOfOccur() {
		 StringOps s =new StringOps();
		 System.out.println("*****Print characters having even frequencies in order of occurrence*****");
		 System.out.println();
		 System.out.println("Enter a string to get characters having even frequency in order of occurence : ");
		 Scanner sc = new Scanner(System.in);
	     String str = sc.nextLine();
	     System.out.println();
		 s.EvenFreqInOrderOfOccur(str);
		 System.out.println("----------------------------------------------------------------------");
	}
	
	/**
	 * Tester method to test the odd frequency in order of occurence
	 */
	public static void testOddFreqInOrderOfOccur() {
		 StringOps s =new StringOps();
		 System.out.println("*****Printing the characters having odd frequencies in order of occurrence*****");
		 System.out.println();
		 System.out.println("Enter a string to get characters having odd frequency in order of occurence : ");
		 Scanner sc = new Scanner(System.in);
	     String str = sc.nextLine();
	     System.out.println();
		 s.OddFreqInOrderOfOccur(str);
		 System.out.println("----------------------------------------------------------------------");
	}
	
	/**
	 * Tester method to test the word reverse
	 */
	public static void testWordReverse() {
		 StringOps s =new StringOps();
		 System.out.println();
		 System.out.println("*****Printing the words in string in reverse order*****");
		 System.out.println();
		 System.out.println("Enter a string to reverse the words in it : ");
		 Scanner sc = new Scanner(System.in);
	     String str = sc.nextLine();
	     System.out.println();
		 s.wordReverse(str);
		 System.out.println("----------------------------------------------------------------------");
	}
	/**
	 * Tester method to print char in decreasing order of frequency
	 */
	public static void testprintCharDecOrderOfFreq()
	{
		 StringOps s =new StringOps();
		 System.out.println("*****Printing characters in string in decreasing order of frequency count*****");
		 System.out.println();
		 System.out.println("Enter a string to print characters in decreasing order of their frequency :  ");
		 Scanner sc = new Scanner(System.in);
		 String str = sc.nextLine();
		 int len = str.length();
		 str.toCharArray();
		 s.printCharDecOrderOfFreq(str, len);
		 System.out.println("----------------------------------------------------------------------");
	}
}
