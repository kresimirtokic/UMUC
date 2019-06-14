/*
 * Author: Kresimir Tokic
 * CMIS242 Project 4
 * Date: 3/4/19
 * Filename: Student.java
 * About: This class creates the student records
 *  
 */
public class Student {

	private final String studentName;
	private final String studentMajor;
	private int studentCredits;
	private double studentGPA;
	private int totalCredits;
	private double totalQualityPoints;

	// change a variable to totalCreditsCompleted?
	// variable named qualityPoints for calculating GPA instead?

	Student(String studentName, String studentMajor) {
		this.studentName = studentName;
		this.studentMajor = studentMajor;
		this.studentCredits = 0;
		this.studentGPA = 0;
	}

	// gets student's name
	//private String getStudentName() {
	//	return studentName;
	//}

	// calculates GPA
	public void courseCompleted(int newCredits, int numericalGrade) {
		totalCredits = studentCredits + newCredits;
		studentCredits += newCredits;
		totalQualityPoints += numericalGrade * newCredits;
		studentGPA = totalQualityPoints / totalCredits;
	}

	// overridden method returns name, major, GPA for output
	@Override
	public String toString() {
		String displayText = "Student Name: " + studentName + "\nStudent Major: " + studentMajor + "\nGPA: ";
		if (studentCredits == 0) {
			displayText += "4.00";
		} else {
			displayText += String.format("%.2f", studentGPA);
		}
		return displayText;
	}
}
