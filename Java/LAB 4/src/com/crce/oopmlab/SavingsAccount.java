/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;

/**
 * A SavingsAccount is a BankAccount with an associated interest rate;
 *  interest is calculated and added to the balance periodically
 *  
 *  @author Gini Chacko
 */

public class SavingsAccount extends BankAccount
{
	/**
	 * private instance variable, not accessible from outside the class
	 */
    private double interestRate;
  
    /**
     * Constructs a Savings Account instance with default value for interest rate 
     */
    public SavingsAccount() 
    {
        this.interestRate = 1.0;
    }
    /**
     * Constructor for Savings Account
     * @param interestRate 
     */
    public SavingsAccount(double interestRate) 
    {
        this.interestRate = interestRate;
    }

    /**
     * Constructor for Savings Account
     * @param interestRate
     * @param balance
     */
    public SavingsAccount(double interestRate, double balance) {
        super(balance);//calling the super class constructor with one parameter
        this.interestRate = interestRate;
    }
        
    /**
    * interest is calculated and added to the balance by calling the deposit() method 
    * of parent class periodically
    */
    
    public void addPeriodicInterest()
    {
        double interest = getBalance() * interestRate / 100;
	    deposit(interest);
       

	}
        
    
}
