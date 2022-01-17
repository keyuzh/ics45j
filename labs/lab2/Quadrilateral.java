package labs.lab2;

/**
 * Represents a quadrilateral, given coordinates of its four corners.
 * Determines the shape of the quadrilateral ("Square", "Rectangle",
 * "Parallelogram", "Trapezoid", "Rhombus" or "None")
 */
public class Quadrilateral {

	// ADD YOUR INSTANCE VARIABLES HERE
	double ax, ay;
	double bx, by;
	double cx, cy;
	double dx, dy;

	/**
	 * Constructs a new Quadrilateral given the coordinates of its four corners 
	 * in the order they appear in a clockwise direction
	 * 
	 * @param ax	x-coordinate of the first vertex (A)
	 * @param ay	y-coordinate of the first vertex (A)
	 * @param bx	x-coordinate of the second vertex (B)
	 * @param by	y-coordinate of the second vertex (B)
	 * @param cx	x-coordinate of the third vertex (C)
	 * @param cy	y-coordinate of the third vertex (C)
	 * @param dx	x-coordinate of the fourth vertex (D)
	 * @param dy	y-coordinate of the fourth vertex (D)
	 */
	public Quadrilateral(double ax, double ay, double bx, double by, double cx, double cy, double dx, double dy) {
        this.ax = ax;
		this.bx = bx;
		this.cx = cx;
		this.dx = dx;
		this.ay = ay;
		this.by = by;
		this.cy = cy;
		this.dy = dy;
	}

	private double getSideLength(char s) {
		return switch (s) {
			case 'a' -> Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
			case 'b' -> Math.sqrt(Math.pow(cx - bx, 2) + Math.pow(cy - by, 2));
			case 'c' -> Math.sqrt(Math.pow(cx - dx, 2) + Math.pow(cy - dy, 2));
			case 'd' -> Math.sqrt(Math.pow(ax - dx, 2) + Math.pow(ay - dy, 2));
			default -> 0;
		};
	}

	private double[] getPoints(char s) {
		return switch (s) {
			case 'a', 'e' -> new double[]{ax, ay};
			case 'b' -> new double[]{bx, by};
			case 'c' -> new double[]{cx, cy};
			case 'd' -> new double[]{dx, dy};
			default -> new double[]{0, 0};
		};
	}

	private static boolean eq(double a, double b) {
		return (Math.abs(a-b) <= 0.001);
	}

	private boolean isOrthogonal(char side1, char side2) {
		int x = 0;
		int y = 1;
		double[] pointA, pointB, pointC, pointD;
		pointA = getPoints(side1);
		pointB = getPoints((char) (side1+1));
		pointC = getPoints(side2);
		pointD = getPoints((char) (side2+1));

		if (eq(pointB[x] - pointA[x], 0) && eq(pointD[x] - pointC[x], 0)) {
			// both vertical
			return false;
		}
		// one vertical
		if (eq(pointB[x] - pointA[x], 0)) {
			return eq((pointD[y] - pointC[y]) / (pointD[x] - pointC[x]), 0);
		}
        if (eq(pointD[x] - pointC[x], 0)) {
			return eq((pointB[y] - pointA[y]) / (pointB[x] - pointA[x]), 0);
		}
		double slope1 = (pointB[y] - pointA[y]) / (pointB[x] - pointA[x]);
		double slope2 = (pointD[y] - pointC[y]) / (pointD[x] - pointC[x]);
		double prod = slope1 * slope2;
		return eq(prod, -1.0);
	}

	private boolean isParallel(char side1, char side2) {
		int x = 0;
		int y = 1;
		double[] pointA, pointB, pointC, pointD;
		pointA = getPoints(side1);
		pointB = getPoints((char) (side1+1));
		pointC = getPoints(side2);
		pointD = getPoints((char) (side2+1));
		if (eq(pointB[x] - pointA[x], 0) && eq(pointD[x] - pointC[x], 0)) {
			return true;
		}
		double slope1 = (pointB[y] - pointA[y]) / (pointB[x] - pointA[x]);
		double slope2 = (pointD[y] - pointC[y]) / (pointD[x] - pointC[x]);
        return eq(slope1, slope2);
	}

	private boolean isSquare() {
		return (
            (eq(getSideLength('a'), getSideLength('b')) && eq(getSideLength('b'), getSideLength('c'))
                && eq(getSideLength('c'), getSideLength('d')) && eq(getSideLength('a'), getSideLength('d')) )
            && (isParallel('a', 'c') && isParallel('b', 'd'))
            && (isOrthogonal('a', 'b') && isOrthogonal('b', 'c'))
		);
	}

	private boolean isRhombus() {
		return (
            (eq(getSideLength('a'), getSideLength('b')) && eq(getSideLength('b'), getSideLength('c'))
                && eq(getSideLength('c'), getSideLength('d')) && eq(getSideLength('a'), getSideLength('d')) )
                && (isParallel('a', 'c') && isParallel('b', 'd'))
		);
	}

	private boolean isRectangle() {
		return (
            (isParallel('a', 'c') && isParallel('b', 'd'))
            && (isOrthogonal('a', 'b') && isOrthogonal('b', 'c'))
        );
	}

	private boolean isParallelogram() {
		return ( (isParallel('a', 'c') && isParallel('b', 'd')) );
	}

	private boolean isTrapezoid() {
		return ( (isParallel('a', 'c') || isParallel('b', 'd')) );
	}

	/**
	 * Gets the type of shape this quadrilateral is ("Square", "Rhombus, "Rectangle", 
	 * "Parallelogram", "Trapezoid", or "None"). When a shape falls in multiple
	 * categories, use the order of precedence just listed.
	 * 
	 * @return	"Square", "Rhombus, "Rectangle", "Parallelogram", "Trapezoid", or "None"
	 */
	public String getShapeType() {
		if (isSquare()) { return "Square"; }
		if (isRhombus()) { return "Rhombus"; }
		if (isRectangle()) { return "Rectangle"; }
		if (isParallelogram()) { return "Parallelogram"; }
		if (isTrapezoid()) { return "Trapezoid"; }
		return "None";
	}
}
