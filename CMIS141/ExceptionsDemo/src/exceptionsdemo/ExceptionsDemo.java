package exceptionsdemo;

import java.util.Scanner;

/*
* File: ExceptionsDemo.java
* Author: Dr. Robertson
* Date: January 1, XXXX
* Purpose: This program demonstrates
* catching several Java run-time exceptions
 */
public class ExceptionsDemo {
    // Declare private variables

    private static int age = 32;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// TODO code application logic here
        Scanner myScanner = new Scanner(System.in);
// Prompt use to enter an int
        while (true) {
            try {
                System.out.println("Enter you age (e.g. 32): ");
                age = Integer.parseInt(myScanner.next());
                break;
            } catch (NumberFormatException ne) {
                System.err.println("NumberFormatException: "
                        + ne.getMessage());
                System.out.println("Please enter a valid age: ");
            } finally {
                System.out.println("Age is only in the mind.");
            }
        } // End while loop
// Catch ArithmeticException
        try {
            int newAge = age / 0;
// This exception seems limited to
// int and long math issues
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException: "
                    + ae.getMessage());
        }
// Catch ArrayIndexOutofBoundsException
        int[] examGrades = {85, 90, 63, 43, 86};
        try {
            for (int i = 0; i <= examGrades.length; i++) {
                System.out.println("Exam grade is "
                        + examGrades[i]);
            }
        } catch (ArrayIndexOutOfBoundsException outOfBounds) {
            System.out.println("Array out of Bounds: "
                    + outOfBounds.getMessage());
        }
    }
}
