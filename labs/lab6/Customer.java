package labs.lab6;

/**
 * A customer that is represented by a name, amount spent, and type
 */
public class Customer {

	// ADD YOUR INSTANCE VARIABLES HERE

	public static enum CustomerType {
		CORPORATE, PERSONAL
	};

	/**
	 * Constructs a bank account with a name, amount spent, and customer type
	 * 
	 * If amountSpent < 0, sets it to 0
	 */
	public Customer(String name, double amountSpent, CustomerType custType) {
		// FIL IN
	}


	/**
	 * Gets the name of the customer.
	 * 
	 * @return the name of the customer
	 */
	public String getName() {
		return ""; // FIX ME
	}


	/**
	 * Gets the amount spent by the customer.
	 * 
	 * @return the amount spent by the customer
	 */
	public double getAmountSpent() {
		return -1.0; // FIX ME
	}


	/**
	 * Sets amountSpent to the new amount
	 * 
	 * If amountSpent < 0, sets it to 0
	 * 
	 * @param amountSpent the new amount spent
	 */
	public void setAmountSpent(double amountSpent) {
		// FILL IN
	}


	/**
	 * Gets the customer type of the customer.
	 * 
	 * @return the customer type of the customer
	 */
	public CustomerType getCustomerType() {
		return CustomerType.CORPORATE; // FIX ME
	}


	/**
	 * Sets customer type to the new type
	 * 
	 * @param custType the new customer type
	 */
	public void setCustomerType(CustomerType custType) {
		// FILL IN
	}


	/**
	 * Returns a string representation of this Customer, consisting of the name,
	 * amount spent, and customer type, each separated by a comma and one space
	 */
	@Override
	public String toString() {
		return ""; // FIX ME
	}


	/**
	 * Returns true if the name, amount spent, and type are equal to this customer,
	 * false otherwise
	 */
	@Override
	public boolean equals(Object otherObj) {
		return false; // FIX ME
	}

}
