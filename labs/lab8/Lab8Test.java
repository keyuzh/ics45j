package labs.lab8;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class Lab8Test {

	@Test
	void problem1() {
		String[] words = { "Mary", "had", "a", "little", "lamb" };
		SelectionSorter<String> strSorter = new SelectionSorter<String>(words);
		strSorter.sort();
		String[] expectedStrs = { "Mary", "a", "had", "lamb", "little" };
		assertTrue(Arrays.equals(expectedStrs, words));

		Integer[] ints = { 13, 18, 2, 9823, 998, 187, -298, 30, 0, -98, 1, 30, 18 };
		SelectionSorter<Integer> intSorter = new SelectionSorter<Integer>(ints);
		intSorter.sort();
		Integer[] expectedInts = { -298, -98, 0, 1, 2, 13, 18, 18, 30, 30, 187, 998, 9823 };
		assertTrue(Arrays.equals(expectedInts, ints));

		Double[] doubles = { 46.2, -88.032, 0.01, 0.02, 1.0, 18.0, -18.0, -46.2, 0.02, -18.0, 23.697 };
		SelectionSorter<Double> doubleSorter = new SelectionSorter<Double>(doubles);
		doubleSorter.sort();
		Double[] expectedDoubles = { -88.032, -46.2, -18.0, -18.0, 0.01, 0.02, 0.02, 1.0, 18.0, 23.697, 46.2 };
		assertTrue(Arrays.equals(expectedDoubles, doubles));
	}


	@Test
	void problem2() {
		List<String> a = Arrays.asList("apple", "orange");
		List<String> b = Arrays.asList("pear", "banana");
		List<String> c = Appender.append(a, b);
		assertEquals(Arrays.asList("apple", "orange"), a);
		assertEquals(Arrays.asList("pear", "banana"), b);
		assertEquals(Arrays.asList("apple", "orange", "pear", "banana"), c);

		List<Integer> intList1 = Arrays.asList(3, 13, 44, 18, 987, -29, -3, 0);
		List<Integer> intList2 = Arrays.asList(-8, 19, 4, 0, 20);
		List<Integer> intList3 = Appender.append(intList1, intList2);
		assertEquals(Arrays.asList(3, 13, 44, 18, 987, -29, -3, 0), intList1);
		assertEquals(Arrays.asList(-8, 19, 4, 0, 20), intList2);
		assertEquals(Arrays.asList(3, 13, 44, 18, 987, -29, -3, 0, -8, 19, 4, 0, 20), intList3);

		List<Double> dblList1 = Arrays.asList(3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0);
		List<Double> dblList2 = Arrays.asList(-0.0008, 1.9, 4.2, 0.0, 2.0);
		List<Double> dblList3 = Appender.append(dblList1, dblList2);
		assertEquals(Arrays.asList(3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0), dblList1);
		assertEquals(Arrays.asList(-0.0008, 1.9, 4.2, 0.0, 2.0), dblList2);
		assertEquals(Arrays.asList(3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0, -0.0008, 1.9, 4.2, 0.0, 2.0),
				dblList3);

		String[] d = { "apple", "orange" };
		String[] e = { "pear", "banana" };
		String[] f = Appender.append(d, e);
		assertTrue(Arrays.equals(new String[] { "apple", "orange" }, d));
		assertTrue(Arrays.equals(new String[] { "pear", "banana" }, e));
		assertTrue(Arrays.equals(new String[] { "apple", "orange", "pear", "banana" }, f));

		Integer[] intArr1 = { 3, 13, 44, 18, 987, -29, -3, 0 };
		Integer[] intArr2 = { -8, 19, 4, 0, 20 };
		Integer[] intArr3 = Appender.append(intArr1, intArr2);
		assertTrue(Arrays.equals(new Integer[] { 3, 13, 44, 18, 987, -29, -3, 0 }, intArr1));
		assertTrue(Arrays.equals(new Integer[] { -8, 19, 4, 0, 20 }, intArr2));
		assertTrue(Arrays.equals(new Integer[] { 3, 13, 44, 18, 987, -29, -3, 0, -8, 19, 4, 0, 20 }, intArr3));

		Double[] dblArr1 = { 3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0 };
		Double[] dblArr2 = { -0.0008, 1.9, 4.2, 0.0, 2.0 };
		Double[] dblArr3 = Appender.append(dblArr1, dblArr2);
		assertTrue(Arrays.equals(new Double[] { 3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0 }, dblArr1));
		assertTrue(Arrays.equals(new Double[] { -0.0008, 1.9, 4.2, 0.0, 2.0 }, dblArr2));
		assertTrue(Arrays.equals(
				new Double[] { 3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0, -0.0008, 1.9, 4.2, 0.0, 2.0 },
				dblArr3));

	}
	
	
	@Test
	void problem3() {
		List<String> strList = new ArrayList<>();
		strList.add("apple");
		strList.add("orange");
		strList.add("pear");
		strList.add("banana");
		List<String> expStrList = Arrays.asList("banana", "pear", "orange", "apple");
		assertEquals(expStrList, Main.problem3_reverse(strList));
		assertEquals(expStrList, strList);

		List<Integer> intList = new ArrayList<>();
		intList.add(0);
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		List<Integer> expIntList = Arrays.asList(4, 3, 2, 1, 0);
		assertEquals(expIntList, Main.problem3_reverse(intList));
		assertEquals(expIntList, intList);
		
		List<Double> dblList = new ArrayList<>();
		dblList.add(1.5);
		dblList.add(2.5);
		dblList.add(3.5);
		dblList.add(4.5);
		List<Double> expDblList = Arrays.asList(4.5, 3.5, 2.5, 1.5);
		assertEquals(expDblList, Main.problem3_reverse(dblList));
		assertEquals(expDblList, dblList);
		
		List<Point> ptList = new ArrayList<>();
		ptList.add(new Point(0, 0));
		List<Point> expPtList = Arrays.asList(new Point(0, 0));
		assertEquals(expPtList, Main.problem3_reverse(ptList));
		assertEquals(expPtList, ptList);
		
		List<Point> ptList2 = new ArrayList<>();
		List<Point> expPtList2 = new ArrayList<>();
		assertEquals(expPtList2, Main.problem3_reverse(ptList2));
		assertEquals(expPtList2, ptList2);
	}
	
	
	@Test
	void problem4() {
		List<String> a = new ArrayList<>();
		a.add("cupcake");
		a.add("banana");
		a.add("apple");
		assertTrue(Main.problem4_isDecreasing(a));

		a.set(2, "Apple");
		assertTrue(Main.problem4_isDecreasing(a));

		a.set(0, "Cupcake");
		assertFalse(Main.problem4_isDecreasing(a));

		a.set(1, "Cupcake");
		a.set(2, "Cupcake");
		assertTrue(Main.problem4_isDecreasing(a));

		List<String> b = new ArrayList<>();
		b.add("banana");
		b.add("pear");
		assertFalse(Main.problem4_isDecreasing(b));

		List<Integer> c = new ArrayList<>();
		for (int i = 0; i < 10; i += 2)
			c.add(i);
		assertFalse(Main.problem4_isDecreasing(c));

		List<Integer> d = new ArrayList<>();
		for (int i = 10; i >= 0; i -= 2)
			d.add(i);
		assertTrue(Main.problem4_isDecreasing(d));

		d.set(2, d.get(2) + 2);
		assertTrue(Main.problem4_isDecreasing(d));

		d.set(2, d.get(2) * 2);
		assertFalse(Main.problem4_isDecreasing(d));
		
		List<Double> e = new ArrayList<>();
		for (double i = 0; i < 10; i += 2.5)
			e.add(i);
		assertFalse(Main.problem4_isDecreasing(e));
		
		List<Double> f = new ArrayList<>();
		for (double i = 10; i >= 0; i -= 2.5)
			f.add(i);
		assertTrue(Main.problem4_isDecreasing(f));

		f.set(2, f.get(2) + 2.0);
		assertTrue(Main.problem4_isDecreasing(f));

		f.set(2, f.get(2) * 2);
		assertFalse(Main.problem4_isDecreasing(f));
		
		List<String> g = new ArrayList<>();
		assertTrue(Main.problem4_isDecreasing(g));
		
		g.add("Robert");
		assertTrue(Main.problem4_isDecreasing(g));
	}
	
	
	@Test
	void problem5() {
		List<Pair<String, Color>> colors = new ArrayList<>();
		colors.add(new Pair("Juliet", Color.BLUE));
		colors.add(new Pair("Adam", Color.RED));
		colors.add(new Pair("Eve", Color.BLUE));
		Map<String, Color> colorMap = Main.problem5_listToMap(colors);
		assertEquals(Color.BLUE, colorMap.get("Juliet")); 
		assertEquals(Color.RED, colorMap.get("Adam"));
		assertEquals(Color.BLUE, colorMap.get("Eve"));
		
		List<Pair<Integer, String>> places = new ArrayList<>();
		places.add(new Pair(5, "Sam"));
		places.add(new Pair(18, "Paris"));
		places.add(new Pair(3, "Halle"));
		places.add(new Pair(1, "Robert"));
		Map<Integer, String> placesMap = Main.problem5_listToMap(places);
		assertEquals("Robert", placesMap.get(1));
		assertEquals("Halle", placesMap.get(3));
		assertEquals("Sam", placesMap.get(5)); 
		assertEquals("Paris", placesMap.get(18));
		
		List<Pair<Double, Double>> nums1 = new ArrayList<>();
		nums1.add(new Pair(0.0, 5.9));
		Map<Double, Double> nums1Map = Main.problem5_listToMap(nums1);
		assertEquals(5.9, nums1Map.get(0.0));
		assertNull(nums1Map.get(5.9)); 
		
		// empty list:
		List<Pair<String, Double>> empty = new ArrayList<>();
		Map<String, Double> emptyMap = Main.problem5_listToMap(empty);
		assertNull(emptyMap.get("Robert")); 
	}

}
