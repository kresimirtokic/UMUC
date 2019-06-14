
/*
 * Author: Kresimir Tokic
 * Date: 3/14/19
 * Filename: InfixCalc.java
 * About: UMUC CMSC350 Project 1
 */

import java.util.*;

public class InfixCalc {

	// declare variables
	private Stack<Character> operandStack = new Stack<>(); // for numbers
	private Stack<Character> operatorStack = new Stack<>(); // for math symbols
	Set<Character> mathSymbols = new HashSet<Character>(Arrays.asList('*', '/', '+', '-', '(', ')'));
	private final int RADIX = 36;
	public int solution;

	// tokenize the user input removing white space then call sorting method
	public void tokenizeUserInput(String userInput) {
		List<Character> tokes = new ArrayList<Character>();
		for (int i = 0; i < userInput.length(); i++) {
			if (Character.isWhitespace(userInput.charAt(i))) {
			} else {
				tokes.add(userInput.charAt(i));
			}
		}
		try {
			checkForInvalidCharacters(tokes);
		} catch (InvalidCharacter e) {
		}
		sortIt(tokes);
	}

	private void checkForInvalidCharacters(List<Character> tokes) throws InvalidCharacter {
		for (char element : tokes) {
			if (!Character.isDigit(element) && !mathSymbols.contains(element)) {
				throw new InvalidCharacter();
			}
		}
	}

	// parse userInput into operator & operand stacks and perform calculations
	private void sortIt(List<Character> tokes) {
		for (int i = 0; i < tokes.size(); i++) {
			if (Character.isDigit(tokes.get(i))) {
				operandStack.push(tokes.get(i));
				;
			} else if (tokes.get(i) == '(') {
				operatorStack.push(tokes.get(i));
			} else if (tokes.get(i) == ')') {
				while (operatorStack.peek() != '(') {
					doMath();
				}
				operatorStack.pop();
			} else if (tokes.get(i) == '*' || tokes.get(i) == '/' || tokes.get(i) == '+' || tokes.get(i) == '-') {
				while (!operatorStack.isEmpty()
						&& precedenceLevel(operatorStack.peek()) >= precedenceLevel(tokes.get(i))
						&& operandStack.size() > 1) {
					doMath();
				}
				operatorStack.push(tokes.get(i));
			}
		}
		while (!operatorStack.isEmpty() && operandStack.size() > 1) {
			doMath();
		}
	}

	// create precedence of operators
	private int precedenceLevel(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}

	// pop one operator and two operands to perform math
	private void doMath() {
		int topDigit = Character.getNumericValue(operandStack.pop());
		int nextDigit = Character.getNumericValue(operandStack.pop());
		switch (operatorStack.pop()) {
		case '*':
			solution = nextDigit * topDigit;
			break;
		case '/':
			if (topDigit == 0) {
				try {
					solution = 0;
					throw new DivideByZero();
				} catch (DivideByZero e) {
				}
			} else if (topDigit != 0) {
				solution = nextDigit / topDigit;
				break;
			}
		case '+':
			solution = nextDigit + topDigit;
			break;
		case '-':
			solution = nextDigit - topDigit;
			break;
		}
		operandStack.push(Character.forDigit(solution, RADIX));
	}
}
