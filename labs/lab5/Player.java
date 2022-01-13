package labs.lab5;

/**
 * Player in the battle game
 *
 */
public class Player {

	// ADD YOUR INSTANCE VARIABLES HERE
	private String name;
	private int strengthPoints, ammo;

	/**
	 * Constructs a new Player with the given name, 0 strength points, and 0 ammo
	 * 
	 * @param name name of the player
	 */
	public Player(String name) {
        this.name = name;
		strengthPoints = 0;
		ammo = 0;
	}


	public String getName() {
        return name;
	}


	public int getStrengthPoints() {
        return strengthPoints;
	}


	public int getAmmo() {
        return ammo;
	}


	/**
	 * If the item is a PowerUp: Collects the given PowerUp if it's not already
	 * collected, and increments the player's strength points by the number of
	 * points the PowerUp is worth
	 *
	 * // TODO: what if player doesn't have enough strength points, do we collect or not?
	 * If the item is Ammo: Collects the given ammo if it's not already collected,
	 * and if the player has enough strength points (each pound of ammo requires 10
	 * strength points); adds to the player's ammo the number of items in the ammo
	 * 
	 * @param c the item to collect
	 * 
	 * @return whether or not the item was collected
	 */
	public boolean collectItem(Collectable c) {
        if ((c instanceof PowerUp) && (!c.isCollected())) {
            strengthPoints += c.collect();
            return true;
		}
		else if ((c instanceof Ammo) && (!c.isCollected()) && (getStrengthPoints() > 10.0 * ((Ammo) c).getWeight())) {
            ammo += c.collect();
            return true;
		}
		return false;
	}


	/**
	 * If the Player has ammo, attacks the given enemy with one ammo (and uses up
	 * one ammo)
	 * 
	 * @param enemy the Enemy to attack
	 * 
	 * @return whether or not the Enemy was attacked
	 */
	public boolean attackEnemy(Enemy enemy) {
        if (ammo > 0) {
			strengthPoints += enemy.attack();
			ammo--;
			return true;
		}
		return false;
	}

}