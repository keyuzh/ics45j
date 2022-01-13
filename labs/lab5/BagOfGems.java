package labs.lab5;

/**
 * Represents a bag of gems that the player can collect
 *
 */

public class BagOfGems extends PowerUp {

	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Constructs a new BagOfGems with: 1) its initial point value equal to 5 times
	 * the number of gems (each gem is worth 5 points); 2) the given number of gems;
	 * 3) its status as not collected
	 * 
	 * @param numGems number of gems in this BagOfGems
	 */
	public BagOfGems(int numGems) {
		super(-1); // FIX ME
	}


	/**
	 * Returns the number of gems in this BagOfGems
	 * 
	 * @return the number of gems in this BagOfGems
	 */
	public int getNumGems() {
		return -1; // FIX ME
	}


	/**
	 * Returns whether or not this item has been collected
	 */
	public boolean isCollected() {
		return false; // FIX ME
	}


	/**
	 * If this BagOfGems is not already collected, sets its status to collected, and
	 * returns the number of points this BagOfGems is worth.
	 * 
	 * If it is already collected, returns 0.
	 */
	public int collect() {
		return -1; // FIX ME
	}


	/**
	 * These are magical, multiplying gems, so increments the number of gems in this
	 * BagOfGems by 1, only if it hasn't been collected yet. If it's already been
	 * collected, there is no change.
	 */
	public void advanceTime() {
		// FILL IN
	}
}