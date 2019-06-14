/*
 * Author: Kresimir Tokic
 * Date: 4/18/19
 * Filename: Fraction.java
 * About: UMUC CMSC350 Project 3
 * Fraction class creates fraction objects
 * parses them for sorting
 */

public class Fraction implements Comparable<Fraction> {

	private String fractionString;
	private double quotient;
	private String[] fractionArray;
	private Fraction nextFraction;
	private double numerator;
	private double denominator;

	// constructor
	public Fraction(String fraction) {
		this.fractionString = fraction;
		fractionArray = this.fractionString.split("/");
		numerator = Double.parseDouble(fractionArray[0]);
		denominator = Double.parseDouble(fractionArray[1]);
		quotient = numerator / denominator;
	}

	// returns string of the fraction
	public String toString() {
		return fractionString;
	}

	/*
	 * from Oracle: "In the foregoing description, the notation sgn(expression)
	 * designates the mathematical signum function, which is defined to return one
	 * of -1, 0, or 1 according to whether the value of expression is negative, zero
	 * or positive."
	 */
	public int compareTo(Fraction fractionObject) {
		nextFraction = fractionObject;
		if (getQuotient() < nextFraction.getQuotient()) {
			return -1;
		} else if (getQuotient() > nextFraction.getQuotient()) {
			return 1;
		} else // if equal {
			return 1;
	}

	/*
	 * 
	 *  
	 *  // alternate solution for required compareTo method
	 *  public int compareTo(Fraction fractionObject) {
	 *  	nextFraction = fractionObject;
	 *  	double resultL = getNumerator() * nextFraction.getDenominator();
	 *  	double resultR = getDenominator() * nextFraction.getNumerator();
	 *  	if (resultL > resultR) {
	 *  		return 1;
	 *  } else if (resultL = resultR) {
	 *  		return 1;
	 *  } else if (resultL < resultR) {
	 *  		return -1;
	 *  }
	 *  }
	 *  
	 *
	* //another alternate for compareTo
	* public int compareTo(Fraction fractionObject) {
	*	if (this.quotient == fractionObject.getQuotient()) {
	*		return 0;
	*	}
	*	return this.quotient > fractionObject.quotient ? 1 : -1;
	*}
	*
	*/
	
	// returns the value of fraction as double
	public double getQuotient() {
		return quotient;
	}

	// returns value of numerator as double
	public double getNumerator() {
		return numerator;
	}
	
	// returns value of denominator as double
	public double getDenominator() {
		return denominator;
	}
}
