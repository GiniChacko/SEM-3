/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;

/**
 * BankAccount class is responsible creating default bank accounts Enable the
 * accounts owner to deposit, withdraw, check balance, etc.
 * 
 * @author Gini Chacko
 */
public class BankAccount 
{
	/**
	 * private instance variable, not accessible from outside the class
	 */
    private double balance;
    
	/**
	 * Getter for instance variable Balance
	 * @return balance
	 */
    public double getBalance()
    {
        return balance;
    }
    
    /**
     * Constructs a Bank Account instance with default value for balance
     */
    public BankAccount()
    {
        this.balance = 0.0;
    }
 
    /**
     * Constructor for Bank Account
     * @param balance
     */
    public BankAccount(double balance) 
    {
        this.balance = balance;
    }
   /**
    * Method deposit to deposit the amount
    * @param amount
    */
    public void deposit(double amount)
    {
        balance += amount;
    }
    
   /**
    * Method withdraw to withdraw the amount   
    * @param amount
    */
    public void withdraw(double amount)
    {
        balance -=  amount;
    }

    /**
     * Method transfer to transfer the amount
     * @param other
     * @param amount
     */
    public void transfer(BankAccount other, double amount) {
        //balance -= amount;
        //other.balance += amount;
        other.deposit(amount);
        this.withdraw(amount);
    }
    
 // Handles end-of-month operations. Overloaded method, because
 	// checking account does different things than savings account.
 	/**
 	 * Handle end of month interest for a savings account
 	 * 
 	 * @param savings the savings account to handle
 	 */
 	public void endOfMonth(SavingsAccount savings) {
 		//
 		savings.addPeriodicInterest();
 		
 	}

 	/**
 	 * Handles end of month fee deduction for a checking account
 	 * 
 	 * @param checking the checking account to handle
 	 */
 	public static void endOfMonth(CheckingAccount checking) {
 		checking.deductFees();

 	}

    @Override
    public String toString() {
        return "BankAccount{" + "balance=" + balance + '}';
    }
    
}