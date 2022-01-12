package labs.lab4;

/**
 * A yearly appointment.
 */
public class YearlyAppointment extends Appointment {

	// ADD YOUR INSTANCE VARIABLES HERE
	int month, day;

	/**
	 * Initializes appointment that happens every year on a given date.
	 * 
	 * @param month       the month
	 * @param day         the day
	 * @param description the text description of the appointment
	 */
	public YearlyAppointment(int month, int day, String description) {
		super();
		super.setDescription(description);
        this.day = day;
		this.month = month;
	}


	public int getMonth() {
        return month;
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
        return this.day == day && this.month == month;
	}


	/**
	 * Returns true if the given object has the same instance variable
	 * value(s) as this YearlyAppointment
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
		YearlyAppointment other = ((YearlyAppointment) otherObject);
		return this.day == other.getDay() && this.month == other.getMonth();
	}

}
