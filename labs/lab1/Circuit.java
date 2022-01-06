package labs.lab1;

/**
 * This class models the circuit for a hallway light.
 */
public class Circuit {

	// ADD YOUR INSTANCE VARIABLES HERE
	private int lampState;
	private int switch1State, switch2State;

	/**
	 * Gets the current state of the indicated switch
	 * 
	 * @param switchNum the number of the switch (1 or 2)
	 * @return the state of the indicated switch (0 = down, 1 = up)
	 */
	public int getSwitchState(int switchNum) {
        return switchNum == 1 ? switch1State : switch2State;
	}


	/**
	 * Gets the current state of the hallway lamp.
	 * 
	 * @return the state of the lamp (0 = off, 1 = on)
	 */
	public int getLampState() {
        return lampState;
	}


	/**
	 * Changes the indicated switch from up to down, or vice versa. Toggling the
	 * switch also changes the state of the lamp.
	 * 
	 * @param switch the number of the switch (1 or 2)
	 */
	public void toggleSwitch(int switchNum) {
		if (switchNum == 1) {
			switch1State = 1 - switch1State;
		}
		else {
			switch2State = 1 - switch2State;
		}
		lampState = 1 - lampState;
	}
}
