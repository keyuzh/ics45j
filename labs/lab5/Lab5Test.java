package labs.lab5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class Lab5Test {

	private final double EPSILON = 1e-2;

	@Test
	void problems1Through5() {
		// players:
		Player robert = new Player("Robert");
		Player emily = new Player("Emily");

		// Collectables:
		// bags of gems:
		Collectable bigBag = new BagOfGems(10);
		Collectable smallBag = new BagOfGems(2);
		Collectable mediumBag = new BagOfGems(5);

		// boxes of rocks:
		Collectable bigBox = new BoxOfRocks(7.5, true);
		Collectable smallBox = new BoxOfRocks(1.0, false);
		Collectable mediumBox = new BoxOfRocks(2.25, true);

		// enemies:
		Enemy goblin1 = new Goblin();
		Enemy goblin2 = new Goblin();
		Enemy fbDragon = new Dragon(true);
		Enemy dragon = new Dragon(false);
		Enemy bigDemo = new Demogorgon(100.0);
		Enemy mediumDemo = new Demogorgon(50.0);
		Enemy smallDemo = new Demogorgon(10.5);
		Enemy weakBugaboo = new Bugaboo(50.25);
		Enemy strongBugaboo = new Bugaboo(534.2);
		Enemy armedClown = new Clown(true);
		Enemy unarmedClown = new Clown(false);

		// gameplay:

		// colllecting stuff:
		assertTrue(robert.collectItem(bigBag));
		assertEquals(50, robert.getStrengthPoints());
		assertFalse(emily.collectItem(bigBag));
		assertEquals(0, emily.getStrengthPoints());
		assertFalse(emily.collectItem(smallBox));
		assertEquals(0, emily.getStrengthPoints());
		assertEquals(0, emily.getAmmo());
		assertTrue(robert.collectItem(mediumBox));
		assertEquals(50, robert.getStrengthPoints());
		assertEquals(9, robert.getAmmo());
		assertTrue(emily.collectItem(mediumBag));
		assertEquals(25, emily.getStrengthPoints());
		assertFalse(emily.collectItem(mediumBag));
		assertTrue(emily.collectItem(smallBox));
		assertEquals(2, emily.getAmmo());

		// attacking enemies:
		assertEquals(100, goblin1.getHealth());
		assertTrue(emily.attackEnemy(goblin1));
		assertEquals(1, emily.getAmmo());
		assertEquals(75, emily.getStrengthPoints());
		assertEquals("red", ((Goblin) goblin1).getColor());
		assertEquals(50, goblin1.getHealth());

		assertEquals(100, fbDragon.getHealth());
		assertTrue(emily.attackEnemy(fbDragon));
		assertEquals(0, emily.getAmmo());
		assertEquals(50, emily.getStrengthPoints());
		assertEquals(100, fbDragon.getHealth());

		assertEquals(100, bigDemo.getHealth());
		assertFalse(emily.attackEnemy(bigDemo)); // (false because Emily has 0 ammo)
		assertEquals(50, emily.getStrengthPoints());
		assertEquals(100, bigDemo.getHealth()); // 100

		// advancing time:
		// Collectables:
		Collectable[] collectables = new Collectable[] { bigBag, smallBag, mediumBag, bigBox, smallBox, mediumBox };

		assertEquals(10, ((BagOfGems) bigBag).getNumGems());
		assertEquals(2, ((BagOfGems) smallBag).getNumGems());
		assertEquals(30, ((BoxOfRocks) bigBox).getNumAmmo());
		assertEquals(9, ((BoxOfRocks) mediumBox).getNumAmmo());

		for (Collectable c : collectables) {
			c.advanceTime();
		}

		assertEquals(10, ((BagOfGems) bigBag).getNumGems());
		assertEquals(3, ((BagOfGems) smallBag).getNumGems());
		assertEquals(29, ((BoxOfRocks) bigBox).getNumAmmo());
		assertEquals(9, ((BoxOfRocks) mediumBox).getNumAmmo());

		for (Collectable c : collectables) {
			c.advanceTime();
		}

		assertEquals(10, ((BagOfGems) bigBag).getNumGems());
		assertEquals(4, ((BagOfGems) smallBag).getNumGems());
		assertEquals(27, ((BoxOfRocks) bigBox).getNumAmmo());
		assertEquals(9, ((BoxOfRocks) mediumBox).getNumAmmo());

		// Enemies:
		Enemy[] enemies = new Enemy[] { armedClown, unarmedClown, goblin1, goblin2, fbDragon, dragon, bigDemo,
				mediumDemo, smallDemo, weakBugaboo, strongBugaboo };

		assertEquals("red", ((Goblin) goblin1).getColor());
		assertEquals(50, goblin1.getHealth());
		assertEquals(100, goblin2.getHealth());
		assertEquals("purple", ((Goblin) goblin2).getColor());
		assertTrue(((Dragon) fbDragon).isFireBreathing());
		assertEquals(100, fbDragon.getHealth());
		assertEquals(100.0, ((Demogorgon) bigDemo).getWeight(), EPSILON);
		assertEquals(100, bigDemo.getHealth());
		assertEquals(50.25, ((Bugaboo) weakBugaboo).getStrength(), EPSILON);
		assertEquals(100, weakBugaboo.getHealth());
		assertTrue(((Clown) armedClown).hasWeapon());
		assertEquals(100, armedClown.getHealth());

		for (Enemy e : enemies) {
			e.advanceTime();
		}

		assertEquals("purple", ((Goblin) goblin1).getColor());
		assertEquals(30, goblin1.getHealth());
		assertEquals(80, goblin2.getHealth());
		assertEquals("orange", ((Goblin) goblin2).getColor());
		assertFalse(((Dragon) fbDragon).isFireBreathing());
		assertEquals(90, fbDragon.getHealth());
		assertEquals(105.0, ((Demogorgon) bigDemo).getWeight(), EPSILON);
		assertEquals(100, bigDemo.getHealth());
		assertEquals(57.7875, ((Bugaboo) weakBugaboo).getStrength(), EPSILON);
		assertEquals(100, weakBugaboo.getHealth());
		assertFalse(((Clown) armedClown).hasWeapon());
		assertEquals(99, armedClown.getHealth());

		for (Enemy e : enemies) {
			e.advanceTime();
		}

		assertEquals("orange", ((Goblin) goblin1).getColor());
		assertEquals(10, goblin1.getHealth());
		assertEquals(60, goblin2.getHealth());
		assertEquals("black", ((Goblin) goblin2).getColor());
		assertTrue(((Dragon) fbDragon).isFireBreathing());
		assertEquals(80, fbDragon.getHealth());
		assertEquals(110.25, ((Demogorgon) bigDemo).getWeight(), EPSILON);
		assertEquals(100, bigDemo.getHealth());
		assertEquals(66.4556, ((Bugaboo) weakBugaboo).getStrength(), EPSILON);
		assertEquals(100, weakBugaboo.getHealth());
		assertTrue(((Clown) armedClown).hasWeapon());
		assertEquals(98, armedClown.getHealth());

		for (Enemy e : enemies) {
			e.advanceTime();
		}

		assertEquals("black", ((Goblin) goblin1).getColor());
		assertEquals(0, goblin1.getHealth());
		assertEquals(40, goblin2.getHealth());
		assertEquals("purple", ((Goblin) goblin2).getColor());
		assertFalse(((Dragon) fbDragon).isFireBreathing());
		assertEquals(70, fbDragon.getHealth());
		assertEquals(115.7625, ((Demogorgon) bigDemo).getWeight(), EPSILON);
		assertEquals(100, bigDemo.getHealth());
		assertEquals(76.42397, ((Bugaboo) weakBugaboo).getStrength(), EPSILON);
		assertEquals(100, weakBugaboo.getHealth());
		assertFalse(((Clown) armedClown).hasWeapon());
		assertEquals(97, armedClown.getHealth());

		assertTrue(robert.attackEnemy(enemies[0]));
		assertTrue(robert.attackEnemy(enemies[1]));
		assertTrue(robert.attackEnemy(enemies[2]));
		assertTrue(robert.attackEnemy(enemies[3]));
		assertTrue(robert.attackEnemy(enemies[4]));
		assertTrue(robert.attackEnemy(enemies[5]));
		assertTrue(robert.attackEnemy(enemies[6]));
		assertTrue(robert.attackEnemy(enemies[7]));
		assertTrue(robert.attackEnemy(enemies[8]));
		assertFalse(robert.attackEnemy(enemies[9]));
		assertFalse(robert.attackEnemy(enemies[10]));

		assertFalse(((Clown) armedClown).hasWeapon());
		assertEquals(77, armedClown.getHealth());
		assertEquals("red", ((Goblin) goblin1).getColor());
		assertEquals(0, goblin1.getHealth());
		assertEquals(0, goblin2.getHealth());
		assertEquals("red", ((Goblin) goblin2).getColor());
		assertFalse(((Dragon) fbDragon).isFireBreathing());
		assertEquals(95, fbDragon.getHealth());
		assertEquals(104.18625, ((Demogorgon) bigDemo).getWeight(), EPSILON);
		assertEquals(85, bigDemo.getHealth());
		assertEquals(76.42397, ((Bugaboo) weakBugaboo).getStrength(), EPSILON);
		assertEquals(100, weakBugaboo.getHealth());

		assertEquals(0, robert.getAmmo());
		assertEquals(100, robert.getStrengthPoints());
	}


	@Test
	void problem6() {
		Coin coin1 = new Coin(.25, "Quarter");
		Coin coin2 = new Coin(.10, "Dime");
		Coin coin3 = new Coin(.10, "Dime");
		Coin coin4 = new Coin(.10, "My Dime");
		Coin coin5 = new Coin(.01, "Penny");
		Coin coin6 = new Coin(.01, "Different Penny");
		Coin coin7 = new Coin(.05, "NICKEL");
		Coin coin8 = new Coin(.05, "nickel");
		Coin coin9 = new Coin(.05, "Nickel");

		assertTrue(coin1.compareTo(coin2) > 0);
		assertEquals(0, coin2.compareTo(coin3));
		assertTrue(coin3.compareTo(coin1) < 0);
		assertTrue(coin3.compareTo(coin4) < 0);
		assertTrue(coin4.compareTo(coin3) > 0);
		assertTrue(coin2.equals(coin3));
		assertFalse(coin2.equals(coin4));

		assertEquals("Value: 0.25, Name: Quarter", coin1.toString());
		assertEquals("Value: 0.1, Name: Dime", coin2.toString());
		assertEquals("Value: 0.1, Name: Dime", coin3.toString());
		assertEquals("Value: 0.1, Name: My Dime", coin4.toString());
		assertEquals("Value: 0.01, Name: Penny", coin5.toString());
		assertEquals("Value: 0.01, Name: Different Penny", coin6.toString());
		assertEquals("Value: 0.05, Name: NICKEL", coin7.toString());
		assertEquals("Value: 0.05, Name: nickel", coin8.toString());
		assertEquals("Value: 0.05, Name: Nickel", coin9.toString());

		List<Coin> coins = new ArrayList<>();
		coins.add(coin1);
		coins.add(coin2);
		coins.add(coin3);
		coins.add(coin4);
		coins.add(coin5);
		coins.add(coin6);
		coins.add(coin7);
		coins.add(coin8);
		coins.add(coin9);

		Collections.sort(coins);

		assertEquals(coin6, coins.get(0));
		assertEquals(coin5, coins.get(1));
		assertEquals(coin7, coins.get(2));
		assertEquals(coin9, coins.get(3));
		assertEquals(coin8, coins.get(4));
		assertEquals(coin2, coins.get(5));
		assertEquals(coin3, coins.get(6));
		assertEquals(coin4, coins.get(7));
		assertEquals(coin1, coins.get(8));
	}


	@Test
	void problem7() {
		Student[] students = new Student[] { new Student("Robert", 1234), new Student("Emily", 4321),
				new Student("Harry", 1111), new Student("Kelly", 18), new Student("Mike", 18), new Student("Mike", 18),
				new Student("Robert", 50000), new Student("Emily", 9832), new Student("Emily", 19),
				new Student("ROBERT", 7778) };

		// test toString:
		assertEquals("Robert, 1234", students[0].toString());
		assertEquals("Mike, 18", students[4].toString());
		assertEquals("ROBERT, 7778", students[9].toString());

		// test compareTo:
		assertTrue(students[8].compareTo(students[7]) < 0);
		assertTrue(students[1].compareTo(students[8]) > 0);
		assertTrue(students[4].compareTo(students[5]) == 0);

		// test equals:
		assertTrue(students[4].equals(students[5]));
		assertFalse(students[7].equals(students[8]));
		assertFalse(students[3].equals(students[4]));

		// test StudentFinder methods:
		assertEquals(students[8], StudentFinder.firstStudent(students));
		assertEquals(students[6], StudentFinder.lastStudent(students));

		students = new Student[] { new Student("Robert", 0) };

		assertEquals(students[0], StudentFinder.firstStudent(students));
		assertEquals(students[0], StudentFinder.lastStudent(students));
	}


	@Test
	void problems8Through10() {
		final int small = 5;
		final int neg = -10000;
		final int large = 1000000;
		final int maxBase = 36;
		NumberFormatter numFormat;

		numFormat = new DefaultFormatter();
		assertEquals("5", numFormat.format(small));
		assertEquals("-10000", numFormat.format(neg));
		assertEquals("1000000", numFormat.format(large));
		assertEquals("36", numFormat.format(maxBase));

		numFormat = new DecimalSeparatorFormatter();
		assertEquals("5", numFormat.format(small));
		assertEquals("-10,000", numFormat.format(neg));
		assertEquals("1,000,000", numFormat.format(large));
		assertEquals("36", numFormat.format(maxBase));

		numFormat = new AccountingFormatter();
		assertEquals("$5", numFormat.format(small));
		assertEquals("$(10000)", numFormat.format(neg));
		assertEquals("$1000000", numFormat.format(large));
		assertEquals("$36", numFormat.format(maxBase));

		numFormat = new BaseFormatter(2); // Binary System
		assertEquals("101", numFormat.format(small));
		assertEquals("-10011100010000", numFormat.format(neg));
		assertEquals("11110100001001000000", numFormat.format(large));
		assertEquals("100100", numFormat.format(maxBase));

		numFormat = new BaseFormatter(8); // Octal System
		assertEquals("5", numFormat.format(small));
		assertEquals("-23420", numFormat.format(neg));
		assertEquals("3641100", numFormat.format(large));
		assertEquals("44", numFormat.format(maxBase));

		numFormat = new BaseFormatter(20); // Base 20
		assertEquals("5", numFormat.format(small));
		assertEquals("-1500", numFormat.format(neg));
		assertEquals("65000", numFormat.format(large));
		assertEquals("1g", numFormat.format(maxBase));

		numFormat = new BaseFormatter(36); // Base 36
		assertEquals("5", numFormat.format(small));
		assertEquals("-7ps", numFormat.format(neg));
		assertEquals("lfls", numFormat.format(large));
		assertEquals("10", numFormat.format(maxBase));
	}

}
