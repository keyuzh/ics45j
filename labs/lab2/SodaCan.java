package labs.lab2;

public class SodaCan {

	// ADD YOUR INSTANCE VARIABLES EHRE
	private double height;
	private double diameter;

	/**
	 * Creates a soda can.
	 * 
	 * @param h the height of the soda can (in inches) - assume will always be > 0
	 * @param d the diameter of the soda can (in inches) - assume will always be > 0
	 */
	public SodaCan(double h, double d) {
        height = h;
		diameter = d;
	}

	/**
	 * Finds and returns the volume of the soda can.
	 * 
	 * @return the volume of liquid the can will hold (in cubic in.)
	 */
	public double getVolume() {
		double radius = diameter / 2.0;
        return Math.PI * radius * radius * height;
	}


	/**
	 * Finds and returns the surface area of the soda can.
	 * 
	 * @return the surface area of the soda can (in square in.)
	 */
	public double getSurfaceArea() {
		double radius = diameter / 2.0;
        return 2.0 * Math.PI * radius * (height + radius);
	}
}
