/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;

/**
 * Rectangle Tester class to test all the methods
 */
public class RectangleTester {
	
	static Point P = new Point(11,15);
	static Point Q = new Point(20,10);
	static Point R = new Point(15,30);
	static Point S = new Point(25,10);

	public static void main(String[] args) {
		// Test methods are made static so can be directly used in the static main()
		// method.
		testAll();
	}

	/**
	 * Test All method containing all the methods to be tested
	 */
	public static void testAll() {
		testPerimeter();
		testTranslate();
		testArea();
		testcontainsRectangle();
		}
	/**
	 * Tester method to find the perimeter of the rectangle
	 */
	public static void testPerimeter() {

		System.out.println("==========================");
		System.out.println("testPerimeter()");
		System.out.println();

		Rectangle rect = new Rectangle (P,Q,R,S);
		System.out.println("The perimeter of the rectangle is : "+rect.Perimeter());
	}
	/**
	 * Tester method to translate the point
	 */
	public static void testTranslate() {

		System.out.println("==========================");
		System.out.println("testTranslate()");
		System.out.println();

		//Rectangle rect = new Rectangle (2,3,5,7,8,4,1,6);
		Rectangle rect = new Rectangle (P,Q,R,S);
		rect.Translate(11, 16);
	}
	/**
	 * Tester method to find the area of the rectangle
	 */
	public static void testArea() {

		System.out.println("==========================");
		System.out.println("testArea()");
		System.out.println();

		Rectangle rect = new Rectangle (2,3,5,7,8,4,1,6);
		System.out.println("The Area of Rectangle = " + rect.Area());
	}
	/**
	 * Tester method to find whether the rectangles overlap or not
	 */
	public static void testcontainsRectangle() {
		
		System.out.println("==========================");
		System.out.println("testcontainsRectangle()");
		Rectangle rect = new Rectangle (2,3,5,7,8,4,1,6);
		
		if (rect.containsRectangle(P, Q, R, S)) { 
			System.out.println("Rectangles Overlap"); 
		} else { 
			System.out.println("Rectangles Don't Overlap"); 
		} 
	}
}
