package labs.lab4;

import java.awt.Point;
import java.util.List;

/**
 * A class for an adventure game with a player, traps, and jet packs. The game
 * world measures 10 x 10, and the center of the world is at coordinates 0, 0.
 */
public class AdventureGame {

	// ADD YOUR INSTANCE VARIABLES HERE
	private List<Point> traps, jetPacks;
	private int direction;
	private Point location;
	private int numMoves;
	private int jetPackCount;

	private final int NORTH = 0;
	private final int EAST = 1;
	private final int SOUTH = 2;
	private final int WEST = 3;

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
        this.jetPacks = jetPacks;
		this.traps = traps;
		this.direction = 0;
		this.location = new Point(0,0);
		this.numMoves = 0;
	}


	/**
	 * Turns the player to the left
	 */
	public void playerTurnLeft() {
        if (direction == 0) {
			direction = 3;
		}
		else {
			direction--;
		}
	}


	/**
	 * Turns the player to the right
	 */
	public void playerTurnRight() {
		direction++;
		direction %= 4;
	}

	private static boolean isValidLocation(Point p) {
		return p.x >= -5 && p.x <= 5 && p.y >= -5 && p.y <= 5;
	}

	private boolean isJetpack() {
		return jetPacks.contains(location);
	}

	private boolean isTrap() {
		return traps.contains(location);
	}

	/**
	 * Moves the player one step in the direction they're facing, as long as the
	 * move is a valid one (within the bounds of the world)
	 */
	public void movePlayer() {
		Point newLocation = new Point(getPlayerLocation());
		switch (direction) {
			case NORTH -> newLocation.translate(0, 1);
			case SOUTH -> newLocation.translate(0, -1);
			case EAST -> newLocation.translate(1, 0);
			case WEST -> newLocation.translate(-1, 0);
		}
		if (!isValidLocation(newLocation)) { return; }
		this.location = newLocation;
		numMoves++;

		if (isJetpack() && jetPackCount < 3) {
			jetPacks.remove(location);
			jetPackCount++;
			System.out.print("Picked up jet pack! ");
		}
		if (isTrap()) {
			System.out.print("Fell into a trap! ");
			if (jetPackCount > 0) {
				jetPackCount--;
				System.out.print("Used jet pack! ");
			}
			else {
				System.out.print("You lose!");
				return;
			}
		}
		if (numMoves >= 30) {
			System.out.print("You win!");
		}
	}


	/**
	 * Returns the player's current location
	 * 
	 * @return the player's current location
	 */
	public Point getPlayerLocation() {
        return location;
	}


	/**
	 * Returns the direction in which the player is currently facing
	 * ("NORTH", "SOUTH", "EAST", OR "WEST")
	 * 
	 * @return	the direction in which the player is currently facing
	 */
	public String getPlayerDirection() {
		return switch (direction) {
			case NORTH -> "NORTH";
			case SOUTH -> "SOUTH";
			case EAST -> "EAST";
			case WEST -> "WEST";
			default -> "";
		};
	}
	
	
	/**
	 * Returns the number of moves the player has taken
	 * 
	 * @return	the number of moves the player has taken
	 */
	public int getNumMovesMade() {
        return numMoves;
	}
}
