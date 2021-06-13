/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;

/**
 * A CheckingAccount is a BankAccount with some number of free transactions,
 * with a fee charged for subsequent transactions
 * 
 * @author Gini Chacko
 */

public class CheckingAccount extends BankAccount
{
	/**
	 * private instance variable, not accessible from outside the class
	 */
    private static final int FREE_TRANSACTIONS = 3; // private members
    private static final double TRANSACTION_FEE = 0.50;
    private int transactionCount; // Number of transactions this period    

    /**
     * Constructs a Checking Account instance with default value for transaction count
     */
    public CheckingAccount() 
    {
        transactionCount=0;
    }
    
    /**
     * Constructor for Checking Account with parameter acc
     * @param acc
     */
    public CheckingAccount(double acc) 
    {
        super(acc);
        transactionCount=0;
    }
    
    @Override
    public void withdraw(double amount)
    {
        
        if(amount>0)
        {
            //increment transaction count by one for every withdrawal
            transactionCount++;
            super.withdraw(amount);
        }
        else
        {
            System.out.println("Insufficient Balance");
        }
        
    }
    @Override
    public void deposit(double amount)
    {
        super.deposit(amount);
        transactionCount++;
    }

    /**
     * Method deduct fees to calculate the deducted fees
     */
    public void deductFees()
    {
        if (transactionCount > FREE_TRANSACTIONS)
        {
            double fees = TRANSACTION_FEE * (transactionCount - FREE_TRANSACTIONS);
            if (fees!=0)
            {
                withdraw(fees);//withdraw the charges for extra transactions
                transactionCount = 0;
            }
            
        }
    }
    
}

