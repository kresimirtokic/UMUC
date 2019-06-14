/*
 * Author: Kresimir Tokic
 * Date: 4/1/19
 * Filename: InvalidCharacter.java
 * About: UMUC CMSC350 Project 2
 * Pops up window when exception thrown
 */

import javax.swing.JOptionPane;

public class InvalidCharacter extends Exception {
	InvalidCharacter(String elementsOf){
		JOptionPane warningMessage = new JOptionPane();
		JOptionPane.showMessageDialog(warningMessage, "Invalid Character: " + elementsOf);
		
	}
}
