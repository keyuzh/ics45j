package labs.lab3;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class Lab3Test {

	private final double EPSILON = 1e-2;

	@Test
	void problem1() {
		assertEquals(1, Main.problem1_countQuadruplets("abcdXXXXabcd"));
		assertEquals(3, Main.problem1_countQuadruplets("xxxxabyyyyycd"));
		assertEquals(0, Main.problem1_countQuadruplets("a"));
		assertEquals(0, Main.problem1_countQuadruplets(""));
		assertEquals(3, Main.problem1_countQuadruplets("xxxxabyyyyycd"));
		assertEquals(1, Main.problem1_countQuadruplets("XXXXabcd"));
		assertEquals(2, Main.problem1_countQuadruplets("XXXXXabc"));
		assertEquals(3, Main.problem1_countQuadruplets("XXXXXXabc"));
		assertEquals(3, Main.problem1_countQuadruplets("2222abyyyycdXXXX"));
		assertEquals(4, Main.problem1_countQuadruplets("abYYYYabXXXXXXab"));
		assertEquals(0, Main.problem1_countQuadruplets("abYYXXabXXYXXab"));
		assertEquals(1, Main.problem1_countQuadruplets("122abhhhh2"));
		assertEquals(3, Main.problem1_countQuadruplets("1222289006677777"));
	}


	@Test
	void problem2() {
		assertEquals(6, Main.problem2_sum("aa1bc2d3"));
		assertEquals(8, Main.problem2_sum("aa11b303"));
		assertEquals(0, Main.problem2_sum("Robert"));
		assertEquals(7, Main.problem2_sum("5hoco1a1e"));
		assertEquals(12, Main.problem2_sum("123ab0c123"));
		assertEquals(0, Main.problem2_sum(""));
		assertEquals(0, Main.problem2_sum("Hello Robert"));
		assertEquals(12, Main.problem2_sum("X1z9b2"));
		assertEquals(14, Main.problem2_sum("5432a"));
		assertEquals(15, Main.problem2_sum("54321"));
		assertEquals(14, Main.problem2_sum("-5432a"));
		assertEquals(14, Main.problem2_sum("-5432"));
		assertEquals(0, Main.problem2_sum("R0BERT"));
	}


	@Test
	void problem3() {
		assertEquals("are not tests", Main.problem3_replace("are tests"));
		assertEquals("These are not tests.", Main.problem3_replace("These are tests."));
		assertEquals("These are not not tests.", Main.problem3_replace("These are not tests."));
		assertEquals("are not-are not", Main.problem3_replace("are-are"));
		assertEquals("These are not right", Main.problem3_replace("These are right"));
		assertEquals("I love Java!", Main.problem3_replace("I love Java!"));
		assertEquals("My favorite numbers are not3 and 5.", Main.problem3_replace("My favorite numbers are3 and 5."));
		assertEquals("I dare you", Main.problem3_replace("I dare you"));
		assertEquals("Double dare", Main.problem3_replace("Double dare"));
		assertEquals("area 51", Main.problem3_replace("area 51"));
		assertEquals("I cared too much!", Main.problem3_replace("I cared too much!"));
		assertEquals("", Main.problem3_replace(""));
		assertEquals("a r e scare are not dare share are not mare stare stared ared a ar re are not",
				Main.problem3_replace("a r e scare are dare share are mare stare stared ared a ar re are"));
		assertEquals("car", Main.problem3_replace("car"));
	}


	@Test
	void problem4() {
		assertEquals("r, u, m, ru, um, rum", Main.problem4_getAllSubstrings("rum"));
		assertEquals("r, u, ru", Main.problem4_getAllSubstrings("ru"));
		assertEquals("r", Main.problem4_getAllSubstrings("r"));
		assertEquals("R, o, b, e, r, t, Ro, ob, be, er, rt, Rob, obe, ber, ert, Robe, ober, bert, Rober, obert, Robert",
				Main.problem4_getAllSubstrings("Robert"));
		assertEquals(
				"R, o, b, e, r, t,  , N, a, v, a, r, r, o, Ro, ob, be, er, rt, t ,  N, Na, av, va, ar, rr, ro, Rob, obe, ber, ert, rt , t N,  Na, Nav, ava, var, arr, rro, Robe, ober, bert, ert , rt N, t Na,  Nav, Nava, avar, varr, arro, Rober, obert, bert , ert N, rt Na, t Nav,  Nava, Navar, avarr, varro, Robert, obert , bert N, ert Na, rt Nav, t Nava,  Navar, Navarr, avarro, Robert , obert N, bert Na, ert Nav, rt Nava, t Navar,  Navarr, Navarro, Robert N, obert Na, bert Nav, ert Nava, rt Navar, t Navarr,  Navarro, Robert Na, obert Nav, bert Nava, ert Navar, rt Navarr, t Navarro, Robert Nav, obert Nava, bert Navar, ert Navarr, rt Navarro, Robert Nava, obert Navar, bert Navarr, ert Navarro, Robert Navar, obert Navarr, bert Navarro, Robert Navarr, obert Navarro, Robert Navarro",
				Main.problem4_getAllSubstrings("Robert Navarro"));
		assertEquals("1, 2, 3, 4, 5, 12, 23, 34, 45, 123, 234, 345, 1234, 2345, 12345",
				Main.problem4_getAllSubstrings("12345"));
		assertEquals(
				"1,  , 2,  , 3,  , 4, 1 ,  2, 2 ,  3, 3 ,  4, 1 2,  2 , 2 3,  3 , 3 4, 1 2 ,  2 3, 2 3 ,  3 4, 1 2 3,  2 3 , 2 3 4, 1 2 3 ,  2 3 4, 1 2 3 4",
				Main.problem4_getAllSubstrings("1 2 3 4"));
		assertEquals("*, *, *, **, **, ***", Main.problem4_getAllSubstrings("***"));
		assertEquals("R, *, U, !, M, &, R*, *U, U!, !M, M&, R*U, *U!, U!M, !M&, R*U!, *U!M, U!M&, R*U!M, *U!M&, R*U!M&",
				Main.problem4_getAllSubstrings("R*U!M&"));
		assertEquals("", Main.problem4_getAllSubstrings(""));
	}


	@Test
	void problem5() {
		CreditCard cc1 = new CreditCard(4022888888881881L, LocalDate.of(2024, 2, 28));
		assertEquals(4022888888881881L, cc1.getNumber());
		assertEquals(LocalDate.of(2024, 2, 28), cc1.getExpirationDate());
		assertEquals("4022 8888 8888 1881", cc1.getNumberWithSpaces());
		assertTrue(cc1.isValid());

		CreditCard cc2 = new CreditCard(4022888888881881L, LocalDate.of(2021, 2, 28));
		assertEquals(4022888888881881L, cc2.getNumber()); //
		assertEquals(LocalDate.of(2021, 2, 28), cc2.getExpirationDate());
		assertEquals("4022 8888 8888 1881", cc2.getNumberWithSpaces());
		assertFalse(cc2.isValid());

		CreditCard cc3 = new CreditCard(5022888888881881L, LocalDate.of(2024, 2, 28));
		assertEquals(5022888888881881L, cc3.getNumber());
		assertEquals(LocalDate.of(2024, 2, 28), cc3.getExpirationDate());
		assertEquals("5022 8888 8888 1881", cc3.getNumberWithSpaces());
		assertFalse(cc3.isValid());

		CreditCard cc4 = new CreditCard(3333333333333333L, LocalDate.of(2019, 4, 9));
		assertEquals(3333333333333333L, cc4.getNumber());
		assertEquals(LocalDate.of(2019, 4, 9), cc4.getExpirationDate());
		assertEquals("3333 3333 3333 3333", cc4.getNumberWithSpaces());
		assertFalse(cc4.isValid());

		CreditCard cc5 = new CreditCard(3333333333333333L, LocalDate.of(2030, 4, 9));
		assertEquals(3333333333333333L, cc5.getNumber());
		assertEquals(LocalDate.of(2030, 4, 9), cc5.getExpirationDate());
		assertEquals("3333 3333 3333 3333", cc5.getNumberWithSpaces());
		assertTrue(cc5.isValid());

		CreditCard cc6 = new CreditCard(3000333333333333L, LocalDate.of(2030, 4, 9));
		assertEquals(3000333333333333L, cc6.getNumber());
		assertEquals(LocalDate.of(2030, 4, 9), cc6.getExpirationDate());
		assertEquals("3000 3333 3333 3333", cc6.getNumberWithSpaces());
		assertTrue(cc6.isValid());

		CreditCard cc7 = new CreditCard(3000333333330000L, LocalDate.of(2030, 4, 9));
		assertEquals(3000333333330000L, cc7.getNumber());
		assertEquals(LocalDate.of(2030, 4, 9), cc7.getExpirationDate());
		assertEquals("3000 3333 3333 0000", cc7.getNumberWithSpaces());
		assertTrue(cc7.isValid());
	}


	@Test
	void problem6() {
		assertTrue(Main.problem6_sumSplitBalance(new int[] { 1, 1, 1, 2, 1 }));
		assertFalse(Main.problem6_sumSplitBalance(new int[] { 2, 1, 1, 2, 1 }));
		assertTrue(Main.problem6_sumSplitBalance(new int[] { 10, 10 }));
		assertFalse(Main.problem6_sumSplitBalance(new int[] { 1 }));
		assertTrue(Main.problem6_sumSplitBalance(new int[] { 10, 0, 1, -1, 10 }));
		assertTrue(Main.problem6_sumSplitBalance(new int[] { 1, 1 }));
		assertFalse(Main.problem6_sumSplitBalance(new int[] { 1, 2 }));
		assertTrue(Main.problem6_sumSplitBalance(new int[] { 1, 1, 1, 1, 4 }));
		assertFalse(Main.problem6_sumSplitBalance(new int[] { 2, 1, 1, 1, 4 }));
		assertFalse(Main.problem6_sumSplitBalance(new int[] { 2, 3, 4, 1, 2 }));
		assertTrue(Main.problem6_sumSplitBalance(new int[] { 1, 2, 3, 1, 0, 2, 3 }));
		assertFalse(Main.problem6_sumSplitBalance(new int[] { 1, 2, 3, 1, 0, 1, 3 }));
		assertTrue(Main.problem6_sumSplitBalance(new int[] { 0, 0, 0, 0, 0 }));
		assertTrue(Main.problem6_sumSplitBalance(new int[] { 11, 1, 3, 3, 4 }));
		assertFalse(Main.problem6_sumSplitBalance(new int[] { 0 }));
		assertTrue(Main.problem6_sumSplitBalance(new int[] { 0, 0 }));
		assertTrue(Main.problem6_sumSplitBalance(new int[] { -1, -11, -3, -18, 3 }));
		assertFalse(Main.problem6_sumSplitBalance(new int[] { -1, -11, -3, -18, -3 }));
		assertTrue(Main.problem6_sumSplitBalance(new int[] { -1, -11, -3, -8, -13, -10 }));
	}


	@Test
	void problem7() {
		assertEquals(4, Main.problem7_maxInterval(new int[] { 1, 2, 1, 1, 3 }));
		assertEquals(6, Main.problem7_maxInterval(new int[] { 1, 4, 2, 1, 4, 1, 4 }));
		assertEquals(6, Main.problem7_maxInterval(new int[] { 1, 4, 2, 1, 4, 4, 4 }));
		assertEquals(3, Main.problem7_maxInterval(new int[] { 3, 3, 3 }));
		assertEquals(3, Main.problem7_maxInterval(new int[] { 3, 9, 3 }));
		assertEquals(2, Main.problem7_maxInterval(new int[] { 3, 9, 9 }));
		assertEquals(1, Main.problem7_maxInterval(new int[] { 3, 9 }));
		assertEquals(2, Main.problem7_maxInterval(new int[] { 3, 3 }));
		assertEquals(0, Main.problem7_maxInterval(new int[] {}));
		assertEquals(1, Main.problem7_maxInterval(new int[] { 1 }));
		assertEquals(3, Main.problem7_maxInterval(new int[] { 1, 2, 1, -1, 3 }));
		assertEquals(4, Main.problem7_maxInterval(new int[] { 1, 2, -1, 1, 3 }));
		assertEquals(4, Main.problem7_maxInterval(new int[] { -1, -2, -1, -1, -3 }));
	}


	@Test
	void problem8() {
		DailySalesTally tally = new DailySalesTally();
		tally.addPurchase(new Purchase("Day care", "Fluffy", 25.0, false));
		tally.addPurchase(new Purchase("Bow tie collar", "Carl", 15.75, true));
		assertEquals(25.0, tally.getTotalForClient("Fluffy"), EPSILON);
		assertEquals(14.96, tally.getTotalForClient("Carl"), EPSILON);
		assertEquals(0, tally.getTotalForClient("carl"), EPSILON);
		assertEquals(0, tally.getTotalForClient("Abby"), EPSILON);
		assertEquals(39.96, tally.getGrandTotal(), EPSILON);
		tally.addPurchase(new Purchase("Bath and blow dry", "Fluffy", 39.95, false));
		tally.addPurchase(new Purchase("Dog biscuits", "Carl", 6.25, true));
		assertEquals(60.96, tally.getTotalForClient("Fluffy"), EPSILON);
		assertEquals(20.3, tally.getTotalForClient("Carl"), EPSILON);
		assertEquals(81.26, tally.getGrandTotal(), EPSILON);
		tally.addPurchase(new Purchase("Nail trim", "Abby", 12.25, false));
		tally.addPurchase(new Purchase("Argyle sweater", "Roger", 99.99, true));
		assertEquals(188.5, tally.getGrandTotal(), EPSILON);
		assertEquals(60.96, tally.getTotalForClient("Fluffy"), EPSILON);
		assertEquals(20.3, tally.getTotalForClient("Carl"), EPSILON);
		assertEquals(12.25, tally.getTotalForClient("Abby"), EPSILON);
		assertEquals(94.99, tally.getTotalForClient("Roger"), EPSILON);
		assertEquals(188.5, tally.getGrandTotal(), EPSILON);
		tally.addPurchase(new Purchase("Bath and blow dry", "Carl", 39.95, false));
		tally.addPurchase(new Purchase("Dog booties", "Fluffy", 27.13, true));
		assertEquals(84.15, tally.getTotalForClient("Fluffy"), EPSILON);
		assertEquals(247.65, tally.getGrandTotal(), EPSILON);
		assertEquals(56.26, tally.getTotalForClient("Carl"), EPSILON);
		assertEquals(12.25, tally.getTotalForClient("Abby"), EPSILON);
		assertEquals(94.99, tally.getTotalForClient("Roger"), EPSILON);
		assertEquals(247.65, tally.getGrandTotal(), EPSILON);
		tally.addPurchase(new Purchase("Bowl of water", "Carl", 0, false));
		tally.addPurchase(new Purchase("Free treats", "Fluffy", 0, true));
		assertEquals(84.15, tally.getTotalForClient("Fluffy"), EPSILON);
		assertEquals(56.26, tally.getTotalForClient("Carl"), EPSILON);
		assertEquals(12.25, tally.getTotalForClient("Abby"), EPSILON);
		assertEquals(94.99, tally.getTotalForClient("Roger"), EPSILON);
		assertEquals(247.65, tally.getGrandTotal(), EPSILON);
	}


	@Test
	void problem9() {
		Inventory inventory = new Inventory();
		assertEquals("No items under-stocked", inventory.getUnderstockReport());
		assertEquals("No items over-stocked", inventory.getOverstockReport());

		inventory.addOrUpdateItem(new Item("plaid bow tie collar", 10, 9));
		inventory.addOrUpdateItem(new Item("blue dog booties", 20, 20));
		inventory.addOrUpdateItem(new Item("pink dog booties", 20, 25));
		inventory.addOrUpdateItem(new Item("multi-colored leash", 5, 0));
		inventory.addOrUpdateItem(new Item("beige dog bed, x-large", 4, 0));
		inventory.addOrUpdateItem(new Item("rawhide bone, small", 50, 50));
		inventory.addOrUpdateItem(new Item("stuffed squirrel", 12, 16));
		assertEquals(
				"Order 1 more of plaid bow tie collar | Order 5 more of multi-colored leash | Order 4 more of beige dog bed, x-large",
				inventory.getUnderstockReport());
		assertEquals("pink dog booties over-stocked by 5 items | stuffed squirrel over-stocked by 4 items",
				inventory.getOverstockReport());

		inventory.removeItemWithDescription("multi-colored leash");
		inventory.removeItemWithDescription("purple harness");
		inventory.removeItemWithDescription("stuffed squirrel");
		assertEquals("Order 1 more of plaid bow tie collar | Order 4 more of beige dog bed, x-large",
				inventory.getUnderstockReport());
		assertEquals("pink dog booties over-stocked by 5 items", inventory.getOverstockReport());

		inventory.addOrUpdateItem(new Item("pink dog booties", 15, 15));
		inventory.addOrUpdateItem(new Item("plaid bow tie collar", 9, 10));
		inventory.addOrUpdateItem(new Item("beige dog bed, x-large", 1, 4));
		assertEquals("No items under-stocked", inventory.getUnderstockReport());
		assertEquals("plaid bow tie collar over-stocked by 1 items | beige dog bed, x-large over-stocked by 3 items",
				inventory.getOverstockReport());
	}


	@Test
	void problem10() {
		Table table = new Table(4, 5); // 4 x 5 table

		// Fill it with a sequence of values:
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				table.set(i, j, (3 + i) * (2 + j));
			}
		}

		assertEquals(12.0, table.neighborAverage(1, 1), EPSILON);
		assertEquals(25.0, table.neighborAverage(2, 3), EPSILON);
		
		// Upper-left corner:
		assertEquals(9.66667, table.neighborAverage(0, 0), EPSILON);
		
		// Lower-right corner:
		assertEquals(28.333333, table.neighborAverage(3, 4), EPSILON);

		// Right-hand side:
		assertEquals(21.6, table.neighborAverage(1, 4), EPSILON);

		// Left-hand side:
		assertEquals(10.4, table.neighborAverage(1, 0), EPSILON);

		// Bottom row:
		assertEquals(21.6, table.neighborAverage(3, 2), EPSILON);

		// Top row:
		assertEquals(14.4, table.neighborAverage(0, 2), EPSILON);

		assertEquals(60.0, table.sum(0, true));
		assertEquals(36.0, table.sum(0, false));
		assertEquals(80.0, table.sum(1, true));
		assertEquals(54.0, table.sum(1, false));
		assertEquals(100.0, table.sum(2, true));
		assertEquals(72.0, table.sum(2, false));
		assertEquals(120.0, table.sum(3, true));
		assertEquals(90.0, table.sum(3, false));
		assertEquals(108.0, table.sum(4, false));
		
		
		table = new Table(1, 1);
		table.set(0, 0, -3);
		assertEquals(-3.0, table.neighborAverage(1, 1), EPSILON);
		assertEquals(0.0, table.neighborAverage(8, 8), EPSILON);
		assertEquals(-3.0, table.sum(0, true));
		assertEquals(-3.0, table.sum(0, false));
	}

}
