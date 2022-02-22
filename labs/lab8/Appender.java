package labs.lab8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A utility class for appending lists/arrays
 *
 */
public class Appender<T> {

	/**
	 * Appends two lists together.
	 * 
	 * Leaves the parameter lists unchanged, and returns a new list that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the lists
	 * @param a   list 1
	 * @param b   list 2
	 * 
	 * @return a new list containing the elements of a and b appended
	 */
	// WRITE METHOD HERE
	public static <T> List<T> append(List<T> a, List<T> b) {
		List<T> res = new ArrayList<>();
		res.addAll(a);
		res.addAll(b);
		return res;
	}


	/**
	 * Appends two arrays together.
	 * 
	 * Leaves the parameter arrays unchanged, and returns a new arrays that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the arrays
	 * @param a   array 1
	 * @param b   array 2
	 *
	 * @return a new array containing the elements of a and b appended
	 */
	// WRITE METHOD HERE
	public static <T> T[] append(T[] a, T[] b) {
		ArrayList<T> res = new ArrayList<>();
		res.addAll(Arrays.asList(a));
		res.addAll(Arrays.asList(b));
		T[] r = (T[]) Array.newInstance(res.get(0).getClass(), a.length+b.length);
		return res.toArray(r);

	}

}