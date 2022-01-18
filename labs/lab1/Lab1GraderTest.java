package labs.lab1;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors


class Lab1GraderTest {

	private final double EPSILON = 1e-3;

	private static double score = 100;
	private static String errors;
	
	private double problem1Points = (double)10 / 11;
	private double problem2Points = (double)10 / 7;
	private double problem3Points = (double)10 / 9;
	private double problem4Points = (double)10 / 8;
	private double problem5Points = (double)10 / 5;
	private double problem6Points = (double)10 / 12;
	private double problem7Points = (double)10 / 16;
	private double problem8Points = (double)10 / 7;
	private double problem9Points = (double)10 / 10;
	private double problem10Points = (double)10 / 6;

	@Test
	void problem1_1() {
		try {
			assertEquals("lloHe", Main.problem1_remove2("HelloHe"));
		} catch (AssertionError | Exception e) {
            score -= problem1Points;
            errors+="Error in 1_1\n" + e;
            System.err.println("Error in 1_1\n" + e);
        }
	}
	
	
	@Test
	void problem1_2() {
		try {
			assertEquals("HelloHi", Main.problem1_remove2("HelloHi"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 1_2\n" + e;
            score -= problem1Points;
            System.err.println("Error in 1_2\n" + e);
        }
	}
	
	
	@Test
	void problem1_3() {
		try {
			assertEquals("Hi", Main.problem1_remove2("HiHi"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 1_3\n" + e;
            score -= problem1Points;
            System.err.println("Error in 1_3\n" + e);
        }
	}
	
	
	@Test
	void problem1_4() {
		try {
			assertEquals("", Main.problem1_remove2("Hi"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 1_4\n" + e;
            score -= problem1Points;
            System.err.println("Error in 1_4\n" + e);
        }
	}
	
	
	@Test
	void problem1_5() {
		try {
			assertEquals("hihI", Main.problem1_remove2("hihI"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 1_5\n" + e;
            score -= problem1Points;
            System.err.println("Error in 1_5\n" + e);
        }
	}
	
	
	@Test
	void problem1_6() {
		try {
			assertEquals("aSa", Main.problem1_remove2("aSa"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 1_6\n" + e;
            score -= problem1Points;
            System.err.println("Error in 1_6\n" + e);
        }
	}
	
	
	@Test
	void problem1_7() {
		try {
			assertEquals("a", Main.problem1_remove2("aaa"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 1_7\n" + e;
            score -= problem1Points;
            System.err.println("Error in 1_7\n" + e);
        }
	}
	
	
	@Test
	void problem1_8() {
		try {
			assertEquals("", Main.problem1_remove2("xx"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 1_8\n" + e;
            score -= problem1Points;
            System.err.println("Error in 1_8\n" + e);
        }
	}
	
	
	@Test
	void problem1_9() {
		try {
			assertEquals("a", Main.problem1_remove2("a"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 1_9\n" + e;
            score -= problem1Points;
            System.err.println("Error in 1_9\n" + e);
        }
	}
	
	@Test
	void problem1_10() {
		try {
			assertEquals("", Main.problem1_remove2(""));
		} catch (AssertionError | Exception e) {
			errors+="Error in 1_10\n" + e;
            score -= problem1Points;
            System.err.println("Error in 1_10\n" + e);
        }
	}

	@Test
	void problem1_11() {
		try {
			assertEquals("Robert", Main.problem1_remove2("Robert"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 1_11\n" + e;
            score -= problem1Points;
            System.err.println("Error in 1_11\n" + e);
        }
	}


	@Test
	void problem2_1() {
		try {
			assertEquals("loHi", Main.problem2_shortConcat("Hello", "Hi"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 2_1\n" + e;
            score -= problem2Points;
            System.err.println("Error in 2_1\n" + e);
        }
	}

	@Test
	void problem2_2() {
		try {
			assertEquals("ellojava", Main.problem2_shortConcat("Hello", "java"));
		} catch (AssertionError | Exception e) {
            errors+="Error in 2_2\n" + e;
            score -= problem2Points;
            System.err.println("Error in 2_2\n" + e);
        }
	}

	@Test
	void problem2_3() {
		try {
			assertEquals("javaello", Main.problem2_shortConcat("java", "Hello"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 2_3\n" + e;
            score -= problem2Points;
            System.err.println("Error in 2_3\n" + e);
        }
	}

	@Test
	void problem2_4() {
		try {
			assertEquals("ey", Main.problem2_shortConcat("ode", "y"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 2_4\n" + e;
            score -= problem2Points;
            System.err.println("Error in 2_4\n" + e);
        }
	}

	@Test
	void problem2_5() {
		try {
			assertEquals("ye", Main.problem2_shortConcat("y", "ode"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 2_5\n" + e;
            score -= problem2Points;
            System.err.println("Error in 2_5\n" + e);
        }
	}

	@Test
	void problem2_6() {
		try {
			assertEquals("", Main.problem2_shortConcat("egg", ""));
		} catch (AssertionError | Exception e) {
			errors+="Error in 2_6\n" + e;
            score -= problem2Points;
            System.err.println("Error in 2_6\n" + e);
        }
	}

	@Test
	void problem2_7() {
		try {
			assertEquals("cdeefg", Main.problem2_shortConcat("cde", "efg"));
		} catch (AssertionError | Exception e) {
			errors+="Error in 2_7\n" + e;
            score -= problem2Points;
            System.err.println("Error in 2_7\n" + e);
        }
	}

	@Test
	void problem3_1() {
		// numPics = 5:
		int numPics = 5;
		String numString = Main.problem3_slotMachine(numPics);
		Scanner s = new Scanner(numString);
		ArrayList<Integer> nums = new ArrayList<>();
		while (s.hasNext()) {
			nums.add(s.nextInt());
		}

		// make sure it generated 4 numbers:
		try {
		assertEquals(4, nums.size());
		} catch (AssertionError | Exception e) {
			errors+="Error in 3_1\n" + e;
            score -= problem3Points;
            System.err.println("Error in 3_1\n" + e);
		}

		// make sure all nums are between the min and max:
		for (Integer num : nums) {
			try {
			assertTrue(num >= 1);
			} catch (AssertionError | Exception e) {
			errors+="Error in 3_1\n" + e;
            score -= problem3Points;
            System.err.println("Error in 3_1\n" + e);
			}
			try {
			assertTrue(num <= numPics);
			} catch (AssertionError | Exception e) {
			errors+="Error in 3_1\n" + e;
            score -= problem3Points;
            System.err.println("Error in 3_1\n" + e);
			}
		}
		s.close();
	}

	@Test
	void problem3_2() {
		// numPics = 2999:
		int numPics = 2999;
		String numString = Main.problem3_slotMachine(numPics);
		Scanner s = new Scanner(numString);
		ArrayList<Integer> nums = new ArrayList<>();
		while (s.hasNext()) {
			nums.add(s.nextInt());
		}

		// make sure it generated 4 numbers:
		try {
		assertEquals(4, nums.size());
		} catch (AssertionError | Exception e) {
			errors+="Error in 3_2\n" + e;
            score -= problem3Points;
            System.err.println("Error in 3_2\n" + e);
		}

		// make sure all nums are between the min and max:
		for (Integer num : nums) {
			try {
			assertTrue(num >= 1);
			} catch (AssertionError | Exception e) {
			errors+="Error in 3_2\n" + e;
            score -= problem3Points;
            System.err.println("Error in 3_2\n" + e);
			}
			try {
			assertTrue(num <= numPics);
			} catch (AssertionError | Exception e) {
			errors+="Error in 3_2\n" + e;
            score -= problem3Points;
            System.err.println("Error in 3_2\n" + e);
			}
		}
		s.close();
	}

	@Test
	void problem3_3() {
		// numPics = 2:
		int numPics = 2;
		String numString = Main.problem3_slotMachine(numPics);
		Scanner s = new Scanner(numString);
		ArrayList<Integer> nums = new ArrayList<>();
		while (s.hasNext()) {
			nums.add(s.nextInt());
		}

		// make sure it generated 4 numbers:
		try {
		assertEquals(4, nums.size());
		} catch (AssertionError | Exception e) {
			errors+="Error in 3_3\n" + e;
            score -= problem3Points;
            System.err.println("Error in 3_3\n" + e);
		}

		// make sure all nums are between the min and max:
		for (Integer num : nums) {
			try {
			assertTrue(num >= 1);
			} catch (AssertionError | Exception e) {
			errors+="Error in 3_4\n" + e;
            score -= problem3Points;
            System.err.println("Error in 3_4\n" + e);
			}
			try {
			assertTrue(num <= numPics);
			} catch (AssertionError | Exception e) {
			errors+="Error in 3_5\n" + e;
            score -= problem3Points;
            System.err.println("Error in 3_5\n" + e);
			}
		}
		s.close();
	}
	
	@Test 
	void problem4_1() {
		try {
			assertEquals("treoR", Main.problem4_deleteAndReverse("Robert", 2));
		} catch (AssertionError | Exception e) {
			errors+="Error in 4_1\n" + e;
            score -= problem4Points;
            System.err.println("Error in 4_1\n" + e);
        }
	}

	@Test
	void problem4_2() {
		try {
			assertEquals("trebo", Main.problem4_deleteAndReverse("Robert", 0));
		} catch (AssertionError | Exception e) {
			errors+="Error in 4_2\n" + e;
            score -= problem4Points;
            System.err.println("Error in 4_2\n" + e);
        }
	}

	@Test
	void problem4_3() {
		try {
			assertEquals("reboR", Main.problem4_deleteAndReverse("Robert", 5));
		} catch (AssertionError | Exception e) {
			errors+="Error in 4_3\n" + e;
            score -= problem4Points;
            System.err.println("Error in 4_3\n" + e);
        }
	}

	@Test
	void problem4_4() {
		try {
			assertEquals("YE", Main.problem4_deleteAndReverse("HEY", 0));
		} catch (AssertionError | Exception e) {
			errors+="Error in 4_4\n" + e;
            score -= problem4Points;
            System.err.println("Error in 4_4\n" + e);
        }
	}

	@Test
	void problem4_5() {
		try {
			assertEquals("YH", Main.problem4_deleteAndReverse("HEY", 1));
		} catch (AssertionError | Exception e) {
			errors+="Error in 4_5\n" + e;
            score -= problem4Points;
            System.err.println("Error in 4_5\n" + e);
        }
	}

	@Test
	void problem4_6() {
		try {
			assertEquals("", Main.problem4_deleteAndReverse("Y", 0));
		} catch (AssertionError | Exception e) {
			errors+="Error in 4_6\n" + e;
            score -= problem4Points;
            System.err.println("Error in 4_6\n" + e);
        }
	}
	
	@Test
	void problem4_7() {
		try {
			assertEquals("i", Main.problem4_deleteAndReverse("hi", 0));
		} catch (AssertionError | Exception e) {
			errors+="Error in 4_7\n" + e;
            score -= problem4Points;
            System.err.println("Error in 4_7\n" + e);
        }
	}
	
	@Test
	void problem4_8() {
		try {
			assertEquals("h", Main.problem4_deleteAndReverse("hi", 1));
		} catch (AssertionError | Exception e) {
			errors+="Error in 4_8\n" + e;
            score -= problem4Points;
            System.err.println("Error in 4_8\n" + e);
        }
	}

	@Test
	void problem5_1() {
		try {
			assertTrue(new BigDecimal(
				"-9.610000000000000550670620214077651938730359583164929117285652827862296732064351090230047702789306640625")
						.equals(Main.problem5_bigPowerNegate(new BigDecimal(3.1), 2)));
		} catch (AssertionError | Exception e) {
			errors+="Error in 5_1\n" + e;
			score -= problem5Points;
			System.err.println("Error in 5_1\n" + e);
		}
	}

	@Test
	void problem5_2() {
		try {
			assertTrue(new BigDecimal(
				"0.007916293657000000587393385931278558904560168021331181838069343034723826023096811683978266027338361275704885165065885279929262796638766985779511742293834686279296875")
						.equals(Main.problem5_bigPowerNegate(new BigDecimal(-0.1993), 3)));
		} catch (AssertionError | Exception e) {
			errors+="Error in 5_2\n" + e;
			score -= problem5Points;
			System.err.println("Error in 5_2\n" + e);
		}
	}

	@Test
	void problem5_3() {
		try {
			assertTrue(new BigDecimal(
				"-9453529591320953.72957178735145919339954101592137687052611699540982668019762429129774880708606363011469913534638642200087975733527338525018416431081877168468948993054507525862520372790018196063711709801337274912965493211538535801744629307310747020273186548595370012002327021520879242282964734817677544461381930035269708541045399616541649226290379426362875392442219890654087066650390625")
						.equals(Main.problem5_bigPowerNegate(new BigDecimal(99.3), 8)));
		} catch (AssertionError | Exception e) {
			errors+="Error in 5_3\n" + e;
			score -= problem5Points;
			System.err.println("Error in 5_3\n" + e);
		}
	}

	@Test
	void problem5_4() {
		try {
			assertTrue(new BigDecimal(
					"30077.329463299000577247869301800168669028352374304281450492448339264841575079783564307633144484345172383200732457719794865624862723052501678466796875")
							.equals(Main.problem5_bigPowerNegate(new BigDecimal(-31.099), 3)));
		} catch (AssertionError | Exception e) {
			errors+="Error in 5_4\n" + e;
			score -= problem5Points;
			System.err.println("Error in 5_4\n" + e);
		}
	}

	@Test
	void problem5_5() {
		try {
			assertTrue(new BigDecimal(
					"-1").equals(Main.problem5_bigPowerNegate(new BigDecimal(3), 0)));
		} catch (AssertionError | Exception e) {
			errors+="Error in 5_5\n" + e;
			score -= problem5Points;
			System.err.println("Error in 5_5\n" + e);
		}
	}


	@Test
	void problem6() {
		Circuit wiring = new Circuit();

		try {
			assertEquals(0, wiring.getSwitchState(1));
		} catch (AssertionError | Exception e) {
			errors+="Error in getting initial state of switch 1\n" + e;
			score -= problem6Points;
			System.err.println("Error in getting initial state of switch 1\n" + e);
		}
		
		try {
			assertEquals(0, wiring.getSwitchState(2));
		} catch (AssertionError | Exception e) {
			errors+="Error in getting initial state of switch 2\n" + e;
			score -= problem6Points;
			System.err.println("Error in getting initial state of switch 2\n" + e);
		}
		
		try {
			assertEquals(0, wiring.getLampState());
		} catch (AssertionError | Exception e) {
			errors+="Error in getting initial state of lamp\n" + e;
			score -= problem6Points;
			System.err.println("Error in getting initial state of lamp\n" + e);
		}
		
		wiring.toggleSwitch(2);
		
		try {
			assertEquals(0, wiring.getSwitchState(1));
		} catch (AssertionError | Exception e) {
			errors+="Error in getting state of switch 1\n" + e;
			score -= problem6Points;
			System.err.println("Error in getting state of switch 1\n" + e);
		}
		
		try {
			assertEquals(1, wiring.getSwitchState(2));
		} catch (AssertionError | Exception e) {
			errors+="Error in getting state of switch 2\n" + e;
			score -= problem6Points;
			System.err.println("Error in getting state of switch 2\n" + e);
		}
		
		try {
			assertEquals(1, wiring.getLampState());
		} catch (AssertionError | Exception e) {
			errors+="Error in getting the state of lamp\n" + e;
			score -= problem6Points;
			System.err.println("Error in getting the state of lamp\n" + e);
		}
		
		wiring.toggleSwitch(1);
		
		try {
			assertEquals(1, wiring.getSwitchState(1));
		} catch (AssertionError | Exception e) {
			errors+="Error in getting state of switch 1\n" + e;
			score -= problem6Points;
			System.err.println("Error in getting state of switch 1\n" + e);
		}
		
		try {
			assertEquals(1, wiring.getSwitchState(2));
		} catch (AssertionError | Exception e) {
			errors+="Error in getting state of switch 2\n" + e;
			score -= problem6Points;
			System.err.println("Error in getting state of switch 2\n" + e);
		}
		
		try {
			assertEquals(0, wiring.getLampState());
		} catch (AssertionError | Exception e) {
			errors+="Error in getting the state of lamp\n" + e;
			score -= problem6Points;
			System.err.println("Error in getting the state of lamp\n" + e);
		}
		
		wiring.toggleSwitch(1);
		
		try {
			assertEquals(0, wiring.getSwitchState(1));
		} catch (AssertionError | Exception e) {
			errors+="Error in getting state of switch 1\n" + e;
			score -= problem6Points;
			System.err.println("Error in getting state of switch 1\n" + e);
		}
		
		try {
			assertEquals(1, wiring.getSwitchState(2));
		} catch (AssertionError | Exception e) {
			errors+="Error in getting state of switch 2\n" + e;
			score -= problem6Points;
			System.err.println("Error in getting state of switch 2\n" + e);
		}
		
		try {
			assertEquals(1, wiring.getLampState());
		} catch (AssertionError | Exception e) {
			errors+="Error in getting the state of lamp\n" + e;
			score -= problem6Points;
			System.err.println("Error in getting the state of lamp\n" + e);
		}
	}	
	
	

	@Test
	void problem7() {
		SavingsAccount momsSavings = new SavingsAccount(15000, 10);

		try {
			assertEquals(15000.0, momsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_1\n" + e;
			score -= problem7Points;
			System.out.println("Error in 7_1\n" + e);
		}

		try {
			momsSavings.addInterest();
			assertEquals(16500.0, momsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_2\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_2\n" + e);
		}

		try {
			momsSavings.addInterest();
			assertEquals(18150.0, momsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_3\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_3\n" + e);
		}

		try {
			momsSavings.addInterest();
			momsSavings.addInterest();
			assertEquals(21961.5, momsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_4\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_4\n" + e);
		}

		SavingsAccount dadsSavings = new SavingsAccount(0, 50);
		try {
			assertEquals(0, dadsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_5\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_5\n" + e);
		}

		try {
			dadsSavings.addInterest();
			assertEquals(0, dadsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_6\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_6\n" + e);
		}

		try {
			dadsSavings.deposit(100);
			assertEquals(100, dadsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_7\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_7\n" + e);
		}

		try {
			dadsSavings.addInterest();
			assertEquals(150, dadsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_8\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_8\n" + e);
		}

		try {
			dadsSavings.withdraw(30);
			assertEquals(120, dadsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_9\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_9\n" + e);
		}

		try {
			dadsSavings.addInterest();
			assertEquals(180, dadsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_10\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_10\n" + e);
		}

		try {
			dadsSavings.addInterest();
			assertEquals(270, dadsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_11\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_11\n" + e);
		}

		try {
			dadsSavings.withdraw(0.5);
			assertEquals(269.5, dadsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_12\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_12\n" + e);
		}

		try {
			assertEquals(3, dadsSavings.getNumTransactions(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_13\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_13\n" + e);
		}

		try {
			assertEquals(21961.5, momsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_14\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_14\n" + e);
		}

		try {
			dadsSavings.withdraw(dadsSavings.getBalance());
			assertEquals(0, dadsSavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_15\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_15\n" + e);
		}	
		
		SavingsAccount mySavings = new SavingsAccount();
		try {
			assertEquals(0, mySavings.getBalance(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 7_16\n" + e;
			score -= problem7Points;
			System.err.println("Error in 7_16\n" + e);
		}
	}


	@Test
	void problem8() {
		Moth gypsy = new Moth(10);
		gypsy.moveToLight(0);
		
		try {
			assertEquals(5.0, gypsy.getPosition(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 8_1\n" + e;
			score -= problem8Points;
			System.err.println("Error in 8_1\n" + e);
		}
		
		gypsy.moveToLight(10);
		
		try {
			assertEquals(7.5, gypsy.getPosition(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 8_2\n" + e;
			score -= problem8Points;
			System.err.println("Error in 8_2\n" + e);
		}
		
		gypsy.moveToLight(0);
		
		try {
			assertEquals(3.75, gypsy.getPosition(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 8_3\n" + e;
			score -= problem8Points;
			System.err.println("Error in 8_3\n" + e);
		}
		
		Moth monte = new Moth(20.5);
		monte.moveToLight(10);
		
		try {
			assertEquals(15.25, monte.getPosition(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 8_4\n" + e;
			score -= problem8Points;
			System.err.println("Error in 8_4\n" + e);
		}
		monte.moveToLight(10.65);
		
		try {
			assertEquals(12.95, monte.getPosition(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 8_5\n" + e;
			score -= problem8Points;
			System.err.println("Error in 8_5\n" + e);
		}
		
		monte.moveToLight(0);
		
		try {
			assertEquals(6.475, monte.getPosition(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 8_6\n" + e;
			score -= problem8Points;
			System.err.println("Error in 8_6\n" + e);
		}
		
		monte.moveToLight(100.52);
		
		try {
			assertEquals(53.4975, monte.getPosition(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 8_7\n" + e;
			score -= problem8Points;
			System.err.println("Error in 8_7\n" + e);
		}
	}


	@Test
	void problem9() {
		Battery battery1 = new Battery(100.0);
		
		try {
			assertEquals(100.0, battery1.getRemainingCapacity(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 9_1\n" + e;
			score -= problem9Points;
			System.err.println("Error in 9_1\n" + e);
		}
		
		battery1.drain(23.4);
		battery1.drain(9.7);
		
		try {
			assertEquals(66.9, battery1.getRemainingCapacity(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 9_2\n" + e;
			score -= problem9Points;
			System.err.println("Error in 9_2\n" + e);
		}
		
		battery1.charge();
		
		try {
			assertEquals(100.0, battery1.getRemainingCapacity());
		} catch (AssertionError | Exception e) {
			errors+="Error in 9_3\n" + e;
			score -= problem9Points;
			System.err.println("Error in 9_3\n" + e);
		}
		
		Battery battery2 = new Battery(51.75);
		
		try {
			assertEquals(51.75, battery2.getRemainingCapacity(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 9_4\n" + e;
			score -= problem9Points;
			System.err.println("Error in 9_4\n" + e);
		}
		
		battery2.drain(50.75);
		
		try {
			assertEquals(1.0, battery2.getRemainingCapacity(), EPSILON);
		} catch (AssertionError | Exception e) {
			errors+="Error in 9_5\n" + e;
			score -= problem9Points;
			System.err.println("Error in 9_5\n" + e);
		}
		
		battery2.charge();
		
		try {
			assertEquals(51.75, battery2.getRemainingCapacity());
		} catch (AssertionError | Exception e) {
			errors+="Error in 9_6\n" + e;
			score -= problem9Points;
			System.err.println("Error in 9_6\n" + e);
		}
		
		battery2.drain(1.5);
		
		try {
			assertEquals(50.25, battery2.getRemainingCapacity());
		} catch (AssertionError | Exception e) {
			errors+="Error in 9_7\n" + e;
			score -= problem9Points;
			System.err.println("Error in 9_7\n" + e);
		}
		
		battery2.charge();
		
		try {
			assertEquals(51.75, battery2.getRemainingCapacity());
		} catch (AssertionError | Exception e) {
			errors+="Error in 9_8\n" + e;
			score -= problem9Points;
			System.err.println("Error in 9_8\n" + e);
		}
		
		battery2.charge();
		
		try {
			assertEquals(51.75, battery2.getRemainingCapacity());
		} catch (AssertionError | Exception e) {
			errors+="Error in 9_9\n" + e;
			score -= problem9Points;
			System.err.println("Error in 9_9\n" + e);
		}
		
		battery2.drain(0);
		
		try {
			assertEquals(51.75, battery2.getRemainingCapacity());
		} catch (AssertionError | Exception e) {
			errors+="Error in 9_10\n" + e;
			score -= problem8Points;
			System.err.println("Error in 9_10\n" + e);
		}
		
	}


	@Test
	void problem10() {
		Greeter greeter1 = new Greeter("World");
		
		try {
			assertEquals("Hello, World", greeter1.sayHello());
		} catch (AssertionError | Exception e) {
			errors+="Error in 10_1\n" + e;
			score -= problem10Points;
			System.err.println("Error in 10_1\n" + e);
		}
		
		try {
			assertEquals("Goodbye, World", greeter1.sayGoodbye());
		} catch (AssertionError | Exception e) {
			errors+="Error in 10_2\n" + e;
			score -= problem10Points;
			System.err.println("Error in 10_2\n" + e);
		}
		
		Greeter greeter2 = new Greeter("Emily");
		
		try {
			assertEquals("Hello, Emily", greeter2.sayHello());
		} catch (AssertionError | Exception e) {
			errors+="Error in 10_3\n" + e;
			score -= problem10Points;
			System.err.println("Error in 10_3\n" + e);
		}
		
		try {
			assertEquals("Goodbye, Emily", greeter2.sayGoodbye());
		} catch (AssertionError | Exception e) {
			errors+="Error in 10_4\n" + e;
			score -= problem10Points;
			System.err.println("Error in 10_4\n" + e);
		}
		
		Greeter greeter3 = new Greeter(" ");
		
		try {
			assertEquals("Hello,  ", greeter3.sayHello());
		} catch (AssertionError | Exception e) {
			errors+="Error in 10_5\n" + e;
			score -= problem10Points;
			System.err.println("Error in 10_5\n" + e);
		}
		
		try {
			assertEquals("Goodbye,  ", greeter3.sayGoodbye());
		} catch (AssertionError | Exception e) {
			errors+="Error in 10_6\n" + e;
			score -= problem10Points;
			System.err.println("Error in 10_6\n" + e);
		}	
		
	}
	
	
    @AfterAll
    public static void print() {
    	 System.err.println("total_score: " + score);
         Logger log = Logger.getLogger(Lab1GraderTest.class.getName());
         log.info("total_score: " + score);

 		try {
 			File myObj = new File("filename.txt");
 			if (myObj.createNewFile()) {
 			  System.err.println("File created: " + myObj.getName());
 			} else {
 			  System.err.println("File already exists.");
 			}
 		} 
 		catch (IOException e) {
 			System.err.println("An error occurred.");
 			e.printStackTrace();
 		}

 		try {
 			FileWriter myWriter = new FileWriter("filename.txt");
 			myWriter.write("total_score: " + score);
 			myWriter.close();
 			System.err.println("Successfully wrote to the file.");
 		} 
 		catch (IOException e) {
 			System.err.println("An error occurred.");
 			e.printStackTrace();
 		}
 		
 		try {
 			File myObj = new File("errors_filename.txt");
 			if (myObj.createNewFile()) {
 			  System.err.println("Error File created: " + myObj.getName());
 			} else {
 			  System.err.println("Error File already exists.");
 			}
 		} 
 		catch (IOException e) {
 			System.err.println("An error occurred.");
 			e.printStackTrace();
 		}

 		try {
 			FileWriter myWriter = new FileWriter("errors_filename.txt");
 			myWriter.write(errors);
 			myWriter.close();
 			System.err.println("Successfully wrote to the error file.");
 		} 
 		catch (IOException e) {
 			System.err.println("An error occurred while writing to error file.");
 			e.printStackTrace();
 		}
    }

}