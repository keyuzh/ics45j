package labs.lab4;

/**
 * A class that represents a right square pyramid and can calculate its volume and surface
 * area.
 */
public class Pyramid {

	 // ADD YOUR INSTANCE VARIABLES HERE
	private double edgeLength, height;

	/**
	 * Creates a new right square pyramid of given edge length and height.
	 * 
	 * @param 	edgeLength		the length of one of the pyramid's base edges (assume > 0)
	 * @param 	height			the height of the pyramid (assume > 0)
	 */
	public Pyramid(double edgeLength, double height) {
		this.edgeLength = edgeLength;
		this.height = height;
	}


	/**
	 * Calculates the volume of the pyramid.
	 * 
	 * @return the volume of the pyramid
	 */
	public double getVolume() {
		return edgeLength * edgeLength * height / 3.0;
	}


	/**
	 * Calculates the surface area of the pyramid.
	 * 
	 * @return the surface area of the pyramid
	 */
	public double getSurface() {
		double slant = Math.sqrt((Math.pow(height, 2)) + Math.pow(edgeLength/2.0, 2));
		return edgeLength * edgeLength + 2.0 * edgeLength * slant;
	}
}
