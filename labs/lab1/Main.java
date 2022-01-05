package labs.lab1;

import java.math.BigDecimal;
import java.util.Random;

public class Main {

	/**
	 * Given a string, if a length 2 substring appears at both its beginning and end
	 * (case-sensitive comparison), return a string without the substring at the
	 * beginning, so "HelloHe" yields "lloHe". The substring may overlap with
	 * itself, so "Hi" yields "." Otherwise, return the original string unchanged.
	 * The string can be any length, including 0.
	 * 
	 * @param str	the input string
	 * @return		if a length 2 substring appears at both its beginning and end,
	 * 				a string without the substring at the beginning
	 */
	public static String problem1_remove2(String str) {
		if (str.length() < 2) {
			return str;
		}
		if (str.endsWith(str.substring(0, 2))) {
			return str.substring(2);
        }
		return str;
	}


	/**
	 * Given two strings, concatenate them together and return the result. However,
	 * if the strings are different lengths, omit chars from the longer string,
	 * starting at the left, so it is the same length as the shorter string. So
	 * "Hello" and "Hi" yield "loHi". The strings may be any length, including 0.
	 * 
	 * @param a	the first string
	 * @param b	the second string
	 * @return	the result of concatenating the strings after trimming the longer one
	 */
	public static String problem2_shortConcat(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		int minLen = Math.min(aLen, bLen);
		return a.substring(aLen-minLen) + b.substring(bLen-minLen);
	}

	
	/**
	 * A slot machine has 4 reels and a number of possible pictures for each 
	 * reel. Most modern slot machines operate based on a random number 
	 * generator that determines which picture to show for each reel. Write a method 
	 * that generates random numbers for 4-reel slot machines. This method takes as 
	 * input numPics, and returns 4 numbers (indicating which picture to show in each
	 * reel) as a string, with each number separated by a space.
	 * 
	 * Construct an object of the Random class (see the Java API docs) and invoke an 
	 * appropriate method to generate each number. 
	 * 
	 * As an example, imagine you have a machine that has 3 possible pictures: 
	 * cherries (picture #1), bananas (picture #2), or money (picture #3).
	 * In this case, the result should contain 4 numbers between 1 and 3. For instance,
	 * "3 2 1 1", which would translate to:
	 * 
	 * Reel 1: money
	 * Reel 2: bananas
	 * Reel 3: cherries
	 * Reel 4: cherries
	 * 
	 * But all you have to return is a string with the numbers in it. The example
	 * with actual pictures of things is just for context.
	 * 
	 * Assume numPics will always be > 0.
	 * 
	 * @param numPics	the number of possible pictures per reel
	 * @return			a string that indicates which picture to show in each reel (4 numbers 
	 * 					separated by a single space
	 */
	public static String problem3_slotMachine(int numPics) {
		Random rng = new Random();
		String[] result = new String[4];
		for (int i = 0; i < 4; i++) {
			result[i] = String.valueOf(rng.nextInt(numPics)+1);
		}
		return String.join(" ", result);
	}
	
	
	/**
	 * Given a string and an integer index, return a new string with the following transformations
	 * applied:
	 * 
	 * 1. Delete the character at the index (assume it will be within bounds)
	 * 2. Reverse the resulting string
	 * 
	 * Hint: See the StringBuilder class in the Java API docs. 
	 * 
	 * @param str		the string to be transformed
	 * @param index		the index at which to delete a character
	 * @return			the string with transformations applied
	 */
	public static String problem4_deleteAndReverse(String str, int index) {
//        StringBuilder result = new StringBuilder(str);
//		result.deleteCharAt(index);
//		result.reverse();
//		return result.toString();
		return new StringBuilder(str).deleteCharAt(index).reverse().toString();
	}
	
	
	/**
	 * The BigDecimal class represents decimal numbers with an arbitrary number of digits (the
	 * double and float types cannot express very high precision). Given a BigDecimal object
	 * and an integer, calculate a BigDecimal that is equal to the original BigDecimal raised to 
	 * the power of the given integer. Then negate that number and return the result.
	 * 
	 * See the BigDecimal class in the Java API docs.
	 * 
	 * @param big	the original BigDecimal
	 * @param power	the power to which to raise big
	 * @return		big raises to the power of power, then negated
	 */
	public static BigDecimal problem5_bigPowerNegate(BigDecimal big, int power) {
		return big.pow(power).negate();
	}
}
