/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */
package com.crce.oopmlab;
/**
 *Class to create a triangle object, methods to find the perimeter of a triangle, to translate a point
 *and to find the area of the triangle
 *
 */

public class Triangle {

	/**
	 * private instance variable, not accessible from outside the class
	 */
	private Point P;
	private Point Q;
	private Point R;
	
	 /**
     * Getter for instance variable P
     * @return P
     */
	public Point getP() {
		return this.P;
	}

	/**
	 * Getter for instance variable Q
	 * @return Q
	 */
	public Point getQ() {
		return this.Q;
	}

	/**
	 * Getter for instance variable R
	 * @return R
	 */
	public Point getR() {
		return this.R;
	}

	/**
	 * Constructs a Triangle instance with given value for point A,B,C 
	 * @param A The first point
	 * @param B The second point
	 * @param C The third point
	 */
	public Triangle(Point A, Point B, Point C) {
		this.P = new Point(A.getX(), A.getY());
		this.Q = new Point(B.getX(), B.getY());
		this.R = new Point(C.getX(), C.getY());
	}

	/**
	 * Constructs a Triangle instance with given value for point x1,y1,x2,y2,x3,y3
	 * @param x1 (x coordinate of first point)
	 * @param y1 (y coordinate of first point)
	 * @param x2 (x coordinate of second point)
	 * @param y2 (y coordinate of second point)
	 * @param x3 (x coordinate of third point)
	 * @param y3 (y coordinate of third point)
	 */
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		this.P = new Point(x1, y1);
		this.Q = new Point(x2, y2);
		this.R = new Point(x3, y3);
	}

	/**
	 * Method to find the perimeter of a triangle
	 * @return perimeter of the the triangle
	 */
	public double Perimeter() {
		double peri;
		peri = this.P.distancefrompoint(this.Q);
		peri = peri + this.P.distancefrompoint(this.R);
		peri = peri + this.Q.distancefrompoint(this.R);
		return peri;
	}

	/**
	 * Method to find the translated point
	 * @param x_trans translation factor for x axis
	 * @param y_trans translation factor for y axis
	 */
	public void Translate(double x_trans, double y_trans) {
		this.P.translate(x_trans, y_trans);
		this.Q.translate(x_trans, y_trans);
		this.R.translate(x_trans, y_trans);
	}

	/**
	 * Method to find the area of a triangle
	 * @return area of a triangle
	 */
	public double Area() {
		double peri, area, s, a, b, c;
		peri = this.Perimeter();
		s = peri / 2;
		a = this.P.distancefrompoint(this.Q);
		b = this.P.distancefrompoint(this.R);
		c = this.Q.distancefrompoint(this.R);
		area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		return area;
	}
}