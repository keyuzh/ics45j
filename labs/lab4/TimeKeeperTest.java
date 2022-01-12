package labs.lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeKeeperTest {
	
	private final double EPSILON = 1e-3;
	
	
	@Test
    public void testAllActivitiesInOneCategory() {
		TimeKeeper tk = new TimeKeeper();
		tk.doActivity(new Activity("Bring in the newspaper", 0.03, Activity.Category.WORK));
		tk.doActivity(new Activity("Take my siblings to school", 0.75, Activity.Category.WORK));
		tk.doActivity(new Activity("Attend Mom's 45J lecture", 1.3, Activity.Category.WORK));
		tk.doActivity(new Activity("Pick my siblings up from school", 1.0, Activity.Category.WORK));
		tk.doActivity(new Activity("Go outside and bark at nothing", 0.15, Activity.Category.WORK));

		assertEquals(3.23, tk.getTotalTimeForCategory(Activity.Category.WORK), EPSILON);
		assertEquals(100.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.WORK), EPSILON);
	}
	
	
	@Test
	public void testNoActivities() {
		TimeKeeper tk = new TimeKeeper();
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.WORK), EPSILON);
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.WORK), EPSILON);
	}
	
	
	@Test
	public void testDuplicateActivities() {
		TimeKeeper tk = new TimeKeeper();
		tk.doActivity(new Activity("Eat breakfast", 0.05, Activity.Category.OTHER));
		tk.doActivity(new Activity("Eat breakfast", 0.05, Activity.Category.OTHER));
		tk.doActivity(new Activity("Eat breakfast", 0.05, Activity.Category.OTHER));
		tk.doActivity(new Activity("Eat breakfast", 0.05, Activity.Category.OTHER));
		tk.doActivity(new Activity("Eat breakfast", 0.05, Activity.Category.OTHER));
		tk.doActivity(new Activity("Pick my siblings up from school", 1.0, Activity.Category.WORK));

		assertEquals(0.25, tk.getTotalTimeForCategory(Activity.Category.OTHER), EPSILON);
		assertEquals(20.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.OTHER), EPSILON);
	}
}
