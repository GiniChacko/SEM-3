/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */

package com.crce.oopmlab;

/**
 * Class to create a rectangle object, methods to find the area , perimeter and
 * translate the points
 */
public class Rectangle {

	/**
	 * private instance variable, not accessible from outside the class
	 */
	private Point P;
	private Point Q;
	private Point R;
	private Point S;

	/**
	 * Getter for instance variable P
	 * 
	 * @return P
	 */
	public Point getP() {
		return P;
	}

	/**
	 * Getter for instance variable Q
	 * 
	 * @return Q
	 */
	public Point getQ() {
		return Q;
	}

	/**
	 * Getter for instance variable R
	 * 
	 * @return R
	 */
	public Point getR() {
		return R;
	}

	/**
	 * Getter for instance variable S
	 * 
	 * @return S
	 */
	public Point getS() {
		return S;
	}

	/**
	 * Constructs a Rectangle instance with given value for point A,B,C,D
	 * 
	 * @param A The first point
	 * @param B The second point
	 * @param C The third point
	 * @param D The fourth point
	 */
	public Rectangle(Point A, Point B, Point C, Point D) {
		this.P = new Point(A.getX(), A.getY());
		this.Q = new Point(B.getX(), B.getY());
		this.R = new Point(C.getX(), C.getY());
		this.S = new Point(D.getX(), D.getY());
	}

	/**
	 * Constructs a Rectangle instance with given value for point
	 * x1,y1,x2,y2,x3,y3,x4,y4
	 * 
	 * @param x1 (x coordinate of first point)
	 * @param y1 (y coordinate of first point)
	 * @param x2 (x coordinate of second point)
	 * @param y2 (y coordinate of second point)
	 * @param x3 (x coordinate of third point)
	 * @param y3 (y coordinate of third point)
	 * @param x4 (x coordinate of fourth point)
	 * @param y4 (y coordinate of fourth (point)
	 */
	public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
		this.P = new Point(x1, y1);
		this.Q = new Point(x2, y2);
		this.R = new Point(x3, y3);
		this.S = new Point(x4, y4);
	}

	/**
	 * Method to find the perimeter of the rectangle
	 * 
	 * @return perimeter of the rectangle
	 */
	public double Perimeter() {
		double peri;

		peri = 2 * this.getP().distancefrompoint(this.getQ());
		peri = peri + 2 * this.getP().distancefrompoint(this.getR());
		return peri;
	}

	/**
	 * Method to find the translated point
	 * 
	 * @param x_trans translation factor for x axis
	 * @param y_trans translation factor for y axis
	 */
	public void Translate(double x_trans, double y_trans) {
		this.P.translate(x_trans, y_trans);
		this.Q.translate(x_trans, y_trans);
		this.R.translate(x_trans, y_trans);
		this.S.translate(x_trans, y_trans);
	}

	/**
	 * Method to find the area of rectangle
	 * 
	 * @return area of the rectangle
	 */
	public double Area() {
		double area, length, width;

		length = this.getP().distancefrompoint(this.getQ());
		width = this.getQ().distancefrompoint(this.getR());
		area = length * width;
		return area;
	}

	/**
	 * Method to find whether the rectangle overlaps or contains another rectangle
	 * or not
	 * 
	 * @param l1 The first point
	 * @param r1 The second point
	 * @param l2 The third point
	 * @param r2 The fourth point
	 * @return true if the rectangles overlap else returns false
	 */
	public boolean containsRectangle(Point l1, Point r1, Point l2, Point r2) {
		// If one rectangle is on left side of other
		if (l1.getX() >= r2.getX() || l2.getX() >= r1.getX()) {
			return false;
		}

		// If one rectangle is above other
		if (l1.getY() <= r2.getY() || l2.getY() <= r1.getY()) {
			return false;
		}
		return true;
	}
}
