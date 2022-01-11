package labs.lab3;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Inventory {
	// ADD YOUR INSTANCE VARIABLES HERE
	ArrayList<Item> items;
	
	
	/**
	 * Constructs a new Inventory
	 */
	public Inventory() {
        items = new ArrayList<>();
	}
	
	
	/**
	 * If an item with the given item's description does not already exist
	 * in the inventory, adds that item to the inventory. If an item with
	 * the given item's description does exist, updates that item with 
	 * the given item's values.
	 * 
	 * @param item	item to add/update
	 */
	public void addOrUpdateItem(Item item) {
		for (Item i: items) {
			if (i.getDescription().equals(item.getDescription())) {
				i.setCurrentStock(item.getCurrentStock());
				i.setTargetStock(item.getTargetStock());
				return;
			}
		}
		items.add(item);
	}
	
	
	/**
	 * Removes item with the given description, if it exists
	 * 
	 * @param description	description of item to remove
	 */
	public void removeItemWithDescription(String description) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getDescription().equals(description)) {
				items.remove(i);
				return;
			}
		}
	}
	
	
	/**
	 * Returns a report of items that are under-stocked (items whose
	 * current stock is less than their target stock)
	 * 
	 * @return	a string that reports which items need to be ordered
	 * and how many of each. If no items are under-stocked, report reads
	 * "No items under-stocked".
	 */
	public String getUnderstockReport() {
		StringJoiner result = new StringJoiner(" | ");
		for (Item i: items) {
			int diff = i.getTargetStock() - i.getCurrentStock();
			if (diff > 0) {
				result.add(String.format("Order %d more of ", diff) + i.getDescription());
			}
		}
        return result.length() > 0 ? result.toString() : "No items under-stocked";
	}
	
	
	/**
	 * Returns a report of items that are over-stocked (items whose
	 * current stock is more than their target stock)
	 * 
	 * @return	a string that reports which items are overstocked and
	 * by how much. If no items are over-stocked, report reads
	 * "No items over-stocked".
	 */
	public String getOverstockReport() {
		StringJoiner result = new StringJoiner(" | ");
		for (Item i: items) {
			int diff = i.getCurrentStock() - i.getTargetStock();
			if (diff > 0) {
				result.add(String.format("%s over-stocked by %d items", i.getDescription(), diff));
			}
		}
		return result.length() > 0 ? result.toString() : "No items over-stocked";
	}
}