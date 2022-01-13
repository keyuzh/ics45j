package labs.lab6;

/**
 * A product in a vending machine.
 */
public class Product {

	// ADD YOUR INSTANCE VARIABLES EHRE

	/**
	 * Constructs a Product object
	 * 
	 * @param aDescription the description of the product
	 * @param aPrice       the price of the product
	 */
	public Product(String aDescription, double aPrice) {
		// FILL IN
	}


	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return ""; // FIX ME
	}


	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return -1.0; // FIX ME
	}


	/**
	 * Determines of this product is the same as the other product.
	 * 
	 * @param other the other product
	 * @return true if the products have the same description and price, false otherwise
	 */
	@Override
	public boolean equals(Object other) {
		return false; // FIX ME
	}


	/**
	 * Returns a string representation of the product consisting of the description,
	 * " @ $", and the prices, formatted with two decimal places after the decimal
	 * point
	 */
	@Override
	public String toString() {
		return ""; // FIX ME
	}

}
