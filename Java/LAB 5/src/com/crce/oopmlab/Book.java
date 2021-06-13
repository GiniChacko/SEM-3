/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;

/**
 * Class Book 
 * @author Gini Chacko
 *
 */
public class Book extends Goods implements Taxable{
	
	/**
	 * private instance variable, not accessible from outside the class
	 */
	private String author;
	
	/**
	 * Default constructor for book
	 */
	public Book() {
		
	}

	/**
	 * Constructor for Book
	 * @param author
	 */
	public Book(String author) {
		super();
		this.author = author;
	}
	
	/**
	 * Constructor for Book
	 * @param description
	 * @param price
	 * @param author
	 */
	public Book(String description, double price, String author) {
		super(description, price);
		this.author = author;
	}

	/**
	 * Getter for instance variable author
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Setter for instance variable author
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public double calculateTax() {
		// TODO Auto-generated method stub
		return taxRate*getPrice();
	}

	@Override
	public String toString() {
		return "Book [author = " + author + " " + super.toString()+"]";
	}
	
}
