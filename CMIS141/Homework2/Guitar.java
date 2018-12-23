/*
* File: Guitar.java
* Author: Kresimir Tokic
* Purpose: This program constructs instances
* a guitar for Homework2
*/

//Import Statements
import java.util.Random;

public class Guitar {
  private int numStrings = 6;
  private double guitarLength = 28.2;
  private String guitarManufacturer = "Gibson";
  private String guitarColor = "RED";
 
  //Constructor add color guitFinish back into first line below
  public Guitar(int guitStrings, double neckLength, String guitMaker, String guitFinish) {
    numStrings = guitStrings; 
    guitarLength = neckLength;
    guitarManufacturer = guitMaker;
    guitarColor = guitFinish;
  }

  //Default constructor
  public Guitar() {
    numStrings = 6; 
    guitarLength = 28.2;
    guitarManufacturer = "Gibson";
    guitarColor = "RED";
  }

  //Setter methods of each variable type
  public void setStrings(int stringCount) {
    numStrings = stringCount; 
  }
  public void setLength(double neck) {
    guitarLength = neck; 
  }
  public void setMaker(String builder) {
    guitarManufacturer = builder;
  }
  public void setFinish(String finish) {
    guitarColor = finish;
  }

  //Getter methods for all variables
  public int getStrings() {
    return numStrings;
  }
  public double getNeck() {
    return guitarLength;
  }
  public String getBuilder() {
    return guitarManufacturer;
  }
  public String getFinish() {
    return guitarColor;
  }

  //playGuitar() method - randomly selects 16 notes and durations
  public String playGuitar() {
    String[] musicalNotes = {"A", "B", "C", "D", "E", "F", "G"};
    String[] noteDuration = {".25", ".5", "1", "2", "4"}; 
    int randInt = 0;
    int randNote = 0;
    int randDuration = 0;
    int loopCount = 0;
    String song = "";
    Random randomGen = new Random();

    //Loops 16 times to generate random value for index and appends 
    //string with note and duration values
    while (loopCount < 16) {
      randNote = randomGen.nextInt(7);
      song += musicalNotes[randNote]; 
      randDuration = randomGen.nextInt(5);
      song += "(" + noteDuration[randDuration] + "), ";
      loopCount++;
    }
    return song;
  }

  //toString method - outputs variable values as string
  public String toString() {
    String str = "(numStrings=" + numStrings + ", guitarLength=" + guitarLength + 
		 ", guitarManufacturer=" + guitarManufacturer + ", guitarColor= " 
		 + guitarColor + ")";
    return str;
  }
}