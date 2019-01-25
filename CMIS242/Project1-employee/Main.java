/**
 * File: Main.java
 * Date: 1/22/19
 * @author Kresimir Tokic
 * CMIS 242 Project 1
 * This is the Main program to demonstrate
 * OOP, inheritance, sub/super classes.
 *
 */
package employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		startReading();

	}// end main

	//
	public static void startReading() {
		// declare variables
		int firstYearCounter = 0;
		int secondYearCounter = 0;
		String employeeLine;
		ArrayList<Employee> firstYearEmployeeData = new ArrayList<>();
		ArrayList<Employee> secondYearEmployeeData = new ArrayList<>();

		BufferedReader readFile;

		// open employee data from file then call appropriate methods
		try {
			// file should be located in project folder
			// initialize readFile to read the file
			readFile = new BufferedReader(new FileReader("employeeData.txt"));
			// loop through whole file
			employeeLine = readFile.readLine();
			while (employeeLine != null) {
				String[] tempString = employeeLine.split(" ");
				if (tempString[0].contentEquals("2014")) {
					firstYearEmployeeData.addAll(parseEmployeeData(tempString));
					firstYearCounter++;
				} else if (tempString[0].contentEquals("2015")) {
					secondYearEmployeeData.addAll(parseEmployeeData(tempString));
					secondYearCounter++;
				} // end if years
				employeeLine = readFile.readLine();
			} // end while
			readFile.close();// close stream, no longer needed
		} catch (IOException io) {
			System.out.println("IOException: " + io.getMessage());
			System.out.println("Exiting Program Now");
			System.exit(0);
		} finally {
			onScreenDisplay(firstYearEmployeeData, firstYearCounter);
			onScreenDisplay(secondYearEmployeeData, secondYearCounter);
		} // end finally
	}

	// method parses strings and converts to int and returns temp object
	public static ArrayList<Employee> parseEmployeeData(String[] tempString) {
		// declare variable
		ArrayList<Employee> tempEmployeeData = new ArrayList<>();

		// parse employee type create temp object
		if (tempString[1].contentEquals("Employee")) {
			int year = Integer.parseInt(tempString[0]);
			int monthlySalary = Integer.parseInt(tempString[3]);
			tempEmployeeData.add(new Employee(year, tempString[2], monthlySalary));
		} else if (tempString[1].contentEquals("Salesman")) {
			int year = Integer.parseInt(tempString[0]);
			int monthlySalary = Integer.parseInt(tempString[3]);
			int sales = Integer.parseInt(tempString[4]);
			tempEmployeeData.add(new Salesman(year, tempString[2], monthlySalary, sales));
		} else if (tempString[1].contentEquals("Executive")) {
			int year = Integer.parseInt(tempString[0]);
			int monthlySalary = Integer.parseInt(tempString[3]);
			int stocks = Integer.parseInt(tempString[4]);
			tempEmployeeData.add(new Executive(year, tempString[2], monthlySalary, stocks));
		}
		return tempEmployeeData;
	}

	// method prints data to screen
	public static void onScreenDisplay(ArrayList<Employee> employeeData, int counter) {
		// declare local variable
		int totalAnnualSalary = 0;

		// loops through elements of array and prints
		for (Employee elements : employeeData) {
			System.out.println(elements.toString());
			System.out.println("Annual Salary: $" + elements.annualSalary());
			totalAnnualSalary += elements.annualSalary();
		}
		System.out.println("----------------------------------");
		System.out.println("Year Avearge: $" + totalAnnualSalary / counter);
	}// end method

}
