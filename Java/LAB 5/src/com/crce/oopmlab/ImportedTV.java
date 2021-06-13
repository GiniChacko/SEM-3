/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;

/**
 * Class Imported TV to calculate the tax and excise tax
 * @author Gini Chacko
 *
 */
public class ImportedTV extends Goods implements ExciseTaxable {

	/**
	 * Constructor for Imported TV
	 * @param des
	 * @param pr
	 */
	public ImportedTV(String des, double pr) {
		super(des,pr);
	}
	
	/**
	 * Method to calculate the extra tax
	 */
	public double calculateExtra() {
		return getPrice()*extraTax;
	}
	
	/**
	 * Method to calculate the tax
	 */
	public double calculateTax() {
		return getPrice()*taxRate;
	}

}
