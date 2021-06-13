/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */

package com.crce.oopmlab;

/**
 * Class to create the circle object, methods to find perimeter, to find the
 * changed radius, To translate, to find whether the point is present inside the
 * circle or no and to find whether the circles are intersecting or no
 */
public class Circle {

	/**
	 * private instance variable, not accessible from outside the class
	 */
	private Point center;
	private double radius;

	/**
	 * Constructs a Circle instance with given value for p and r
	 */
	Circle(Point p, double r) {
		center = new Point(p.getX(), p.getY());
		radius = r;
	}

	/**
	 * Constructs a Circle instance with given value for x, y and r
	 */
	Circle(double x, double y, double r) {
		center = new Point(x, y);
		radius = r;
	}

	/**
	 * Constructs a Circle instance with default value for point and radius(Default
	 * constructor)
	 */
	Circle() {
		center = new Point(0, 0);
		radius = 0;
	}

	/**
	 * Getter for instance variable center
	 * 
	 * @return center
	 */
	public Point getCenter() {
		return center;
	}

	/**
	 * Setter for instance variable center
	 * 
	 * @param Center
	 */
	public void setCenter(Point center) {
		this.center = center;
	}

	/**
	 * Getter for instance variable radius
	 * 
	 * @return Radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Setter for instance variable center
	 * 
	 * @param radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * Method to find the perimeter of the circle
	 * 
	 * @return the value of the perimeter of circle
	 */
	public double Perimeter() {
		return (2 * 3.14 * radius);
	}

	/**
	 * Method to find the value of the changed radius
	 * 
	 * @param radius_change(the value to change radius)
	 * @return the value of the changed radius
	 */
	public double changeRadius(double radius_change) {
		radius = radius + radius_change;
		return radius;
	}

	/**
	 * Method to find whether the point is inside the circle or not
	 * 
	 * @param P point to be checked if it's inside or not
	 * @return true if point is inside the circle else return false
	 */
	public boolean pointInsidecircle(Point P) {
		double dist = getCenter().distancefrompoint(P);
		System.out.println(dist);
		if (dist > radius)
			return false;
		else
			return true;
	}

	/**
	 * Method to find the translated point
	 * 
	 * @param x_diff translation factor for x axis
	 * @param y_diff translation factor for y axis
	 */
	public void Translate(double x_diff, double y_diff) {
		center.translate(x_diff, y_diff);
	}

	/**
	 * Method to find whether the circles intersects or no
	 * 
	 * @param C1 circle 1
	 * @param C2 circle 2
	 * @return true if circles intersect else return false
	 */
	public boolean intersectCircles(Circle C1, Circle C2) {
		double distance, sumOfRadii;
		distance = C1.center.distancefrompoint(C2.center);
		sumOfRadii = C1.radius + C2.radius;

		if (distance <= sumOfRadii)
			return true;
		else
			return false;
	}
}
