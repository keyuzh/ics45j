package labs.lab5;

/**
 * Represents an enemy in the game
 *
 */

public abstract class Enemy implements Attackable {

	// ADD YOUR INSTANCE VARIABLES HERE
	private int health;

	/**
	 * Constructs a new Enemy with health = 100
	 */
	public Enemy() {
		health = 100;
	}


	public int getHealth() {
        return health;
	}


	/**
	 * Sets health to the given amount, within the bounds of 0 and 100 (inclusive).
	 * If the given amount is > 100, sets it to 100. If the given amount is < 0,
	 * sets it to 0.
	 * 
	 * @param health the new health
	 */
	public void setHealth(int health) {
		this.health = Math.min(100, Math.max(0, health));
	}

}