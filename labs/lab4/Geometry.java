package labs.lab4;

/**
 * A class that can calculate surface area and volume of cubes, rectangular
 * prisms,and square pyramids. 
 */
public class Geometry {

	/**
	 * Calculates the volume of a cube.
	 * 
	 * @param 	sideLength	the length of one side of the cube (assume > 0)
	 * @return 	the volume of the cube
	 */
	public static double cubeVolume(double sideLength) {
        return sideLength * sideLength * sideLength;
	}


	/**
	 * Calculates the surface area of a cube.
	 * 
	 * @param 	sideLength	the length of one side of the cube (assume > 0)
	 * @return 	the surface area of the cube
	 */
	public static double cubeSurface(double sideLength) {
        return 6.0 * sideLength * sideLength;
	}


	/**
	 * Calculates the volume of a rectangular prism.
	 * 
	 * @param 	width		the width of the prism's base (assume > 0)
	 * @param 	length	the length of the prism's base (assume > 0)
	 * @param 	height	the height of the prism (assume > 0)
	 * @return 	the volume of the rectangular prism
	 */
	public static double prismVolume(double width, double length, double height) {
		return width * length * height;
	}
	
	
	/**
	 * Calculates the surface area of a rectangular prism.
	 * 
	 * @param 	width		the width of the prism's base (assume > 0)
	 * @param 	length	the length of the prism's base (assume > 0)
	 * @param 	height	the height of the prism (assume > 0)
	 * @return 	the surface area of the rectangular prism
	 */
	public static double prismSurface(double width, double length, double height) {
        return 2.0 * width * length + (2.0 * (width + length)) * height;
	}
	
	
	/**
	 * Calculates the volume of a right square pyramid.
	 * 
	 * @param 	edgeLength		the length of one of the pyramid's base edges (assume > 0)
	 * @param 	height			the height of the pyramid (assume > 0)
	 * @return 	the volume of the pyramid
	 */
	public static double pyramidVolume(double edgeLength, double height) {
        return edgeLength * edgeLength * height / 3.0;
	}
	
	
	/**
	 * Calculates the surface area of a right square pyramid.
	 * 
	 * @param 	edgeLength		the length of one of the pyramid's base edges (assume > 0)
	 * @param 	height			the height of the pyramid (assume > 0)
	 * @return 	the surface area of the pyramid
	 */
	public static double pyramidSurface(double edgeLength, double height) {
		double slant = Math.sqrt((Math.pow(height, 2)) + Math.pow(edgeLength/2.0, 2));
        return edgeLength * edgeLength + 2.0 * edgeLength * slant;
	}
}
