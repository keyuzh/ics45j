package labs.lab4;

/**
 * A onetime appointment.
 */
public class OnetimeAppointment extends Appointment {

	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Initializes appointment for a given date.
	 * 
	 * @param year        the year
	 * @param month       the month
	 * @param day         the day
	 * @param description the text description of the appointment
	 */
	public OnetimeAppointment(int year, int month, int day, String description) {
		// FILL IN
	}


	public int getYear() {
		return -1; // FIX ME
	}


	public int getMonth() {
		return -1; // FIX ME
	}


	public int getDay() {
		return -1; // FIX ME
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
		return false; // FIX ME
	}


	/**
	 * Returns true if the given object has the same instance variable
	 * value(s) as this OnetimeAppointment
	 */
	@Override
	public boolean equals(Object otherObject) {
		// HINT: CALL THE SUPERCLASS'S EQUALS METHOD AS PART OF YOUR IMPLEMENTATION
		return false; // FIX ME
	}

}
