package labs.lab4;

/**
 * A onetime appointment.
 */
public class OnetimeAppointment extends Appointment {

	// ADD YOUR INSTANCE VARIABLES HERE
	int year, month, day;

	/**
	 * Initializes appointment for a given date.
	 * 
	 * @param year        the year
	 * @param month       the month
	 * @param day         the day
	 * @param description the text description of the appointment
	 */
	public OnetimeAppointment(int year, int month, int day, String description) {
        super();
		super.setDescription(description);
		this.year = year;
		this.month = month;
		this.day = day;
	}


	public int getYear() {
        return year;
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
        return (this.day == day) && (this.month == month) && (this.year == year);
	}


	/**
	 * Returns true if the given object has the same instance variable
	 * value(s) as this OnetimeAppointment
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
		OnetimeAppointment other = (OnetimeAppointment) otherObject;
		return this.day == other.getDay() && this.month == other.getMonth() && this.year == other.getYear();
	}

}
