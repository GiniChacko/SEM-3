/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab.uncheckedexception;
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

		System.out.println("===============BANK ACCOUNT TESTER FOR UNCHECKED EXCEPTIONS================\n");
		
	    System.out.println("Testing for Bank Account 1");
		BankAccount account1 = new BankAccount();
		System.out.println(account1);
		System.out.println("-------------------------------------------------------------------------\n");
		
		System.out.println("Testing for Bank Account 2");
		BankAccount account2 = new BankAccount(500,10400);
		account2.transfer(100, account1);
		System.out.println("The blance in account 1 after the transaction is "+account1.getBalance());
		System.out.println("The blance in account 2 after the transaction is "+account2.getBalance());
		System.out.println("-------------------------------------------------------------------------\n");
		
		System.out.println("Testing for Bank Account 3");
		BankAccount account3 = new BankAccount(200,10400);
		System.out.println(account3);
		account3.withdraw(300);
		//account3.deposit(-300);
		System.out.println(account3);
	}


}
