package labs.lab5;

/**
 * This class represents a student with a name and ID.
 */
public class Student implements Comparable {

	// ADD YOUR INSTANCE VARIABLES HERE
	private String name;
	private int id;

	/**
	 * Constructs a student object
	 * 
	 * @param name the student's name
	 * @param id   the student's id
	 */
	public Student(String name, int id) {
        this.name = name;
		this.id = id;
	}


	/**
	 * Gets the student's name
	 * 
	 * @return the name
	 */
	public String getName() {
        return name;
	}


	/**
	 * Gets the student's id
	 * 
	 * @return the name
	 */
	public int getId() {
        return id;
	}


	@Override
	public String toString() {
		return String.format("%s, %d", name, id);
	}


	@Override
	public boolean equals(Object otherObject) {
		if (otherObject instanceof Student other) {
			return (id == other.getId() && name.equals(other.getName()));
		}
		return false;
	}


	/**
	 * Compares student objects first by name, then by id
	 * 
	 * @param other Other student against which to compare
	 * @return negative int if this students comes before, 0 if equal, positive int
	 *         if this student comes after
	 */
	public int compareTo(Object other) {
		Student o = (Student) other;
		int strCompareResult = name.compareTo(o.getName());
		if (strCompareResult == 0) {
			return Integer.compare(id, o.getId());
		}
		return strCompareResult;
	}

}
