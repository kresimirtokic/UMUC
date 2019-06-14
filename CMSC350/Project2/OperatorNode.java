/*
 * Author: Kresimir Tokic
 * Date: 4/1/19
 * Filename: Node.java
 * About: UMUC CMSC350 Project 2
 *  This is the OperatorNode class. It evaluates the node
 *  to calculate its value, and it prints the tree
 *  in inorder, and postorder formats.
 */

public class OperatorNode extends Node {

	// constructor
	public OperatorNode(String operator, Node right, Node left) {
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

}
