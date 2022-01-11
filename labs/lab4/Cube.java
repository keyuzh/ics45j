package labs.lab4;

/**
 * A class that represents a cube and can calculate its volume and surface
 * area.
 */
public class Cube {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double sideLength;

	/**
	 * Creates a cube with the given side length.
	 * 
	 * @param sideLength the side length (assume > 0)
	 */
	public Cube(double sideLength) {
        this.sideLength = sideLength;
	}


	/**
	 * Calculates the volume of the cube.
	 * 
	 * @return the volume of the cube.
	 */
	public double getVolume() {
		return sideLength * sideLength * sideLength;
	}


	/**
	 * Calculates the surface area of the cube.
	 * 
	 * @return the surface area of the cube.
	 */
	public double getSurface() {
		return 6.0 * sideLength * sideLength;
	}
}
