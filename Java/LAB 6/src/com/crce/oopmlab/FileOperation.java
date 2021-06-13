/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;
import edu.duke.FileResource;
/**
 * File operation class
 * @author Gini Chacko
 *
 */
public class FileOperation {
	
	/**
	 * Method to fetch count
	 * @return count
	 */
	public static int fetchCount() {
		int count=0;
		// create File resource to fetch data from file
		FileResource fileResource = new FileResource("data/words.txt");
		// row in file is fetched and stored in String line
		for (String line : fileResource.lines()) {
			String[] tokens=line.split(" ");
			count = count+ tokens.length;
			
		}
		return count;
       }
}
