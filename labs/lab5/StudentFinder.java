package labs.lab5;

/**
 * Test class for Comparable Student objects.
 */
public class StudentFinder {

	/**
	 * Determines first student in a non-empty array of Student objects.
	 * 
	 * @param students array of Student objects
	 * @return first Student
	 */
	public static Student firstStudent(Student[] students) {
		Student first = students[0];
		for (Student s: students) {
            if (s.compareTo(first) < 0) {
				first = s;
			}
		}
		return first;
	}


	/**
	 * Determines last student in a non-empty array of Student objects.
	 * 
	 * @param students array of Student objects
	 * @return last Student
	 */
	public static Student lastStudent(Student[] students) {
		Student last = students[0];
		for (Student s: students) {
			if (s.compareTo(last) > 0) {
				last = s;
			}
		}
		return last;
	}

}
