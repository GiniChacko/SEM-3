/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab.checkedexception;
/**
 * Bank Account Exception class
 * @author Gini Chacko
 *
 */
public class BankAccountException extends Exception {
	/**
	 * private instance variable, not accessible from outside the class
	 */
	private String message;

	/**
	 * Bank account exception method
	 * @param message
	 */
	public BankAccountException(String message) {
		
		super(message);	
		this.message = message;
	}
	
	/**
	 * Bank account exception method
	 * @param message
	 * @param cause
	 */
	public BankAccountException(String message, Throwable cause) {	
		super(message, cause);	
	}

	@Override
	public String toString() {
		return "BankAccountException [message=" + message + "]";
	}
	
	
}
