/*
 * Kresimir TOkic
 * March 25 2020
 * Square.java
 * subclass of Rectangle a subclass of TwoDimensionalShape
 */

public class Square extends Rectangle {

	// variables
	//double length, height;
	double side;

	// constructor
	public Square(double side) {
		super(side,side);
		this.side = side;
	}

	// getters
	public double getSie() {
		return side;
	}

	// setters
	public void setSide(double side) {
		this.side = side;
	}

	// returns area
	@Override
	public double getArea() {
		double area = height * length;
		return area;
	}

}
