package labs.lab5;

/**
 * A dragon enemy
 *
 */

public class Dragon extends Enemy {

	// ADD YOUR INSTANCE VARIABLES EHRE

	/**
	 * Constructs a new Dragon
	 * 
	 * @param fireBreathing whether or not it's fire-breathing
	 */
	public Dragon(boolean fireBreathing) {
		// FILL IN
	}


	public boolean isFireBreathing() {
		return false; // FIX ME
	}


	/**
	 * 1) increments the Dragon's health by 25; 2) returns -25 (the number of
	 * strength points deducted for a player attacking this Dragon)
	 * 
	 * @return -25 (the number of strength points deducted for a player attacking
	 *         this Dragon)
	 */
	public int attack() {
		return -1; // FIX ME
	}


	/**
	 * 1) toggles fireBreathing from true to false or vice-versa; 2) decrements the
	 * Dragon's health by 10
	 */
	public void advanceTime() {
		// FILL IN
	}

}