/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import java.util.Scanner;

/**
 *
 * @author kresimir.tokic
 */
public class AddressBook {

    //declare variables
    private static String name;
    private static int age;
    private static int zip;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner myScanner = new Scanner(System.in);
        /*
            try {
                System.out.println("Enter your name: ");
                name = myScanner.next();
                //break;
            } catch (IllegalFormatException se) {
                System.err.println("StringFormatException: "
                        + se.getMessage());
                System.out.println("Please enter a valid name: ");
            } finally {
                System.out.println("Age is only in the mind.");
            }
         */
        while (true) {
            try {
                System.out.println("Enter your name: ");
                name = myScanner.next();
                System.out.println("Enter you age (e.g. 32): ");
                age = Integer.parseInt(myScanner.next());
                System.out.println("Enter your zipcode: ");
                zip = Integer.parseInt(myScanner.next());
                // break;
            } catch (NumberFormatException ne) {
                System.err.println("NumberFormatException: "
                        + ne.getMessage());
                System.out.println("Please enter a valid number: ");
            } finally {
                System.out.println("Name, age, zipcode: " + name + ", " + age + ", " + zip);
            }
        }
    }
}
