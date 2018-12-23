/*
* File: TestGuitar.java
* Author: Kresimir Tokic
* Purpose: This program constructs instances
* of the Guitar class and uses
* its methods
*/

public class TestGuitar {
  public static void main(String[] args) {

  //Construct 3 guitars with varying parameters
  Guitar g1 = new Guitar(7, 30.2, "Fender", "Black");
  Guitar g2 = new Guitar(5, 45.4, "PRS", "Red");
  Guitar g3 = new Guitar(3, 28.2, "Ibanez", "Blue");

  //Construct a default Guitar
  Guitar g4 = new Guitar();
     
  //Display the first guitar values using toString
  System.out.println("toString(): " + g1.toString());

  //Call the getter methods
  //Print the results of first guitar
  System.out.println("getStrings(): " + g1.getStrings());
  System.out.println("getNeck(): " + g1.getNeck());
  System.out.println("getBuilder(): " + g1.getBuilder());
  System.out.println("getFinish(): " + g1.getFinish());
  
  //Display the first song using playGuitar
  System.out.println("playGuitar(): [" + g1.playGuitar() + "]");

  //Display the second guitar values using toString
  System.out.println("toString(): " + g2.toString());

  //Call the getter methods
  //Print the results of second guitar
  System.out.println("getStrings(): " + g2.getStrings());
  System.out.println("getNeck(): " + g2.getNeck());
  System.out.println("getBuilder(): " + g2.getBuilder());
  System.out.println("getFinish(): " + g2.getFinish());

  //Display the second song using playGuitar
  System.out.println("playGuitar(): [" + g2.playGuitar() + "]");

  //Display the third gutiar values using toString
  System.out.println("toString(): " + g3.toString());

  //Call the getter methors
  //Pring the results of third guitar
  System.out.println("getStrings(): " + g3.getStrings());
  System.out.println("getNeck(): " + g3.getNeck());
  System.out.println("getBuilder(): " + g3.getBuilder());
  System.out.println("getFinish(): " + g3.getFinish());

  //Display the third song using playGuitar
  System.out.println("playGuitar(): [" + g3.playGuitar() + "]");

 }
}