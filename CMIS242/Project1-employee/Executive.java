/**
 * File: Executive.java
 * Date: 1/22/19
 * @author Kresimir Tokic
 * CMIS 242 Project 1
 * This sub class demonstrates 
 * OOP, inheritance, sub/super classes
 *
 */
package employee;

public class Executive extends Employee {
	// declare private instance variables
	private int stockPrice;

	// constructor
	public Executive(int year, String name, int wage, int stockPrice) {
		super(year, name, wage);
		this.stockPrice = stockPrice;
	}// end

	// override method to determine bonus
	public double annualSalary() {
		if (this.stockPrice > 50) {
			return super.annualSalary() + 30000;
		} else {
			return super.annualSalary();
		}
	}// end method

	// add stockPrice to output
	public String toString() {
		return super.toString() + "\nStock Price: $" + stockPrice;
	}// end method
}// end class
