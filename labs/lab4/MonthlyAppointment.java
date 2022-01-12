package labs.lab4;

/**
 * Monthly appointment.
 */
public class MonthlyAppointment extends Appointment {

	// ADD YOUR INSTANCE VARIABLES HERE
	int day;

	/**
	 * Initializes appointment to repeat monthly on day of the month.
	 * 
	 * @param day         the day of the month
	 * @param description the text description of the appointment
	 */
	public MonthlyAppointment(int day, String description) {
		super();
		super.setDescription(description);
        this.day = day;
	}


	public int getDay() {
        return day;
	}


	/**
	 * Determines if this appointment occurs on the given date.
	 * 
	 * @param year  the year
	 * @param month the month
	 * @param day   the day
	 * 
	 * @return true if the appointment occurs on the given date.
	 */
	public boolean occursOn(int year, int month, int day) {
        return this.day == day;
	}


	/**
	 * Returns true if the given object has the same instance variable
	 * value(s) as this MonthlyAppointment
	 */
	@Override
	public boolean equals(Object otherObject) {
		// HINT: CALL THE SUPERCLASS'S EQUALS METHOD AS PART OF YOUR IMPLEMENTATION
		if (!super.equals(otherObject)) {
			return false;
		}
		if (otherObject.getClass() != this.getClass()) {
			return false;
		}
		MonthlyAppointment other = (MonthlyAppointment) otherObject;
		return this.day == other.getDay();

	}

}
