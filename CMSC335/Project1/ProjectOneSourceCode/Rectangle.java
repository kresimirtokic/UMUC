/*
 * Kresimir TOkic
 * March 25 2020
 * Rectangle.java
 * subclass of TwoDimensionalShape
 */

public class Rectangle extends TwoDimensionalShape {

	// variables
	double length, height;

	// constructor
	public Rectangle(double length, double height) {
		this.length = length;
		this.height = height;
	}

	// getters
	public double getLength() {
		return length;
	}

	public double getHeight() {
		return height;
	}

	// setters
	public void setLength(double length) {
		this.length = length;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// returns area
	@Override
	public double getArea() {
		double area = height * length;
		return area;
	}

}
