/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;

/**
 * Time Deposit Account class is responsible to add period interest
 * @author Gini Chacko
 *
 */
 class TimeDepositAccount extends SavingsAccount
{
	/**
	  * private instance variable, not accessible from outside the class
	  */
    private int elapsedPeriods;
    private int maturityPeriods ;
    private double interestPenaltyRate ;
    
    /**
     * Constructor for Time Deposit Account
     * @param interestRate
     * @param balance
     * @param maturityPeriods
     * @param interestPenaltyRate
     */
    public TimeDepositAccount(double interestRate, double balance, int maturityPeriods, double interestPenaltyRate) // constructor
    {
       super(interestRate,balance);
       this.elapsedPeriods=0;
       this.maturityPeriods=maturityPeriods;
       this.interestPenaltyRate = interestPenaltyRate;
       
       
    }
    
   /**
    * Method add period interest to add the period interest 
    */
    @Override
    public void addPeriodicInterest()
    {
        elapsedPeriods++;   
        super.addPeriodicInterest();
        System.out.println(elapsedPeriods);
    }
    
    /**
     * Method withdraw to withdraw the amount
     */
    @Override
    public void withdraw(double amount)  //Overridden method
    {
        elapsedPeriods++;
            
        if(elapsedPeriods<maturityPeriods)
        {
            double fees = getBalance()*(interestPenaltyRate/100)*elapsedPeriods;
            super.withdraw(fees);//withdraw the penalty
            super.withdraw(amount);//withdraw the actual amount
            
        }
            
    }

    public int getElapsedPeriods() {
		return elapsedPeriods;
	}    
}
