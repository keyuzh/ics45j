package labs.lab2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Lab2Test {

	private final double EPSILON = 1e-3;

	@Test
	void problem1() {
		SodaCan standardCan = new SodaCan(4.83, 2.60);
		assertEquals(25.643878, standardCan.getVolume(), EPSILON);
		assertEquals(50.070704, standardCan.getSurfaceArea(), EPSILON);

		SodaCan tinyCan = new SodaCan(0.5, 0.25);
		assertEquals(0.02454369260617026, tinyCan.getVolume(), EPSILON);
		assertEquals(0.4908738521234052, tinyCan.getSurfaceArea(), EPSILON);

		SodaCan hugeCan = new SodaCan(288, 170.334);
		assertEquals(6562737.893807766, hugeCan.getVolume(), EPSILON);
		assertEquals(199689.14110728877, hugeCan.getSurfaceArea(), EPSILON);
	}


	@Test
	void problem2() {
		// Test case 1
		String input = "4155551212\n";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem2_formatPhoneNumber(new Scanner(System.in));
		String result = output.toString();
		assertEquals("Please enter a ten-digit phone number: (415) 555-1212", result);

		// Test case 2
		input = "0000000000\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem2_formatPhoneNumber(new Scanner(System.in));
		result = output.toString();
		assertEquals("Please enter a ten-digit phone number: (000) 000-0000", result);

		// Test case 3
		input = "5233039999\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem2_formatPhoneNumber(new Scanner(System.in));
		result = output.toString();
		assertEquals("Please enter a ten-digit phone number: (523) 303-9999", result);

		// Test case 4
		input = "9999999999\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem2_formatPhoneNumber(new Scanner(System.in));
		result = output.toString();
		assertEquals("Please enter a ten-digit phone number: (999) 999-9999", result);

	}


	@Test
	void problem3() {
		Balloon balloon = new Balloon();
		assertEquals(0.0, balloon.getVolume(), EPSILON);
		assertEquals(0.0, balloon.getSurfaceArea(), EPSILON);
		assertEquals(0.0, balloon.getRadius(), EPSILON);

		balloon.addAir(100);
		assertEquals(100.0, balloon.getVolume(), EPSILON);
		assertEquals(104.18794157356086, balloon.getSurfaceArea(), EPSILON);
		assertEquals(2.8794119114848606, balloon.getRadius(), EPSILON);

		balloon.addAir(100);
		assertEquals(200.0, balloon.getVolume(), EPSILON);
		assertEquals(165.38804805627186, balloon.getSurfaceArea(), EPSILON);
		assertEquals(3.6278316785978095, balloon.getRadius(), EPSILON);
	}
	
	
	@Test
	void problem4() {
		assertEquals("Input: 89877, Last 2 digits: 77, Reversed: 77, Sum: 975",
				Main.problem4_reverseAndAdd(89877));
		assertEquals("Input: 89, Last 2 digits: 89, Reversed: 98, Sum: 98",
				Main.problem4_reverseAndAdd(89));
		assertEquals("Input: 371, Last 2 digits: 71, Reversed: 17, Sum: 20",
				Main.problem4_reverseAndAdd(371));
		assertEquals("Input: 3928, Last 2 digits: 28, Reversed: 82, Sum: 121",
				Main.problem4_reverseAndAdd(3928));
		assertEquals("Input: 5999, Last 2 digits: 99, Reversed: 99, Sum: 158",
				Main.problem4_reverseAndAdd(5999));
		assertEquals("Input: 2727, Last 2 digits: 27, Reversed: 72, Sum: 99",
				Main.problem4_reverseAndAdd(2727));
		assertEquals("Number too small!", Main.problem4_reverseAndAdd(2));
	}
	
	
	@Test
	void problem5() {
        Triangle triangle1 = new Triangle(0, 5, 1.5, 2, 8, 25.92);
        assertEquals(3.3541019662496847, triangle1.getSide1Length(), EPSILON);
        assertEquals(22.39746414217467,triangle1.getSide2Length(), EPSILON);
        assertEquals(24.787424230847385,triangle1.getSide3Length(), EPSILON);
        assertEquals(2.312694531902217,triangle1.getAngle1(), EPSILON);
        assertEquals(0.7289796952097912,triangle1.getAngle2(), EPSILON);
        assertEquals(0.09991842647778622,triangle1.getAngle3(), EPSILON);
        assertEquals(50.53899033927174,triangle1.getPerimeter(), EPSILON);
        assertEquals(27.690000000000044,triangle1.getArea(), EPSILON);
        
        Triangle triangle2 = new Triangle(-5.2, -10.5, 0.005, -33.33, 16, 99.3);
        assertEquals(23.415826378755032, triangle2.getSide1Length(), EPSILON);
        assertEquals(111.82790349461087,triangle2.getSide2Length(), EPSILON);
        assertEquals(133.59100615310896,triangle2.getSide3Length(), EPSILON);
        assertEquals(2.726703271998203,triangle2.getAngle1(), EPSILON);
        assertEquals(0.3441770951688207,triangle2.getAngle2(), EPSILON);
        assertEquals(0.0707122864227689,triangle2.getAngle3(), EPSILON);
        assertEquals(268.83473602647484,triangle2.getPerimeter(), EPSILON);
        assertEquals(527.7524999999993,triangle2.getArea(), EPSILON);
	}
	
	
	@Test
	void problem6() {
		assertEquals(21, Main.problem6_playBlackjack(19, 21)); 
		assertEquals(21, Main.problem6_playBlackjack(21, 19));
		assertEquals(19, Main.problem6_playBlackjack(19, 22));
		assertEquals(19, Main.problem6_playBlackjack(19, 19));
		assertEquals(0, Main.problem6_playBlackjack(22, 22));
		assertEquals(1, Main.problem6_playBlackjack(1, 1));
		assertEquals(19, Main.problem6_playBlackjack(19, 1));
		assertEquals(19, Main.problem6_playBlackjack(1, 19));
		assertEquals(19, Main.problem6_playBlackjack(19, 220));
		assertEquals(18, Main.problem6_playBlackjack(22, 18));
	}
	
	
	@Test
	void problem7() {
		assertTrue(Main.problem7_evenlySpaced(2, 4, 6));
		assertTrue(Main.problem7_evenlySpaced(4, 6, 2));
		assertFalse(Main.problem7_evenlySpaced(4, 6, 3));
		assertTrue(Main.problem7_evenlySpaced(4, 4, 4));
		assertTrue(Main.problem7_evenlySpaced(2, 6, 4));
		assertTrue(Main.problem7_evenlySpaced(20000, 10000, 0));
		assertFalse(Main.problem7_evenlySpaced(-2, 6, 4));
		assertFalse(Main.problem7_evenlySpaced(-2, -6, 4));
		assertFalse(Main.problem7_evenlySpaced(2, 4, -6));
		assertTrue(Main.problem7_evenlySpaced(-2, -6, -4));
		assertFalse(Main.problem7_evenlySpaced(26, 26, 25));
	}
	
	
	@Test
	void problem8() {
		assertEquals("Square", (new Quadrilateral(5, 10, 15, 10, 15, 20, 5, 20)).getShapeType());
		assertEquals("None", (new Quadrilateral(5, 0, 25, 0, 30, 198, 0, 30)).getShapeType());
		assertEquals("Rectangle", (new Quadrilateral(9, -0.33, -29.25, -0.33, -29.25, 16.77, 9, 16.77)).getShapeType()); 
		assertEquals("Trapezoid", (new Quadrilateral(5, 0, 25, 0, 30, 30, 0, 30)).getShapeType());
		assertEquals("Rhombus", (new Quadrilateral(7.4315, 0, 14.863, 8.11, 7.4315, 16.22, 0, 8.11)).getShapeType());
		assertEquals("Rectangle", (new Quadrilateral(5, 10, 15, 10, 15, 30, 5, 30)).getShapeType());
		assertEquals("Parallelogram", (new Quadrilateral(0, 0, 4, 0, 3, -2, -1, -2)).getShapeType());
	}
	
	
	@Test
	void problem9() {
		// Test case 1:
		String input = "88.3 dB\n";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getSoundLevel(new Scanner(System.in));
		String result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Normal conversation", result);
		
		
		// Test case 2:
		input = "0.001 dB\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Light leaf rustling", result);
		
		
		// Test case 3:
		input = "0.049 Pa\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Normal conversation", result);
		
		
		// Test case 4:
		input = "2.5 Pa\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Jack hammer at 1 m", result);
		
		
		// Test case 5:
		input = "3233.33 dB\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Threshold of pain", result);
		
		
		// Test case 6:
		input = "-0.045 m\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Invalid unit and sound level", result);
		
		
		// Test case 7:
		input = "0.045 m\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Invalid unit", result);
		
		
		// Test case 8:
		input = "-0.045 Pa\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Invalid sound level", result);
	}
	
	
	@Test 
	void problem10() {
		Paycheck p = new Paycheck(10.5, 42, 0);
		assertEquals(462.0, p.getPay(), EPSILON); 
		
		p = new Paycheck(10.5, 42, 10);
		assertEquals(415.8, p.getPay(), EPSILON);
		
		p = new Paycheck(10.5, 40, 10);
		assertEquals(378.0, p.getPay(), EPSILON);
		
		p = new Paycheck(10.5, 33.2, 25);
		assertEquals(261.45, p.getPay(), EPSILON);
		
		p = new Paycheck(100.33, 65.5, 20);
		assertEquals(7304.024, p.getPay(), EPSILON);
		
		p = new Paycheck(0, 0, 0);
		assertEquals(0, p.getPay(), EPSILON);
		
		p = new Paycheck(0, 500, 50);
		assertEquals(0, p.getPay(), EPSILON);
		
		p = new Paycheck(500, 0, 50);
		assertEquals(0, p.getPay(), EPSILON);
	}

}
