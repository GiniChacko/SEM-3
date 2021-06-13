/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab.uncheckedexception;
/**
 * Bank Account Class
 * @author Gini Chacko
 *
 */
public class BankAccount {
	
	/**
	 * private instance variable, not accessible from outside the class
	 */
	private double balance;
	private int accountNo;
	
	/**
	 * Default constructor for bank account
	 */
	public BankAccount() {
		
		this.accountNo = 007;
		this.balance = 1.0;
	}
	
	/**
	 * Constructor for bank account
	 * @param accountNo
	 */
	public BankAccount(int accountNo) {
		
		this.accountNo = accountNo;
		this.balance = 1.0;
	}
	
	/**
	 * Constructor for bank account
	 * @param initialBalance
	 * @param accountNo
	 */
	public BankAccount(double initialBalance, int accountNo)  {

        if (initialBalance < 0)
        	throw new BankAccountException("Intial Balance must not be negative");
        
        else 
        {
			this.balance = initialBalance;
			this.accountNo = accountNo;
        }
	}
	
	/**
	 * Getter for instance variable balance
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Setter for instance variable balance
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
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
	
	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + ", accountNo=" + accountNo + "]";
	}
	
	/**
	 * Method to deposit the amount
	 * @param amount
	 */
	public void deposit(double amount) {
		
		if(amount < 0)
			throw new BankAccountException("Deposit amount must not be negative");
		else 
		{
		    balance = balance + amount;	
		}
	}
	
	/**
	 * Method to withdraw the amount
	 * @param amount
	 */
	public void withdraw(double amount)  {
		
		if(balance < amount)
			throw new BankAccountException("Withdrawal amount must not be less than the balance");
		else 
		{
		    balance = balance - amount;	
		}
	}	
	
	/**
	 * Method to transfer the amount
	 * @param amount
	 * @param otherAccount
	 */
	public void transfer(double amount,BankAccount otherAccount)  {
		
			withdraw(amount);
			otherAccount.deposit(amount);
	}

}
