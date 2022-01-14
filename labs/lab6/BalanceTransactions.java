package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * A utility class for validating the cash on hand amount at the end of the day with the 
 * amount recorded in a file
 */

public class BalanceTransactions {

	/**
	 * Given a starting balance (amount of cash at the beginning of the day) and an
	 * ending balance (amount of cash at the end of the day), checks whether the
	 * actual amount of cash at the end of the day equals the expected value (within
	 * an 1E-3 error margin)
	 * 
	 * @param startBalance amount of cash at the beginning of the day; assume always
	 *                     >= 0
	 * @param endBalance   amount of cash at the end of the day
	 * @param filename     name of file containing transactions
	 * 
	 * @return a string indicating whether the end of day total was balanced or not
	 *         (either "End of day total is properly balanced." or "End of day total
	 *         is not balanced."
	 */
	public static String balance(double startBalance, double endBalance, String filename) {
		BigDecimal balance = BigDecimal.valueOf(startBalance);
		try (Scanner in = new Scanner(new File(filename))) {
			while (in.hasNextLine()) {
				long invoiceNum = in.nextLong();
				BigDecimal amount = BigDecimal.valueOf(in.nextDouble());
				String mode = in.nextLine().trim();
				switch (mode) {
					case "R" -> balance = balance.add(amount);
					case "P" -> balance = balance.subtract(amount);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.printf("File: %s not found", filename);
		}
		if (balance.compareTo(BigDecimal.valueOf(endBalance)) == 0) {
			return "End of day total is properly balanced.";
		}
		return "End of day total is not balanced.";
	}
}
