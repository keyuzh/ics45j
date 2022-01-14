package labs.lab6;

import java.io.*;
import java.util.*;

public class Files {
	private static final String[] spelling = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

	/**
	 * Sorts the words in each line of a file lexicographically, then sorts the
	 * lines lexicographically, and writes the result back to the original file with
	 * a space between each word and no space between each line. Ignores blank lines
	 * and does not write them to the revised file.
	 * 
	 * @param fileName name of the input file
	 */
	public static void sortFile(String fileName) {
		File f = new File(fileName);
		ArrayList<String> lines = new ArrayList<>();
		try (Scanner in = new Scanner(f)) {
			String ln;
			String[] sep;
			while (in.hasNextLine()) {
				ln = in.nextLine();
				if (ln.equals("")) continue;
				sep = ln.trim().split("\\s+");
				Arrays.sort(sep);
				lines.add(String.join(" ", sep));
			}
		} catch (FileNotFoundException e) {
			System.out.printf("File: %s not found", fileName);
			return;
		}
		Collections.sort(lines);
		try (PrintWriter out = new PrintWriter(new FileWriter(f, false))) {
			for (String line: lines) {
				out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Replaces each occurrence of a digit (0-9) in a file with the word (in all
	 * caps) that spells out that digit, e.g., ZERO, ONE, TWO, etc.
	 * 
	 * @param fileName name of the input file
	 */
	public static void spellDigits(String fileName) {
		File f = new File(fileName);
		ArrayList<String> lines = new ArrayList<>();
		try (Scanner in = new Scanner(f)) {
			while (in.hasNextLine()) {
				lines.add(in.nextLine());
			}
		}
		catch (FileNotFoundException e) {
			System.out.printf("File: %s not found", fileName);
			return;
		}
		try (PrintWriter out = new PrintWriter(new FileWriter(f, false))) {
			for (String line: lines) {
				String replaced = line;
				for (int i = 0; i < 10; i++) {
					replaced = replaced.replaceAll(Integer.toString(i), spelling[i]);
				}
				out.println(replaced);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
