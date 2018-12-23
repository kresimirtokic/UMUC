/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UScrime;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;


/**
 * File: USCrime.java
 * Date: 10/5/18
 * Author: Kresimir Tokic 
 * CMIS 141 Final Project
 * Custom class to read data from file and parse it.
 * It also calls the processing class
 */
public class USCrimeData {

    //declare varaiables and named objects
    private static final Integer ROWS = 20;

    FileInputStream readFile = null;
    BufferedReader inputStream = null;
    String crimeDataRow;

    private final int[] years = new int[ROWS];
    private final int[] population = new int[ROWS];
    private final int[] violentCrime = new int[ROWS];
    private final float[] violentCrimeRate = new float[ROWS]; //double not required for decimal spaces this time
    private final int[] murder = new int[ROWS];             //consider doubles for flexibility in future
    private final float[] murderRate = new float[ROWS];
    private final int[] rapes = new int[ROWS];
    private final float[] rapeRate = new float[ROWS];
    private final int[] robbery = new int[ROWS];
    private final float[] robberyRate = new float[ROWS];
    private final int[] aggroAssault = new int[ROWS];
    private final float[] aggroAssaultRate = new float[ROWS];
    private final int[] propCrime = new int[ROWS];
    private final float[] propCrimeRate = new float[ROWS];
    private final int[] burglary = new int[ROWS];
    private final float[] burglaryRate = new float[ROWS];
    private final int[] larceny = new int[ROWS];
    private final float[] larcenyRate = new float[ROWS];
    private final int[] carTheft = new int[ROWS];
    private final float[] carTheftRate = new float[ROWS];

    ProcessCrimeData processor = new ProcessCrimeData();

    //ArrayList<String> 
    public void readData(String fileName) { //maybe not return string?
        ArrayList<String> fullDataSets = new ArrayList<>(); //maybe not string?
        try {
            //file should be located in Netbeans folder project location
            //initialize readFile to read the file
            Scanner readFile = new Scanner(new FileInputStream(fileName));
            readFile.nextLine();
            //loops through whole file including header item by item
            while (readFile.hasNextLine()) {
                crimeDataRow = readFile.nextLine();
                String[] temp = crimeDataRow.split(",");
                //adds crimeData to array list dataSets
                fullDataSets.add(crimeDataRow);
            }//end while
        } catch (IOException io) {
            System.out.println("IOException: " + io.getMessage());
            System.out.println("Exiting Program Now");
            System.exit(0);
        } finally {                
        //call parsing method to sort all this data
        parseCrimeData(fullDataSets);
        }
    }//end method

    //outputs menu options
    public void showMenu() {
        System.out.println("\nEnter the number of the question you want answered. "
                + "Enter 'Q' to quit the program");
        System.out.println();
        System.out.println("1. What were the precentages in population growth"
                + " for each consecutive year from 1994-2013?");
        System.out.println("2. What year was the Murder rate the highest?");
        System.out.println("3. What year was the Murder rate the lowest?");
        System.out.println("4. What year was the Robbery rate the highest?");
        System.out.println("5. What year was the Robbery rate the lowest?");
        System.out.println("6. What is the violent crime per capita each year?");
        System.out.println("Q. Quit the program.");
        System.out.println();
        System.out.print("Enter your selection: ");
    }

    //sets user menu choice
    //trim leading/trailing white space
    public String setUserInput() {
        Scanner userInput = new Scanner(System.in);
        String menuSelection = userInput.next();
        menuSelection = menuSelection.trim().toUpperCase();
        return menuSelection;
    }

    public void menuOptions() {
        String menuSelection = "";
        while (menuSelection.compareTo("Q") != 0) {
            showMenu();
            menuSelection = setUserInput();
            switch (menuSelection) {
                case "1":
                    processor.getPopulationGrowth(years, population);
                break;
                case "2":
                   processor.getMaxMurderYear(years, murderRate);
                    break;
                case "3":
                   processor.getMinMurderYear(years, murderRate);
                    break;
                case "4":
                   processor.getMaxRobberyYear(years, robberyRate);
                    break;
                case "5":
                   processor.getMinRobberyYear(years, robberyRate);
                    break;
                case "6":
                    processor.getViolentPerCapita(years, violentCrimeRate, population);
                    break;
                case "Q":
                    System.out.println("\nThank you for trying the US Crime Stats App.");
                    return;
                default:
                    System.out.println("\nInvalid selection, try again.");
            }//end switch
        }//end while
    }//end method

    //take in a row of crime data to parse the types out
    public void parseCrimeData(ArrayList fullDataSets) {
        //separate data types by commas to temp array
        for (int i = 0; i < fullDataSets.size(); i++) {
            String tempJoint = (String) fullDataSets.get(i);
            String[] tempArray = tempJoint.split(",");
            //System.out.println(Arrays.toString(tempArray)); for testing

            //String[] tempArray = crimeDataRow.split(",");
            this.years[i] = Integer.parseInt(tempArray[0]);
            this.population[i] = Integer.parseInt(tempArray[1]);
            this.violentCrime[i] = Integer.parseInt(tempArray[2]);
            this.violentCrimeRate[i] = Float.parseFloat(tempArray[3]);
            this.murder[i] = Integer.parseInt(tempArray[4]);
            this.murderRate[i] = Float.parseFloat(tempArray[5]);
            this.rapes[i] = Integer.parseInt(tempArray[6]);
            this.rapeRate[i] = Float.parseFloat(tempArray[7]);
            this.robbery[i] = Integer.parseInt(tempArray[8]);
            this.robberyRate[i] = Float.parseFloat(tempArray[9]);
            this.aggroAssault[i] = Integer.parseInt(tempArray[10]);
            this.aggroAssaultRate[i] = Float.parseFloat(tempArray[11]);
            this.propCrime[i] = Integer.parseInt(tempArray[12]);
            this.propCrimeRate[i] = Float.parseFloat(tempArray[13]);
            this.burglary[i] = Integer.parseInt(tempArray[14]);
            this.burglaryRate[i] = Float.parseFloat(tempArray[15]);
            this.larceny[i] = Integer.parseInt(tempArray[16]);
            this.larcenyRate[i] = Float.parseFloat(tempArray[17]);
            this.carTheft[i] = Integer.parseInt(tempArray[18]);
            this.carTheftRate[i] = Float.parseFloat(tempArray[19]);
        }
    }
}//end class
