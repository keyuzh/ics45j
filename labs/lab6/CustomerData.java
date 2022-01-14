package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Contains data and does some analysis about all customers in a store
 */
public class CustomerData {

	// ADD YOUR INSTANCE VARIABLES HERE
	private ArrayList<Customer> customers;

	/**
	 * Constructs a new CustomerData object from the data in the file
	 * 
	 * If a file contains more than one customer with the same name, the data from
	 * the last one read overwrites the previously read data.
	 */
	public CustomerData(String fileName) {
		customers = new ArrayList<>();
		try (Scanner in = new Scanner(new File(fileName))) {
			while (in.hasNextLine()) {
				String[] sep = in.nextLine().trim().split("\\s+");
				Customer nextCustomer = new Customer(
						sep[0], Double.parseDouble(sep[1]), Customer.CustomerType.valueOf(sep[2]));
				customers.removeIf((c) -> (c.getName().equals(nextCustomer.getName())));
				customers.add(nextCustomer);
			}
		} catch (FileNotFoundException e) {
			System.out.printf("File: %s not found", fileName);
		}
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
		BigDecimal highest = BigDecimal.valueOf(0);
		for (Customer c : customers) {
			highest = highest.max(BigDecimal.valueOf(c.getAmountSpent()));
		}
		List<Customer> best = new ArrayList<>();
		for (Customer c : customers) {
			if (highest.compareTo(BigDecimal.valueOf(c.getAmountSpent()))==0) {
				best.add(c);
			}
		}
		return best;
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
		BigDecimal highest = BigDecimal.valueOf(0);
		for (Customer c : customers) {
			if (c.getCustomerType().equals(custType)) {
				highest = highest.max(BigDecimal.valueOf(c.getAmountSpent()));
			}
		}
		List<Customer> best = new ArrayList<>();
		for (Customer c : customers) {
			if ((c.getCustomerType().equals(custType))
					&& (highest.compareTo(BigDecimal.valueOf(c.getAmountSpent()))==0)) {
				best.add(c);
			}
		}
		return best;
	}

}
