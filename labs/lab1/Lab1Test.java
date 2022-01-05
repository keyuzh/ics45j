package labs.lab1;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class Lab1Test {

	private final double EPSILON = 1e-3;

	@Test
	void problem1() {
		assertEquals("lloHe", Main.problem1_remove2("HelloHe"));
		assertEquals("HelloHi", Main.problem1_remove2("HelloHi"));
		assertEquals("Hi", Main.problem1_remove2("HiHi"));
		assertEquals("", Main.problem1_remove2("Hi"));
		assertEquals("Hihi", Main.problem1_remove2("Hihi"));
		assertEquals("rPr", Main.problem1_remove2("rPr"));
		assertEquals("Chocolate", Main.problem1_remove2("Chocolate"));
		assertEquals("x", Main.problem1_remove2("xxx"));
		assertEquals("", Main.problem1_remove2("xx"));
		assertEquals("x", Main.problem1_remove2("x"));
		assertEquals("", Main.problem1_remove2(""));
		assertEquals("Robert", Main.problem1_remove2("Robert"));
	}


	@Test
	void problem2() {
		assertEquals("loHi", Main.problem2_shortConcat("Hello", "Hi"));
		assertEquals("ellojava", Main.problem2_shortConcat("Hello", "java"));
		assertEquals("javaello", Main.problem2_shortConcat("java", "Hello"));
		assertEquals("cx", Main.problem2_shortConcat("abc", "x"));
		assertEquals("xc", Main.problem2_shortConcat("x", "abc"));
		assertEquals("", Main.problem2_shortConcat("abc", ""));
	}


	@Test
	void problem3() {
		// numPics = 5:
		int numPics = 5;
		String numString = Main.problem3_slotMachine(numPics);
		Scanner s = new Scanner(numString);
		ArrayList<Integer> nums = new ArrayList<>();
		while (s.hasNext()) {
			nums.add(s.nextInt());
		}

		// make sure it generated 4 numbers:
		assertEquals(4, nums.size());

		// make sure all nums are between the min and max:
		for (Integer num : nums) {
			assertTrue(num >= 1);
			assertTrue(num <= numPics);
		}
		s.close();

		// numPics = 3:
		numPics = 3;
		numString = Main.problem3_slotMachine(numPics);
		s = new Scanner(numString);
		nums = new ArrayList<>();
		while (s.hasNext()) {
			nums.add(s.nextInt());
		}

		// make sure it generated 4 numbers:
		assertEquals(4, nums.size());

		// make sure all nums are between the min and max:
		for (Integer num : nums) {
			assertTrue(num >= 1);
			assertTrue(num <= numPics);
		}
		s.close();

		// numPics = 10:
		numPics = 10;
		numString = Main.problem3_slotMachine(numPics);
		s = new Scanner(numString);
		nums = new ArrayList<>();
		while (s.hasNext()) {
			nums.add(s.nextInt());
		}

		// make sure it generated 4 numbers:
		assertEquals(4, nums.size());

		// make sure all nums are between the min and max:
		for (Integer num : nums) {
			assertTrue(num >= 1);
			assertTrue(num <= numPics);
		}
		s.close();

		// numPics = 3000:
		numPics = 3000;
		numString = Main.problem3_slotMachine(numPics);
		s = new Scanner(numString);
		nums = new ArrayList<>();
		while (s.hasNext()) {
			nums.add(s.nextInt());
		}

		// make sure it generated 4 numbers:
		assertEquals(4, nums.size());

		// make sure all nums are between the min and max:
		for (Integer num : nums) {
			assertTrue(num >= 1);
			assertTrue(num <= numPics);
		}
		s.close();
	}


	@Test
	void problem4() {
		assertEquals("treoR", Main.problem4_deleteAndReverse("Robert", 2));
		assertEquals("trebo", Main.problem4_deleteAndReverse("Robert", 0));
		assertEquals("reboR", Main.problem4_deleteAndReverse("Robert", 5));
		assertEquals("I", Main.problem4_deleteAndReverse("HI", 0));
		assertEquals("H", Main.problem4_deleteAndReverse("HI", 1));
		assertEquals("", Main.problem4_deleteAndReverse("H", 0));
	}


	@Test
	void problem5() {
		assertTrue(new BigDecimal(
				"-9.610000000000000550670620214077651938730359583164929117285652827862296732064351090230047702789306640625")
						.equals(Main.problem5_bigPowerNegate(new BigDecimal(3.1), 2)));
		assertTrue(new BigDecimal(
				"0.007916293657000000587393385931278558904560168021331181838069343034723826023096811683978266027338361275704885165065885279929262796638766985779511742293834686279296875")
						.equals(Main.problem5_bigPowerNegate(new BigDecimal(-0.1993), 3)));
		assertTrue(new BigDecimal(
				"-9453529591320953.72957178735145919339954101592137687052611699540982668019762429129774880708606363011469913534638642200087975733527338525018416431081877168468948993054507525862520372790018196063711709801337274912965493211538535801744629307310747020273186548595370012002327021520879242282964734817677544461381930035269708541045399616541649226290379426362875392442219890654087066650390625")
						.equals(Main.problem5_bigPowerNegate(new BigDecimal(99.3), 8)));
	}


	@Test
	void problem6() {
		Circuit wiring = new Circuit();
		assertEquals(0, wiring.getSwitchState(1));
		assertEquals(0, wiring.getSwitchState(2));
		assertEquals(0, wiring.getLampState());

		wiring.toggleSwitch(1);
		assertEquals(1, wiring.getSwitchState(1));
		assertEquals(0, wiring.getSwitchState(2));
		assertEquals(1, wiring.getLampState());

		wiring.toggleSwitch(2);
		assertEquals(1, wiring.getSwitchState(1));
		assertEquals(1, wiring.getSwitchState(2));
		assertEquals(0, wiring.getLampState());

		wiring.toggleSwitch(1);
		assertEquals(0, wiring.getSwitchState(1));
		assertEquals(1, wiring.getSwitchState(2));
		assertEquals(1, wiring.getLampState());

		wiring.toggleSwitch(2);
		assertEquals(0, wiring.getSwitchState(1));
		assertEquals(0, wiring.getSwitchState(2));
		assertEquals(0, wiring.getLampState());

		wiring.toggleSwitch(2);
		assertEquals(0, wiring.getSwitchState(1));
		assertEquals(1, wiring.getSwitchState(2));
		assertEquals(1, wiring.getLampState());

		wiring.toggleSwitch(1);
		assertEquals(1, wiring.getSwitchState(1));
		assertEquals(1, wiring.getSwitchState(2));
		assertEquals(0, wiring.getLampState());

		wiring.toggleSwitch(2);
		assertEquals(1, wiring.getSwitchState(1));
		assertEquals(0, wiring.getSwitchState(2));
		assertEquals(1, wiring.getLampState());

		wiring.toggleSwitch(1);
		assertEquals(0, wiring.getSwitchState(1));
		assertEquals(0, wiring.getSwitchState(2));
		assertEquals(0, wiring.getLampState());
	}


	@Test
	void problem7() {
		SavingsAccount momsSavings = new SavingsAccount(1000, 10);
		momsSavings.addInterest();
		assertEquals(1100.0, momsSavings.getBalance(), EPSILON);
		momsSavings.addInterest();
		assertEquals(1210.0, momsSavings.getBalance(), EPSILON);
		momsSavings.deposit(1000.00);
		assertEquals(2210.0, momsSavings.getBalance(), EPSILON);
		momsSavings.addInterest();
		assertEquals(2431.0, momsSavings.getBalance(), EPSILON);
		momsSavings.withdraw(2000.0);
		assertEquals(431.0, momsSavings.getBalance(), EPSILON);
		momsSavings.addInterest();
		assertEquals(474.1, momsSavings.getBalance(), EPSILON);

		SavingsAccount emilysSavings = new SavingsAccount();
		assertEquals(0.0, emilysSavings.getBalance(), EPSILON);
		emilysSavings.addInterest();
		assertEquals(0.0, emilysSavings.getBalance(), EPSILON);
		emilysSavings.deposit(100);
		assertEquals(100.0, emilysSavings.getBalance(), EPSILON);
		emilysSavings.addInterest();
		assertEquals(100.0, emilysSavings.getBalance(), EPSILON);

		SavingsAccount robertsSavings = new SavingsAccount(250, 50);
		assertEquals(250.0, robertsSavings.getBalance(), EPSILON);
		robertsSavings.addInterest();
		robertsSavings.addInterest();
		robertsSavings.addInterest();
		assertEquals(843.75, robertsSavings.getBalance(), EPSILON);
		robertsSavings.deposit(10000.0);
		robertsSavings.addInterest();
		assertEquals(16265.625, robertsSavings.getBalance(), EPSILON);
	}


	@Test
	void problem8() {
		Moth gypsy = new Moth(10);
		gypsy.moveToLight(0);
		assertEquals(5.0, gypsy.getPosition(), EPSILON);
		gypsy.moveToLight(10);
		assertEquals(7.5, gypsy.getPosition(), EPSILON);
		gypsy.moveToLight(0);
		assertEquals(3.75, gypsy.getPosition(), EPSILON);

		Moth monte = new Moth(20);
		monte.moveToLight(10);
		assertEquals(15.0, monte.getPosition(), EPSILON);
		monte.moveToLight(10);
		assertEquals(12.5, monte.getPosition(), EPSILON);
		monte.moveToLight(0);
		assertEquals(6.25, monte.getPosition(), EPSILON);
		monte.moveToLight(1000.52);
		assertEquals(503.385, monte.getPosition(), EPSILON);
	}


	@Test
	void problem9() {
		Battery battery1 = new Battery(100.0);
		assertEquals(100.0, battery1.getRemainingCapacity(), EPSILON);
		battery1.drain(23.4);
		battery1.drain(9.7);
		assertEquals(66.9, battery1.getRemainingCapacity(), EPSILON);
		battery1.charge();
		assertEquals(100.0, battery1.getRemainingCapacity());

		Battery battery2 = new Battery(55.75);
		assertEquals(55.75, battery2.getRemainingCapacity(), EPSILON);
		battery2.drain(55.75);
		assertEquals(0.0, battery2.getRemainingCapacity(), EPSILON);
		battery2.charge();
		assertEquals(55.75, battery2.getRemainingCapacity());
		battery2.drain(1.0);
		assertEquals(54.75, battery2.getRemainingCapacity());
		battery2.charge();
		assertEquals(55.75, battery2.getRemainingCapacity());
		battery2.charge();
		assertEquals(55.75, battery2.getRemainingCapacity());
		battery2.drain(0);
		assertEquals(55.75, battery2.getRemainingCapacity());
	}


	@Test
	void problem10() {
		Greeter greeter1 = new Greeter("World");
		assertEquals("Hello, World", greeter1.sayHello());
		assertEquals("Goodbye, World", greeter1.sayGoodbye());

		Greeter greeter2 = new Greeter("Robert");
		assertEquals("Hello, Robert", greeter2.sayHello());
		assertEquals("Goodbye, Robert", greeter2.sayGoodbye());
		
		Greeter greeter3 = new Greeter("");
		assertEquals("Hello, ", greeter3.sayHello());
		assertEquals("Goodbye, ", greeter3.sayGoodbye());
	}

}
