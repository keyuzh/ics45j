package labs.lab2;

/**
 * A class to represent a triangle defined by the x- and y-coorindates of its
 * three corner points
 */
public class Triangle {

	// ADD YOUR INSTANCE VARIABLES HERE
	double x1, x2, x3;
	double y1, y2, y3;

	/**
	 * Constructs a triangle with the given corner points
	 * 
	 * @param x1 x-value of corner point 1
	 * @param y1 y-value of corner point 1
	 * @param x2 x-value of corner point 2
	 * @param y2 y-value of corner point 2
	 * @param x3 x-value of corner point 3
	 * @param y3 y-value of corner point 3
	 */
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
	}


	/**
	 * Returns the length of side 1: (x1, y1) to (x2, y2)
	 * 
	 * @return the length of side 1
	 */
	public double getSide1Length() {
        return Math.sqrt( Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) );
	}


	/**
	 * Returns the length of side 2: (x1, y1) to (x3, y3)
	 * 
	 * @return the length of side 2
	 */
	public double getSide2Length() {
		return Math.sqrt( Math.pow(x1-x3, 2) + Math.pow(y1-y3, 2) );
	}


	/**
	 * Returns the length of side 3: (x2, y2) to (x3, y3)
	 * 
	 * @return the length of side 3
	 */
	public double getSide3Length() {
		return Math.sqrt( Math.pow(x2-x3, 2) + Math.pow(y2-y3, 2) );
	}


	/**
	 * Returns the angle at corner 1 (x1, y1)
	 * 
	 * @return the angle at corner 1
	 */
	public double getAngle1() {
		return Math.abs(Math.atan2(y3-y1, x3-x1) - Math.atan2(y2-y1, x2-x1));
	}


	/**
	 * Returns the angle at corner 2 (x2, y2)
	 * 
	 * @return the angle at corner 2
	 */
	public double getAngle2() {
		return Math.abs(Math.atan2(y3-y2, x3-x2) - Math.atan2(y1-y2, x1-x2));
	}


	/**
	 * Returns the angle at corner 3 (x3, y3)
	 * 
	 * @return the angle at corner 3
	 */
	public double getAngle3() {
		return Math.abs(Math.atan2(y1-y3, x1-x3) - Math.atan2(y2-y3, x2-x3));
	}


	/**
	 * Returns the perimeter of the triangle
	 * 
	 * @return the perimeter of the triangle
	 */
	public double getPerimeter() {
        return getSide1Length() + getSide2Length() + getSide3Length();
	}


	/**
	 * Returns the area of the triangle
	 * 
	 * @return the area of the triangle
	 */
	public double getArea() {
        return Math.abs(0.5 * (x1 * (y2-y3) + x2 * (y3-y1) + x3 * (y1-y2)));
	}
}