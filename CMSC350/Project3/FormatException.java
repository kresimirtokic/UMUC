/*
 * Author: Kresimir Tokic
 * Date: 4/18/19
 * Filename: FormatExceptionr.java
 * About: UMUC CMSC350 Project 3
 * Pops up window when exception thrown
 */

import javax.swing.JOptionPane;

public class FormatException extends Exception {
	FormatException(String elementsOf){
		JOptionPane warningMessage = new JOptionPane();
		JOptionPane.showMessageDialog(warningMessage, "You Entered: " + elementsOf + "\n Verify Entry And Check Numeric Type");
}
}