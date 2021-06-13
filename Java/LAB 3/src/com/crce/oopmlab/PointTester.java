/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */

package com.crce.oopmlab;
/**
 * Point Tester class to test all the methods
 */
public class PointTester {
	
	public static void main(String[] args) {
		// Test methods are made static so can be directly used in the static main()
		// method.
		testAll();
	}
   /**
    * Test All method containing all the methods to be tested
    */
	public static void testAll() {

		testdistancefromorigin();
		testdistancefrompoint();
		testtranslate();
		testerxMirrorImage();
		testcalculateCenterPoint();
		testcalculateCenterPoint3();	
	}
	/**
	 * Tester method to find the distance from origin
	 */
	public static void testdistancefromorigin() {
		System.out.println("==========================");
		System.out.println("testdistancefromorigin()");
			
		Point pt = new Point(3,5);
		System.out.println("Distance of the point from the origin is : "+pt.distancefromorigin());	
	}

	/**
	 * Tester method to find the distance from point
	 */
	public static void testdistancefrompoint() {
		System.out.println("==========================");
		System.out.println("testdistancefrompoint()");
		
		Point pt1 = new Point(6,7);
		Point pt2 = new Point(8,9);
		
		System.out.println("Distance between the two point is : "+pt1.distancefrompoint(pt2));	
	}
	
	/**
	 * Tester method to translate the point
	 */
	public static void testtranslate() {
		System.out.println("=================");
		System.out.println("testtranslate()");
		
		Point pt = new Point(6,7);
		pt.translate(10, 20);	
	}
	
	/**
	 * Tester method to find the xMirror Image
	 */
	public static void testerxMirrorImage() {
		
		System.out.println("======================");
		System.out.println("testerxMirrorImage()");
	
		Point pt = new Point(5,7);
		pt.xMirrorImage();
		System.out.println();	
	}
	
	/**
	 * Tester method to calculate the center point with two points 
	 */
	public static void testcalculateCenterPoint() {

		System.out.println("===========================");
		System.out.println("testcalculateCenterPoint()");

		Point pt = new Point();
		Point P = new Point(6,7);
		Point Q = new Point(3,5);
		pt = pt.calculateCenterPoint(P, Q);
		System.out.println("The Midpoint is :" + "("+pt.getX()+" , " +pt.getY()+")");
		System.out.println();
	}
	
	
	/**
	 * Tester method to calculate the center point with three points 
	 */
    public static void testcalculateCenterPoint3() {
    	
    	System.out.println("=============================");
		System.out.println("testcalculateCenterPoint3()");
	
		Point pt = new Point();
		Point P = new Point(6,7);
		Point Q = new Point(3,5);
		Point R = new Point(2,8);
		pt = pt.calculateCenterPoint3(P, Q, R);
		System.out.println("The Midpoint is :" + "("+pt.getX()+" , " +pt.getY()+")");
		System.out.println();
	}
}
