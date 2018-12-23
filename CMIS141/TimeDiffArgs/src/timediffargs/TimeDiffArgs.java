/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timediffargs;

import java.time.Duration;
import java.time.Instant;
/**
 *
 * @author kresimir.tokic
 */
public class TimeDiffArgs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //default values
        int outerLoop = 100;
        int innerLoop = 10;
        
        //check to make sur ewe have command line argument
        if (args.length == 2) {
            outerLoop = Integer.parseInt(args[0]);
            innerLoop = Integer.parseInt(args[1]);
            System.out.println("Setting loop values: " + args[0] + ", " + args[1]);
        }
        else {
            System.out.println("Application requires 2 command arguments");
            System.out.println("eg java TimeDiffArgs 1000 10");
            System.exit(0);
        }//end if else
        
        //snap an instance
        Instant before = Instant.now();
        //now runa  lenght loop
        for (int i = 0; i < outerLoop; i++){
            for (int j = 0; j < innerLoop; j++){
                System.out.println("i x j = " + i*j);
            }//end inner loop
        }//end outer loop
        
        Instant after = Instant.now();
        System.out.println("Diff is "  + Duration.between(before, after).toNanos()/1000000000.0 + " seconds.");
    }//end main
    
}//end TimeDiffArgss
