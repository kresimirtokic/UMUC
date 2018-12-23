/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UScrime;

/**
 * File: ProcessCrimeData.java
 * @author kresimir.tokic
 * Date: 10/5/18
 * This class processes crime data
 * and outputs results
 */
public class ProcessCrimeData {

    //determines population grown in % between each year
    public void getPopulationGrowth(int[] years, int[] population) {
        float result;
        for (int i = 0; i < years.length - 1; i++) {
            result = (population[i + 1] - population[i]);
            result = (result / population[i]) * 100;
            System.out.println("Population growth between " + years[i] + " and " + years[i + 1]
                    + " is " + String.format("%.4f", result) + "%");
        }
    }

    //gets year with highest murder rate
    public void getMaxMurderYear(int[] years, float[] murderRate) {
        float maxMurderRate = 0;
        int indexTracker = 0;
        for (int i = 0; i < murderRate.length; i++) {
            if (maxMurderRate > murderRate[i]) {
                indexTracker = i;
                maxMurderRate = murderRate[i];
            }
        }
        System.out.println("The Murder rate was highest in " + years[indexTracker]);
    }

    //gets year with lowest murder rate
    public void getMinMurderYear(int[] years, float[] murderRate) {
        float minMurderRate = 999999999;
        int indexTracker = 0;
        for (int i = 0; i < murderRate.length; i++) {
            if (minMurderRate > murderRate[i]) {
                indexTracker = i;
                minMurderRate = murderRate[i];
            }
        }
        System.out.println("The Murder rate was lowest in " + years[indexTracker]);
    }

    //gets year with higest robbery same as highest murder method
    public void getMaxRobberyYear(int[] years, float[] robberyRate) {
        float maxRobberyRate = 0;
        int indexTracker = 0;
        for (int i = 0; i < robberyRate.length; i++) {
            if (maxRobberyRate > robberyRate[i]) {
                indexTracker = i;
                maxRobberyRate = robberyRate[i];
            }
        }
        System.out.println("The Robbery rate was highest in " + years[indexTracker]);
    }

    //gets year with lowest robbery same as lowest murder method
    public void getMinRobberyYear(int[] years, float[] robberyRate) {
        float minRobberyRate = 999999999;
        int indexTracker = 0;
        for (int i = 0; i < robberyRate.length; i++) {
            if (minRobberyRate > robberyRate[i]) {
                indexTracker = i;
                minRobberyRate = robberyRate[i];
            }
        }
        System.out.println("The Robbery rate was lowest in " + years[indexTracker]);
    }

    //determine violent crime per capita 100k
    //formula is (crime stat / (population size / 100k)) * 100
    public void getViolentPerCapita(int[] years, float[] crimeRate, int[] population) {
        float result;
        for (int i = 0; i < years.length; i++) {
            result = (crimeRate[i] / (population[i] / 100000)) * 100;
            System.out.println("Violent crime per capita per 100k in " + years[i]  
                                + " is " + String.format("%.4f", result) + "%");
        }
    }
   /*
    * these methods commented out are simply
    * to demonstrate how to make pseudo-generic
    * methods for finding min/max crime rate years
    *
    //generic max crime year method    
    public void getMaxCrimeYear(int[] years, float[] crimeRate) {
        float maxCrimeRate = 0;
        int indexTracker = 0;
        for (int i = 0; i < years.length; i++) {
            if (maxCrimeRate > crimeRate[i]) {
                indexTracker = i;
                maxCrimeRate = crimeRate[i];
            }
        }                           
        System.out.println("The rate was highest in " + years[indexTracker]);
    }
    //generic min crime year method
    public void getMinCrimeYear(int[] years, float[] crimeRate) {
        float minCrimeRate = 999999999;
        int indexTracker = 0;
        for (int i = 0; i < years.length; i++) {
            if (minCrimeRate > crimeRate[i]) {
                indexTracker = i;
                minCrimeRate = crimeRate[i];
            }
        }
        System.out.println("The rate was lowest in " + years[indexTracker]);
    }
*/
}
