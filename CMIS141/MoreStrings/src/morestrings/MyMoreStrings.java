/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymorestrings;

/**
 * File: MyMoreStrings.java
 * @author kresimir.tokic
 * Date: 9/16/18
 * Purpose: This program constructs String,
 * StingBuffer, StringBuilder objects
 * and uses several methods
 */
public class MyMoreStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Create Strings
        String[] firstName = {"John", "Paul", "George", "Ringo"};
        String[] lastName = {"Lennon", "McCartney", "Harrison", "Starr"};
        String[] city = {"Liverpool", "London", "New York", "LA"};
            
        //Create String Buffers
        StringBuffer[] firstNameBuffer = new StringBuffer[4];
        StringBuffer[] lastNameBuffer = new StringBuffer[4];
        StringBuffer[] cityBuffer = new StringBuffer[4];
        
        //String builders
        StringBuilder[] firstNameBuilder = new StringBuilder[4];
        StringBuilder[] lastNameBuilder = new StringBuilder[4];
        StringBuilder[] cityBuilder = new StringBuilder[4];

        //Create arrays for full names of each type
        String[] fullName = new String[firstName.length];
        StringBuffer[] fullNameBuffer = new StringBuffer[firstName.length];
        StringBuilder[] fullNameBuilder = new StringBuilder[firstName.length];
        
        //loop to assign values to string buffer and builder from strings
        for (int i=0; i<firstName.length; i++) {
            firstNameBuffer[i] = new StringBuffer(firstName[i]);
            lastNameBuffer[i] = new StringBuffer(lastName[i]);
            cityBuffer[i] = new StringBuffer(city[i]);
            firstNameBuilder[i] = new StringBuilder(firstName[i]); 
            lastNameBuilder[i] = new StringBuilder(lastName[i]);
            cityBuilder[i] = new StringBuilder(city[i]);
        }
                
        
        //Use String methods
        //Concatenate first and last name - add space
        for (int i = 0; i < firstName.length; i++) {
            fullName[i] = firstName[i].concat(" ").concat(lastName[i]);
            System.out.println("string fullName is " + fullName[i]);  
            //System.out.println("string city first char is " + city[i].charAt(0) + " last char is " + city[i].substring(city[i].length() - 1));           //alternate way to do the same thing below
            System.out.println("string city first char is " + city[i].charAt(0) + " last char is " + city[i].charAt(city[i].length() - 1));
            System.out.println("string fullName length is " + fullName[i].length());
            System.out.println("fullName substring indx 0, 3 is " + fullName[i].substring(0,3));
            
        }
        System.out.println("");
        for (int i = 0; i < firstName.length; i++) {
            fullNameBuffer[i] = firstNameBuffer[i].append(" ").append(lastNameBuffer[i]);
            System.out.println("stringBuffer fullName is " + fullNameBuffer[i]);
            System.out.println("stringBuffer city first char is " + cityBuffer[i].charAt(0) + " last char is " + cityBuffer[i].charAt(cityBuffer[i].length()-1));
            System.out.println("stringBuffer fullName length is " + fullNameBuffer[i].length());
            System.out.println("stringBuffer fullName capacity is " + fullNameBuffer[i].capacity());
            System.out.println("fullNameBuffer substring indx 0, 3 is " + fullNameBuffer[i].substring(0,3));
        }
        System.out.println("");        
        for (int i = 0; i < firstName.length; i++) {
            fullNameBuilder[i] = firstNameBuilder[i].append(" ").append(lastNameBuilder[i]);
            System.out.println("stringBuilder fullName is " + fullNameBuilder[i]);  
            System.out.println("stringBuilder city first char is " + cityBuilder[i].charAt(0) + " last char is " + cityBuilder[i].charAt(cityBuilder[i].length()-1));
            System.out.println("stringBuilder fullName length is " + fullNameBuilder[i].length());
            System.out.println("stringBuilder fullName capacity is " + fullNameBuilder[i].capacity());
            System.out.println("fullNameBuilder substring indx 0, 3 is " + fullNameBuilder[i].substring(0,3));            
        }

        
    }//end main
    
}//end class
