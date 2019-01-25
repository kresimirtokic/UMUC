/**
 * File: Salesman.java
 * Date: 1/22/19
 * @author Kresimir Tokic
 * CMIS 242 Project 1
 * This sub class demonstrates 
 * OOP, inheritance, sub/super classes
 *
 */
package employee;

public class Salesman extends Employee {

		//declare private instance variables
		private int annualSales;

		//constructor
		public Salesman(int year, String name, int wage, int annualSales) {
			super(year, name, wage);
			this.annualSales = annualSales;
		}//end
		
		//overrides employee method to determine annual salary plus commission
		public double annualSalary() {
			double commission = this.annualSales * .02;

			if (commission > 20000) {
				return super.annualSalary() + 20000;
			} else {
			return super.annualSalary() + commission;
			}
		}//end method
		
		//method to output data as string
		public String toString() {
			return super.toString() + "\nAnnual Sales: $" + annualSales;
		}//end method
	}//end class

