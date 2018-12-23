/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testheadphones;

//import statements
import java.awt.Color;

/**
 * File: TestHeadphones.java Date: Sepetember 13, 2018 Author Kresimir Tokic
 * Purpose: Test the headphone class
 */
public class TestHeadphones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //define constants
        final int LOW = 1;
        final int MEDIUM = 2;
        final int HIGH = 3;

        //construct default headphone object
        Headphone hpDefault = new Headphone();

        //print values of hdDefault
        System.out.println("volume: " + hpDefault.getVol());
        System.out.println("plugged in: " + hpDefault.getPluggedIn());
        System.out.println("manufacturer: " + hpDefault.getManuf());
        System.out.println("color: " + hpDefault.getColor());
        System.out.println("model: " + hpDefault.getModel());
        System.out.println("toString: " + hpDefault.toString());
        //change volume of default headphone
        hpDefault.changeVolume(HIGH);
        System.out.println("volume change: " + hpDefault.getVol() + "\n");

        //construct another headphone object
        Headphone hp1 = new Headphone(LOW, true, "Sony", Color.RED, "MDR-XB650BT");
        //print values of fully constructed headphone1
        System.out.println("volume: " + hp1.getVol());
        System.out.println("plugged in: " + hp1.getPluggedIn());
        System.out.println("manufacturer: " + hp1.getManuf());
        System.out.println("color: " + hp1.getColor());
        System.out.println("model: " + hp1.getModel());
        System.out.println("toString: " + hp1.toString());
        //change colume of headphone 1
        hp1.changeVolume(MEDIUM);
        System.out.println("volume change: " + hp1.getVol() + "\n");


        //construct a headphone using all of the setter methods
        Headphone hp2 = new Headphone();
        hp2.setVolume(HIGH);
        hp2.setPluggedIn(true);
        hp2.setManufacturer("AudioTechnica");
        hp2.setColor(Color.BLUE);
        hp2.setModel("ATH-M50xBB");
        //print values of setter headphone2
        System.out.println("volume: " + hp2.getVol());
        System.out.println("plugged in: " + hp2.getPluggedIn());
        System.out.println("manufacturer: " + hp2.getManuf());
        System.out.println("color: " + hp2.getColor());
        System.out.println("model: " + hp2.getModel());
        System.out.println("toString: " + hp2.toString());
        
        //change the volume for headphone2
        hp2.changeVolume(LOW);
        System.out.println("volume change: " + hp2.getVol());

    }//end main

}
