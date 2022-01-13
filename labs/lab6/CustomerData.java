package labs.lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains data and does some analysis about all customers in a store
 */
public class CustomerData {

	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Constructs a new CustomerData object from the data in the file
	 * 
	 * If a file contains more than one customer with the same name, the data from
	 * the last one read overwrites the previously read data.
	 */
	public CustomerData(String fileName) {
		// FILL IN
	}


	/**
	 * Gets the customer(s) with the highest amount spent.
	 * 
	 * @return a list containing the customer(s) with the highest amount spent. If
	 *         there is only 1 customer with the highest amount, the list contains
	 *         only that one customer. If there are > 1 customer with the highest
	 *         amount, the list contains them all, in an undetermined order.
	 */
	public List<Customer> getBestCustomer() {
		return new ArrayList<Customer>(); // FIX ME
	}


	/**
	 * Gets the customer(s) of the given customer type with the highest amount
	 * spent.
	 * 
	 * @return a list containing the customer(s) of the given type with the highest
	 *         amount spent. If there is only 1 customer with the highest amount,
	 *         the list contains only that one customer. If there are > 1 customer
	 *         with the highest amount, the list contains them all, in an
	 *         undetermined order.
	 */
	public List<Customer> getBestCustomer(Customer.CustomerType custType) {
		return new ArrayList<Customer>(); // FIX ME
	}

}
