package labs.lab3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

	/**
	 * We'll say that a "quadruplet" in a string is a char appearing four times in a
	 * row. Return the number of quadruplets in the given string. The quadruplets
	 * may overlap.
	 * 
	 * @param str the string to check for quadruplets
	 * @return the number of quadruplets in the string
	 */
	public static int problem1_countQuadruplets(String str) {
		int res = 0;
		for (int i = 0; i <= str.length() - 4; i++) {
			char c = str.charAt(i);
			if (c == str.charAt(i+1) && c == str.charAt(i+2) && c == str.charAt(i+3)) {
				res++;
			}
		}
		return res;
	}


	/**
	 * Given a string, return the sum of the digits 0-9 that appear in the string,
	 * ignoring all other characters. Return 0 if there are no digits in the string.
	 * (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1',
	 * .. '9'. Integer.parseInt(String) converts a string to an int.)
	 * 
	 * @param str the string from which to sum the digits
	 * @return the sum of the digits 0-9 that appear in the string
	 */
	public static int problem2_sum(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				sum += Integer.parseInt(String.valueOf(c));
			}
		}
		return sum;
	}


	/**
	 * Takes a string as a parameter and returns a string where every appearance of
	 * the lowercase word "are" has been replaced with "are not". The word "are"
	 * should not be immediately preceded or followed by a letter -- so for example
	 * the "are" in "care" or "scared" does not count. (Note:
	 * Character.isLetter(char) tests if a char is a letter.)
	 * 
	 * @param str the string to replaces "are"s in
	 * @return the string with all "are"s replaced with "are not"s.
	 */
	public static String problem3_replace(String str) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (i < str.length()-2 && str.startsWith("are", i)
					&& (i - 1 <  0            || !Character.isLetter(str.charAt(i-1)))
					&& (i + 3 >= str.length() || !Character.isLetter(str.charAt(i+3))) ) {
				res.append("are not");
				i += 2;
			}
			else {
				res.append(str.charAt(i));
			}
		}
		return res.toString();
	}


	/**
	 * Takes in a string and returns a string containing all substrings, sorted by
	 * length (ascending), with a comma and a space separating each one
	 * 
	 * @param str the string from which to make substrings
	 * @return string containing all substrings
	 */
	public static String problem4_getAllSubstrings(String str) {
		if (str.isEmpty()) { return ""; }
		StringBuilder res = new StringBuilder();
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 0; j < str.length()-i+1; j++) {
				res.append(str, j, j+i);
				res.append(", ");
			}
		}
		res.delete(res.length()-2, res.length());
		return res.toString();
	}


	/**
	 * Given a non-empty array, return true if there is a place to split the array
	 * so that the sum of the numbers on one side is equal to the sum of the numbers
	 * on the other side.
	 * 
	 * @param nums the array to split
	 * @return true if there is a place to split the array so that the sum of the
	 *         numbers on one side is equal to the sum of the numbers on the other
	 *         side
	 */
	public static boolean problem6_sumSplitBalance(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int[] left = Arrays.copyOfRange(nums, 0, i);
			int[] right = Arrays.copyOfRange(nums, i, nums.length);
			if (IntStream.of(left).sum() == IntStream.of(right).sum()) { return true; }
		}
		return false; // FIX ME
	}


	
	/**
	 * Consider the leftmost and rightmost appearances of some value in an array.
	 * We'll say that the "interval" is the number of elements between the two, inclusive.
	 * A single value has an interval of 1. Return the largest interval found in the
	 * given array.
	 * 
	 * @param nums	the array in which to find the interval
	 * @return		the largest interval in the array
	 */
	public static int problem7_maxInterval(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length-1; j >= i; j--) {
				if (nums[i] == nums[j]) {
					res = Math.max(j-i+1, res);
				}
			}
		}
		return res;
	}
}