/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;

/**
 * Class Food
 * @author Gini Chacko
 *
 */
public class Food extends Goods  {
  
   /**	
    * private instance variable, not accessible from outside the class
    */
   private double calories;
   
   /**
    * Default Constructor for Food
    */
   public Food() {
	   
   }

   /**
    * Constructor for Food
    * @param calories
    */
	public Food(double calories) {
		super();
		this.calories = calories;
	}
   
    /**
     * Constructor for Food
     * @param description
     * @param price
     * @param calories
     */
    public Food(String description, double price, double calories) {
    	super(description,price);
    	this.calories = calories;
    }

    /**
     * Getter for instance variable calories
     * @return the calories
     */
	public double getCalories() {
		return calories;
	}

	/**
	 * Setter for instance variable Calories
	 * @param calories the calories to set
	 */
	public void setCalories(double calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Food [calories = " + calories + " " + super.toString()+"]";
	}

	
}
