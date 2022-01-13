package labs.lab5;

/**
 * Represents ammo that the player can pick up and use to attack enemies
 *
 */

public abstract class Ammo implements Collectable {

	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * constructs a new Ammo with the given weight
	 * 
	 * @param weight weight of ammo (in pounds)
	 */
	public Ammo(double weight) {
		// FILL IN
	}


	public double getWeight() {
		return -1.0; // FIX ME
	}


	public void setWeight(double weight) {
		// FILL IN
	}


	/**
	 * returns the number of ammo (how many attacks can come from this Ammo)
	 * 
	 * @return the number of ammo (how many attacks can come from this Ammo)
	 */
	public abstract int getNumAmmo();

}