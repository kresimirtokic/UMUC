/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;

/*
* File: DateTime.java
* Author: Kresimir Tokic
* Date: Spetember 20, 2018
* Purpose: This program demonstrates
* the use of the classes in the
* java.time package
*/
public class DateTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Use LocalDate Class
        //now() uses current local date
        LocalDate date = LocalDate.now();
        
        //get Year, Julian day of year and Day of Month
        int year = date.getYear();
        int yearDay = date.getDayOfYear();
        int monthDay = date.getDayOfMonth();
        
        //print results
        System.out.println("Year is " + year);
        System.out.println("Julia;n day is " + yearDay);
        System.out.println("Day of month is " + monthDay);
        
        //use plus method
        System.out.printf("%s%n", DayOfWeek.MONDAY.plus(4));
        
        //use of method an dloop to determine leap years
        for (int i = 1990; i <2025; i++){
            boolean isLeap = Year.of(i).isLeap();
            if (isLeap) {
                System.out.println(i + " is a leap year");
            }//end if
        }//end for
        
        //experiment with LocalTime
        LocalTime thisSec;
        //initaliaze to now
        thisSec = LocalTime.now();
        //Display the hours and LocalTime
        System.out.println("this is " + thisSec.getHour() + ", " + thisSec);
        
        //date and time using Date and time
        LocalDateTime thisDate;
        //now() method is useful for all
        thisDate = LocalDateTime.now();
        //get methods are available
        System.out.println("Time Data: " + thisDate.getHour() + ":" + thisDate.getMinute());
        //plus methods are available for checking dates in future
        System.out.printf("now: %s%n", LocalDateTime.now() + "," + LocalDateTime.now().plusMonths(24).plusDays(5));
        
        
    }//end main
    
}//end package
