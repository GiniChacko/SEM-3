/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */

package com.crce.oopmlab;

/**
 * Class to create a point object, methods to find the distance from origin,
 * distance from point, to translate the point, to find the xMirror Image, to
 * calculate the center with 2 points, to calculate the center with 3 points.
 *
 */
public class Point {
	/**
	 * private instance variable, not accessible from outside the class
	 */
	private double x;
	private double y;

	/**
	 * Getter for instance variable x
	 * 
	 * @return x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Setter for instance variable x
	 * 
	 * @param x of type double
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Getter for instance variable y
	 * 
	 * @return y of type double
	 */
	public double getY() {
		return y;
	}

	/**
	 * Setter for instance variable y
	 * 
	 * @param Y
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Constructs a Point instance with default value for x and y(Default
	 * constructor)
	 */
	public Point() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * Constructs a Point instance with given value for x and y
	 * 
	 * @param x1 (x coordinate)
	 * @param y1 (y coordinate)
	 */
	public Point(double x1, double y1) {
		this.x = x1;
		this.y = y1;
	}

	/**
	 * Method to find the distance from the origin
	 * 
	 * @return distance from the origin
	 */

	public double distancefromorigin() {
		double dist;
		dist = Math.sqrt(this.x * this.x + this.y * this.y);
		return dist;
	}

	/**
	 * Method to find the from a point
	 * 
	 * @param Q The distance from the point to be found
	 * @return Math.sqrt(diff_x*diff_x + diff_y*diff_y)
	 */
	public double distancefrompoint(Point Q) {
		double diff_x = this.x - Q.x;
		double diff_y = this.y - Q.y;
		return Math.sqrt(diff_x * diff_x + diff_y * diff_y);
	}

	/**
	 * Method to translate a point
	 * 
	 * @param x_trans translation factor for x axis
	 * @param y_trans translation factor for y axis
	 */
	public void translate(double x_trans, double y_trans) {
		this.x = x + x_trans;
		this.y = y + y_trans;
		System.out.println("The point after translation is : " + "(" + x + "," + y + ")");
	}

	/**
	 * Method to find the xMirrorImage
	 */
	public void xMirrorImage() {
		this.y = -this.y;
		this.x = -this.x;
		System.out.println("The Mirror Image of the point is : " + "(" + x + "," + y + ")");
	}

	/**
	 * Calculate distance from center
	 * 
	 * @param P The first point
	 * @param Q The second point
	 * @return The mid point of the two points P and Q
	 */

	public Point calculateCenterPoint(Point P, Point Q) {
		Point mid = new Point((P.x + Q.x) / 2, (P.y + Q.y) / 2);
		return mid;
	}

	/**
	 * Calculate distance from center
	 * 
	 * @param P The first point
	 * @param Q The second point
	 * @param R The third point
	 * @return The mid point of the two points P and Q
	 */
	public Point calculateCenterPoint3(Point P, Point Q, Point R) {
		Point mid = new Point((P.x + Q.x + R.x) / 3, (P.y + Q.y + R.y) / 3);
		return mid;
	}

}