package labs.lab7;

import java.awt.*;
import java.util.PriorityQueue;

/**
 * Represents a player in the survival game
 *
 */
public class Player {

	private Point location;
	private int energy;
	private PriorityQueue<Food> foods; // foods in the world

	/**
	 * Constructs a new player with location 0, 0 and energy 100
	 */
	public Player() {
		location = new Point();
		energy = 100;
		foods = new PriorityQueue<>(Food::compareTo);
	}


	public Point getLocation() {
		return location;
	}


	public int getEnergy() {
		return energy;
	}


	public void setEnergy(int newEnergy) {
		energy = newEnergy;
	}


	/**
	 * Adds the given food item to this player's priority queue
	 * 
	 * @param f the food item
	 */
	public void addFoodToQueue(Food f) {
		foods.add(f);
	}


	/**
	 * Moves player to location of food with highest priority and eats it (removes
	 * it from the queue). Updates player's energy accordingly from the net energy
	 * value of the food.
	 * 
	 * Causes the food queue to be updated (all items removed and re-added), since
	 * their priorities have changed based on the player's changed location
	 * 
	 * @return the food with highest priority
	 */
	public Food getFood() {
		if (foods.isEmpty()) {
			return null;
		}
		Food toEat = foods.remove();
		setEnergy((int) (getEnergy() + toEat.getNetEnergy()));
		location = toEat.getLocation();
		PriorityQueue<Food> temp = new PriorityQueue<>();
		while (!foods.isEmpty()) {
			temp.add(foods.remove());
		}
		foods = temp;
		return toEat;
	}

}