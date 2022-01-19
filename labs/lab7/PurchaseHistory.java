package labs.lab7;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a record of purchases
 *
 */
public class PurchaseHistory {

	// ADD YOUR INSTANCE VARIABLES EHRE
	List<Purchase> purchases;

	public PurchaseHistory() {
		purchases = new ArrayList<>();
	}


	/**
	 * Adds a purchase to the history
	 * 
	 * @param date        date of purchase
	 * @param description description of purchase
	 * @param amount      amount of purchase
	 */
	public void addPurchase(LocalDate date, String description, double amount) {
		purchases.add(new Purchase(date, description, amount));
	}


	/**
	 * Removes all purchases matching the given parameters from the history
	 * 
	 * @param date        date of purchase
	 * @param description description of purchase
	 * @param amount      amount of purchase
	 * 
	 * @return the number of purchases matching the parameters and therefore removed
	 */
	public int removePurchase(LocalDate date, String description, double amount) {
		int before = purchases.size();
		purchases.removeIf((p) -> p.equals(new Purchase(date, description, amount)));
		return before - purchases.size();
	}


	/**
	 * Gets a list of all purchases that fall within a date range
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return a list of purchases in the date range, in sorted order
	 */
	public List<Purchase> getPurchasesInDateRange(LocalDate start, LocalDate end) {
		List<Purchase> res = new ArrayList<>();
		for (Purchase p : purchases) {
			if (!p.getDate().isBefore(start) && !p.getDate().isAfter(end)) {
				res.add(p);
			}
		}
		res.sort(Purchase::compareTo);
		return res;
	}


	/**
	 * Gets the total of all purchases that fall within a date range
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return the total of purchases in the date range
	 */
	public double getPurchaseTotalInDateRange(LocalDate start, LocalDate end) {
		double total = 0.0;
		for (Purchase p : purchases) {
			if (!p.getDate().isBefore(start) && !p.getDate().isAfter(end)) {
				total += p.getAmount();
			}
		}
		return total;
	}


	/**
	 * Gets a list of all purchases that match a description
	 * 
	 * @param description the description to match
	 * 
	 * @return a list of purchases matching the description, in sorted order
	 */
	public List<Purchase> getPurchasesMatchingDescription(String description) {
		List<Purchase> res = new ArrayList<>();
		for (Purchase p : purchases) {
			if (p.getDescription().equals(description)) {
				res.add(p);
			}
		}
		res.sort(Purchase::compareTo);
		return res;
	}


	/**
	 * Gets the total of all purchases that match a description
	 * 
	 * @param description the description to match
	 * 
	 * @return the total of purchases that match the description
	 */
	public double getPurchaseTotalMatchingDescription(String description) {
		double total = 0.0;
		for (Purchase p : purchases) {
			if (p.getDescription().equals(description)) {
				total += p.getAmount();
			}
		}
		return total;
	}


	/**
	 * Gets a list of all purchases that fall within an amount range
	 * 
	 * @param min lower bound of the amount range (inclusive)
	 * @param max upper bound of the amount range (inclusive)
	 * 
	 * @return a list of purchases in the amount range, in sorted order
	 */
	public List<Purchase> getPurchasesInAmountRange(double min, double max) {
		List<Purchase> res = new ArrayList<>();
		for (Purchase p : purchases) {
			if (p.amount.compareTo(BigDecimal.valueOf(min)) >= 0 && p.amount.compareTo(BigDecimal.valueOf(max)) <= 0) {
				res.add(p);
			}
		}
		res.sort(Purchase::compareTo);
		return res;
	}


	/**
	 * Gets the total of all purchases that fall within an amount range
	 * 
	 * @param min lower bound of the amount range (inclusive)
	 * @param max upper bound of the amount range (inclusive)
	 * 
	 * @return the total of purchases in the amount range
	 */
	public double getPurchaseTotalInAmountRange(double min, double max) {
		double total = 0.0;
		for (Purchase p : purchases) {
			if (p.amount.compareTo(BigDecimal.valueOf(min)) >= 0 && p.amount.compareTo(BigDecimal.valueOf(max)) <= 0) {
				total += p.getAmount();
			}
		}
		return total;
	}


	/**
	 * Gets the most expensive purchase(s) made within a date range.
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return a sorted list of the most expensive purchase(s) made within the date
	 *         range
	 */
	public List<Purchase> getMaxPurchaseInDateRange(LocalDate start, LocalDate end) {
		List<Purchase> inrange = getPurchasesInDateRange(start, end);
		BigDecimal m = new BigDecimal(0);
		for (Purchase p : inrange) {
			m = m.max(p.amount);
		}
		BigDecimal finalM = m;
		inrange.removeIf((x) -> x.amount.compareTo(finalM) < 0);
		return inrange;
	}


	/**
	 * Gets the least expensive purchase(s) made within a date range.
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return a sorted list of the least expensive purchase(s) made within the date
	 *         range
	 */
	public List<Purchase> getMinPurchaseInDateRange(LocalDate start, LocalDate end) {
		List<Purchase> inrange = getPurchasesInDateRange(start, end);
		BigDecimal m = null;
		for (Purchase p : inrange) {
			if (m == null || m.compareTo(p.amount) > 0) {
				m = p.amount;
			}
		}
		BigDecimal finalM = m;
		inrange.removeIf((x) -> x.amount.compareTo(finalM) > 0);
		return inrange;
	}


	/**
	 * Returns a string representing all the purchases in the history, sorted, with
	 * a comma and space between each one
	 */
	@Override
	public String toString() {
		purchases.sort(Purchase::compareTo);
		StringBuilder sb = new StringBuilder();
		for (Purchase p : purchases) {
			sb.append(p.toString()).append(", ");
		}
		return sb.substring(0, sb.length()-2);
	}

}
