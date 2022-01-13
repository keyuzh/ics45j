package labs.lab6;

/**
 * A coin with a monetary value.
 */
public class Coin {

	// ADD YOUR INSTANCE VARIABLES HERE

	public static final Coin NICKEL = new Coin(.05, "nickel");
	public static final Coin DIME = new Coin(.10, "dime");
	public static final Coin QUARTER = new Coin(.25, "quarter");
	public static final Coin DOLLAR = new Coin(1.0, "dollar");

	/**
	 * Constructs a coin.
	 * 
	 * @param aValue the monetary value of the coin.
	 * @param aName  the name of the coin
	 */
	public Coin(double aValue, String aName) {
		// FILL IN
	}


	/**
	 * Gets the coin value.
	 * 
	 * @return the value
	 */
	public double getValue() {
		return -1.0; // FIX ME
	}


	/**
	 * Gets the coin name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return ""; // FIX ME
	}


	/**
	 * Returns a string representation of the coin consisting of the name, " @ $", 
	 * and the value, formatted with 2 decimal places after the decimal point
	 */
	@Override
	public String toString() {
		return ""; // FIX ME
	}

}
