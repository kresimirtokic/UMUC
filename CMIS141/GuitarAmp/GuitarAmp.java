/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testguitaramp;

/**
 *
 * @author kresimir.tokic
 */
public class GuitarAmp {

    //declare variables
    private boolean isOn;
    //declare variables
    private int volume  = 0;
    private int[] toneControls;

    //full constructor
    public GuitarAmp(boolean power, int vol, int[] tone) {
        this.volume = vol;
        this.isOn = power;
        this.toneControls = tone;
    }

    //default constructor
    public GuitarAmp() {
        this.toneControls = new int[]{5, 5, 5};
        this.volume = 5;
        this.isOn = false;
        
    }

    //partial constructor
    public GuitarAmp(boolean power) {
        this.volume = 0;
        this.isOn = power;
        this.volume = 5;        
        this.toneControls = new int[]{5, 5, 5};

    }

    //setter method for power
    public void setPower(boolean power) {
        this.isOn = power;
    }

    //setter method for volume knob
    public void setVolume(int vol) {
        volume = vol;
    }

    //setter method for tone knobs
    public void setTone(int[] tone) {
        toneControls = tone;
    }

    //getter method for power
    public boolean getPower() {
        return this.isOn;
    }

    //getter method for volume level
    public int getVolume() {
        return this.volume;
    }

    // getter method for tone settings
    public int[] getTone() {
        return this.toneControls;
    }

}//end class
