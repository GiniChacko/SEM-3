/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;
/**
 * Triangle Tester class to test all the methods
 */
public class TriangleTester {
	
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

}
	/**
	 * Tester method to find the perimeter of the triangle
	 */
	public static void testPerimeter() {
		System.out.println("==========================");
		System.out.println("testPerimeter()");
		System.out.println();
		Triangle tri = new Triangle(2, 3, 5, 7, 9, 1);
		System.out.println("The Perimeter of Triangle = "+tri.Perimeter());	
	}
	/**
	 * Tester method to find the translated point
	 */
	public static void testTranslate() {
		
		System.out.println("==========================");
		System.out.println("testTranslate()");
		System.out.println();

		Triangle tri = new Triangle(2, 3, 5, 7, 9, 1);
		tri.Translate(11, 16);
		
		
	}
	/**
	 * Tester method to find the area of rectangle
	 */
	public static void testArea() {
		
		System.out.println("==========================");
		System.out.println("testArea()");
		System.out.println();

		Triangle tri = new Triangle(2, 3, 5, 7, 9, 1);
		
		System.out.println("The Area of Triangle = " + tri.Area());
		
	}
}
