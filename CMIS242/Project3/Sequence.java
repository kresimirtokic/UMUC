/*
 * Kresimir Tokic
 * CMIS242 Project 3
 * Sequence.java
 * 2/24/19
 * This class calculates the result of
 * a formula both recursively and iteratively
 * 
 */
public class Sequence {

	// class variables
	public static int result;
	public static int efficiencyCounter;
	private static int previousTerm;
	private static int secondPreviousTerm;
	
	//private constructor
	private Sequence() {
	}

	// compute result and efficiency via iterative method
	public static int computeIterative(int nValue) {
		efficiencyCounter = 0;
		previousTerm = 1;
		secondPreviousTerm = 0;
		if (nValue == 0) {
			result = 0;
			efficiencyCounter++;
		} else if (nValue == 1) {
			efficiencyCounter++;
			result = 1;
		} else {
			for (int i = 2; i <= nValue; i++) { 
				efficiencyCounter++;
				result = 2 * previousTerm + secondPreviousTerm;
				secondPreviousTerm = previousTerm;
				previousTerm = result;
			}
		}
		return result;
	}

	// recursive method initiates efficiencyCounter an calls helper function
	public static int computeRecursive(int nValue) {
		efficiencyCounter = 0;
		result = 0;
		return recursiveHelper(nValue);
	}

	// actually calculates the result
	private static int recursiveHelper(int nValue) {
		if (nValue == 0 ) {
			efficiencyCounter++;
			return result = 0;
		} else if (nValue == 1) {
			efficiencyCounter++;
			return result = 1;
		} else {
			efficiencyCounter++;
			return result =  (2 * recursiveHelper(nValue-1)) + recursiveHelper(nValue - 2);
		}
	}


	// get efficiency count
	public static int getEfficiency() {
		return efficiencyCounter;
	}
	
	// result
	public static int getResult() {
		return result;
	}

}
