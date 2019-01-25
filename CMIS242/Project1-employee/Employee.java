/**
 * File: Employee.java
 * Date: 1/22/19
 * @author Kresimir Tokic
 * CMIS 242 Project 1
 * This super class demonstrates 
 * OOP, inheritance, sub/super classes
 *
 */

package employee;

public class Employee {

	// declare instance variables
	private String employeeName;
	private int monthlySalary;
	private double annualSalaryValue;

	// constructor
	public Employee(int year, String name, int wage) {
		this.employeeName = name;
		this.monthlySalary = wage;
	}// end constructor

	// method to output data as string
	public String toString() {
		return "\nEmployee Name: " + this.employeeName + "\nMonthly Salary: $" + this.monthlySalary;
	}

	// method determines annual salary
	public double annualSalary() {
		annualSalaryValue = monthlySalary * 12;
		return this.annualSalaryValue;
	}

}// end class
