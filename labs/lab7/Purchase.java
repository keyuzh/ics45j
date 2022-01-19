package labs.lab7;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 * Represents a purchase
 *
 */
public class Purchase implements Comparable<Purchase> {

	// ADD YOUR INSTANCE VARIABLES HERE
	LocalDate date;
	String description;
	BigDecimal amount;

	/**
	 * Constructs a new Purchase
	 * 
	 * @param date        the date of the purchase
	 * @param description a description of the purchase
	 * @param amount      the amount of the purchase (if < 0, sets it to 0)
	 */
	public Purchase(LocalDate date, String description, double amount) {
		this.date = date;
		this.description = description;
		this.amount = BigDecimal.valueOf(amount);
	}


	public LocalDate getDate() {
		return date;
	}


	public String getDescription() {
		return description;
	}


	public double getAmount() {
		return amount.doubleValue();
	}


	/**
	 * Returns a string representing this purchase, consisting of the date,
	 * description, and amount, each separated by a single space
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.0#");
		return String.format("%s %s %s", date.toString(), description, df.format(amount));
	}


	/**
	 * Returns true if the date, description, and amount all match
	 */
	@Override
	public boolean equals(Object o) {
		Purchase other = (Purchase) o;
		return (date.equals(other.date) && description.equals(other.description) && (amount.compareTo(other.amount) == 0));
	}


	/**
	 * Compares first by date (earlier dates first), then by amount (higher amounts
	 * first), then by description (lexicographically)
	 */
	public int compareTo(Purchase other) {
		int datecmp = date.compareTo(other.date);
		if (datecmp != 0) {
			return datecmp;
		}
		int amountcmp = amount.compareTo(other.amount);
		if (amountcmp != 0) {
			return -amountcmp;
		}
		return description.compareTo(other.description);
	}

}