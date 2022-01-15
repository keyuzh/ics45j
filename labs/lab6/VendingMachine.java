package labs.lab6;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A vending machine.
 */
public class VendingMachine {

	private List<Product> products; // the products in the machine
	public CoinBox storedCoins; // the coins that have already been used to purchase a product
	public CoinBox currentCoins; // the coins that have been inserted but have not yet been used to purchase a
									// product
	private HashMap<Product, Integer> quantities;

	/**
	 * Constructs a VendingMachine object with no products or coins
	 */
	public VendingMachine() {
		products = new ArrayList<>();
		storedCoins = new CoinBox();
		currentCoins = new CoinBox();
		quantities = new HashMap<>();
	}


	/**
	 * Gets the type of products in the vending machine.
	 * 
	 * @return a list of products in this machine
	 */
	public List<Product> getProductTypes() {
		return products;
	}


	/**
	 * Adds a product to the vending machine.
	 * 
	 * @param p        the product to add
	 * @param quantity the quantity
	 */
	public void addProduct(Product p, int quantity) {
		products.add(p);
		quantities.put(p, quantities.getOrDefault(p, 0) + quantity);
	}


	/**
	 * Adds the coin to the vending machine, and returns the total value of coins
	 * that have been inserted but not yet used to buy a product
	 * 
	 * @param c the coin to add
	 * @return the total value of coins that have been inserted but not yet used to
	 *         buy a product
	 */
	public double addCoin(Coin c) {
		currentCoins.addCoin(c);
		return currentCoins.getValue();
	}


	/**
	 * Buys a product from the vending machine, causing all the coins that have been
	 * inserted since the last purchase to be stored in the machine and unavailable
	 * to use for other purchases.
	 * 
	 * @param p the product to buy
	 * @return "OK" if the product was purchased, "Insufficient money" if the
	 *         product exists but there is not enough to purchase the product, or
	 *         "No such product" if the product doesn't exist in the machine
	 */
	public String buyProduct(Product p) {
		if (!products.contains(p)) {
			return "No such product";
		}
		BigDecimal productPrice = BigDecimal.valueOf(p.getPrice());
		BigDecimal inserted = BigDecimal.valueOf(currentCoins.getValue());
		if (productPrice.compareTo(inserted) > 0) {
			return "Insufficient money";
		}
		storedCoins.addCoins(currentCoins);
		quantities.put(p, quantities.get(p)-1);
		//TODO: try write some tests that buy/insert products after they have been sold out once
		if (quantities.get(p) == 0) {
			products.remove(p);
			quantities.remove(p);
		}
		return "OK";
	}


	/**
	 * Removes the stored money from the vending machine.
	 * 
	 * @return the amount of money removed
	 */
	public double removeStoredMoney() {
		double amount = storedCoins.getValue();
		storedCoins.removeAllCoins();
		return amount;
	}

}
