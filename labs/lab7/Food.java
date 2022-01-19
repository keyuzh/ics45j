package labs.lab7;

import java.awt.Point;

/**
 * Class representing a food item in the survival game
 */
public class Food implements Comparable {

	// ADD YOUR INSTANCE VARIABLES HERE
	Point location;
	Player player;
	String description;
	int energyValue;

	/**
	 * Constructs a new food item
	 * 
	 * @param location    location of the food item
	 * @param player      player in the game
	 * @param description description of the food item
	 * @param energyValue energy value of the food item
	 */
	public Food(Point location, Player player, String description, int energyValue) {
		this.location = location;
		this.player = player;
		this.description = description;
		this.energyValue = energyValue;
	}


	public Point getLocation() {
		return location;
	}


	public String getDescription() {
		return description;
	}


	/**
	 * Compares based on the net energy value of this food item to the player; A
	 * higher net energy means a more urgent priority.
	 */
	@Override
	public int compareTo(Object otherObject) {
		Food other = (Food) otherObject;
		return (int) (other.getNetEnergy() - getNetEnergy());
	}


	/**
	 * Returns a string representation of the food in the format: 
	 * "[description] at location [x], [y], energy value [energy value]
	 */
	@Override
	public String toString() {
		return String.format("%s at location %d, %d, energy value %d", description, location.x, location.y, energyValue);
	}


	/**
	 * Calculates the net energy gain/loss to the player of getting this food item.
	 * Net energy = (food energy value) - (distance from food (rounded to the nearest int))
	 * 
	 * @return	the net energy
	 */
	public long getNetEnergy() {
		long distance = Math.round(Math.sqrt(Math.pow(location.getX()-player.getLocation().getX(), 2) + Math.pow(location.getY()-player.getLocation().getY(), 2) ));
//		long distance = (int)(Math.sqrt(Math.pow(location.getX()-player.getLocation().getX(), 2) + Math.pow(location.getY()-player.getLocation().getY(), 2) ));
		return energyValue - distance;
	}
}