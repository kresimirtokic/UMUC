
/*
 * Author: Kresimir Tokic
 * Date: 4/1/19
 * Filename: Node.java
 * About: UMUC CMSC350 Project 2
 *  This is the OperatorNode class. It evaluates the node
 *  to calculate its value, and it prints the tree
 *  in inorder, and postorder formats.
 */

import java.io.*;

public abstract class Node {

	public Node left;
	public Node right;
	public String operator;
	public int registerNumber = 0;
	public File ThreeAddressTextFile = new File("ThreeAddress.txt");

	// method used to create infix expression
	public String inOrderWalk() {
		String leftValue = left.inOrderWalk();
		String rightValue = right.inOrderWalk();
		return "(" + leftValue + " " + operator + " " + rightValue + ")";
	}

	// method used to create 3 address
	public String postOrderWalk() {
		String leftValue = left.postOrderWalk();
		if (leftValue.matches("\\d")) {
			// no need to do anything
		} else {
			leftValue = "R" + registerNumber++;
		}

		String rightValue = right.postOrderWalk();
		if (rightValue.matches("\\d")) {
			// no need to do anything
		} else {
			rightValue = "R" + registerNumber++;
		}

		String text = operatorToString(operator) + " R" + registerNumber + " " + leftValue + " " + rightValue;
		//System.out.println(text);
		try {
			BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(ThreeAddressTextFile, true));
			bufferedFileWriter.write(text);
			bufferedFileWriter.newLine();
			bufferedFileWriter.close();
		} catch (IOException io) {
			// exception caught
		}
		return "R" + registerNumber;
	}

	// method converts operator symbol to text
	private String operatorToString(String operator) {
		String operatorWord = "";

		switch (operator) {
		case "*":
			operatorWord = "MUL";
			break;
		case "/":
			operatorWord = "DIV";
			break;
		case "+":
			operatorWord = "ADD";
			break;
		case "-":
			operatorWord = "SUB";
			break;
		}
		return operatorWord;
	}
}
