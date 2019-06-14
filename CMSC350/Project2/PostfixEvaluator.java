
/*
 * Author: Kresimir Tokic
 * Date: 4/3/19
 * Filename: PostfixEvaluator.java
 * About: UMUC CMSC350 Project 2
 * Parses user input and evaluates user input
 */

import java.util.*;

public class PostfixEvaluator {
	// example postfix expression from project rubric 3 5 9+- 2 3 * /
	// which prints ((3-(5+9))/(2*3))

	// declare variables
	private Set<String> mathSymbols = new HashSet<String>(Arrays.asList("*", "/", "+", "-"));
	private Stack<String> expressionStack = new Stack<String>();
	private Node tree;
	public String solution;

	// tokenize the user input and evaluate the postfix expression
	public void tokenizeUserInput(String userInput) throws InvalidCharacter, EmptyStackException {
		String[] tokens = userInput.replaceAll("(?=\\p{Punct})|(?<=\\p{Punct})", " ").split("\\s+");
		;
		for (String elementsOf : tokens) {
			if (!elementsOf.matches("^[0-9]+$") && !mathSymbols.contains(elementsOf)) {
				throw new InvalidCharacter(elementsOf);
			} else if (elementsOf.matches("^[0-9]+$")) {
				expressionStack.push(elementsOf);
			} else if (mathSymbols.contains(elementsOf)) {
				tree = new OperatorNode(elementsOf, new OperandNode(expressionStack.pop()),
						new OperandNode(expressionStack.pop()));
				expressionStack.push(tree.inOrderWalk());
				solution = tree.inOrderWalk();
				tree.postOrderWalk();
			}
		}
	}

}
