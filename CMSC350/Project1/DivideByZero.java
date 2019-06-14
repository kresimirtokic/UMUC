/*
 * Author: Kresimir Tokic
 * Date: 3/31/19
 * Filename: DivideByZero.java
 * About: UMUC CMSC350 Project 1
 * Pops up window when exception thrown
 */

import javax.swing.JOptionPane;

public class DivideByZero extends Exception {
	DivideByZero(){
		JOptionPane warningMessage = new JOptionPane();
		JOptionPane.showMessageDialog(warningMessage, "Cannot Divide By 0");
	}
}
