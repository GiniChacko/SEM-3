package com.crce.oopmlab;

/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
public class QuoteTester {

	public static void main(String[] args) {
		// Test methods are made static so can be directly used in the static main()
		// method.
		testAll();
	}

	public static void testAll() {

		testPrintDate();
		testPrintQuoteRandom();
		testPrintQuote();

	}
	// This method tests QuotePrintFeature

//this method tests  customizable datePrint feature
	public static void testPrintDate() {
		System.out.println("=================");
		System.out.println("testPrintDate()");
		System.out.println("=================");
		Quotes.printDate();
		System.out.println();
	}

	public static void testPrintQuote() {
		// Quotes.printQuote();
		 System.out.println("=================");
		 System.out.println("testPrintQuote()");
		 System.out.println("=================");
		 Quotes.printQuote("motivational");// 5 with respect to our example
		 Quotes.printQuote("inspirational");// 2 with respect to our example
		 Quotes.printQuote("perfectionist");// 1 with respect to our example
		 Quotes.printQuote("Life learning");// 2 with respect to our example
	}

	public static void testPrintQuoteRandom() {
		System.out.println("=================");
		System.out.println("testPrintRandom()");
		System.out.println("=================");
		Quotes.printQuoteRandom();
	}
	
}
