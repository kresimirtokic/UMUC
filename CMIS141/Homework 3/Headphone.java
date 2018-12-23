/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testheadphones;

//import statements
import java.awt.Color;

/**
 * File: Headphone.java
 * Date: September 13, 2018
 * Author: Kresimir Tokic
 * Purpose: This program constructs instances
 * of the Headphone class and uses methods
 */
public class Headphone {

    //define constants
    private static final int LOW = 1;
    private static final int MEDIUM = 2;
    private static final int HIGH = 3;

    //declare variables
    private int volume = MEDIUM;
    private boolean pluggedIn = false;
    private String manufacturer;
    private Color headPhoneColor;
    private String headPhoneModel;

    //default constructor
    public Headphone() {
        this.volume = MEDIUM;
        this.pluggedIn = false;
        this.manufacturer = "Beyerdynamic";
        this.headPhoneColor = Color.BLACK;
        this.headPhoneModel = "DT 770 Pro";
    }//end default constructor

    //add fully parameterized constructor here
    public Headphone(int vol, boolean plugged, String manuf, Color mainColor, String modelNum){
        this.volume = vol;
        this.pluggedIn = plugged;
        this.manufacturer = manuf;
        this.headPhoneColor = mainColor;
        this.headPhoneModel = modelNum;
    }
    
    //setter methods
    public void setVolume(int vol) {
        this.volume = vol;
    }

    public void setPluggedIn(boolean plugged) {
        this.pluggedIn = plugged;
    }

    public void setManufacturer(String manuf) {
        this.manufacturer = manuf;
    }

    public void setColor(Color mainColor) {
        this.headPhoneColor = mainColor;
    }

    public void setModel(String modelNum) {
        this.headPhoneModel = modelNum;
    }

    //getter methods
    public int getVol() {
        return this.volume;
    }
    public boolean getPluggedIn() {
        return this.pluggedIn;
    }

    public String getManuf() {
        return this.manufacturer;
    }

    public Color getColor() {
        return this.headPhoneColor;
    }

    public String getModel() {
        return this.headPhoneModel;
    }

    //change volume method
    public int changeVolume(int vol) {
        return this.volume = vol;
    }

    //toString method returns values
    @Override
    public String toString() {
        String str = "volume= " + volume + " pluggedIn= " + pluggedIn
                + " manufacturer= " + manufacturer + " headPhoneColor= "
                + headPhoneColor + " headPhoneModel= " + headPhoneModel;
        return str;
    }

}//end class

