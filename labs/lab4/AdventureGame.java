package labs.lab4;

import java.awt.Point;
import java.util.List;

/**
 * A class for an adventure game with a player, traps, and jet packs. The game
 * world measures 10 x 10, and the center of the world is at coordinates 0, 0.
 */
public class AdventureGame {

	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Constructs a new game with player location 0, 0 (in the center of the world)
	 * facing north, with the traps and jet packs given
	 * 
	 * @param traps    list of locations of traps (assume all within world bounds,
	 *                 and not at 0, 0)
	 * @param jetPacks list of locations of jet packs (assume all within world
	 *                 bounds, and not at 0, 0)
	 */
	public AdventureGame(List<Point> traps, List<Point> jetPacks) {
		// FILL IN
	}


	/**
	 * Turns the player to the left
	 */
	public void playerTurnLeft() {
		// FILL IN
	}


	/**
	 * Turns the player to the right
	 */
	public void playerTurnRight() {
		// FILL IN
	}


	/**
	 * Moves the player one step in the direction they're facing, as long as the
	 * move is a valid one (within the bounds of the world)
	 */
	public void movePlayer() {
		// FILL IN
	}


	/**
	 * Returns the player's current location
	 * 
	 * @return the player's current location
	 */
	public Point getPlayerLocation() {
		return null; // FIX ME
	}


	/**
	 * Returns the direction in which the player is currently facing
	 * ("NORTH", "SOUTH", "EAST", OR "WEST")
	 * 
	 * @return	the direction in which the player is currently facing
	 */
	public String getPlayerDirection() {
		return ""; // FIX ME
	}
	
	
	/**
	 * Returns the number of moves the player has taken
	 * 
	 * @return	the number of moves the player has taken
	 */
	public int getNumMovesMade() {
		return -1; // FIX ME
	}
}
