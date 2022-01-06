package labs.lab1;

/**
 * A rechargeable battery.
 */
public class Battery {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double cap, remain;

	/**
	 * Create a battery with specified capacity.
	 * 
	 * @param capacity maximum capacity, measured in milliampere hours
	 */
	public Battery(double capacity) {
        cap = capacity;
		remain = capacity;
	}


	/**
	 * Drain capacity of the battery by given amount.
	 * 
	 * @param amount amount of battery used (assume it will not be > its current capacity
	 */
	public void drain(double amount) {
        remain -= amount;
	}


	/**
	 * Recharge the battery to maximum capacity.
	 */
	public void charge() {
        remain = cap;
	}


	/**
	 * Retrieve the battery's current capacity.
	 * 
	 * @return remaining capacity
	 */
	public double getRemainingCapacity() {
        return remain;
	}
}
