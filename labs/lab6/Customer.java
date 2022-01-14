package labs.lab6;

import java.math.BigDecimal;

/**
 * A customer that is represented by a name, amount spent, and type
 */
public class Customer {

	// ADD YOUR INSTANCE VARIABLES HERE
	private String name;
	private BigDecimal amountSpent;
	private CustomerType type;

	public static enum CustomerType {
		CORPORATE, PERSONAL
	};

	/**
	 * Constructs a bank account with a name, amount spent, and customer type
	 * 
	 * If amountSpent < 0, sets it to 0
	 */
	public Customer(String name, double amountSpent, CustomerType custType) {
		this.name = name;
		this.amountSpent = (BigDecimal.ZERO).max(BigDecimal.valueOf(amountSpent));
		this.type = custType;
	}


	/**
	 * Gets the name of the customer.
	 * 
	 * @return the name of the customer
	 */
	public String getName() {
		return name;
	}


	/**
	 * Gets the amount spent by the customer.
	 * 
	 * @return the amount spent by the customer
	 */
	public double getAmountSpent() {
		return amountSpent.doubleValue();
	}


	/**
	 * Sets amountSpent to the new amount
	 * 
	 * If amountSpent < 0, sets it to 0
	 * 
	 * @param amountSpent the new amount spent
	 */
	public void setAmountSpent(double amountSpent) {
		this.amountSpent = (BigDecimal.ZERO).max(BigDecimal.valueOf(amountSpent));
	}


	/**
	 * Gets the customer type of the customer.
	 * 
	 * @return the customer type of the customer
	 */
	public CustomerType getCustomerType() {
		return type;
	}


	/**
	 * Sets customer type to the new type
	 * 
	 * @param custType the new customer type
	 */
	public void setCustomerType(CustomerType custType) {
		this.type = custType;
	}


	/**
	 * Returns a string representation of this Customer, consisting of the name,
	 * amount spent, and customer type, each separated by a comma and one space
	 */
	@Override
	public String toString() {
		return String.format("%s, %s, %s", name, amountSpent.toString(), type.toString());
	}


	/**
	 * Returns true if the name, amount spent, and type are equal to this customer,
	 * false otherwise
	 */
	@Override
	public boolean equals(Object otherObj) {
		Customer other = (Customer) otherObj;
		return (this.name.equals(other.name)
				&& amountSpent.compareTo(other.amountSpent) == 0
				&& type.equals(other.type));
	}

}
