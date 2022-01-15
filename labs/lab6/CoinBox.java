package labs.lab6;

import java.math.BigDecimal;

/**
 * A box of coins.
 */
public class CoinBox {

	// ADD YOUR INSTANCE VARIABLES HERE
	private BigDecimal value;

	/**
	 * Constructs an empty CoinBox object.
	 */
	public CoinBox() {
		this.value = new BigDecimal(0);
	}


	/**
	 * Adds a coin.
	 * 
	 * @param c the coin to add
	 */
	public void addCoin(Coin c) {
		value = value.add(BigDecimal.valueOf(c.getValue()));
	}


	/**
	 * Removes coins from another coinbox and adds them to this one. 
	 * 
	 * @param other the box of coins from which to add
	 */
	public void addCoins(CoinBox other) {
		this.value = this.value.add(other.value);
		other.removeAllCoins();
	}


	/**
	 * Gets the value of all the coins.
	 * 
	 * @return total the total value of all the coins
	 */
	public double getValue() {
		return value.doubleValue();
	}


	/**
	 * Removes all the coins.
	 */
	public void removeAllCoins() {
		value = new BigDecimal(0);
	}

}