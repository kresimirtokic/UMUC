
/*
 * Author: Kresimir Tokic
 * Date: 4/18/19
 * Filename: BinarySearchTree.java
 * About: UMUC CMSC350 Project 3
 * Creates BST and sorts ascending and descending order
 * uses Fraction.java class
 */

import java.util.Vector;

public class BinarySearchTree {
	/*
	 * sample 4 8 2 1 23 16 8 16 3 14 2 10 24 ascend 1 2 2 3 4 8 8 10 14 16 16 23 24
	 * sample 1/2 3/4 3/2 5/8 4/9 7/16 5/32 1/8 descend 3/2 3/4 5/8 1/2 4/9 7/16 s5/32 1/8
	 */

	// variables
	private Node root;
	private String[] tokens;
	private Vector objectVector = new Vector();

	// constructor
	public BinarySearchTree(String[] tokens) {
		this.tokens = tokens;
		root = null;
	}

	// sorts user input in ascending order by checking if fraction first then
	// creates nodes and call sorting method
	public String sortAscending() {
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].contains("/")) {
				Fraction temp = new Fraction(tokens[i]);
				objectVector.addElement(new Double(temp.getQuotient()));
				objectVector.addElement(new Fraction(tokens[i]));
			} else {
				objectVector.addElement(new Double(Double.parseDouble(tokens[i])));
				objectVector.addElement(new String(tokens[i]));
			}
		}
		// sets root node
		root = new Node((double) (objectVector.get(0)), objectVector.get(1));
		int length = objectVector.size();
		// inserts nodes in tree
		for (int i = 2; i < length; i += 2) {
			root.insertNode((double) objectVector.get(i), objectVector.get(i + 1));

		}
		return root.inOrderWalk(new StringBuilder(""));
	}

	// sorts user input in descending order by checking if fraction first then
	// creates nodes and call sorting method
	public String sortDescending() {
		// objectVector.setSize(tokens.length);
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].contains("/")) {
				Fraction temp = new Fraction(tokens[i]);
				objectVector.addElement(new Double(temp.getQuotient()));
				objectVector.addElement(new Fraction(tokens[i]));
			} else {
				objectVector.addElement(new Double(Double.parseDouble(tokens[i])));
				objectVector.addElement(new String(tokens[i]));
			}
		}
		// sets root node
		root = new Node((double) (objectVector.get(0)), objectVector.get(1));
		int length = objectVector.size();
		// inserts nodes in tree
		for (int i = 2; i < length; i += 2) {
			root.insertNode((double) objectVector.get(i), objectVector.get(i + 1));

		}
		return root.reverseOrderWalk(new StringBuilder(""));
	}
}
