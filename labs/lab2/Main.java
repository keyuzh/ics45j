package labs.lab2;

import java.util.Arrays;
import java.util.Scanner;

class Main {

	/**
	 * Reads a ten-digit number from the user and prints it as a more readable
	 * string with parentheses and dashes. Specifically:
	 * 
	 * 1. Take the first three characters and surround them with "(" and ")". This
	 * is the area code. 2. Concatenate the area code, a single space, the next
	 * three characters, a hyphen, and the last four characters. This is the
	 * formatted number.
	 * 
	 * When you print the formatted number, use print instead of println.
	 * 
	 * Assume all input will be valid ten-digit numbers.
	 * 
	 * To run this method using the keyboard for user input, call it like this:
	 * problem2_formatPhoneNumber(new Scanner(System.in));
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 */
	public static void problem2_formatPhoneNumber(Scanner in) {
		System.out.print("Please enter a ten-digit phone number: ");
        long unformatted = in.nextLong();
		long areaCode = unformatted / 1_000_0000;
		long middle = (unformatted / 1_0000) % 1_000;
		long last = unformatted % 1_0000;
		System.out.printf("(%03d) %03d-%04d", areaCode, middle, last);
	}


	/**
	 * 
	 * This method trims a number to its last 2 digits, reverses the remaining
	 * digits, adds the number formed by the discarded digits (0 if no digits were
	 * discarded) to the reversed digits, and returns all of these results in a
	 * string. If the input num is less than least 2 digits, it returns the string
	 * "Number too small!"
	 * 
	 * You can assume that all of the input numbers will be positive integers that
	 * consist only of the digits 1-9 (no zeroes).
	 * 
	 * @param num the number to be used for the add/reversal
	 * 
	 * @return the result of the reversal/addition, as a string
	 */
	public static String problem4_reverseAndAdd(int num) {
		if (num < 10) {
			return "Number too small!";
		}
		int discarded = num / 100;
		int last2 = num % 100;
		int reversed = (last2 / 10) + ((last2 % 10) * 10);
		int sum = discarded + reversed;
		return String.format("Input: %d, Last 2 digits: %d, Reversed: %d, Sum: %d",
				num, last2, reversed, sum);
	}


	/**
	 * Given 2 integer values greater than 0, return whichever value is nearest to
	 * 21 without going over. If they both go over, return 0.
	 * 
	 * @param a the first value
	 * @param b the second value
	 * 
	 * @return whichever value is nearest to 21 without going over; if they both go
	 *         over, return 0
	 */
	public static int problem6_playBlackjack(int a, int b) {
		if (a <= 21 && b <= 21) {
			return Math.max(a, b);
		}
		if (a <= 21) {
			return a;
		}
		if (b <= 21) {
			return b;
		}
		return 0;
	}


	/**
	 * Given three integers a, b, and c, one of them is small, one is medium, and
	 * one is large. Return true if the three values are evenly spaced, so the
	 * difference between small and medium is the same as the difference between
	 * medium and large.
	 *
	 * @param a first integer
	 * @param b second integer
	 * @param c third integer
	 *
	 * @return true if the three values are evenly space, false otherwise
	 */
	public static boolean problem7_evenlySpaced(int a, int b, int c) {
		int[] t = {a, b, c};
		Arrays.sort(t);
		return (t[2] - t[1] == t[1] - t[0]);
	}


	/**
	 * Reads a value and a unit (either dB or Pa) from the user, then prints a
	 * string indicating which sound level category the sound falls into.
	 * 
	 * When you print the formatted number, use print instead of println.
	 * 
	 * To run this method using the keyboard for user input, call it like this:
	 * problem9_getSoundLevel(new Scanner(System.in));
	 * 
	 * @param in the Scanner to be used for user input
	 */
	public static void problem9_getSoundLevel(Scanner in) {
        final double p0 = 2e-5;
        System.out.print("Enter sound level and unit (dB or Pa): ");
		double value = in.nextDouble();
		String unit = in.next();
		boolean validUnit = (unit.equals("dB") || unit.equals("Pa"));
		boolean negative = (value < 0);
		if (!validUnit && negative) { System.out.print("Invalid unit and sound level"); return;}
		if (!validUnit) { System.out.print("Invalid unit"); return;}
		if (negative) { System.out.print("Invalid sound level"); return;}
		if (unit.equals("Pa")) {
			value = 20.0 * Math.log10(value / p0);
		}
		if (value < 30.0) {
			System.out.print("Light leaf rustling");
		}
		else if (value < 60.0) {
			System.out.print("Calm library");
		}
		else if (value < 90.0) {
			System.out.print("Normal conversation");
		}
		else if (value < 100.0) {
			System.out.print("Traffic on a busy roadway at 10 m");
		}
		else if (value < 120.0) {
			System.out.print("Jack hammer at 1 m");
		}
		else if (value < 130.0) {
			System.out.print("Possible hearing damage");
		}
		else {
			System.out.print("Threshold of pain");
		}
	}
}
