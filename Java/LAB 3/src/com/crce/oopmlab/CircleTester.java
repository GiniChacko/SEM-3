/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;

/**
 * Point Tester class to test all the methods
 */
public class CircleTester {

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
		testChangeradius();
		testPointInsidecircle();
		testTranslate();
		testIntersectCircles();
	}

	/**
	 * Tester method to find the perimeter of circle
	 */
	public static void testPerimeter() {
		System.out.println("==========================");
		System.out.println("testPerimeter()");
		Circle cir = new Circle(5, 6, 7);
		System.out.println("The Perimeter of Circle = " + cir.Perimeter());
	}

	/**
	 * Tester method to find the changed radius of circle
	 */
	public static void testChangeradius() {
		System.out.println("==========================");
		System.out.println("testChangeradius()");
		Circle cir = new Circle();
		cir.setRadius(5);
		System.out.println("The radius of Circle = " + cir.changeRadius(9));
	}

	/**
	 * Tester method to find whether the point is present inside the circle or not
	 */
	public static void testPointInsidecircle() {
		System.out.println("==========================");
		System.out.println("testPointInsidecircle()");

		Circle cir = new Circle(0, 0, 6);
		Point pt = new Point(3, 4);
		System.out.println("Point Inside circle = " + cir.pointInsidecircle(pt));

	}

	/**
	 * Tester method to find to translate the point
	 */
	public static void testTranslate() {
		System.out.println("==========================");
		System.out.println("testTranslate()");

		Circle cir = new Circle(2, 4, 6);

		cir.Translate(11, 16);
	}

	/**
	 * Tester method to find whether the circles are intersecting or not
	 */
	public static void testIntersectCircles() {
		System.out.println("==========================");
		System.out.println("testIntersectCircles()");

		Circle C1 = new Circle(0, 0, 3);
		Circle C2 = new Circle(5, 0, 1);

		if (C1.intersectCircles(C1, C2))
			System.out.println("The circles DO intersect");
		else
			System.out.println("The circles DO NOT intersect");
	}
}
