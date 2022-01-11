package labs.lab3;

import java.time.LocalDate;

/**
 * Represents a credit card
 *
 */
public class CreditCard {

	// ADD YOUR INSTANCE VARIABLES HERE
	long num;
	LocalDate exp;

	
	/**
	 * Constructs a credit card object with the given number and expiration
	 * date
	 * 
	 * Assume the number passed in will always have 16 digits and will not
	 * start with 0. 
	 * 
	 * Assume the date passed in will always be a valid date.
	 * 
	 * @param number	the credit card number
	 * @param expDate	the credit card expiration date
	 */
	public CreditCard(long number, LocalDate expDate) {
        num = number;
		exp = expDate;
	}


	/**
	 * Returns the credit card number
	 * 
	 * @return	the credit card number
	 */
	public long getNumber() {
        return num;
	}


	/**
	 * Returns the credit card expiration date
	 * 
	 * @return	the credit card expiration date
	 */
	public LocalDate getExpirationDate() {
		return exp;
	}
	
	
	/**
	 * Returns a string containing the card number, with a space inserted
	 * between every 4 digits
	 * 
	 * @return	the card number, with a space inserted between every 4 digits
	 */
	public String getNumberWithSpaces() {
        StringBuilder res = new StringBuilder(String.valueOf(num));
		res.insert(4, " ");
		res.insert(9, " ");
		res.insert(14, " ");
		return res.toString();
	}

	private int getNumberAt(int index) {
        return Integer.parseInt(String.valueOf(num).substring(index, index+1));
	}

	private boolean isValidExpDate() {
		LocalDate today = LocalDate.now();
		return !today.isAfter(exp);
	}

	private boolean isValidNumber() {
		int sum = 0;
		int large = 0;
		// sum of all digits
		for (int i = 0; i < 16; i++) {
			sum += getNumberAt(i);
		}
		// sum in odd numbered indexes
		for (int i = 1; i < 16; i++) {
			int n = getNumberAt(i);
			if (n > 5) { large++; } // TODO: 1/10/22 CHECK PROBLEM DESCRIPTION 
			sum += n;
		}
		sum += large;
//		return false; // TODO: 1/10/22 DELETE
		return (sum % 3 == 0);
	}


	/**
	 * Returns true if both the card number and expiration date are valid,
	 * false otherwise
	 * 
	 * @return	whether card is valid
	 */
	public boolean isValid() {
		return isValidExpDate() && isValidNumber();
	}
}