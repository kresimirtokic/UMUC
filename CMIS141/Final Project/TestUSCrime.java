/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UScrime;


/**
 * File: TestUSCrime.java
 * Date: 10/5/18
 * @author kresimir.tokic 
 * CMIS 141 Final Project
 * This tests the classes 
 * and outputs time stamps
 */
public class TestUSCrime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        long startTimeMachine = System.currentTimeMillis();
        long endTimeMachine;
        long elapsedTime;

        System.out.println("********** Welcome to the US Crime Stats App **********");

        //checks for command line argument, exits if none entered
        if (args.length != 1) {
            System.out.println("Please enter valid argument");
            System.out.println("eg: java TestUSCrime Crime.csv");
            System.exit(0);
        }
        //create object 
        USCrimeData crimeTest = new USCrimeData();

        //sets command line argument to variable fileName
        String fileName = args[0];
        crimeTest.readData(fileName);

        //who menu & get user input
        crimeTest.menuOptions();
        
        //end program
        endTimeMachine = System.currentTimeMillis();
        elapsedTime = (endTimeMachine - startTimeMachine) / 1000;
        System.out.println("\nElapsed time in seconds was: " + elapsedTime);
    }//end main
}//end class

