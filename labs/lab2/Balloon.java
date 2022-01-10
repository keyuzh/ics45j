package labs.lab2;

/**
 * A class to represent an inflatable spherical balloon.
 */
public class Balloon {

	// ADD YOUR INSTANCE VARIABLES EHRE
	double volume;

	/**
	 * Constructs an unfilled balloon.
	 */
	public Balloon() {
        volume = 0.0;
	}


	/**
	 * Inflates the balloon with a specified amount of air.
	 * 
	 * @param amount the increase to the volume of the balloon (in cubic cm). Assume
	 * always >= 0.
	 */
	public void addAir(double amount) {
        volume += amount;
	}


	/**
	 * Returns the volume of air currently inside the balloon.
	 * 
	 * @return the volume of air in the balloon (in cubic cm)
	 */
	public double getVolume() {
        return volume;
	}


	/**
	 * Finds and returns the radius of the balloon.
	 * 
	 * @return the radius of balloon (in centimeters)
	 */
	public double getRadius() {
		return Math.cbrt((0.75 * volume) / Math.PI);
	}


	/**
	 * Finds and returns the surface area of the balloon.
	 * 
	 * @return the surface area of balloon (in square centimeters)
	 */
	public double getSurfaceArea() {
        return Math.pow(3.0 * volume, 2.0/3.0) * Math.pow(4.0 * Math.PI, 1.0/3.0);
	}
}