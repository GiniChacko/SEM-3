package PostLab;
/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

 
public class Quotes {

	public static Quote myQuotes[] = new Quote[11];// Array for Storing 10 Quote Objects.

	static {
		// this is Array Of Quotes as input

		Quote q1 = new Quote(1,
				"“You’re off to great places, today is your day. Your mountain is waiting, so get on\r\n" + "your way.",
				"sunil", "inspirational");
		Quote q2 = new Quote(2, "You always pass failure on the way to success.", "Mickey Rooney", "inspirational");
		Quote q3 = new Quote(3, "No one is perfect - that’s why pencils have erasers.", "Wolfgang Riebe",
				"perfectionist");
		Quote q4 = new Quote(4, "It always seems impossible until it\r\n" + "is done.", "sunil", "motivational");
		Quote q5 = new Quote(5, "As you think so you become", "Sadguru Wamanrao Pai", "Life learning");
		Quote q6 = new Quote(6, "You are Architect of your Destiny", "Sadguru Wamanrao Pai", "Life learning");
		Quote q7 = new Quote(7, "Dream, dream, dream. Dreams transform into thoughts and thoughts result in action.",
				"Dr. A.P.J. Abdul Kalam", "motivational");
		Quote q8 = new Quote(8, "To succeed in your mission, you must have single-minded devotion to your goal",
				"Dr. A.P.J. Abdul Kalam", "motivational");

		Quote q9 = new Quote(9, "Dream, dream, dream. Dreams transform into thoughts and thoughts result in action.",
				"Dr. A.P.J. Abdul Kalam", "motivational");
		Quote q10 = new Quote(10, "Dream, dream, dream. Dreams transform into thoughts and thoughts result in action.",
				"Dr. A.P.J. Abdul Kalam", "motivational");
		myQuotes[0] = q1;
		myQuotes[1] = q2;
		myQuotes[2] = q3;
		myQuotes[3] = q4;
		myQuotes[4] = q5;
		myQuotes[5] = q6;
		myQuotes[6] = q7;
		myQuotes[7] = q8;
		myQuotes[8] = q9;
		myQuotes[9] = q10;
	}

	// This method display Thought Of The Day randomly
	public static void printQuoteRandom() {
		int index = (int) (Math.random() * 10);
	

		System.out.println();
		System.out.println("Todays Quote is ");
		System.out.println((myQuotes[index]).getQuoteValue());
		System.out.println("---By " + myQuotes[index].getQuoteAuthor());
		System.out.println("The Quote is " + myQuotes[index].getQuoteType());

	}

	// This method display date in customized format
	public static void printDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		System.out.println("Today's date is " + strDate);
		formatter = new SimpleDateFormat("EEEE");
		strDate = formatter.format(date);
		System.out.println("Today is " + strDate);

	}

	// This method display Thought Of The Day randomly based on input quoteType
	public static void printQuote(String quoteType) {

		System.out.println();
	 ArrayList<Quote> arrayList=new ArrayList<>();
	 for(int i=0; i<10 ;i++) {
		 if(((myQuotes[i]).getQuoteType()).equals(quoteType))
		 {
			 arrayList.add(myQuotes[i]);
		 }
		 
	 }
		 System.out.println("Total number of " + quoteType + " Messages are " +
		 arrayList.size());

		// To maintain randomness based on quoteType
		 int index = (int) (Math.random() * arrayList.size());
		 Quote quote =arrayList.get(index);

		// display quote here
		
		  System.out.println("Todays Quote Of the day is :");
		  System.out.println(quote.getQuoteValue());
		  System.out.println(quote.getQuoteAuthor());
		  System.out.println(quote.getQuoteType());
		 
	}
	public static void printQuoteAuthor(String quoteAuthor) {
		System.out.println();
		 ArrayList<Quote> arrayList= new ArrayList<>();
		 for(int i=0; i<=9 ; i++) {
			 
			 if(((myQuotes[i]).getQuoteAuthor()).equals(quoteAuthor))
			 {
				 arrayList.add(myQuotes[i]);
			 }
			 
		 }
			 System.out.println("Total number of  Messages written by " +quoteAuthor+" is "+ arrayList.size());
    }
	
	
	public static void addQuote(int newId, String newQuoteValue, String newQuoteAuthor, String newQuoteType) {
		Quote q11= new Quote(newId, newQuoteValue, newQuoteAuthor, newQuoteType);
		myQuotes[10] = q11;
		
		for(int i=0; i<myQuotes.length; i++) {
			System.out.println(myQuotes[i]);	
		}

	}
  
}


