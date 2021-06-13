/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab.checkedexception;
/**
 * Bank Account tester class
 * @author Gini Chacko
 *
 */
public class BankAccountTester {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args)  {

		System.out.println("===============BANK ACCOUNT TESTER FOR CHECKED EXCEPTIONS================\n");
		
	    System.out.println("Testing for Bank Account 1");
		BankAccount account1 = new BankAccount();
		System.out.println(account1);
		System.out.println("-------------------------------------------------------------------------\n");
		
		System.out.println("Testing for Bank Account 2");
		try 
		{
			BankAccount account2 = new BankAccount(500, 10400);
			System.out.println(account2);
			account2.deposit(-300);
			System.out.println(account2);

		} 
		catch (BankAccountException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------------------------------------------------------------------------\n");
		
		System.out.println("Testing for Bank Account 3");
		try 
		{
			BankAccount account3 = new BankAccount(500, 10400);
			System.out.println(account3);
			account3.withdraw(1000);
			System.out.println(account3);
		}
		catch (BankAccountException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------------------------------------------------------------------------\n");
	    System.out.println("ALL EXCEPTIONS SUCCESSFULLY CHECKED !!!");
	}

	

}
