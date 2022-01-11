package labs.lab3;

import java.util.ArrayList;

public class DailySalesTally {

	// ADD YOUR INSTANCE VARIABLES HERE
    ArrayList<Purchase> purchases;

	public DailySalesTally() {
		purchases = new ArrayList<>();
	}


	/**
	 * Adds a purchase to the tally
	 * 
	 * @param p	the purchase
	 */
	public void addPurchase(Purchase p) {
        purchases.add(p);
	}
	
	
	/**
	 * Calculates the total for the day for the client with the given name
	 * 
	 * @param clientName	name of the client for whom to calculate the total
	 * @return				total for the given client
	 */
	public double getTotalForClient(String clientName) {
		double total = 0.0;
		boolean firstPurchase = true;
		for (Purchase p : purchases) {
			if (p.getClientName().equals(clientName)) {
				double price = p.getPrice();
				if (!firstPurchase) { price *= 0.9; }
				else { firstPurchase = false; }
				if (p.isBoutiquePurchase()) { price *= 0.95; }
				total += price;
			}
		}
		return total;
	}


	/**
	 * Calculates the grand total for the day for all purchases
	 * 
	 * @return	the grand total for the day for all purchases
	 */
	public double getGrandTotal() {
		double total = 0.0;
        ArrayList<String> clients = new ArrayList<>();
		for (Purchase p : purchases) {
			double price = p.getPrice();
			String clientName = p.getClientName();
			if (clients.contains(clientName)) { price *= 0.9; }
			else { clients.add(clientName); }
            if (p.isBoutiquePurchase()) { price *= 0.95; }
            total += price;
		}
		return total;
	}
}