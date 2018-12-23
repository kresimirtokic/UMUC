/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testguitaramp;

import java.lang.reflect.Array;

/**
 *
 * @author kresimir.tokic
 */
public class TestGuitarAmp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //declare variables
        boolean power = true;
        int vol = 0;
        int[] toneKnobs = {0, 0, 0};

        //construct default 
        GuitarAmp defaultGuitAmp = new GuitarAmp();

        //call get valus
        System.out.println("Power is: " + defaultGuitAmp.getPower());
        System.out.println("Volume is: " + defaultGuitAmp.getVolume());
        System.out.println("Tone High: " + Array.get(defaultGuitAmp.getTone(), 0));
        System.out.println("Tone Mid: " + Array.get(defaultGuitAmp.getTone(), 1));
        System.out.println("Tone Low: " + Array.get(defaultGuitAmp.getTone(), 2));
        System.out.println("");

        //declare arry of guitar amp objecs
        GuitarAmp[] guitAmp = new GuitarAmp[3]; //must be 3 because range of toneKnobs in line 42
        //for loop to increment through amps and states
        for (int i = 0; i < guitAmp.length; i++) {
            vol = (int)(Math.random()*10); //assign random level volume
            toneKnobs[i] = (int)(Math.random()*10);//assign random value (if array length is greater than 3 values will be out of range)
            guitAmp[i] = new GuitarAmp(power, vol, toneKnobs);
            System.out.println("Power is: " + guitAmp[i].getPower());
            System.out.println("Volume is: " + guitAmp[i].getVolume());
            System.out.println("Tone High: " + Array.get(guitAmp[i].getTone(), 0));
            System.out.println("Tone Mid: " + Array.get(guitAmp[i].getTone(), 1));
            System.out.println("Tone Low: " + Array.get(guitAmp[i].getTone(), 2));
            System.out.println("");
        }//end for loop
        
        //construct from a partial constructor
        GuitarAmp guitAmpPartial = new GuitarAmp(power);
         //call get valus
        System.out.println("Power is: " + guitAmpPartial.getPower());
        System.out.println("Volume is: " + guitAmpPartial.getVolume());
        System.out.println("Tone High: " + Array.get(guitAmpPartial.getTone(), 0));
        System.out.println("Tone Mid: " + Array.get(guitAmpPartial.getTone(), 1));
        System.out.println("Tone Low: " + Array.get(guitAmpPartial.getTone(), 2));
        System.out.println("");
        
    }//end main

}//end class
