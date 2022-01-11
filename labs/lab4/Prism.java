package labs.lab4;

/**
 * A class that represents a rectangular and can calculate its volume and surface area.
 */
public class Prism {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double width, length, height;

	/**
	 * Creates a rectangular prism of given width, length, and height.
	 * 
	 * @param 	width	the width of the prism's base (assume > 0)
	 * @param 	length	the length of the prism's base (assume > 0)
	 * @param 	height	the height of the prism (assume > 0)
	 * @return 	the volume of the rectangular prism
	 */
	public Prism(double width, double length, double height) {
        this.width = width;
		this.length = length;
		this.height = height;
	}


	/**
	 * Calculates the volume of the prism.
	 * 
	 * @return the volume of the prism
	 */
	public double getVolume() {
		return width * length * height;
	}


	/**
	 * Calculates the surface area of the prism.
	 * 
	 * @return the surface area of the prism
	 */
	public double getSurface() {
		return 2.0 * width * length + (2.0 * (width + length)) * height;
	}

}
