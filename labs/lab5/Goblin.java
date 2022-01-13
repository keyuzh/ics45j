package labs.lab5;

/**
 * A goblin enemy
 *
 */

public class Goblin extends Enemy {

	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Constructs a new Goblin with color purple
	 */
	public Goblin() {
		// FILL IN
	}


	public String getColor() {
		return ""; // FIX ME
	}


	/**
	 * 1) changes the Goblin's color to "red"; 2) decrements the Goblin's health by
	 * 50; 3) returns 50 (the number of strength points awarded to a player for
	 * attacking this Goblin)
	 * 
	 * @return 50 (the number of strength points awarded to a player for attacking
	 *         this Goblin)
	 */
	public int attack() {
		return -1; // FIX ME
	}


	/**
	 * 1) decrements the Goblin's health by 20; 2) changes Goblin's color to the next
	 * one in the cycle purple, orange, black, purple, orange, black, ..., OR if the
	 * Goblin is red (from a stomp), starts the cycle over again with purple
	 */
	public void advanceTime() {
		// FILL IN
	}

}