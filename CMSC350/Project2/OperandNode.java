/*
 * Author: Kresimir Tokic
 * Date: 4/1/19
 * Filename: Node.java
 * About: UMUC CMSC350 Project 2
 * This class implements the Operand Node
 */

public class OperandNode extends Node {

	private String value;

	// constructor
	public OperandNode(String value) {
		this.value = value;
	}

	// method used for infix expression
	public String inOrderWalk() {
		return String.valueOf(value);
	}

	// method used for 3 address
	public String postOrderWalk() {
		return String.valueOf(value);
	}

}
