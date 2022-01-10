package labs.lab2;

/**
 * This class models a paycheck.
 */
public class Paycheck {
	// ADD YOUR INSTANCE VARIABLES HERE
	double wage, hourWorked, taxRate;

	/**
	 * Constructs a PayCheck for a given week.
	 * 
	 * @param wage      the employee's hourly wage
	 * @param hours		the amount of hours worked
	 * @param taxRate	percentage this employee is taxed
	 */
	public Paycheck(double wage, double hours, double taxRate) {
        this.wage = wage;
		this.hourWorked = hours;
		this.taxRate = taxRate;
	}

	/**
	 * Gets the pay for this week
	 * 
	 * @return the pay, including overtime if earned, and taxes taken out on 
	 * the full amount earned
	 */
	public double getPay() {
        return (
				(wage * Math.min(40.0, hourWorked)
				+ 2.0 * wage * Math.max(0.0, hourWorked-40.0))
				* 0.01 * (100.0-taxRate)
				);
	}
}
