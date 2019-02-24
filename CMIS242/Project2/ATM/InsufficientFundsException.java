/*
 * InsuficientFundsException.java
 * Kresimir Tokic
 * January 31 1019
 * User defined checked exception for mock ATM GUI
 * for CMIS 242 Project 2 Assignment
 * 
 */

import javax.swing.*;

public class InsufficientFundsException extends Exception {
	
	
	public InsufficientFundsException() {
	JOptionPane warningMessage = new JOptionPane();
	JOptionPane.showMessageDialog(warningMessage, "Insufficient Funds!");
	}

}
