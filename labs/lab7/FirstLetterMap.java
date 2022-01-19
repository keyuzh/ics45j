package labs.lab7;

/**
 * Reads all words from a file and adds them to a map 
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter. 
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FirstLetterMap {

	private Map<Character, Set<String>> words;

	/**
	 * Constructs a new FirstLetterMap based on the given file. Reads all words from
	 * the file with the given name and adds them to a map whose keys are the first
	 * letters of the words and whose values are sets of words that start with that
	 * same letter.
	 * 
	 * All non-letter characters are ignored. All letters are converted to lower
	 * case for processing.
	 * 
	 * @param fileName name of the file on which to construct the map
	 */
	public FirstLetterMap(String fileName) {
		File f = new File(fileName);
		words = new TreeMap<>();
		try (Scanner in = new Scanner(f)) {
			String ln;
			String[] sep;
			while (in.hasNextLine()) {
				ln = in.nextLine().replaceAll("(\\p{Punct})|(\\d)","").toLowerCase();
				sep = ln.trim().split("\\s+");
				for (String s : sep) {
					if (!s.isEmpty()) {
						words.putIfAbsent(s.charAt(0), new TreeSet<>());
						words.get(s.charAt(0)).add(s);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.printf("File: %s not found", fileName);
		}
	}


	/**
	 * Returns a sorted set of all words in the map that start with the given
	 * character
	 * 
	 * @param c the character beginning the words
	 * @return a sorted set of all words in the map that start with the given
	 *         character
	 */
	public Set<String> getWordsThatStartWith(char c) {
		return words.get(c);
	}


	/**
	 * Returns a string representation of the map with the keys and each set of
	 * words sorted in lexicographic order (HINT: call the toString method of the
	 * words map
	 */
	@Override
	public String toString() {
		return words.toString();
	}
}
