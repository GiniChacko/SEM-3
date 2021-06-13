/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;

/**
 * 
 * @author Gini Chacko
 *
 */
public class Goods {

	/**
	 * private instance variable, not accessible from outside the class
	 */
	private String description;
	private double price;
	
	/**
	 * Default Constructor for Goods
	 */
	public Goods() {
		
	}
	
	/**
	 * Constructor for Goods
	 * @param description
	 * @param price
	 */
	public Goods(String description, double price) {
		super();
		this.description = description;
		this.price = price;
	}
	
	/**
	 * Getter for instance variable description
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Setter for instance variable description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Getter for instance variable price
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Setter for instance variable price
	 * @param the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Goods [description = " + description + ", price = " + price + "]";
	}

}
