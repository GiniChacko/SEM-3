/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;
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
	public static void main(String[] args) {
		
		System.out.println("===============BANK ACCOUNT TESTER================\n");
		
	    System.out.println("Testing for Bank Account 1");
		BankAccount account1 = new BankAccount();
		System.out.println(account1);
		System.out.println("-------------------------------------------------------------------------\n");
		
		System.out.println("Testing for Bank Account 2");
		BankAccount account2 = new BankAccount(1000, 101);
		System.out.println(account2);
		System.out.println("-------------------------------------------------------------------------\n");
		
		System.out.println("Testing for Bank Account 3");
		BankAccount account3 = new BankAccount(2000,101);
		account3.withdraw(500);
		System.out.println("The balance in the bank account 3 after withdrawing 500 is " +account3.getBalance());
		System.out.println("-------------------------------------------------------------------------\n");
	
		System.out.println("Testing for Bank Account 4");
		BankAccount account4 = new BankAccount(2000,101);
		account4.deposit(200);
		System.out.println("The balance in the bank account 4 after deposting 200 is " +account4.getBalance());
		System.out.println("-------------------------------------------------------------------------\n");
		
		System.out.println("Testing for Bank Account 5");
		BankAccount account5 = new BankAccount(10000,101);
		account5.transfer(5500, account2);
		System.out.println("The balance in the bank account 2 after deposting 5500 is " +account2.getBalance());
		System.out.println("-------------------------------------------------------------------------\n");
		
		System.out.println("Testing for Bank Account 6");
		BankAccount account6 = new BankAccount(-2000,101);
		System.out.println(account6);
	}

}
