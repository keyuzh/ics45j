package labs.lab6;

import java.math.BigDecimal;

/**
 * A product in a vending machine.
 */
public class Product {

	// ADD YOUR INSTANCE VARIABLES EHRE
	private String description;
	private BigDecimal price;

	/**
	 * Constructs a Product object
	 * 
	 * @param aDescription the description of the product
	 * @param aPrice       the price of the product
	 */
	public Product(String aDescription, double aPrice) {
		description = aDescription;
		price = BigDecimal.valueOf(aPrice);
	}


	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price.doubleValue();
	}


	/**
	 * Determines of this product is the same as the other product.
	 * 
	 * @param other the other product
	 * @return true if the products have the same description and price, false otherwise
	 */
	@Override
	public boolean equals(Object other) {
		Product o = (Product) other;
		return (description.equals(o.getDescription()) && (price.compareTo(o.price) == 0));
	}


	/**
	 * Returns a string representation of the product consisting of the description,
	 * " @ $", and the prices, formatted with two decimal places after the decimal
	 * point
	 */
	@Override
	public String toString() {
		return String.format("%s @ $%.2f", description, price);
	}

}
