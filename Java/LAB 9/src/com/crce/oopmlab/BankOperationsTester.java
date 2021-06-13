/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

/**
 * Bank operations tester class
 * @author Gini Chacko
 * 
 */

class BankAccount {
	
	/**
	 * private instance variable, not accessible from outside the class
	 */
	private double balance;
	private int accountNo;
	
	/**
	 * Default constructor for bank account
	 */
	public BankAccount() {
		// TODO Auto-generated constructor stub
		balance = 0.0;
	}

	/**
	 * Constructor for bank account
	 * @param initialBalance
	 */
	public BankAccount(double initialBalance) {
		// TODO Auto-generated constructor stub
		balance = initialBalance;
	}
	
	/**
	 * Getter for instance variable balance
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Getter for instance variable account no
	 * @return account no
	 */
	public int getAccountNo() {
		return accountNo;
	}
	
	/**
	 * Setter for instance variable account no
	 * @param accountNo
	 */
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	/**
	 * Setter for instance variable balance
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Method to deposit the amount
	 * @param amount
	 */
	public synchronized void deposit(double amount) {
		balance += amount;
		System.out.println(amount + " is Deposited.");
		displayBalance();
	}
	
	/**
	 * Method to withdraw the amount
	 * @param amount
	 */
	public synchronized void withdraw(double amount) {
		balance -= amount;
		System.out.println(amount + " is Withdrawn.");
		displayBalance();
	}
	
	/**
	 * Method to transfer the amount
	 * @param amount
	 * @param otherAccount
	 */
	public void transfer(double amount, BankAccount otherAccount) {
		//balance -= amount;
		withdraw(amount);
		otherAccount.deposit(amount);
		
	}
	
	/**
	 * Method to display the balance amount
	 */
	void displayBalance() {
		System.out.println("Account No: " + accountNo + " Balance: " + balance);
	}

	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + "]";
	}
	
}


	class TransactionDeposit implements Runnable {
		
		int amount;
		BankAccount accountX;
	
	/**
	 * 
	 * @param amount
	 * @param accountX
	 */
	public TransactionDeposit(int amount, BankAccount accountX) {
		this.amount = amount;
		this.accountX = accountX;
	}
		
	public void run() {
		accountX.deposit(amount);
	}
	
}
	

	class TransactionWithdraw implements Runnable {
		int amount;
		BankAccount accountY;
	
	/**
	 * 
	 * @param amount
	 * @param accountY
	 */
	public TransactionWithdraw(int amount, BankAccount accountY) {
		this.amount = amount;
		this.accountY = accountY;
	}
		
	public void run() {
		accountY.withdraw(amount);
	}
	
}
	

public class BankOperationsTester {
		
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
			
		BankAccount account = new BankAccount();
		account.setBalance(10000);
		account.setAccountNo(29469);
		account.displayBalance();
		
		TransactionDeposit transactionDeposit = new TransactionDeposit(1500,account);
		TransactionWithdraw transactionWithdraw = new TransactionWithdraw(2500,account);
		
		Thread t1 = new Thread(transactionDeposit);
		Thread t2 = new Thread(transactionWithdraw);
		
		t1.start();
		t2.start();
		
	}
		
}




