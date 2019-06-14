
/*
 * Author: Kresimir Tokic
 * Date: 4/18/19
 * Filename: Node.java
 * About: UMUC CMSC350 Project 3
 * It evaluates the node
 *  to calculate its value, and it prints the tree
 *  in inorder, and rev order formats.
 */


public class Node<T> { 

	//variables
	private T tValue;
	private double doubleValue;
	private Node<T> left, right;
	private StringBuilder sortedResult;

	// constructor
	public Node(double doubleValue, T tValue) {
		this.doubleValue = doubleValue;
		this.tValue = tValue;
	}

	
	// method inserts node in binary search tree
	public void insertNode(double doubleValue, T tValue) {
		if (doubleValue <= this.doubleValue) {
			if (left == null) {
				left = new Node(doubleValue, tValue);
			} else {
				left.insertNode(doubleValue, tValue);
			}
		} else {
			if (right == null) {
				right = new Node(doubleValue, tValue);
			} else {
				right.insertNode(doubleValue, tValue);
			}
		}
	}

	// method in order for ascending
	public String inOrderWalk(StringBuilder result) {
		if (left != null) {
			left.inOrderWalk(result);
		}
		sortedResult = result.append(tValue.toString()).append(" ");
		if (right != null) {
			right.inOrderWalk(result);
		}
		return sortedResult.toString();
	}

	// method for descending
	public String reverseOrderWalk(StringBuilder result) {
		if (right != null) {
			right.reverseOrderWalk(result);
		}
		sortedResult = result.append(tValue.toString()).append(" ");
		if (left != null) {
			left.reverseOrderWalk(result);
		}
		return sortedResult.toString();
	}
}
