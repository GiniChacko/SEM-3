/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */

package PostLab;
import java.util.Scanner;


public class QuoteTester {

	public static void main(String[] args) {
		
		testAll();
	}

	public static void testAll() {

		testPrintDate();
		testPrintQuoteRandom();
		testPrintQuote();
        testPrintCountQuoteAuthor();
        testAddQuote();
	}
	// This method tests QuotePrintFeature

//this method tests  customizable datePrint feature
	public static void testPrintDate() {
		
		System.out.println("=================");
		System.out.println("testPrintDate()");
		System.out.println("=================");
		Quotes.printDate();
	}

	public static void testPrintQuote() {
		
		 System.out.println("=================");
		 System.out.println("testPrintQuote()");
		 System.out.println("=================");
		 Quotes.printQuote("Life learning");
		 Quotes.printQuote("perfectionist");
		 Quotes.printQuote("motivational");// 5 with respect to our example
		 Quotes.printQuote("inspirational");// 2 with respect to our example
	}

	public static void testPrintQuoteRandom() {
		System.out.println("=================");
		System.out.println("testPrintRandom()");
		System.out.println("=================");
		Quotes.printQuoteRandom();
	}
	
	
	public static void testPrintCountQuoteAuthor() {
		
		System.out.println("=======================");
		System.out.println("testPrintQuoteAuthor()");
		System.out.println("=======================");
		 Quotes.printCountQuoteAuthor("Sadguru Wamanrao Pai");
		 Quotes.printCountQuoteAuthor("Mickey Rooney");
		 Quotes.printCountQuoteAuthor("sunil");
		 Quotes.printCountQuoteAuthor("Dr. A.P.J. Abdul Kalam");
		 
	}
	public static void testAddQuote() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("===================");
		System.out.println("testPrintAddQuote()");
		System.out.println("===================");
		
		System.out.println("Enter : ");
		System.out.println("id");
		System.out.println("QuoteValue");
		System.out.println("QuoteAuthor");
		System.out.println("QuoteType");
		System.out.println("in the following sequence");
		
		int p = sc.nextInt();
		sc.nextLine();
		String q=sc.nextLine();
		String r=sc.nextLine();
		String s=sc.nextLine();
		
		Quotes.addQuote(p,q,r,s);
		
		System.out.println("The Quote is successfully ADDED !!!");
		
	}
	
	
	
}
