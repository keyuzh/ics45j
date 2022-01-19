package labs.lab7;

import java.awt.Point;

public class SurvivalGame {

	// ADD YOUR INSTANCE VARIABLES HERE
	private Player player;

	/**
	 * Constructs a new survival game with player
	 */
	public SurvivalGame() {
		player = new Player();
	}


	public Player getPlayer() {
		return player;
	}


	/**
	 * Drops food into the game
	 * 
	 * @param location    food drop location
	 * @param description description of food item
	 * @param energyValue energy value of food item
	 */
	public void dropFood(Point location, String description, int energyValue) {
		Food toDrop = new Food(location, player, description, energyValue);
		player.addFoodToQueue(toDrop);
	}

}