package labs.lab4;

import java.util.ArrayList;

public class TimeKeeper {
	// ADD YOUR INSTANCE VARIABLES HERE
	private ArrayList<Activity> activities;

	/**
	 * Constructs a new TimeKeeper, with no activities
	 */
	public TimeKeeper() {
		activities = new ArrayList<>();
	}
	
	
	/**
	 * Causes TimeKeeper to record the given activity
	 * 
	 * @param a	the activity to record
	 */
	public void doActivity(Activity a) {
        activities.add(a);
	}
	
	
	/**
	 * Returns the total time (in hours) spent in the given category
	 * 
	 * @param 	category	category to calculate the time spent in
	 * @return	total time (in hours) spent in the category	
	 */
	public double getTotalTimeForCategory(Activity.Category category) {
		double total = 0.0;
		for (Activity a: activities) {
			if (a.getCategory().equals(category)) {
				total += a.getTime();
			}
		}
		return total;
	}
	
	
	/**
	 * Returns the total percentage of time spent in the given category
	 * 
	 * @param 	category	category to calculate the time spent in
	 * @return	total percentage of time spent in the category	
	 */
	public double getPercentageOfTimeSpentInCategory(Activity.Category category) {
		double totalTime = 0.0;
		double categoryTime = 0.0;
		for (Activity a: activities) {
			if (a.getCategory().equals(category)) {
				categoryTime += a.getTime();
			}
			totalTime += a.getTime();
		}
		if (totalTime == 0.0) { return 0.0; }
		return 100.0 * categoryTime / totalTime;
	}
}