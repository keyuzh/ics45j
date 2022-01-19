package labs.lab7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for managing the production queue for Robert's business
 */
public class ProductionLine {

	private Queue<Integer> standard;
	private Queue<Integer> rush;

	/**
	 * Constructs a new production line with empty queues
	 */
	public ProductionLine() {
		standard = new LinkedList<>();
		rush = new LinkedList<>();
	}


	/**
	 * Adds an order to the standard queue
	 * 
	 * @param customerID the customer ID
	 */
	public void addStandardOrder(Integer customerID) {
		standard.add(customerID);
	}


	/**
	 * Adds an order to the rush queue
	 * 
	 * @param customerID the customer ID
	 */
	public void addRushOrder(Integer customerID) {
		rush.add(customerID);
	}


	/**
	 * Handles the next order to be produced
	 * 
	 * @return a string that describes the order that was handled, in the format
	 *         "Producing [rush/standard] order for customer [customerID]"
	 */
	public String handleNextOrder() {
		if (!rush.isEmpty()){
			return String.format("Producing rush order for customer %d", rush.poll());
		}
		if (!standard.isEmpty()) {
			return String.format("Producing standard order for customer %d", standard.poll());
		}
		return "";
	}

}
