package labs.lab7;

public class Main {

	/**
	 * Given a string, compute recursively a new string where all the lowercase 'x'
	 * chars have been moved to the end of the string.
	 *
	 * @param str the string in which to move the x's
	 * 
	 * @return the string with all the x's moved to the end
	 */
	public static String problem1_moveXToEnd(String str) {
		int x = str.indexOf('x');
		if (x == -1) {
			return str;
		}
		return problem1_moveXToEnd(str.substring(0, x) + str.substring(x+1)) + 'x';
	}


	/**
	 * Given a string and a non-empty substring sub, compute recursively the number
	 * of times that sub appears in the string, without the sub-strings overlapping.
	 * 
	 * @param str the string in which to count occurrences of sub
	 * @param sub the substring to count
	 * 
	 * @return the number of times that sub appears in the string, without the sub
	 *         strings overlapping
	 */
	public static int problem2_countSubs(String str, String sub) {
		int i = str.indexOf(sub);
		if (i == -1) {
			return 0;
		}
		return 1 + problem2_countSubs(str.substring(i+sub.length()), sub);
	}


	/**
	 * Given a string, compute recursively the number of times lowercase "hi"
	 * appears in the string, however do not count "hi"s that have an 'x' immedately
	 * before them.
	 * 
	 * @param str the string in which to count occurrences of "hi"
	 * 
	 * @return the number of times lowercase "hi" (without an 'x' immediately before
	 *         it) appears in the string, however do
	 */
	public static int problem3_countHis(String str) {
		int i = str.indexOf("hi");
		if (i == -1) {
			return 0;
		}
		return ((i-1 < 0 || str.charAt(i-1) != 'x') ? 1 : 0) + problem3_countHis(str.substring(i+2));
	}

}