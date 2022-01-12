package labs.lab4;

import java.awt.Point;

/**
 * A class to represent a labeled point.
 */
public class LabeledPoint extends Point {

	// ADD YOUR INSTANCE VARIABLES HERE
	String label;

	/**
	 * Constructs a labeled point at (x,y) with a given label.
	 * 
	 * @param x     the x coordinate
	 * @param y     the y coordinate
	 * @param label the point label
	 */
	public LabeledPoint(int x, int y, String label) {
		// HINT: CALL THE SUPERCLASS CONSTRUCTOR AS PART OF YOUR IMPLEMENTATION
        super(x, y);
		this.label = label;
	}


	/**
	 * Displays the (x,y) and point label
	 */
	@Override
	public String toString() {
		// HINT: CALL THE SUPERCLASS TOSTRING AS PART OF YOUR IMPLEMENTATION
        return String.format("%s label=%s", super.toString(), label);
	}
}
