/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */

package com.crce.oopmlab;
/**
 * Interface Taxable to calculate the tax and excise tax
 * @author Gini Chacko
 *
 */
public interface Taxable {
	
	public static double taxRate = 0.06;
	
	double calculateTax();

}
/**
 * This is specific interface which calculates extra tax than other taxable items
 */
interface ExciseTaxable extends Taxable{
	double extraTax = 0.02;
	
	double calculateExtra();
}
