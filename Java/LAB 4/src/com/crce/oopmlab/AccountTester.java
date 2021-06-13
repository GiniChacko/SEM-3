/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;
/**
 * Account tester to test all the methods
 * @author Gini Chacko
 *
 */
public class AccountTester 
{
    public static void main(String[] args)
    {
        testAll();
    }
   
    /**
	 * Test All method containing all the methods to be tested
	 */
    public static void testAll() {
    	testSavingsAccountBehaviour();
    	testCheckingAccountBehaviour();
		testBankAccountBehaviour();
		testTimeDepositAccountBehaviour();
		testPolymorphicCalls();
	}

    /**
	 * Tester method to test savings account behaviour
	 */
	public static void testSavingsAccountBehaviour() {
		
		System.out.println("===============================");
		System.out.println("testSavingsAccountBehaviour()");
		System.out.println();
		
		SavingsAccount RinusSaving = new SavingsAccount(1.0);
		SavingsAccount PraisysSavings = new SavingsAccount(1.0);
		RinusSaving.deposit(10000);
		System.out.println("Balance in Rinu's account after depositing 10000: "+RinusSaving.getBalance());
		RinusSaving.withdraw(500);
		System.out.println("Balance in Rinu's account after withdrawing 500 : "+RinusSaving.getBalance());

		RinusSaving.transfer(PraisysSavings, 2000);
		System.out.println();
		System.out.println("Balance in Rinu's account after transferring 2000 to Praisy's account :" + RinusSaving.getBalance());
		System.out.println("Balance in Praisy's account after receiving the transaction : " + PraisysSavings.getBalance());

	}

	/**
	 * Tester method to test checking account behaviour
	 */
	public static void testCheckingAccountBehaviour() {
		
		System.out.println("===============================");
		System.out.println("testCheckingAccountBehaviour() ");
		System.out.println();
		
		SavingsAccount RinusAccount = new SavingsAccount(1.0);
		RinusAccount.deposit(10000);

		CheckingAccount PraisysAccount = new CheckingAccount();
		PraisysAccount.deposit(2000);
		System.out.println("Balance in Praisy's account after depositing 2000 : "+PraisysAccount.getBalance());
		PraisysAccount.withdraw(400);
		System.out.println("Balance in Praisy's account after withdrawing 400 : "+PraisysAccount.getBalance());

		PraisysAccount.withdraw(400);
		System.out.println("Balance in Praisy's account after withdrawing 400 : "+PraisysAccount.getBalance());
		PraisysAccount.withdraw(400);
		System.out.println("Balance in Praisy's account after withdrawing 400 : "+PraisysAccount.getBalance());

		RinusAccount.transfer(PraisysAccount, 2000);
		System.out.println();
		System.out.println("Balance in Praisy's account after receiving the transaction : " + PraisysAccount.getBalance());
		System.out.println("Balance in Rinu's account after transferring 2000 to Praisy's account : " +RinusAccount.getBalance());

	}

	/**
	 * Tester method to test bank account behaviour
	 */
	public static void testBankAccountBehaviour() {
		
		System.out.println("===============================");
		System.out.println("testBankAccountBehaviour()");
		System.out.println();
		
		BankAccount bankAccount1 = new BankAccount();
		bankAccount1.deposit(10000);// account1 balance 10000

		BankAccount bankAccount2 = new BankAccount();
		bankAccount2.deposit(5000);// account2 balance 5000

		System.out.println("Balance in bank account 1 after depositing 10000 : "+bankAccount1.getBalance());
		bankAccount1.deposit(5000);// account1 balance 20000
		System.out.println("Balance in bank account 1 after depositing 5000 : "+bankAccount1.getBalance());

		bankAccount1.deposit(5000);
		System.out.println("Balance in bank account 1 after depositing 5000 : "+bankAccount1.getBalance()); // account1 balance 18000

		bankAccount1.transfer(bankAccount2, 2000); // account2 balance 7000
		
		System.out.println();
		System.out.println("Balance in bank account 1 after transferring 2000 to bank account 2 : "+bankAccount1);
		System.out.println("Balance in bank account 2 after receiving the transaction : "+bankAccount2);

		bankAccount2.transfer(bankAccount1, 4000);
		
		System.out.println();
		System.out.println("Balance in bank account 1 after receiving the transaction : "+bankAccount1);
		System.out.println("Balance in bank account 2 after transferring 4000 to bank account 1 : "+bankAccount2);

	}

	/**
	 * Tester method to test time deposit account behaviour
	 */
	public static void testTimeDepositAccountBehaviour() {
		
		System.out.println("======================================");
		System.out.println("testTimeDepositeAccountBehaviour()");
		System.out.println();
		
		TimeDepositAccount timeDepositeAccount = new TimeDepositAccount(1.0, 10000.00, 3, 0.5);
		System.out.println("Balance in account after depositing 10000: "+timeDepositeAccount.getBalance());
		CheckingAccount checkingAccount1 = new CheckingAccount(10000);
		timeDepositeAccount.transfer(checkingAccount1, 980);

		System.out.println("Balance in account after transferring 980 : "+timeDepositeAccount.getBalance());
		timeDepositeAccount.endOfMonth(timeDepositeAccount);

		System.out.println(timeDepositeAccount.getElapsedPeriods());

		/*
		 * timeDepositeAccount.withdraw(1000);
		 * timeDepositeAccount.withdraw(1000);
		 * timeDepositeAccount.withdraw(1000);
		 * timeDepositeAccount.withdraw(1000);
		 */
		System.out.println( timeDepositeAccount.getElapsedPeriods());
		System.out.println("Balance in account after penalty : " +timeDepositeAccount.getBalance());

	}

	/**
	 * Tester method to test polymorphic calls
	 */
	public static void testPolymorphicCalls() {
		
		System.out.println("===============================");
		System.out.println("testPolymorphicCalls()");
		System.out.println();
		
		BankAccount account1 = new SavingsAccount(2);
		account1.deposit(10000);
		account1.endOfMonth((SavingsAccount) account1);
		System.out.println("Balance in the end of the month : "+account1.getBalance());
	}
}
