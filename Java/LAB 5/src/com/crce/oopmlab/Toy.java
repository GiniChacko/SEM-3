/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;

/**
 * Class Toy
 * @author Gini Chacko
 *
 */
public class Toy extends Goods implements Taxable{
	
	/**
	 * private instance variable, not accessible from outside the class
	 */
	private int minimumAge;
	
	/**
	 * Default constructor for Toy
	 */
	public Toy() {
		
	}

	/**
	 * Constructor for Toy
	 * @param minimumAge
	 */
	public Toy(int minimumAge) {
		super();
		this.minimumAge = minimumAge;
	}
	
	/**
	 * Constructor for Toy
	 * @param description
	 * @param price
	 * @param minimumAge
	 */
	public Toy(String description, double price, int minimumAge) {
		super(description, price);
		this.minimumAge = minimumAge;
	}

	/**
	 * Getter for instance variable minimum age
	 * @return the minimum age
	 */
	public int getMinimumAge() {
		return minimumAge;
	}

	/**
	 * Setter for instance variable minimum age
	 * @param minimumAge the minimum age to set
	 */
	public void setMinimumAge(int minimumAge) {
		this.minimumAge = minimumAge;
	}
	
	@Override
	public double calculateTax() {
		// TODO Auto-generated method stub
		return taxRate*getPrice();

	}

	@Override
	public String toString() {
		return "Toy [minimumAge = " + minimumAge + " " + super.toString()+ "]";
	}
	
	

}
