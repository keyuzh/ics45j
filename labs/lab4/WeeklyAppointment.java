package labs.lab4;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Weekly appointment.
 */
public class WeeklyAppointment extends Appointment {

	// ADD YOUR INSTANCE VARIABLES HERE
	DayOfWeek dow;

	/**
	 * Initializes appointment for a given day of the week.
	 * 
	 * @param dayOfWeek   the day of the wee
	 * @param description the text description of the appointment
	 */
	public WeeklyAppointment(DayOfWeek dayOfWeek, String description) {
        super();
		super.setDescription(description);
		dow = dayOfWeek;
	}


	public DayOfWeek getDayOfWeek() {
		return dow;
	}


	/**
	 * Determines if this appointment occurs on the given date.
	 * 
	 * @param year  the year
	 * @param month the month
	 * @param day   the day
	 * @return true if the appointment occurs on the given date.
	 */
	public boolean occursOn(int year, int month, int day) {
		LocalDate ld = LocalDate.of(year, month, day);
		return ld.getDayOfWeek() == dow;
	}


	/**
	 * Returns true if the given object has the same instance variable
	 * value(s) as this WeeklyAppointment
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
		WeeklyAppointment other = ((WeeklyAppointment) otherObject);
		return this.dow == other.getDayOfWeek();
	}
}
