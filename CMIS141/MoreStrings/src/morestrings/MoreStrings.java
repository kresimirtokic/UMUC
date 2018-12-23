/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morestrings;

/**
 * File: MoreStrings.java
 * @author kresimir.tokic
 * Date: 9/16/18
 * Purpose: This program constructs String,
 * StingBuffer, StringBuilder objects
 * and uses several methods
 */
public class MoreStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Create Strings
        String firstName = new String("John");
        String lastName = new String("Frederick");
        String city = new String("College Park");
        
        //Use String methods
        //Concatenate first and last name - add space
        String fullName = firstName.concat(" ").concat(lastName);
        System.out.println("fullName is " + fullName);
        
        //Check if city starts with C
        System.out.println("City starts with C? " +city.startsWith("C"));
        
        //Display Uppercase
        System.out.println("Upper case fullname: " + fullName.toUpperCase());
        
        //Comparison returns true
        if (firstName.equals("John")) {
            System.out.println("Welcome John");
        }//end if
        
        //Comparison returns false
        if (lastName.equals(firstName)) {
            System.out.println("Your first and last name are the same");
        }//end if
        
        //Add some StringBuffers
        StringBuffer facultyName = new StringBuffer("Professor Robertson");
        
        //Display the facultyName
        System.out.println("Faculty is " + facultyName);
        
        //Append the city info
        facultyName.append(" lives in ").append(city);
        System.out.println("Faculty is now " + facultyName);
        
        //Remove strings in locations 29-37
        facultyName.delete(29, 37);
        System.out.println("Faculty is now " + facultyName);
        
        //Reverse the string
        facultyName.reverse();
        System.out.println("Faculty is now " + facultyName);
        
        //Some methods for StringBuilder
        StringBuilder studentName = new StringBuilder("Joe Reeves");
        //Display the studentName
        System.out.println("Student is " + studentName);
        //Append the city info
        studentName.append(" lives in " ).append(city);
        System.out.println("Student is now " + studentName);
        //Remove strings 29-37
        studentName.delete(29, 37);
        System.out.println("Student is now " + studentName);
        //Reverse the String
        studentName.reverse();
        System.out.println("Student is now " + studentName);
        
    }//end main
    
}//end class
