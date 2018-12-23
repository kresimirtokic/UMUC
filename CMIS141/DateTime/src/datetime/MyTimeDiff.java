/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.Year;

/**
 *
 * @author kresimir.tokic
 */
public class MyTimeDiff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
               
        Instant firstSnapShot = Instant.now();
        
        for (int i = 1979; i < 2018; i++){
            boolean isLeap = Year.of(i).isLeap();
            if (isLeap) {
                System.out.println(i + " is a leap year");
            }//end if
        }//end for
        
        Instant lastSnapShot = Instant.now();
        //System.out.println("Duration is " + Duration.between(firstSnapShot, lastSnapShot));
        System.out.println("Duration is " + Duration.between(firstSnapShot, lastSnapShot).toNanos()/1000000000.0 + " seconds.");
        
    }//end main
    
}//end class

